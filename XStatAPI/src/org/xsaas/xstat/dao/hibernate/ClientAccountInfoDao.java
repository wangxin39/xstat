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
import org.xsaas.xstat.dao.IClientAccountInfoDao;
import org.xsaas.xstat.po.ClientAccountInfo;


public class ClientAccountInfoDao extends HibernateDaoSupport implements
		IClientAccountInfoDao {

	@Override
	public void deleteClientAccountInfo(ClientAccountInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int firstResult,final
			int maxResult) {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("accountID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public ClientAccountInfo getClientAccountInfo(Long accountID) {
		
		return (ClientAccountInfo) this.getHibernateTemplate().get(ClientAccountInfo.class, accountID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientAccountInfo> getClientAccountInfoList() {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("accountID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getClientAccountInfoTotal() {
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("accountID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveClientAccountInfo(ClientAccountInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateClientAccountInfo(ClientAccountInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientAccountInfo> findClientAccountInfoByPage(final int account,
		   final int firstResult,final int maxResult) {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("account", account));		
				 query.addOrder(Order.desc("accountID"));				 		 
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getClientAccountInfoTotal(int account) {
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("account", account));
		query.setProjection(Projections.count("accountID"));		
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
	public List<ClientAccountInfo> getClientAccountInfoList(final Long clientID,
			final Long informantID) {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.add(Restrictions.eq("informantID", informantID));	
				 query.addOrder(Order.desc("accountID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientAccountInfo> findClientAccountInfoByPage(final Long clientID,final int firstResult,final int maxResult) {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));	
				 query.addOrder(Order.desc("accountID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getClientAccountInfoTotal(Long clientID) {
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("clientID", clientID));	
		query.setProjection(Projections.count("accountID"));
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
	public ClientAccountInfo isLogin(String loginname, String password) {
		ClientAccountInfo info = null;
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("loginName", loginname));
		query.add(Restrictions.eq("passWord", password));
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
			info = (ClientAccountInfo)list.get(0);
		}
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isRegister(String loginname, String password) {
		boolean yes = false;
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("loginName", loginname));
		query.add(Restrictions.eq("passWord", password));
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
	public List<ClientAccountInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ClientAccountInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientAccountInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("accountID"));
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
		Criteria query = this.getSession().createCriteria(ClientAccountInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("accountID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
