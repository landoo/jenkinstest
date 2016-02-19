<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="systemList.title"/></title>
    <meta name="menu" content="SystemMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<h2><fmt:message key="systemList.heading"/></h2>

<form method="get" action="${ctx}/systems" id="searchForm" class="form-inline">
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

<p><fmt:message key="systemList.message"/></p>

<div id="actions" class="btn-group">
    <a href='<c:url value="/systemform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>

<display:table name="systemList" class="table table-condensed table-striped table-hover" requestURI="" id="systemList" export="true" pagesize="25">
    <display:column property="systemId" sortable="true" href="systemform" media="html"
        paramId="systemId" paramProperty="systemId" titleKey="system.systemId"/>
    <display:column property="systemId" media="csv excel xml pdf" titleKey="system.systemId"/>
    <display:column property="systemAbbreviation" sortable="true" titleKey="system.systemAbbreviation"/>
    <display:column property="systemName" sortable="true" titleKey="system.systemName"/>
    <display:column property="systemRemark" sortable="true" titleKey="system.systemRemark"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="systemList.system"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="systemList.systems"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="systemList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="systemList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="systemList.title"/>.pdf</display:setProperty>
</display:table>
