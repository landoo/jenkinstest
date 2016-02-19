package com.cqrcb.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.cqrcb.service.SystemManager;
import com.cqrcb.model.System;
import com.cqrcb.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/systemform*")
public class SystemFormController extends BaseFormController {
    private SystemManager systemManager = null;

    @Autowired
    public void setSystemManager(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    public SystemFormController() {
        setCancelView("redirect:systems");
        setSuccessView("redirect:systems");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected System showForm(HttpServletRequest request)
    throws Exception {
        String systemId = request.getParameter("systemId");

        if (!StringUtils.isBlank(systemId)) {
            return systemManager.get(new String(systemId));
        }

        return new System();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(System system, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(system, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "systemform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (system.getSystemId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            systemManager.remove(system.getSystemId());
            saveMessage(request, getText("system.deleted", locale));
        } else {
            systemManager.save(system);
            String key = (isNew) ? "system.added" : "system.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:systemform?systemId=" + system.getSystemId();
            }
        }

        return success;
    }
}
