package com.cqrcb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqrcb.dao.StaffDao;
import com.cqrcb.model.Staff;
import org.appfuse.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class StaffManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private StaffManagerImpl manager;

    @Mock
    private StaffDao dao;

    @Test
    public void testGetStaff() {
        log.debug("testing get...");
        //given
        final String staffId = "0000001";
        final Staff staff = new Staff();
        given(dao.get(staffId)).willReturn(staff);

        //when
        Staff result = manager.get(staffId);

        //then
        assertSame(staff, result);
    }

    @Test
    public void testGetStaffs() {
        log.debug("testing getAll...");
        //given
        final List<Staff> staffs = new ArrayList<>();
        given(dao.getAll()).willReturn(staffs);

        //when
        List result = manager.getAll();

        //then
        assertSame(staffs, result);
    }

    @Test
    public void testSaveStaff() {
        log.debug("testing save...");

        //given
        final Staff staff = new Staff();
        // enter all required fields
        staff.setStaffName("WlKcXySvNfJ");
        staff.setStaffstatus(1L);

        given(dao.save(staff)).willReturn(staff);

        //when
        manager.save(staff);

        //then
        verify(dao).save(staff);
    }

    @Test
    public void testRemoveStaff() {
        log.debug("testing remove...");

        //given
        final String staffId = "0000001";
        willDoNothing().given(dao).remove(staffId);

        //when
        manager.remove(staffId);

        //then
        verify(dao).remove(staffId);
    }
}
