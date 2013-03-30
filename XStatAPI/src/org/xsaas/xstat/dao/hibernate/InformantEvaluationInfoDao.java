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
	 * 删除问卷信息
	 */
	public void delete(InformantEvaluationInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public InformantEvaluationInfo getInformantEvaluationInfo(Long evaluationID) {		
		return (InformantEvaluationInfo) this.getHibernateTemplate().get(InformantEvaluationInfo.class,evaluationID);
	}
	/**
	 * 保存问卷信息
	 */
	public void save(InformantEvaluationInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷信息
	 */
	public void update(InformantEvaluationInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
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
	 * 通过指定的起始数和结束数得到一个集合
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
	 * 通过指定的起始数获取总集合
	 * @return \集合总数
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
