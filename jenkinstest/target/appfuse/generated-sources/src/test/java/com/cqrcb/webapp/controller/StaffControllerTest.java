package com.cqrcb.webapp.controller;

import com.cqrcb.service.StaffManager;
import com.cqrcb.model.Staff;

import com.cqrcb.webapp.controller.BaseControllerTestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StaffControllerTest extends BaseControllerTestCase {
    @Autowired
    private StaffManager staffManager;
    @Autowired
    private StaffController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testHandleRequest() throws Exception {
        mockMvc.perform(get("/staffs"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("staffList"))
            .andExpect(view().name("staffs"));
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        staffManager.reindex();

        Map<String,Object> model = mockMvc.perform((get("/staffs")).param("q", "*"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("staffList"))
            .andReturn()
            .getModelAndView()
            .getModel();

        List results = (List) model.get("staffList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}
