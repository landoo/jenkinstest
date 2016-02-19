package com.cqrcb.dao.hibernate;

import com.cqrcb.model.System;
import com.cqrcb.dao.SystemDao;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("systemDao")
public class SystemDaoHibernate extends GenericDaoHibernate<System, String> implements SystemDao {

    public SystemDaoHibernate() {
        super(System.class);
    }
}
