package com.cqrcb.webapp.controller;

import com.cqrcb.service.SystemManager;
import com.cqrcb.model.System;

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

public class SystemControllerTest extends BaseControllerTestCase {
    @Autowired
    private SystemManager systemManager;
    @Autowired
    private SystemController controller;

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
        mockMvc.perform(get("/systems"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("systemList"))
            .andExpect(view().name("systems"));
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        systemManager.reindex();

        Map<String,Object> model = mockMvc.perform((get("/systems")).param("q", "*"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("systemList"))
            .andReturn()
            .getModelAndView()
            .getModel();

        List results = (List) model.get("systemList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}
