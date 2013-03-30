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
import org.xsaas.xstat.dao.IStatPartInfoDao;
import org.xsaas.xstat.po.StatPartInfo;


public class StatPartInfoDao extends HibernateDaoSupport implements
		IStatPartInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(StatPartInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public StatPartInfo getStatPartInfo(Long statPartID) {
		
		return (StatPartInfo) this.getHibernateTemplate().get(StatPartInfo.class, statPartID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(StatPartInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(StatPartInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<StatPartInfo> getStatPartInfoList() {
		List<StatPartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatPartInfo.class);		 
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
	 * @return list<StatPartInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<StatPartInfo> findByPage(final int firstResult,final int maxResult) {
		List<StatPartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatPartInfo.class);		 
				 query.addOrder(Order.desc("statPartID"));
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
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.count("statPartID"));
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
	public boolean isSave(Long planID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.count("statPartID"));
		query.add(Restrictions.eq("planID", planID));
		query.add(Restrictions.eq("partID", partID));
		query.setMaxResults(1);
		List list = query.list();
		boolean ret = true;
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
			if(result > 0) {
				ret = false;
			}
		}	
		return ret;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getActualTotal(Long planID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("actualMarks"));
		query.add(Restrictions.eq("planID", planID));
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
	public int getPartTotal(Long planID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.count("partID"));
		query.add(Restrictions.eq("planID", planID));
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
	public int getWeightedTotal(Long planID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("weightedMark"));
		query.add(Restrictions.eq("planID", planID));
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
	public List<StatPartInfo> findByPlan(Long planID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.add(Restrictions.eq("planID", planID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getActualTotal(Long informantID, Long issueID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("actualMarks"));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("partID", partID));		
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
	public int getActualTotal(Long issueID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("actualMarks"));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("partID", partID));	
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
	public int getSmgkTotal(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("issueID", issueID));
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
	public int getSmgkTotal(Long issueID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("issueID", issueID));
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
	public int getWeightedTotal(Long informantID, Long issueID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("weightedMark"));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("partID", partID));
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
	public int getWeightedTotal(Long issueID, Long partID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("weightedMark"));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("partID", partID));
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
	public StatPartInfo findByIssue(Long issueID, Long partID, Integer round) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("partID", partID));
		query.add(Restrictions.eq("round", round));
		query.setMaxResults(1);
		List list = query.list();
		StatPartInfo spi = null;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				spi = (StatPartInfo)obj;
			}
		}
		return spi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int findActualByYear(Integer year, Long clientID, Long projectID,
			Long informantID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("actualMarks"));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("projectID", projectID));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("year", year));		
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
	public int findActualByYear(Integer year, Long clientID, Long projectID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("actualMarks"));
		query.add(Restrictions.eq("projectID", projectID));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("year", year));			
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
	public int findWeightedByYear(Integer year, Long clientID, Long projectID,
			Long informantID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("weightedMark"));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("projectID", projectID));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("year", year));			
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
	public int findWeightedByYear(Integer year, Long clientID, Long projectID) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.setProjection(Projections.sum("weightedMark"));
		query.add(Restrictions.eq("projectID", projectID));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("year", year));			
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
	public StatPartInfo findByIssue(Long issueID, Long informantID, Long partID, Integer round) {
		Criteria query = this.getSession().createCriteria(StatPartInfo.class);
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("partID", partID));
		query.add(Restrictions.eq("round", round));
		query.setMaxResults(1);
		List list = query.list();
		StatPartInfo spi = null;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				spi = (StatPartInfo)obj;
			}
		}
		return spi;
	}
	
}
