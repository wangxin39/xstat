package org.xsaas.xstat.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IFinalEvaluationInfoDao;
import org.xsaas.xstat.po.FinalEvaluationInfo;



public class FinalEvaluationInfoDao extends HibernateDaoSupport implements
		IFinalEvaluationInfoDao {
	/**
	 * 删除项目培训信息
	 */
	public void delete(FinalEvaluationInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public FinalEvaluationInfo getFinalEvaluationInfo(Long finalEvaluationID) {
		
		return (FinalEvaluationInfo) this.getHibernateTemplate().get(FinalEvaluationInfo.class, finalEvaluationID);
	}
	/**
	 * 保存项目培训信息
	 */
	public void save(FinalEvaluationInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新项目培训信息
	 */
	public void update(FinalEvaluationInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<FinalEvaluationInfo> getFinalEvaluationInfoList() {
		List<FinalEvaluationInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(FinalEvaluationInfo.class);		 
				 query.addOrder(Order.desc("finalEvaluationID"));
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
	 * @return list<QuestionnaireFinalEvaluationInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<FinalEvaluationInfo> findByPage(final int firstResult,final int maxResult) {
		List<FinalEvaluationInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(FinalEvaluationInfo.class);		 
				 query.addOrder(Order.desc("finalEvaluationID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return 集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(FinalEvaluationInfo.class);
		query.setProjection(Projections.count("finalEvaluationID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}


}
