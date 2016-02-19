package com.cqrcb.service.impl;

import com.cqrcb.dao.StaffDao;
import com.cqrcb.model.Staff;
import com.cqrcb.service.StaffManager;
import org.appfuse.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("staffManager")
@WebService(serviceName = "StaffService", endpointInterface = "com.cqrcb.service.StaffManager")
public class StaffManagerImpl extends GenericManagerImpl<Staff, String> implements StaffManager {
    StaffDao staffDao;

    @Autowired
    public StaffManagerImpl(StaffDao staffDao) {
        super(staffDao);
        this.staffDao = staffDao;
    }
}