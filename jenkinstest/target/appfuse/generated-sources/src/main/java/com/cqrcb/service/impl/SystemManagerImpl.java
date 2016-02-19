package com.cqrcb.service.impl;

import com.cqrcb.dao.SystemDao;
import com.cqrcb.model.System;
import com.cqrcb.service.SystemManager;
import org.appfuse.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("systemManager")
@WebService(serviceName = "SystemService", endpointInterface = "com.cqrcb.service.SystemManager")
public class SystemManagerImpl extends GenericManagerImpl<System, String> implements SystemManager {
    SystemDao systemDao;

    @Autowired
    public SystemManagerImpl(SystemDao systemDao) {
        super(systemDao);
        this.systemDao = systemDao;
    }
}