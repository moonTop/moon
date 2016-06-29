img {	cursor: pointer; }

.iconImg {
	width: 16px;
	height: 16px;
	cursor: pointer;
}
.icon_img{
	position:relative;
	float:left;
	margin-top:1px;
}

<#list list as item>
<#list item as ite>
.ext-icon-${ite.folder}-${ite.fileName} { background: url('images/ext_icons/${ite.folder}/${ite.file}') no-repeat ; }
</#list>

</#list>