<#-- 
此宏生成一个表格  下面有些有自定义的值在用的时候根据需要填
id:表格ID
name:表格name
title:表格标题,空时整个标题栏不显示
columnsJsonList:表格的列,支持列合并
frozenColumns:表格的列,支持列冻结
jsonExtend:表格事件执行方法,该事件必须是表格自带的事件 jsonExtend='{onSelect:function(rowIndex, rowData){....}}
loadUrl:默认加载表格数据的URL
saveUrl:默认保存数据的URL,保存时候 增、删、改一起操作 inserted\deleted\updated
isHasToolBar:是否要自带的工具条，默认false,一般自定义工具条
divToolbar:自定义工具条的DIV,DIV里面放的工具条，只有当isHasToolBar==false,divToolbar才有值
height: 高度    width:宽度
onClickRowEdit:单击是否可以编辑，如是查询模块的话为false
singleSelect:单选还是多选,默认 true
pageSize：每页显示条数 默认20
pagination：是否有分页 默认true

reduceHeight: 减少业务其他DIV高度之和   自动适应高度时 表格的高度=屏幕高度-reduceHeight  如果height有值优先取height,次之再用计算高度
onRowContextMenuDiv:右键菜单Div的ID
checkOnSelect: 选中行时是否默认勾上复选框
selectOnCheck: 勾上复选框时是否默认选择该行
pageList:分页选项,数组类型,如[10,20,...,1000]，默认[10,20,50,100,200,300,400,500]
-->
<#macro datagrid
	id="id" name="" title="" columnsJsonList="[]" frozenColumns="[]" jsonExtend="{}" loadUrl="" saveUrl=""   defaultColumn=""  
	isHasToolBar="true"  divToolbar=""  height="" width="" onClickRowEdit="true" singleSelect="true" pageSize='10'  
	pagination="true" rownumbers="false" onClickRowAuto="true" fit="" idField="" reduceHeight=0 onRowContextMenuDivId="" 
	checkOnSelect="false"  selectOnCheck="false" fitColumns="false" enableHeaderClickMenu="true" enableHeaderContextMenu="true"
	enableHeaderContextMenuCopy = "false" pageList=""
	emptyMsg="暂无数据"  border="false" showFooter="false" footerData="" view="">
<script type="text/javascript">
    
  	$.extend($.fn.datagrid.methods, {
	    addEditor : function(jq, param) {
	        var array=param.field.split(',');
	        for(var i=0;i<array.length;i++){
	            var temp=array[i];
	            var e = $(jq).datagrid('getColumnOption', temp);
                e.editor = param.editor;
	        }
	    },
	    removeEditor : function(jq, param) {
	        var  params=param.split(",");
	        if (params instanceof Array) {
	            $.each(params, function(index, item) {
	                var e = $(jq).datagrid('getColumnOption', item);
	                e.editor = {};
	            });
	        } else {
	            var e = $(jq).datagrid('getColumnOption', param);
	            e.editor = {};
	        }
	    }
  });

	function mergeCellsByField(tableID,colList){
	    var ColArray = colList.split(",");
	    var tTable = $('#'+tableID);
	    var TableRowCnts=tTable.datagrid("getRows").length;
	    var tmpA;
	    var tmpB;
	    var PerTxt = "";
	    var CurTxt = "";
	    var alertStr = "";
	    for (j=ColArray.length-1;j>=0 ;j-- )
	    {
	        PerTxt="";
	        tmpA=1;
	        tmpB=0;
	         
	        for (i=0;i<=TableRowCnts ;i++ )
	        {
	            if (i==TableRowCnts)
	            {
	                CurTxt="";
	            }
	            else
	            {
	                CurTxt=tTable.datagrid("getRows")[i][ColArray[j]];
	            }
	            if (PerTxt==CurTxt)
	            {
	                tmpA+=1;
	            }
	            else
	            {
	                tmpB+=tmpA;
	                tTable.datagrid('mergeCells',{
	                    index:i-tmpA,
	                    field:ColArray[j],
	                    rowspan:tmpA,
	                    colspan:null
	                });
	                tmpA=1;
	            }
	            PerTxt=CurTxt;
	        }
	    }
	}
	

</script>

