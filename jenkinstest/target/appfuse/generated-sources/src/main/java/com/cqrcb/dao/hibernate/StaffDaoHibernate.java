package com.cqrcb.dao.hibernate;

import com.cqrcb.model.Staff;
import com.cqrcb.dao.StaffDao;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("staffDao")
public class StaffDaoHibernate extends GenericDaoHibernate<Staff, String> implements StaffDao {

    public StaffDaoHibernate() {
        super(Staff.class);
    }
}
