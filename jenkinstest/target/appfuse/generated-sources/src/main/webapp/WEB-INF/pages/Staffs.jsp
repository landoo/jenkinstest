<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="staffList.title"/></title>
    <meta name="menu" content="StaffMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<h2><fmt:message key="staffList.heading"/></h2>

<form method="get" action="${ctx}/staffs" id="searchForm" class="form-inline">
<div id="search" class="text-right">
    <span class="col-sm-9">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
    </span>
    <button id="button.search" class="btn btn-default btn-sm" type="submit">
        <i class="icon-search"></i> <fmt:message key="button.search"/>
    </button>
</div>
</form>

<p><fmt:message key="staffList.message"/></p>

<div id="actions" class="btn-group">
    <a href='<c:url value="/staffform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>

<display:table name="staffList" class="table table-condensed table-striped table-hover" requestURI="" id="staffList" export="true" pagesize="25">
    <display:column property="staffId" sortable="true" href="staffform" media="html"
        paramId="staffId" paramProperty="staffId" titleKey="staff.staffId"/>
    <display:column property="staffId" media="csv excel xml pdf" titleKey="staff.staffId"/>
    <display:column property="staffName" sortable="true" titleKey="staff.staffName"/>
    <display:column property="staffRemark" sortable="true" titleKey="staff.staffRemark"/>
    <display:column property="staffstatus" sortable="true" titleKey="staff.staffstatus"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="staffList.staff"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="staffList.staffs"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="staffList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="staffList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="staffList.title"/>.pdf</display:setProperty>
</display:table>
