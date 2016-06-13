
<#-- 查询面板的起止日期查询条件 定义宏 -->
<#macro searchDate showName showFiled>
    <th>
		${showName}：
	</th>
	<td>
		<input class="easyui-datebox" data-options="maxDate:'${showFiled}End'" name="${showFiled}Start" id="${showFiled}Start" />
	</td>
	<th>
		至 &nbsp;
	</th>
	<td>
		<input class="easyui-datebox" data-options="minDate:'${showFiled}Start'" name="${showFiled}End" id="${showFiled}End" />
	</td>
</#macro>

<#macro requirdDate showName showFiled>
    <th>
		${showName}：
	</th>
	<td>
		<input class="easyui-datebox easyui-validatebox ipt" data-options="maxDate:'${showFiled}End'" name="${showFiled}Start" id="${showFiled}Start" required="required" />
	</td>
	<th>
		至 &nbsp;
	</th>
	<td>
		<input class="easyui-datebox easyui-validatebox ipt" data-options="minDate:'${showFiled}Start'" name="${showFiled}End" id="${showFiled}End" required="required" />
	</td>
</#macro>

<#-- 单据工具条 定义宏 -->
<#macro billToolBar type>
    <!-- 明细按钮 -->
	<#assign iconAddDetail={"id":"foot_btn_pre","title":"新增明细","iconCls":"icon-add-dtl","action":"ctrl.addDetail()","type":2} >
	<#assign iconDeleteDtl={"id":"foot_btn_next","title":"删除明细","iconCls":"icon-del-dtl","action":"ctrl.deleteDtl()","type":2} >
	<#assign iconDeleteAllDtl={"id":"foot_btn_deleteAllDtl","title":"清空明细","iconCls":"icon-remove","action":"ctrl.deleteAllDtl()","type":2} >
	
	<!--add by xu.j 盘点单明细过滤需要 -->
	<#assign iconDeleteDtlBatchStk={"id":"foot_btn_delete_batch","title":"删除明细","iconCls":"icon-del-dtl","action":"billCheckStk.delCheckDtl()","type":2} >
	<#assign iconDeleteConditonDtl={"id":"foot_btn_deleteConditonDtl","title":"清空明细","iconCls":"icon-remove","action":"billCheckStk.deleteConditionAll()","type":2} >
	
	<#assign iconAddDtl={"id":"foot_btn_pre","title":"新增明细","iconCls":"icon-add-dtl","action":"addDtl()","type":2} >
	<#assign iconSkuAnalyse={"id":"foot_btn_pre","title":"sku预测","iconCls":"icon-aduit","action":"ctrl.skuAnalyse()","type":0} >
	<#assign iconImportDetail={"id":"foot_btn_import","title":"导入明细","iconCls":"icon-import","action":"ctrl.importDetail()","type":2} >
	<#assign iconExportDetail={"id":"foot_btn_import","title":"导出明细","iconCls":"icon-export","action":"ctrl.exportDetail()","type":4} >
	<#assign iconSingleColumn={"id":"singleColumn","title":"竖排显示 ","iconCls":"icon-xq","action":"returnTab('detailTab','单列显示')","type":0} >
	<#assign iconSingleColumn2={"id":"singleColumn","title":"竖排显示 ","iconCls":"icon-xq","action":"returnTab('detailTab','竖排显示')","type":0} >
	
	<#--定义按钮-->
	<#assign iconReturnLookDetail ={"id":"mian_btn_search","title":"查看明细","iconCls":"icon-info","action":"ctrl.returnTabs(0)","type":0}>
	<#assign iconReturnAdd ={"id":"mian_btn_search","title":"新增","iconCls":"icon-add","action":"ctrl.returnTabs(0)","type":0}>
	<#assign iconGeneratorBill ={"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate(1)","type":23}>
	<#assign iconSearch ={"id":"mian_btn_search","title":"查询","iconCls":"icon-search","action":"ctrl.search()","type":0}>
	<#assign iconEmpty={"id":"mian_btn_clear","title":"清空","iconCls":"icon-empty","action":"ctrl.clear()","type":0}>
	<#--批量操作  -->
	<#assign iconBatchDel={"id":"mian_btn_del","title":"删除","iconCls":"icon-del","action":"ctrl.batchDel()","type":3} >
	<#assign iconBatchConfrim={"id":"mian_btn_aduit","title":"确认","iconCls":"icon-aduit","action":"ctrl.batchConfirm()","type":18}>
	<#assign iconBatchAduit={"id":"mian_btn_aduit","title":"审核","iconCls":"icon-aduit","action":"ctrl.batchVerify()","type":5} >
	<#assign iconBatchCancel={"id":"mian_btn_del","title":"作废","iconCls":"icon-del","action":"ctrl.batchCancel()","type":11}>
	<#assign iconBatchOver={"id":"mian_btn_ok","title":"完结","iconCls":"icon-ok","action":"ctrl.batchOver()","type":19}>
	<#assign iconBatchReturn={"id":"top_btn_verify","title":"归还确认","iconCls":"icon-aduit","action":"ctrl.batchConfirm()","type":21} >
	<#assign iconReceipt={"id":"mian_btn_receipt","title":"收货","iconCls":"icon-goods-in","action":"billAsn.openReceiptWork()","type":19}>
	<#assign iconBatchReceipt={"id":"mian_btn_receipt","title":"批量收货确认","iconCls":"icon-cash","action":"ctrl.batchReceipt()","type":19}>
	<#assign iconBatchReverseConfirm={"id":"mian_btn_aduit","title":"反确认","iconCls":"icon-aduit","action":"ctrl.batchReverseConfirm()","type":10} >
	<!-- <#assign iconCreateBillReturnConfirmList={"id":"mian_btn_aduit1","title":"获取退厂鉴定处理单","iconCls":"icon-aduit","action":"ctrl.createBillReturnConfirm(1)","type":0} > -->
	<#--导出  导入 打印 -->
	<#assign iconExport1={"id":"mian_btn_export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel(1)","type":4}>
	<#assign iconPrint1={"id":"mian_btn_print","title":"打印","iconCls":"icon-print","action":"ctrl.print(1)","type":20}>
	<#assign iconPrintBarcodeBatch={"id":"mian_btn_print","title":"打印单据条码","iconCls":"icon-print","action":"ctrl.printerBarcode(1)","type":20}>
	
	<#assign iconReturnSearch={"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0}>
	<#assign iconAdd={"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1}>
	<#assign iconTransferBill={"id":"icon-aduit","title":"转单","iconCls":"icon-redo","action":"ctrl.editInfo()","type":23}>
    <#assign iconSave={"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} >
    <#assign iconDelete={"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} >
	<#assign iconConfirm={"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} >
	<#assign iconReceipt={"id":"top_btn_receipt","title":"收货","iconCls":"icon-goods-in","action":"billAsn.openReceiptWork()","type":19}>
	<#assign iconAduit={"id":"top_btn_verify","title":"审核","iconCls":"icon-aduit","action":"ctrl.verify()","type":5} >
	<#assign iconPrev={"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0}>
	<#assign iconNext={"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0}>
	<#assign iconExport={"id":"foot_btn_export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4}>
	<#assign iconImport	={"id":"top_btn_import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} >
	<#assign iconInitImport	={"id":"top_btn_init_import","title":"调货初始化导入","iconCls":"icon-import","action":"ctrl.import()","type":0} >
	<#assign iconPrint={"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}>	
	<#assign iconCallBack={"id":"mian_btn_del","title":"作废","iconCls":"icon-del","action":"ctrl.callBack()","type":11} >
	
	<#assign iconCreateDiff={"id":"main_btn_diff","title":"生成盘差","iconCls":"icon-ok","action":"ctrl.createDiff()","type":0} >
	<#assign iconCreateDeliveryNtAtListPage={"id":"main_btn_diff","title":"生成配货单","iconCls":"icon-ok","action":"ctrl.createDeliveryNt(1)","type":0} >
	<#assign iconCheckAgain={"id":"main_btn_check","title":"重盘","iconCls":"icon-redo","action":"ctrl.checkAgain()","type":0} >
	<#assign iconCheckInitImport={"id":"top_btn_init_import","title":"库存初始化导入","iconCls":"icon-import","action":"ctrl.initImport()","type":0} >
	<#assign iconCopyDetail={"id":"dtl_btn_copy","title":"复制明细","iconCls":"icon-copy","action":"ctrl.copyDetail()","type":0} >
	
	<#if "bill_toolbar_foot_checkStk"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtlBatchStk,iconDeleteConditonDtl,iconImportDetail,iconCopyDetail]
		/>
	</#if>
	
	<#if "bill_toolbar_foot_quotation"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconImportDetail]
		/>
	</#if>
	 <#if "bill_toolbar_foot_receipt"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl]
		/>
	</#if>
	<#if "bill_toolbar_foot"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl]
		/>
	</#if>
	
	<#if "bill_toolbar_foot_transferNt"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconSkuAnalyse]
		/>
	</#if>
	
	 <#if "bill_toolbar_foot_wholesale"==type>
		<@p.toolbar id="foot_bar"	listData=[iconDeleteDtl,iconDeleteAllDtl]
		/>
	</#if>
	
	 <#if "bill_toolbar_foot_single"==type>
		<@p.toolbar id="foot_bar" listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconSingleColumn2] />
	</#if>
	
	
	

	<!--适用于单据明细没有新增按钮的单据查询(前置单据必须) :目前使用的有验收单,调货出库单-->
	<#if "bill_maintab_toolbar_top_LookDetail"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnLookDetail,iconSearch,iconEmpty,iconGeneratorBill,iconBatchDel,iconBatchConfrim,
												iconExport1,iconPrint1]
		    />
	</#if>
	<#if "bill_maintab_toolbar_top_TransferBill"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnLookDetail,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,iconTransferBill,
												iconExport1,iconPrint1]
		    />
	</#if>
	
	
	
	<#if "toolbarList"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,iconAdd,iconSave,iconDelete,iconConfirm,
											  iconPrev,iconNext,iconImport,iconExport,iconPrint]
		    />
	</#if>
	<#if "toolbarList_repairIn"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,
											  iconPrev,iconNext,iconExport,iconPrint]
		    />
	</#if>
	<#if "toolbarList_new"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,iconSave,iconConfirm,
											  iconPrev,iconNext,iconExport,iconPrint]
		    />
	</#if>
	<#if "toolbarList_borrowReturn"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,iconConfirm,iconPrev,iconNext,iconExport,iconPrint]/>
	</#if>
	
	<#if "bill_maintab_toolbar_quotation"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconGeneratorBill,iconBatchDel,iconBatchConfrim,
											  iconBatchCancel,iconExport1,iconPrint1]
		    />
	</#if>
	
	<#if "bill_maintab_toolbar_warehose_out"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,iconInitImport,
												iconExport1,iconPrint1,iconPrintBarcodeBatch]
		    />
	</#if>
	<#if "bill_maintab_toolbar_generatorBill"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,
												iconExport1,iconPrint1]
		    />
	</#if>
	<#if "bill_maintab_toolbar_order"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconExport1,iconPrint1]
		    />
	</#if>
	
	<#if "bill_maintab_toolbar_delivery"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,
												iconExport1,iconPrint1,iconPrintBarcodeBatch]
		    />
	</#if>
	<#if "bill_maintab_toolbar_transfer_cargo_out"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnLookDetail,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,
												iconExport1,iconPrint1,iconPrintBarcodeBatch]
		    />
	</#if>
	
	<#if "bill_no_add_and_Del_for_search"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchConfrim,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_no_import_for_search"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchConfrim,iconExport1,iconPrint1] />
	</#if>
	<#if "bill_maintab_toolbar_borrowConfirm"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchReturn,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_aduit"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchAduit,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_checkStk"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconCheckInitImport
												iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_toolbar_main"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_noAdd"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconExport1,iconPrint1] />
	</#if>
	<#if "bill_maintab_toolbar_storeBad"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconExport1,iconPrint1,iconPrintBarcodeBatch] />
	</#if>
	<#if "bill_maintab_toolbar"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconGeneratorBill,iconExport1,iconPrint1] />
	</#if>
	<!--补货建议单查询列表工具条-->
	<#if "bill_maintab_toolbar_reStockSuggest"==type>
			<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconCreateDeliveryNtAtListPage,iconExport]/>
	</#if>
	<#if "bill_toolbar_top"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,iconAdd,iconSave,iconDelete,iconAduit,iconPrev,iconNext,iconExport,iconPrint] />
	</#if>
	
	<!--盘差单明细工具条 -->
	<#if "bill_maintab_toolbar_top_checkDiff"==type>
			<@p.toolbar id="mainbar" listData=[iconReturnSearch,iconSave,iconConfirm,iconCreateDiff,iconPrev,
										       iconNext,iconExport,iconPrint]/>
	</#if>
	
	<#if "bill_toolbar_top_receipt"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20},
			{"id":"foot_btn_report","title":"退出","iconCls":"icon-close","action":"billReceiptWork.closeReceiptWork()","type":0}
		 ]/>
	</#if>
	 
	<#if "bill_toolbar_top_quotation"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"top_btn_del","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"top_btn_copy","title":"复制","iconCls":"icon-add-dtl","action":"ctrl.copyBill()","type":8} ,
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	</#if>
	 
	<#if "bill_toolbar_top_sale_order"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"top_btn_verify","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19},
			{"id":"top_btn_comfirm","title":"订补货单生成","iconCls":"icon-aduit","action":"ctrl.createOrderBill()","type":18} ,
			{"id":"GeneratorNewBill","title":"批发退货","iconCls":"icon-ok","action":"ctrl.billReturn()","type":24} ,
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	</#if>
	  <#if "bill_toolbar_group_order"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"top_btn_verify","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19},
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	 </#if>
	 
	 <#if "bill_toolbar_topNt"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_verify","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18},
			{"id":"top_btn_delete","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11},
			{"id":"top_btn_verify","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19},
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"top_btn_import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} ,
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	 </#if>
	 
	 <#if "bill_toolbar_topNt1"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_verify","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18},
			{"id":"top_btn_delete","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11},
			{"id":"top_btn_verify","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19},
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"top_btn_import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} ,
			{"id":"top_btn_import","title":"快速导入","iconCls":"icon-import","action":"ctrl.import('Custom')","type":6} ,
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_report","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	 </#if>

	 <#if "toolbarList2"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListReturn"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarList3"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarList4"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListConfirm"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListBorrowConfirm"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"icon-aduit","title":"归还确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":21} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListVerify"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"verify","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListNt"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"verify","title":"审核","iconCls":"icon-aduit","action":"ctrl.verify()","type":5} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"over","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListConfirmNt"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"over","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListConfirmNt1"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"over","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListConfirmNt2"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"over","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListTransferCargoIn"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListStoreBad"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20},
			{"id":"print","title":"打印单据条码","iconCls":"icon-print","action":"ctrl.printerBarcode()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListNotAdd"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListLoss"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"verify","title":"审核","iconCls":"icon-aduit","action":"ctrl.verify()","type":5} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListGeneratorBill"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarListGeneratorBill1"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarListDelivery"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20},
			{"id":"print","title":"打印单据条码","iconCls":"icon-print","action":"ctrl.printerBarcode()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListDeliveryNt"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"over","title":"完结","iconCls":"icon-ok","action":"ctrl.over()","type":19} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <!-- 补货建议单 明细工具栏 -->
	 <#if "toolbarListRestockSuggest"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"createDeliveryNt","title":"生成配货单","iconCls":"icon-aduit","action":"ctrl.createDeliveryNt(0)","type":18}
		 ]/>
	 </#if>
	 <#if "toolbarListRelationCreate"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "shopSearchCodeLineSetting"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"查询","iconCls":"icon-search","action":"ctrl.search()","type":0},
			{"id":"mian_btn_clear","title":"清空","iconCls":"icon-empty","action":"ctrl.clear()","type":0},
			{"id":"add","title":"新增","iconCls":"icon-save","action":"ctrl.add()","type":1} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":0}
		 ]/>
	 </#if>
	 <#if "toolbarListTransferCargoOut"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20},
			{"id":"print","title":"打印单据条码","iconCls":"icon-print","action":"ctrl.printerBarcode()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListRelationCreate2"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListWareHouseOut"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20},
			{"id":"print","title":"打印单据条码","iconCls":"icon-print","action":"ctrl.printerBarcode()","type":20}
		 ]/>
	 </#if>
	 
	 <#if "toolbarListTransfer"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"transit","title":"中转记录","iconCls":"icon-ts-1","action":"billTransfer.addTransit()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarListTransfer"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"transit","title":"中转记录","iconCls":"icon-ts-1","action":"billTransfer.addTransit()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 
	  <#if "toolbardifference"==type>
		<@p.toolbar id="main_bar" listData=[
			{"id":"mian_btn_search","title":"查询","iconCls":"icon-search","action":"ctrl.search()","type":0},
			{"id":"mian_btn_clear","title":"清空","iconCls":"icon-empty","action":"ctrl.clear()","type":0},
			{"id":"icon-aduit","title":"差异处理","iconCls":"icon-aduit","action":"ctrl.editInfo()","type":25} ,
			{"id":"icon-build-some","title":"串码批量处理","iconCls":"icon-build-some","action":"ctrl.batchHandle()","type":0},
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel(1)","type":4}
		 ]/>
	 </#if>
	 
	 <#if "toolbarLis"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"verify","title":"审核","iconCls":"icon-aduit","action":"ctrl.verify()","type":5} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 
	 <#if "toolbarListDiff"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"verify","title":"审核","iconCls":"icon-aduit","action":"ctrl.verify()","type":5} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	  <#if "toolbarListDiffApply"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListNoOver"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1} ,
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"cancel","title":"作废","iconCls":"icon-del","action":"ctrl.cancel()","type":11} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if>
	 <#if "toolbarListReverseConfirm"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"top_btn_add","title":"新增","iconCls":"icon-add","action":"ctrl.add()","type":1},
			{"id":"foot_btn_save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"top_btn_delete","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"top_btn_comfirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"top_btn_create","title":"生成明细","iconCls":"icon-info","action":"ctrl.createDtl()","type":26} ,
			{"id":"main_btn_check","title":"重盘","iconCls":"icon-redo","action":"ctrl.checkAgain()","type":0},
			{"id":"top_btn_back","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"top_btn_next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0},
			{"id":"top_btn_import","title":"导入","iconCls":"icon-import","action":"ctrl.import()","type":6},
			{"id":"foot_btn_report","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4},
			{"id":"foot_btn_print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20}
		 ]/>
	 </#if>
	  <#if "bill_toolbar_top_wholesale"==type>
		<@p.toolbar id="mainbar" listData=[
			{"id":"mian_btn_search","title":"浏览","iconCls":"icon-search","action":"ctrl.returnTabs(1)","type":0},
			{"id":"save","title":"保存","iconCls":"icon-save","action":"ctrl.save(3)","type":7} ,
			{"id":"del","title":"删除","iconCls":"icon-del","action":"ctrl.del()","type":3} ,
			{"id":"confirm","title":"确认","iconCls":"icon-aduit","action":"ctrl.confirm()","type":18} ,
			{"id":"GeneratorBill","title":"关联生成","iconCls":"icon-ok","action":"ctrl.relationCreate()","type":23} ,
			{"id":"prev","title":"上单","iconCls":"icon-prev","action":"ctrl.prev()","type":0} ,
			{"id":"next","title":"下单","iconCls":"icon-next","action":"ctrl.next()","type":0} ,
			{"id":"export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel()","type":4} ,
			{"id":"print","title":"打印","iconCls":"icon-print","action":"ctrl.print()","type":20} 
		 ]/>
	 </#if> 
	 <#if "bill_maintab_toolbar_wholesale"==type>
		<@p.toolbar id="main_bar" listData=[
			iconReturnAdd,
			{"id":"mian_btn_search","title":"查询","iconCls":"icon-search","action":"ctrl.search()","type":0},
			{"id":"mian_btn_clear","title":"清空","iconCls":"icon-empty","action":"ctrl.clear()","type":0},
			{"id":"mian_btn_del","title":"删除","iconCls":"icon-del","action":"ctrl.batchDel()","type":3},
			{"id":"top_btn_verify","title":"确认","iconCls":"icon-aduit","action":"ctrl.batchConfirm()","type":18},
			{"id":"mian_btn_export","title":"导出","iconCls":"icon-export","action":"ctrl.exportExcel(1)","type":4},
			{"id":"mian_btn_print","title":"打印","iconCls":"icon-print","action":"ctrl.print(1)","type":20}
		 ]/>
	 </#if>
	 
	 
	 
	<!--111111 -->
	<#if "bill_toolbar_foot_new"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl]
		/>
	</#if>
	<#if "bill_toolbar_foot_new1"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconImportDetail]
		/>
	</#if>
	 <#if "bill_toolbar_foot_new3"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconSingleColumn]
		/>
	</#if>
	 <#if "bill_toolbar_foot_new4"==type>
		<@p.toolbar id="foot_bar"	listData=[iconSingleColumn]
		/>
	</#if>
	
	<!--222222 -->
	<#if "bill_toolbar_foot_singleColumn"==type>
		<@p.toolbar id="foot_bar" listData=[iconDeleteDtl,iconDeleteAllDtl,iconSingleColumn2] />
	</#if>
	<#if "bill_toolbar_foot_singleColumn2"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconImportDetail,iconSingleColumn] />
	</#if>
	<#if "bill_toolbar_foot_singleColumn3"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl] />
	</#if>
	<#if "bill_toolbar_foot_singleColumn4"==type>
		<@p.toolbar id="foot_bar"	listData=[iconAddDetail,iconDeleteDtl,iconDeleteAllDtl,iconImportDetail,iconExportDetail,iconSingleColumn] />
	</#if>
	
	<!--3333333 -->
	<#if "bill_no_add_for_search"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconExport1,iconPrint1] />
	</#if>
	 <#if "bill_no_add_for_search2"==type>
			<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchConfrim,iconImport,iconExport1,iconPrint1] />
	</#if>
	 
	<!--4444444 -->
	<#if "bill_maintab_toolbar_topNt"==type>
	 	<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchAduit,
	 											iconBatchCancel,iconBatchOver,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_new"==type>
		<@p.toolbar id="main_bar"	listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconBatchCancel,
											  iconBatchOver,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_receipt"==type>
		<@p.toolbar id="main_bar"	listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconReceipt,iconBatchReceipt,iconBatchCancel,
											  iconBatchOver,iconExport1,iconPrint1] />
	</#if>
	 <#if "bill_maintab_toolbar_billReturn"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconExport1,iconPrint1] />
	</#if>
	<#if "bill_maintab_toolbar_topNt_new1"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
											  iconBatchCancel,iconBatchOver,iconExport1,iconPrint1] />
	</#if>
	
	 <#if "bill_maintab_toolbar_topNt_new3"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_new4"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchConfrim,iconExport1,iconPrint1] />
	</#if>
	
	<!-- 
	<#if "bill_maintab_toolbar_topNt_new4"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchConfrim,iconExport1,iconPrint1] />
	</#if>
	-->
	
	<#if "bill_maintab_toolbar_topNt_new5"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconBatchAduit,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_new6"==type>
		<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconBatchAduit,iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_new7"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,
												iconExport1,iconPrint1] />
	</#if>
	
	<#if "bill_maintab_toolbar_topNt_new8"==type>
		<@p.toolbar id="main_bar" listData=[iconReturnAdd,iconSearch,iconEmpty,iconBatchDel,iconBatchConfrim,iconGeneratorBill,
												iconExport1,iconPrint1] />
	</#if>
	 
	<#if "bill_maintab_toolbar_topNt_new9"==type>
		<@p.toolbar id="main_bar" listData=[iconSearch,iconEmpty,iconPrint1] />
	</#if>
</#macro>