<script type="text/javascript">
    

	function onRowContextMenu(e, rowIndex, rowData){
		   e.preventDefault();
		   var selected=$("#${id!}").datagrid('getRows'); //获取所有行集合对象
		    selected[rowIndex].id; //index为当前右键行的索引，指向当前行对象
		    $("#${onRowContextMenuDivId!}").menu('show', {
		        left:e.pageX,
		        top:e.pageY
		    });		
	}

    
    $(function() {
        var v_reduceHeight=${reduceHeight};
        var clientHeight=document.body.clientHeight-v_reduceHeight;
        var $dg = $("#${id!}");
        var editIndex = undefined;
        var $dgExtend={
            <#if view!="">
            view: ${view},
            </#if>
            <#if loadUrl!="">
            url : "<@s.url loadUrl/>",
            </#if>
            title:"${title}",
            <#if height!="">
                height : "${height}",
                <#else>
                height:clientHeight,
            </#if>
            <#if width!="">
                width : "${width}",
            </#if>
            <#if fit!="">
                fit : true,
            </#if>
            <#if idField!="">
                idField : "${idField}",
            </#if>
            loadMsg:'请稍等,正在加载...',
            iconCls:'icon-ok',
            pageSize:"${pageSize?number}",
            <#if pageList!=null&&pageList!=""&&pageList!="[]"&&pageList!="[ ]">
            	pageList:${pageList},
            <#else>
            	pageList:[10,20,50,100,200,300,400,500],
            </#if>
            collapsible:false,
            <#if border='true'>
                border:true,
                <#else>
                border:false,
            </#if>
            <#if showFooter='true'>
                showFooter:true,
                <#else>
                showFooter:false,
            </#if>
            <#if checkOnSelect='true'>
                checkOnSelect:true,
                <#else>
                checkOnSelect:false,
            </#if>
            <#if selectOnCheck='true'>
                selectOnCheck:true,
                <#else>
                selectOnCheck:false,
            </#if>
            <#if pagination='true'>
                pagination:true,
                <#else>
                pagination:false,
            </#if>
            <#if singleSelect='true'>
                singleSelect:true,
                <#else>
                singleSelect:false,
            </#if>
            <#if rownumbers=='true'>
                  rownumbers:true,
                  <#else>
                  rownumbers:false,
            </#if>
             <#if fitColumns='true'>
                fitColumns:true,
                <#else>
                fitColumns:false,
            </#if>
             <#if enableHeaderContextMenu=='true'>
                  enableHeaderContextMenu:true,
                  <#else>
                  enableHeaderContextMenu:false,
            </#if>
            <#if enableHeaderContextMenuCopy=='true'>
                  rowContextMenu:[{id : 'copy', text:'拆单',iconCls:'icon-copy',handler:function(e, rowIndex, rowData, eventData, grid, item, menu){
					  	if(1 < rowData.qty){
					  		grid.datagrid('updateRow', {
								index : rowIndex,
								row: {
									qty:rowData.qty-1
								}
							});
							
							var row = new Object();
							row.id=rowData.id;
							row.order=rowData.order;
							row.orderDtlId=rowData.orderDtlId;
							row.businessNo=rowData.businessNo;
							row.skuNo=rowData.skuNo;
							row.itemNo=rowData.itemNo;
							row.brandNo=rowData.brandNo;
							row.itemFlag=rowData.itemFlag;
							row.sizeKind=rowData.sizeKind;
							row.categoryNo=rowData.categoryNo;
							row.discPrice=rowData.discPrice;
							row.prefPrice=rowData.prefPrice;
							row.proNo=rowData.proNo;
							row.discount=rowData.discount;
							row.discountType=rowData.discountType;
							row.discountTypeName=rowData.discountTypeName;
							row.discountSourceId=rowData.discountSourceId;
							row.discountName=rowData.discountName;
							row.vipDiscount=rowData.vipDiscount;
							row.baseScore=rowData.baseScore;
							row.proScore=rowData.proScore;
							row.costScore=rowData.costScore;
							row.assistantId=rowData.assistantId;
							row.assistantNo=rowData.assistantNo;
							row.colorNo=rowData.colorNo;
							row.colorName=rowData.colorName;
							row.brandName=rowData.brandName;
							row.assignProNo=rowData.assignProNo;
							row.isChangePro=rowData.isChangePro;
							row.effectiveProList=rowData.effectiveProList;
							row.settlePriceHidden=rowData.settlePriceHidden;
							row.reducePrice=rowData.reducePrice;
							row.oldQty=rowData.oldQty;
							row.itemCode=rowData.itemCode;
							row.sizeNo=rowData.sizeNo;
							row.itemName=rowData.itemName;
							row.assistant=rowData.assistant;
							row.tagPrice=rowData.tagPrice;
							row.salePrice=rowData.salePrice;
							row.itemDiscount=rowData.itemDiscount;
							row.settlePrice=rowData.settlePrice;
							row.qty=1;
							row.amount=rowData.amount;
							row.availableFlag=rowData.availableFlag;
							row.proName=rowData.proName;
							row.discountCode=rowData.discountCode;
							row.billingCode=rowData.billingCode;
							row.reason=rowData.reason
							grid.datagrid("appendRow",row);
					  	}
				  }}],
            </#if>
            <#if enableHeaderClickMenu=='true'>
                  enableHeaderClickMenu:true,
                  <#else>
                  enableHeaderClickMenu:false,
            </#if>
            emptyMsg:"${emptyMsg}",
            frozenColumns:[${frozenColumns}],
            columns : [ ${columnsJsonList}],
         <#if (divToolbar??&&divToolbar!="")>
            toolbar:"${divToolbar}",
         </#if>
         <#if (onRowContextMenuDivId??&&onRowContextMenuDivId!="")>
            onRowContextMenu:onRowContextMenu,
         </#if>
         
         <#if isHasToolBar='true'>  
            toolbar : [ {
                text : "添加",
                iconCls : "icon-add",
                handler : function() {
                    var hiddenMainId=$('#hiddenMainId').val();
                    var defaultColumn="${defaultColumn}";
                    if(hiddenMainId!=''&&defaultColumn!=''){
                        $dg.datagrid('appendRow', {"${defaultColumn}":$('#hiddenMainId').val()});
                    }else{
                       $dg.datagrid('appendRow', {});
                    }
                    var rows = $dg.datagrid('getRows');
                    $dg.datagrid('beginEdit', rows.length - 1);
               }
            },  {
                text : "删除",
                iconCls : "icon-remove",
                handler : function() {
                    var row = $dg.datagrid('getSelected');
                    if (row) {
                        var rowIndex = $dg.datagrid('getRowIndex', row);
                        $dg.datagrid('deleteRow', rowIndex);
                    }
                }
            }, {
                text : "保存",
                iconCls : "icon-save",
                data: 
                handler : function() {
                    endEdit();
                    if ($dg.datagrid('getChanges').length) {
                    
                        var inserted = $dg.datagrid('getChanges', "inserted");
                        var deleted = $dg.datagrid('getChanges', "deleted");
                        var updated = $dg.datagrid('getChanges', "updated");
                        
                        var effectRow = new Object();
                        if (inserted.length) {
                            effectRow["inserted"] = JSON.stringify(inserted);
                        }
                        if (deleted.length) {
                            effectRow["deleted"] = JSON.stringify(deleted);
                        }
                        if (updated.length) {
                            effectRow["updated"] = JSON.stringify(updated);
                        }

                        $.post("<@s.url saveUrl/>", effectRow, function(rsp) {
                            if(rsp.success){
                                $.messager.alert("提示", "提交成功！");
                                $dg.datagrid('acceptChanges');
                            }
                            $dg.reload();
                        }, "JSON").error(function() {
                            $.messager.alert("提示", "提交错误了！");
                        });
                    }
                }
            }
             ],
       </#if>     
        <#if onClickRowAuto='true'> 
            onClickRow:function(index){
					    if (endEditing()){
					          <#if onClickRowEdit='true'>
					           	 $dg.datagrid('selectRow', index);
					           	 $dg.datagrid('beginEdit', index);
					    	     editIndex = index;
					         </#if>
					    } else {
					         <#if onClickRowEdit='true'>
					    	    $dg.datagrid('selectRow', editIndex);
					        </#if>
					    }
	              }
	    </#if>          
          };
        
        var opt=$.extend(${jsonExtend!'{}'},$dgExtend);
        $dg.datagrid(opt);
        function endEdit(){
            var rows = $dg.datagrid('getRows');
            for ( var i = 0; i < rows.length; i++) {
                $dg.datagrid('endEdit', i);
            }
        }
        
        function endEditing(){
		    if (editIndex == undefined){
		    	return true;
		    }
		    if ($dg.datagrid('validateRow', editIndex)){
		    	$dg.datagrid('endEdit', editIndex);
			    editIndex = undefined;
			    return true;
		    } else {
		    	return false;
	    	}
	    }
	    
	    <#if (showFooter='true' && footerData!="")>
              $dg.datagrid('reloadFooter',${footerData});
         </#if>
    });
         
    
</script>
 <table id="${id}" ></table>
</#macro>