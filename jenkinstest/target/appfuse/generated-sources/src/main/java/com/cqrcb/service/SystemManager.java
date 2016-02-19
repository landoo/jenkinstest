package com.cqrcb.service;

import org.appfuse.service.GenericManager;
import com.cqrcb.model.System;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface SystemManager extends GenericManager<System, String> {
    
}