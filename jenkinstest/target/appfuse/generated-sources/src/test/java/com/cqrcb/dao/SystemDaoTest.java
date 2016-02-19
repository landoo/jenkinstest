package com.cqrcb.dao;

import org.appfuse.dao.BaseDaoTestCase;
import com.cqrcb.model.System;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SystemDaoTest extends BaseDaoTestCase {
    @Autowired
    private SystemDao systemDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveSystem() {
        System system = new System();

        // enter all required fields
        system.setSystemAbbreviation("GzNsEeNpWhDhKeKh");
        system.setSystemName("VdBsSlTuZxBoKiCvZrYwImGwIjGrGlPvShKlFfGcTbVvYrYdLoCuPoKuVxQqNsQj");

        log.debug("adding system...");
        system = systemDao.save(system);

        system = systemDao.get(system.getSystemId());

        assertNotNull(system.getSystemId());

        log.debug("removing system...");

        systemDao.remove(system.getSystemId());

        // should throw DataAccessException 
        systemDao.get(system.getSystemId());
    }
}