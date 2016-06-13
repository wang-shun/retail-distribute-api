<html>

<body>
	<#if brand??>
		<h3>以下信息为bi-mdm产品同步至分销库的结果</h3>
		<#list brand?keys as key>
			<#assign pros=brand[key].PRODUCT />
			<#assign result=brand[key].RESULT />
			<#if result.ERROR_CODE == '1000'>
				<span style='color:green;font-size:16px;font-weight:bolder'>品牌${key},同步成功^_^</span>
			<#elseif result.ERROR_CODE == '2000'>
				<span style='color:red;font-size:16px;font-weight:bolder'>品牌${key},同步失败,系统异常，已联系管理员</span>
			<#else>
				<span style='color:red;font-size:16px;font-weight:bolder'>品牌${key},同步失败,同步过程中转换数据失败，或者分销库中不存在相应的基础数据</span>
			</#if>
			</br>
			<#--编历产品-->
			<#if pros??>
				<#list pros?keys as key>
					<#assign pro=pros[key] />
					<#if pro.success == false>
						<span style='color:red;padding-left:20px'>货号:${pro.productCode},同步时间:${pro.updateTime},错误信息:${pro.errorInfo},同步的尺寸:${pro.sizeCodeStr},未同步的尺寸:${pro.unSynSizeCodeStr}</span>
					<#else>
						<span style='color:green;padding-left:20px'>货号:${pro.productCode},同步时间:${pro.updateTime},同步的尺寸:${pro.sizeCodeStr},未同步的尺寸:${pro.unSynSizeCodeStr}</span>
					</#if>
					<br/>
				</#list>
			</#if>
		</#list>
	<#else>
		<h3>本次没有信息需要同步</h3>
	</#if>
</body>
</html>