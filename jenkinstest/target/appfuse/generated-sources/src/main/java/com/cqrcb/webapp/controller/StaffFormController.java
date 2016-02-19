package com.cqrcb.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.cqrcb.service.StaffManager;
import com.cqrcb.model.Staff;
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
@RequestMapping("/staffform*")
public class StaffFormController extends BaseFormController {
    private StaffManager staffManager = null;

    @Autowired
    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public StaffFormController() {
        setCancelView("redirect:staffs");
        setSuccessView("redirect:staffs");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Staff showForm(HttpServletRequest request)
    throws Exception {
        String staffId = request.getParameter("staffId");

        if (!StringUtils.isBlank(staffId)) {
            return staffManager.get(new String(staffId));
        }

        return new Staff();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Staff staff, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(staff, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "staffform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (staff.getStaffId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            staffManager.remove(staff.getStaffId());
            saveMessage(request, getText("staff.deleted", locale));
        } else {
            staffManager.save(staff);
            String key = (isNew) ? "staff.added" : "staff.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:staffform?staffId=" + staff.getStaffId();
            }
        }

        return success;
    }
}
