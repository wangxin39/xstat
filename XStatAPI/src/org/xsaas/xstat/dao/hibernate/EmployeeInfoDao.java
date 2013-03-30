package org.xsaas.xstat.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IEmployeeInfoDao;
import org.xsaas.xstat.po.EmployeeInfo;
import org.xsaas.xstat.util.CacheTool;


public class EmployeeInfoDao extends HibernateDaoSupport implements
		IEmployeeInfoDao {

	@Override
	public void deleteEmployeeInfo(EmployeeInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeInfo> findEmployeeInfoByPage(final int firstResult,final
			int maxResult) {
		List<EmployeeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmployeeInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("employeeID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public EmployeeInfo getEmployeeInfo(Long employeeID) {
		Object obj = CacheTool.get("EMPLOYEE_ID_"+employeeID);
		EmployeeInfo info = null;
		if(obj == null) {
			info = (EmployeeInfo) this.getHibernateTemplate().get(EmployeeInfo.class, employeeID);
			if(info != null) {
				CacheTool.delete("EMPLOYEE_ID_"+info.getEmployeeID());
				CacheTool.add("EMPLOYEE_ID_"+info.getEmployeeID(), info);
			}
		}else{
			info = (EmployeeInfo)obj;
		}		
		return info;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeInfo> getEmployeeInfoList() {
		List<EmployeeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmployeeInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("employeeID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	

	@Override
	public void saveEmployeeInfo(EmployeeInfo data) {		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateEmployeeInfo(EmployeeInfo data) {		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeInfo> findEmployeeInfoByPage(final int status,final int firstResult,final int maxResult) {
		List<EmployeeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmployeeInfo.class);					 
				 query.add(Restrictions.eq("status",status));
				 query.addOrder(Order.desc("employeeID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getEmployeeInfoTotal(int status) {
		Criteria query = this.getSession().createCriteria(EmployeeInfo.class);
		query.add(Restrictions.eq("status",status));
		query.setProjection(Projections.count("employeeID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	@SuppressWarnings("unchecked")
	public int getEmployeeInfoTotal() {
		Criteria query = this.getSession().createCriteria(EmployeeInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("employeeID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeInfo isLogin(String loginname, String password) {
		EmployeeInfo info = null;
		Criteria query = this.getSession().createCriteria(EmployeeInfo.class);
		query.add(Restrictions.eq("loginName", loginname));
		query.add(Restrictions.eq("passWord", password));
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
			info = (EmployeeInfo)list.get(0);
		}
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isRegister(String loginName, String passWord) {
		boolean yes = false;
		Criteria query = this.getSession().createCriteria(EmployeeInfo.class);
		query.add(Restrictions.eq("loginName", loginName));
		query.add(Restrictions.eq("passWord", passWord));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
//			当数据库有记录时，返回值为已注册过此用户，如果为0，则表示没有注册
			int num = (Integer) list.get(0);
			if(num > 0){
				yes = true;
			}
		}
		return yes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<EmployeeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmployeeInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("employeeID"));				 
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalByDelStatus() {
		Criteria query = this.getSession().createCriteria(EmployeeInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("employeeID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
