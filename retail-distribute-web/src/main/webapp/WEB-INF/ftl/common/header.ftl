<#assign BasePath = springMacroRequestContext.getContextPath()/>
<script type="text/javascript">
	var staticurl = '${staticFileUrl}';
	var pic_file_url = '${pic_file_url}';
	var BasePath = '${springMacroRequestContext.getContextPath()}';
	var currentZoneNo="1";//默认1 标识后台要获取当前登录大区做过滤条件
	var sysDate = "${.now?string('yyyy-MM-dd')}";
	var options = [${options}];
</script>
<!--
<link rel="stylesheet" href="<@s.url '/resources/css/gms.css'/>" type="text/css" />
-->
<link rel="stylesheet" href="<@s.url '/resources/css/sys-window.css'/>" type="text/css" />
<script type="text/javascript" src="${staticFileUrl}/boot.js?version=${version}"></script>
<!--<script type="text/javascript" src="<@s.url "/resources/common/boot.js?version=${version}"/>"></script>-->
<script type="text/javascript" src="<@s.url "/resources/common/easyui.validate.extends.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/common/easyui_dataGrid.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/js/common.js?version=${version}"/>"></script>
<!--
<script type="text/javascript" src="<@s.url "/resources/js/gms.data.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/js/gms.common.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/js/gms.plugin.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/js/gms.grid.js?version=${version}"/>"></script>
<script type="text/javascript" src="<@s.url "/resources/js/gms.js?version=${version}"/>"></script>
-->
<script type="text/javascript" src="<@s.url "/resources/common/jquery.importexcel.js?version=${version}"/>"></script>
