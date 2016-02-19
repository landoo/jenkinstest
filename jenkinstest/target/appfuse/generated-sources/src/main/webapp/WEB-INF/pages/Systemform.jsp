<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="systemDetail.title"/></title>
    <meta name="menu" content="SystemMenu"/>
    <meta name="heading" content="<fmt:message key='systemDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="systemList.system"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-3">
    <h2><fmt:message key="systemDetail.heading"/></h2>
    <fmt:message key="systemDetail.message"/>
</div>

<div class="col-sm-6">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="system" method="post" action="systemform" cssClass="well"
           id="systemForm" onsubmit="return validateSystem(this)">
    <spring:bind path="system.systemId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="system.systemId" styleClass="control-label"/>
        <form:input path="systemId" id="systemId"/>
        <form:errors path="systemId" cssClass="help-block"/>
    </div>
    <spring:bind path="system.systemAbbreviation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="system.systemAbbreviation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="systemAbbreviation" id="systemAbbreviation"  maxlength="16"/>
        <form:errors path="systemAbbreviation" cssClass="help-block"/>
    </div>
    <spring:bind path="system.systemName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="system.systemName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="systemName" id="systemName"  maxlength="64"/>
        <form:errors path="systemName" cssClass="help-block"/>
    </div>
    <spring:bind path="system.systemRemark">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="system.systemRemark" styleClass="control-label"/>
        <form:input cssClass="form-control" path="systemRemark" id="systemRemark"  maxlength="65535"/>
        <form:errors path="systemRemark" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" id="save" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty system.systemId}">
            <button type="submit" class="btn btn-danger" id="delete" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" id="cancel" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="system" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['systemForm']).focus();
    });
</script>
