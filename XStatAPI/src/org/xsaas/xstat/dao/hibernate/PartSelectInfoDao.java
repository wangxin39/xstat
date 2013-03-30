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
import org.xsaas.xstat.dao.IPartSelectInfoDao;
import org.xsaas.xstat.po.PartSelectInfo;


public class PartSelectInfoDao extends HibernateDaoSupport implements
		IPartSelectInfoDao {

	/**
	 * ɾ���ʾ���ѡ����Ϣ
	 */
	public void delete(PartSelectInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public PartSelectInfo getPartSelectInfo(Long PartSelectID) {
		
		return (PartSelectInfo) this.getHibernateTemplate().get(PartSelectInfo.class, PartSelectID);
	}
	/**
	 * �����ʾ���ѡ����Ϣ
	 */
	public void save(PartSelectInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ���ѡ����Ϣ
	 */
	public void update(PartSelectInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<PartSelectInfo> getPartSelectInfoList() {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("partSelectID"));
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
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("partSelectID"));
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
	 * @return list<PartSelectInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PartSelectInfo> findByPage(final long partQuestionID,final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("partQuestionID", partQuestionID));
				 query.addOrder(Order.desc("partSelectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ��������
	 */
	@SuppressWarnings("unchecked")
	public int getTotal(long partQuestionID) {
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setProjection(Projections.count("partSelectID"));
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
	public List<PartSelectInfo> findByQuestion(Long inquisitionID, Long partQuestionID) {		
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findByQuestion(Long partQuestionID) {		
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findPartSelectInfoByPage(final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("partSelectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getPartSelectInfoTotal() {
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("partSelectID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
