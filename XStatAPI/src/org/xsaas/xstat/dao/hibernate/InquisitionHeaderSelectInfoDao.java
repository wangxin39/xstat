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
import org.xsaas.xstat.dao.IInquisitionHeaderSelectInfoDao;
import org.xsaas.xstat.po.InquisitionHeaderSelectInfo;


public class InquisitionHeaderSelectInfoDao extends HibernateDaoSupport implements	IInquisitionHeaderSelectInfoDao{

	/**
	 * ɾ���ʾ���Ϣ
	 */
	public void delete(InquisitionHeaderSelectInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public InquisitionHeaderSelectInfo getInquisitionHeaderSelectInfo(Long headerSelectID) {
		
		return (InquisitionHeaderSelectInfo) this.getHibernateTemplate().get(InquisitionHeaderSelectInfo.class, headerSelectID);
	}
	/**
	 * �����ʾ���Ϣ
	 */
	public void save(InquisitionHeaderSelectInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ���Ϣ
	 */
	public void update(InquisitionHeaderSelectInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<InquisitionHeaderSelectInfo> getList() {
		List<InquisitionHeaderSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderSelectInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("headerSelectID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InquisitionHeaderSelectInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<InquisitionHeaderSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderSelectInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("headerSelectID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionHeaderSelectInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("headerSelectID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult
	 * @param maxResult
	 * @return list<InquisitionHeaderSelectInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<InquisitionHeaderSelectInfo> findByPage(final Long headerID,final int firstResult,final int maxResult) {
		List<InquisitionHeaderSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderSelectInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("headerID", headerID));
				 query.addOrder(Order.desc("headerSelectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return \��������
	 */
	@SuppressWarnings("unchecked")
	public int getTotal(Long headerID) {
		Criteria query = this.getSession().createCriteria(InquisitionHeaderSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("headerID", headerID));
		query.setProjection(Projections.count("headerSelectID"));
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
	public List<InquisitionHeaderSelectInfo> findByPage(final int firstResult,final int maxResult) {
		List<InquisitionHeaderSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderSelectInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("headerSelectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(InquisitionHeaderSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("headerSelectID"));
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
	public List<InquisitionHeaderSelectInfo> getList(Long inquisitionID,Long headerID) {		
		 Criteria query = this.getSession().createCriteria(InquisitionHeaderSelectInfo.class);	
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("headerID", headerID));
		 query.addOrder(Order.desc("headerSelectID"));
		 query.setMaxResults(Integer.MAX_VALUE);			 
		 return query.list();
	}



}
