<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="staffDetail.title"/></title>
    <meta name="menu" content="StaffMenu"/>
    <meta name="heading" content="<fmt:message key='staffDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="staffList.staff"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-3">
    <h2><fmt:message key="staffDetail.heading"/></h2>
    <fmt:message key="staffDetail.message"/>
</div>

<div class="col-sm-6">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="staff" method="post" action="staffform" cssClass="well"
           id="staffForm" onsubmit="return validateStaff(this)">
    <spring:bind path="staff.staffId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="staff.staffId" styleClass="control-label"/>
        <form:input path="staffId" id="staffId"/>
        <form:errors path="staffId" cssClass="help-block"/>
    </div>
    <spring:bind path="staff.staffName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="staff.staffName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="staffName" id="staffName"  maxlength="11"/>
        <form:errors path="staffName" cssClass="help-block"/>
    </div>
    <spring:bind path="staff.staffRemark">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="staff.staffRemark" styleClass="control-label"/>
        <form:input cssClass="form-control" path="staffRemark" id="staffRemark"  maxlength="255"/>
        <form:errors path="staffRemark" cssClass="help-block"/>
    </div>
    <spring:bind path="staff.staffstatus">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="staff.staffstatus" styleClass="control-label"/>
        <form:input cssClass="form-control" path="staffstatus" id="staffstatus"  maxlength="255"/>
        <form:errors path="staffstatus" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" id="save" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty staff.staffId}">
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

<v:javascript formName="staff" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['staffForm']).focus();
    });
</script>
