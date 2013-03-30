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
import org.xsaas.xstat.dao.IStatQuestionInfoDao;
import org.xsaas.xstat.po.StatQuestionInfo;


public class StatQuestionInfoDao extends HibernateDaoSupport implements
		IStatQuestionInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(StatQuestionInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public StatQuestionInfo getStatQuestionInfo(Long statID) {
		
		return (StatQuestionInfo) this.getHibernateTemplate().get(StatQuestionInfo.class, statID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(StatQuestionInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(StatQuestionInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<StatQuestionInfo> getStatQuestionInfoList() {
		List<StatQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatQuestionInfo.class);		 
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
	 * @return list<StatQuestionInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<StatQuestionInfo> findByPage(final int firstResult,final int maxResult) {
		List<StatQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatQuestionInfo.class);		 
				 query.addOrder(Order.desc("statID"));
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
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);
		query.setProjection(Projections.count("statID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean isSave(Long planID, Long partID, Long partQuestionID,
			Long partSelectID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);
		query.setProjection(Projections.count("statID"));
		query.add(Restrictions.eq("planID",planID));
		query.add(Restrictions.eq("partID",partID));
		query.add(Restrictions.eq("partQuestionID",partQuestionID));
		query.add(Restrictions.eq("partSelectID",partSelectID));
		query.setMaxResults(1);
		List list = query.list();
		boolean ret = true;
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
			if(result > 0) {
				ret = false;
			}
		}	
		return ret;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCountMarks(Long planID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);		
		query.setProjection(Projections.sum("marks"));
		query.add(Restrictions.eq("planID",planID));
		query.add(Restrictions.eq("partID",partID));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCountMarks(Long planID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);		
		query.setProjection(Projections.sum("marks"));
		query.add(Restrictions.eq("planID",planID));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public StatQuestionInfo findByPlan(Long issueID, Long planID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);
		query.add(Restrictions.eq("planID",planID));
		query.add(Restrictions.eq("partID",partID));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		StatQuestionInfo sqi = null;
		if(list.size() > 0) {
			sqi = (StatQuestionInfo)list.get(0);
		}
		return sqi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public StatQuestionInfo findByIssue(Long issueID, Long partID,
			Long partQuestionID, Integer round) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);
		query.add(Restrictions.eq("partQuestionID",partQuestionID));
		query.add(Restrictions.eq("partID",partID));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("round",round));
		query.setMaxResults(1);
		List list = query.list();
		StatQuestionInfo sqi = null;
		if(list.size() > 0) {
			sqi = (StatQuestionInfo)list.get(0);
		}
		return sqi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCountWeights(Long planID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);		
		query.setProjection(Projections.sum("weight"));
		query.add(Restrictions.eq("planID",planID));
		query.add(Restrictions.eq("partID",partID));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCountWeights(Long planID) {
		Criteria query = this.getSession().createCriteria(StatQuestionInfo.class);		
		query.setProjection(Projections.sum("weight"));
		query.add(Restrictions.eq("planID",planID));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	
}
