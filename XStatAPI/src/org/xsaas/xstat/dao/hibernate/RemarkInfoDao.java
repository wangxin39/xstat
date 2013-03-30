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
import org.xsaas.xstat.dao.IRemarkInfoDao;
import org.xsaas.xstat.po.RemarkInfo;


public class RemarkInfoDao extends HibernateDaoSupport implements
		IRemarkInfoDao {

	/**
	 * ɾ���ʾ�������Ϣ
	 */
	public void delete(RemarkInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public RemarkInfo getRemarkInfo(Long remarkID) {
		
		return (RemarkInfo) this.getHibernateTemplate().get(RemarkInfo.class, remarkID);
	}
	/**
	 * �����ʾ�������Ϣ
	 */
	public void save(RemarkInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�������Ϣ
	 */
	public void update(RemarkInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<RemarkInfo> getRemarkInfoList() {
		List<RemarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RemarkInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
	 * @param firstResult
	 * @param maxResult
	 * @return list<QuestionnaireRemarkInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<RemarkInfo> findByPage(final long clientID,final int firstResult,final int maxResult) {
		List<RemarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RemarkInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("remarkID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RemarkInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<RemarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RemarkInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("remarkID"));
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
		Criteria query = this.getSession().createCriteria(RemarkInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("remarkID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ��������
	 */
	@SuppressWarnings("unchecked")
	public int getTotal(long clientID) {
		Criteria query = this.getSession().createCriteria(RemarkInfo.class);
		 query.add(Restrictions.eq("status", 1));
			query.add(Restrictions.eq("clientID", clientID));
		query.setProjection(Projections.count("remarkID"));
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
	public List<RemarkInfo> findByPage(final int firstResult,final int maxResult) {
		List<RemarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RemarkInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("remarkID"));
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
		Criteria query = this.getSession().createCriteria(RemarkInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("remarkID"));
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
	public List<RemarkInfo> findByInformant(Long issueID, Long informantID,
			Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(RemarkInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));		
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}



}
