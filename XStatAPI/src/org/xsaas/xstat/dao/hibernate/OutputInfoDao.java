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
import org.xsaas.xstat.dao.IOutputInfoDao;
import org.xsaas.xstat.po.OutputInfo;


public class OutputInfoDao extends HibernateDaoSupport implements IOutputInfoDao {
	/**
	 * ɾ���ʾ�����Ϣ
	 */
	public void deleteOutputInfo(OutputInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public OutputInfo getOutputInfo(Long statID) {
		
		return (OutputInfo) this.getHibernateTemplate().get(OutputInfo.class, statID);
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void saveOutputInfo(OutputInfo data) {
		this.getHibernateTemplate().save(data);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OutputInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<OutputInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(OutputInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("outputID"));
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
		Criteria query = this.getSession().createCriteria(OutputInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("outputID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void updateOutputInfo(OutputInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<OutputInfo> getOutputInfoList() {
		List<OutputInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(OutputInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("outputID"));
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
	 * @return list<OutputInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<OutputInfo> findOutputInfoByPage(final int firstResult,final int maxResult) {
		List<OutputInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(OutputInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("outputID"));
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
	public int getOutputInfoTotal() {
		Criteria query = this.getSession().createCriteria(OutputInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("outputID"));
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
	public List<OutputInfo> findByPage(final Long informantID,final Long issueID,final int firstResult,final int maxResult) {
		List<OutputInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(OutputInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("informantID", informantID));
				 query.add(Restrictions.eq("issueID", issueID));
				 query.addOrder(Order.desc("outputID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(OutputInfo.class);
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("informantID", informantID));
		 query.add(Restrictions.eq("issueID", issueID));
		query.setProjection(Projections.count("outputID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
