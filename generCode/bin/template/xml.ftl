<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!-- 
         符号转义说明
    &lt;          < 
    &gt;          >  
    &lt;&gt;     <>
    &amp;        & 
    &apos;       '
    &quot;       "
  <![CDATA[ 这里写你的SQL或者符号 ]]> 
 -->
${"<!--"} ${authorOriginally} ${"-->"}
${"<!--"} ${tableRemark} ${"-->"}
<mapper namespace="${namespace}Mapper" >
	<!-- Result Map 数据库映射到实体类  -->
	<resultMap id="tableMapToModel" type="${packageName}.${beanName}" >
	<#list fields as field>
		<result column="${field.fieldName}" property="${field.fieldName}"/>	${"<!--"} ${field.remark} ${"-->"}
	</#list>
	</resultMap>
  	
  	<!-- tableColumns  所有列 -->
	<sql id="tableColumns" >
		<trim suffix="" suffixOverrides=",">
		<#list fields as field>
			a.${field.column}	as	${field.fieldName},	${"<!--"} ${field.remark} ${"-->"}
		</#list>
		</trim>
	</sql>
	
	<!-- insertColumns 入库列 -->
	<sql id="insertColumns">
		<trim suffix="" suffixOverrides=",">
		<#list fields as field>
			<if test="${field.fieldName} != null and ${field.fieldName} != '' " >
				${field.column},	${"<!--"} ${field.remark} ${"-->"}
			</if>
		</#list>
	    </trim>
	</sql>
	
	<!-- insertParams  入库值 -->
	<sql id="insertParams">
		<trim suffix="" suffixOverrides=",">
		<#list fields as field>
			<if test="${field.fieldName} != null and ${field.fieldName} != '' " >
				${"#"}{${field.fieldName}},	${"<!--"} ${field.remark} ${"-->"}
			</if>
		</#list>
	    </trim>
	</sql>
	
	<!-- updateParams  更新列 -->
	<sql id="updateParams">
		<trim suffix="" suffixOverrides=",">
		<#list fields as field>
			<if test="${field.fieldName} != null " >
				a.${field.column} = ${"#"}{${field.fieldName}},	${"<!--"} ${field.remark} ${"-->"}
			</if>
		</#list>
	    </trim>
	</sql>
  
  	<!-- 查询条件  包含所有 -->
	<sql id="andAll">
		<trim  suffixOverrides="," >
		<#list fields as field>
			<if test="${field.fieldName} != null " >
				and a.${field.column} = ${"#"}{${field.fieldName}}	${"<!--"} ${field.remark} ${"-->"}
			</if>
		</#list>
		</trim>
	</sql>
	
	<!-- 模糊查询判断 -->
	<sql id="andLike">
		<trim  suffixOverrides="," >
		<#list fields as field>
			<if test="${field.fieldName} != null and ${field.fieldName} != '' " >
				and a.${field.column} like '%${"$"}{${field.fieldName}}%'	${"<!--"} ${field.remark} ${"-->"}
		    </if>
		</#list>
		</trim>
	</sql>
	
	<!-- columnKey  主键 列名称 ,视图获取不到主键 需要设置 -->
	<sql id="columnKey">
		<#list fields as field>
		<#if field.isPK?index_of("true")!=-1>
		and a.${field.column} = ${"#"}{${field.fieldName}}	${"<!--"} ${field.remark} ${"-->"}
	    </#if>
		</#list>
	</sql>
	
	
  	<!-- 添加,插入记录   -->
	<insert id="insert" parameterType="${packageName}.${beanName}" >
	    insert into ${tabName} (<include refid="insertColumns"/>) values(<include refid="insertParams"/>)
	</insert>
	
	<!-- 删除,主键删除   -->
	<delete id="deleteByPrimaryKey" parameterType="${packageName}.${beanName}">
	    delete a from ${tabName} a where 1=1 <include refid="columnKey"/>
	</delete>
	
	<!-- 删除,实体删除   -->
	<delete id="deleteByEntity" parameterType="${packageName}.${beanName}">
	    delete a from ${tabName} a where 1=1 <include refid="andAll"/>
	</delete>
	
	<!-- 修改,主键更新  -->
	<update id="updateByPrimaryKey" parameterType="${packageName}.${beanName}" >
		update ${tabName} a 
			<set><include refid="updateParams"/></set>
			where 1=1 <include refid="columnKey"/>
	</update>
	
	<!-- 查询,实体查询   -->
	<select id="selectByEntiry" resultMap="tableMapToModel" parameterType="${packageName}.${beanName}">
		select <include refid="tableColumns"/> 
		from ${tabName} a 
		where 1=1 <include refid="andAll"/>
	</select>
	
	<!-- 查询,ID查询   -->
	<select id="selectById" resultMap="tableMapToModel" parameterType="java.lang.String">
		select <include refid="tableColumns"/> 
		from ${tabName} a 
		where 1=1 <include refid="columnKey"/>
	</select>
	
	<!-- 查询,Map参数查询 -->
	<select id="selectByMap" resultMap="tableMapToModel"  parameterType="com.tw.sys.dto.ParamDTO">
		select <include refid="tableColumns"/>
		from ${tabName} a 
		where 1=1 <include refid="andAll"/>
	</select>
	
	<!-- 分页查询,ParamDTO参数查询 -->
	<select id="queryPage" resultMap="tableMapToModel"  parameterType="com.tw.sys.dto.ParamDTO">
		select <include refid="tableColumns"/>
		from ${tabName} a 
		where 1=1 <include refid="andAll"/>
	</select>
  
</mapper>