package com.cqrcb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cqrcb.dao.SystemDao;
import com.cqrcb.model.System;
import org.appfuse.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class SystemManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private SystemManagerImpl manager;

    @Mock
    private SystemDao dao;

    @Test
    public void testGetSystem() {
        log.debug("testing get...");
        //given
        final String systemId = 7L;
        final System system = new System();
        given(dao.get(systemId)).willReturn(system);

        //when
        System result = manager.get(systemId);

        //then
        assertSame(system, result);
    }

    @Test
    public void testGetSystems() {
        log.debug("testing getAll...");
        //given
        final List<System> systems = new ArrayList<>();
        given(dao.getAll()).willReturn(systems);

        //when
        List result = manager.getAll();

        //then
        assertSame(systems, result);
    }

    @Test
    public void testSaveSystem() {
        log.debug("testing save...");

        //given
        final System system = new System();
        // enter all required fields
        system.setSystemAbbreviation("KfDkYlJnVaFgVaIa");
        system.setSystemName("KwGfTjTwNsFmKxFdOpJnIzWsBiLgLdAiTsHjIbKkTlDfZsNbThZfHbUbZaHmVxDd");

        given(dao.save(system)).willReturn(system);

        //when
        manager.save(system);

        //then
        verify(dao).save(system);
    }

    @Test
    public void testRemoveSystem() {
        log.debug("testing remove...");

        //given
        final String systemId = -11L;
        willDoNothing().given(dao).remove(systemId);

        //when
        manager.remove(systemId);

        //then
        verify(dao).remove(systemId);
    }
}
