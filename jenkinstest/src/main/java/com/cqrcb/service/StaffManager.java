package com.cqrcb.service;

import org.appfuse.service.GenericManager;
import com.cqrcb.model.Staff;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface StaffManager extends GenericManager<Staff, String> {
    
}