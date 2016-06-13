package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.model.DistributeColoth;
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;
import cn.wonhigh.retail.scheduler.distribute.ProductApi;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProBarcode;
import com.yougou.bi.mdm.api.vo.ProProductDto;
@Service
public class MDMConvert {

	
	private static ProductApi productApi;

	public static List<DistributeColothTB> pro2ColothTB(List<ProProductDto> proList){
		List<DistributeColothTB> clist = new ArrayList<>(proList.size());
		for(ProProductDto pro : proList){
			clist.add(pro2ColothTB(pro)); 
		}
		return clist;
	}
	
	public static List<DistributeColoth> pro2Coloth(ProProductDto proDto) throws Exception{
		Map<String,Object> params = new HashMap<>();
		params.put("productNo", proDto.getProductNo());
		params.put("defaultValue", "Y");
		params.put("brandDetailNo", proDto.getBrandDetailNo());
		List<ProBarcode> proList = productApi.getProBarcode(params);
		if(!CommonUtil.hasValue(proList)){
			SendInfoUtils.addWarnInfo("BI-MDM没有产品条码信息");
			return null;
		}
		//特别处理 尺寸类型需要特别处理  所有含有F尺码的尺寸类型转为D，尺码转为F，如果同时含有F和其它尺码就报错
		SizeConvert.specialSizeCodeD(proList);
		List<DistributeColoth> clist = new ArrayList<>();
		int recno = 0;
		String dicolor = ColorConvert.convent(proDto);//颜色单独转换

		for(ProBarcode bar : proList){
			DistributeColoth coloth = new DistributeColoth();
			coloth.setColthno(proDto.getProductCode());
			coloth.setRecno(++recno);
			String sizeCode = null;
			//尺码特别处理,F尺码直接转为F
			if("F".equals(bar.getSizeCode())){
				sizeCode = "F";
			} else {
				sizeCode = SizeConvert.convert(bar,proDto);
				if(!CommonUtil.hasValue(sizeCode)){
					SendInfoUtils.addUnSynSizeCode(bar.getSizeCode());
					continue;
				}
			}
			coloth.setMsize(sizeCode);
			coloth.setMcolor(dicolor);
			coloth.setColorNos(coloth.getMcolor()+"-"+coloth.getMsize());
			coloth.setColthname(proDto.getProductEname());
			coloth.setWords(bar.getBarcodeCode());
			//工价 牌价 成本价
			coloth.setGxrq(bar.getEdittm());
			coloth.setYhid(bar.getEditor());
			clist.add(coloth);
			//加入邮件信息中
			SendInfoUtils.addSizeCode(bar.getSizeCode()+"-->"+coloth.getMsize());
		}
		
		return clist;
	}
	
	public static List<DistributeCltypep> pro2Cltypep(ProProductDto pro) throws Exception{
		//暂时所有的子品牌对应的编码到是020，直接写死
		DistributeCltypep p1 = new DistributeCltypep(BrandConvert.getTypeNo(pro.getBrandNo()),
				BrandConvert.getBrandDetail(pro));
		
		//转换大类
		DistributeCltypep p2 = CategoryConvert.convertCategory(pro);
		//跟型
		DistributeCltypep p3 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"跟型", pro.getHeelTypeNo());
		
		//底型 
		DistributeCltypep p4 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"底型", pro.getEndTypeNo());
		//季节 
		DistributeCltypep p5 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"季节", pro.getSeasonNo());
		//性别
		DistributeCltypep p6 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"性别", pro.getGenderNo());
		//主料
		DistributeCltypep p7 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"主料", pro.getMainMtrlNo());
		//年份
		DistributeCltypep p8 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"年份", pro.getProductYearNo());
		//内里
		DistributeCltypep p9 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"内里", pro.getLiningNo());
		//订货形式
		DistributeCltypep p10 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"订货形式", pro.getOrderStyleNo());
		//产品季节 b
		DistributeCltypep p11 = GroupAttributeConvert.convertGroupAttribute(pro.getBrandNo(),"产品季节", pro.getProductSeasonNo());
		List<DistributeCltypep> plist = buildCltypepList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11);
		List<DistributeCltypep> p2list = BrandAttributeConvert.convert(pro);
		if(CommonUtil.hasValue(p2list)){
			plist.addAll(p2list);
			for(DistributeCltypep p : plist){
				p.setColthno(pro.getProductCode());
				p.setYhid(pro.getEditor());
				p.setGxrq(pro.getEdittm());
			}
		}
		return plist;
	}

	private static List<DistributeCltypep> buildCltypepList(DistributeCltypep... cltypeps){
		List<DistributeCltypep> plist = new ArrayList<>();
		for(DistributeCltypep p : cltypeps){
			if(null != p){
				plist.add(p);
			}
		}
		return plist;
	}
	
	public static DistributeColothTB pro2ColothTB(ProProductDto pro){
		DistributeColothTB colothTB = new DistributeColothTB();
		colothTB.setColthno(pro.getProductCode());
		colothTB.setShoestyle(pro.getStyle());
		colothTB.setColthname4(pro.getFactoryProductCname());
		colothTB.setBz1(pro.getMainColor());
		colothTB.setBz2(pro.getOuterPad());
		colothTB.setBz3(pro.getOuterBottom());
		colothTB.setGxrq(pro.getEdittm());
		colothTB.setYhid(pro.getEditor());
		return colothTB;
	}
	
	public static DistributeColothT pro2ColothT(ProProductDto pro)
			throws Exception{
		DistributeColothT colothT = new DistributeColothT();
		colothT.setColthno(pro.getProductCode());
		colothT.setColthname(pro.getProductName());
		colothT.setColthname3(pro.getProductLname());
		colothT.setLocation(pro.getPattern());
		colothT.setStyleno(pro.getPlateCode());
		colothT.setOriginhh(pro.getProductCode2());
		colothT.setSizekind2(pro.getBrandNo());
		colothT.setCusno(SupplyConvert.convert(pro.getSupplierNo(), pro.getBrandNo()));//供应商转换
		colothT.setColthnob(pro.getFactoryProduct());
		colothT.setMainqdb(pro.getVampMaterial());
		colothT.setValids(StatusConvert.convert(pro.getProductStatus(), pro.getBrandNo()));//状态需要转换
		colothT.setSizekind(SizeTypeConvert.convert(pro));//尺寸类别需要转换
		//牌价，成本，工价
		colothT.setGxrq(pro.getEdittm());
		colothT.setYhid(pro.getEditor());
		
		return colothT;
	}

	@Resource
	public void setProductApi(ProductApi productApi) {
		MDMConvert.productApi = productApi;
	}
	
}
