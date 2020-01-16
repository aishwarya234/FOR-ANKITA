package org.deloitte.sms.studentstaffdetailsmanagement.dao.impl;

import java.util.List;

import org.deloitte.sms.studentstaffdetailsmanagement.beans.StaffInfo;
import org.deloitte.sms.studentstaffdetailsmanagement.dao.StaffDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository

public class StaffDaoImpl implements StaffDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<StaffInfo> getStaffs() {
		
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<StaffInfo> list=session.createQuery("from StaffInfo").list();
		 
		return list;
		
	}

}
