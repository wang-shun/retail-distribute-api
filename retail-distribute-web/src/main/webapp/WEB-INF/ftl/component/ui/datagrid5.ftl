<#-- 
此宏生成一个表格  下面有些有自定义的值在用的时候根据需要填
id:表格ID
name:表格name
title:表格标题,空时整个标题栏不显示
columnsJsonList:表格的列,支持列合并
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
enableHeaderClickMenu:是否显示表头小箭头
enableHeaderContextMenu:是否表头右键菜单
emptyMsg:数据为空提示信息
-->
<#macro datagrid
	id="id" name="" title="" columnsJsonList="[]" frozenColumns="[]" jsonExtend="{}" loadUrl="" saveUrl=""   defaultColumn=""  
	isHasToolBar="true" fitColumns="false" showFooter="false" divToolbar=""  height="" width="" onClickRowEdit="true" singleSelect="true" pageSize='20'  
	pagination="true" rownumbers="true" onClickRowAuto="true" fit="" idField="" enableHeaderClickMenu="true" enableHeaderContextMenu="true" emptyMsg="暂无数据" >
 

<script type="text/javascript">
    $(function() {
        var $dg = $("#${id!}");
        var editIndex = undefined;
        var $dgExtend={
            <#if loadUrl!="">
            url : "<@s.url loadUrl/>",
            </#if>
            title:"${title}",
            <#if height!="">
                height : "${height}",
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
            pageList:[20,50,100,200,300,400,500],
            checkOnSelect:false,
            <#if pagination='true'>
                pagination:true,
                <#else>
                pagination:false,
            </#if>
            <#if fitColumns='true'>
                fitColumns:true,
                <#else>
                fitColumns:false,
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
            <#if showFooter=='true'>
                  showFooter:true,
                  <#else>
                  showFooter:false,
            </#if>
            <#if enableHeaderContextMenu=='true'>
                  enableHeaderContextMenu:true,
                  <#else>
                  enableHeaderContextMenu:false,
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
             
          };
        
        var opt=$.extend(${jsonExtend!'{}'},$dgExtend);
        $dg.datagrid(opt);
    
    });
</script>
 <table id="${id}" ></table>
</#macro>