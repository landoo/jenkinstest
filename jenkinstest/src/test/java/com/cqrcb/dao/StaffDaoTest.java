package com.cqrcb.dao;

import org.appfuse.dao.BaseDaoTestCase;
import com.cqrcb.model.Staff;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaffDaoTest extends BaseDaoTestCase {
    @Autowired
    private StaffDao staffDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveStaff() {
        Staff staff = new Staff();

        // enter all required fields
        staff.setStaffName("YlRvSzUvWpP");
        staff.setStaffstatus(1L);

        log.debug("adding staff...");
        staff = staffDao.save(staff);

        staff = staffDao.get(staff.getStaffId());

        assertNotNull(staff.getStaffId());

        log.debug("removing staff...");

        staffDao.remove(staff.getStaffId());

        // should throw DataAccessException 
        staffDao.get(staff.getStaffId());
    }
}