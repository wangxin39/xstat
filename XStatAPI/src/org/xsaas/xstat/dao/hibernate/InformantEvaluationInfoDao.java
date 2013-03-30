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
import org.xsaas.xstat.dao.IInformantEvaluationInfoDao;
import org.xsaas.xstat.po.InformantEvaluationInfo;


public class InformantEvaluationInfoDao extends HibernateDaoSupport implements IInformantEvaluationInfoDao{

	/**
	 * ɾ���ʾ���Ϣ
	 */
	public void delete(InformantEvaluationInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public InformantEvaluationInfo getInformantEvaluationInfo(Long evaluationID) {		
		return (InformantEvaluationInfo) this.getHibernateTemplate().get(InformantEvaluationInfo.class,evaluationID);
	}
	/**
	 * �����ʾ���Ϣ
	 */
	public void save(InformantEvaluationInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ���Ϣ
	 */
	public void update(InformantEvaluationInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<InformantEvaluationInfo> getInformantEvaluationInfoList() {
		List<InformantEvaluationInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantEvaluationInfo.class);	
				 query.addOrder(Order.desc("evaluationID"));
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
	 * @return list<InquisitionEvaluateInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<InformantEvaluationInfo> findByPage(final int firstResult,final int maxResult) {
		List<InformantEvaluationInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantEvaluationInfo.class);		 
				 query.addOrder(Order.desc("evaluationID"));
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
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(InformantEvaluationInfo.class);
		query.setProjection(Projections.count("evaluationID"));
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
	public List<InformantEvaluationInfo> findByInformant(final Long issueID,final Long informantID) {
		 Criteria query = this.getSession().createCriteria(InformantEvaluationInfo.class);		
		 query.addOrder(Order.desc("evaluationID"));
		 query.add(Restrictions.eq("issueID", issueID));
		 query.add(Restrictions.eq("informantID", informantID));
		 query.setMaxResults(Integer.MAX_VALUE);			 
		 return query.list();
	}



}
