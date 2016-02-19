package com.cqrcb.webapp.controller;

import org.appfuse.dao.SearchException;
import com.cqrcb.service.StaffManager;
import com.cqrcb.model.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staffs*")
public class StaffController {
    private StaffManager staffManager;

    @Autowired
    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(staffManager.search(query, Staff.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(staffManager.getAll());
        }
        return model;
    }
}
