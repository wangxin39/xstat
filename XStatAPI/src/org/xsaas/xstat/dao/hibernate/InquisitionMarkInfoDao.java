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
import org.xsaas.xstat.dao.IInquisitionMarkInfoDao;
import org.xsaas.xstat.po.InquisitionMarkInfo;


public class InquisitionMarkInfoDao extends HibernateDaoSupport implements
		IInquisitionMarkInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(InquisitionMarkInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public InquisitionMarkInfo getInquisitionMarkInfo(Long inquisitionMarkID) {
		
		return (InquisitionMarkInfo) this.getHibernateTemplate().get(InquisitionMarkInfo.class, inquisitionMarkID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(InquisitionMarkInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(InquisitionMarkInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<InquisitionMarkInfo> getInquisitionMarkInfoList() {
		List<InquisitionMarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionMarkInfo.class);	
				 query.addOrder(Order.desc("inquisitionMarkID"));
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
	 * @return list<InquisitionMarkInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<InquisitionMarkInfo> findByPage(final int firstResult,final int maxResult) {
		List<InquisitionMarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionMarkInfo.class);		 
				 query.addOrder(Order.desc("inquisitionMarkID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.count("inquisitionMarkID"));
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
	public InquisitionMarkInfo findByISI(Long issueID, Long smgkID,	Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("smgkID", smgkID));
		query.add(Restrictions.eq("informantID", informantID));		
		query.setMaxResults(1);
		InquisitionMarkInfo imi = null;
		List list = query.list();
		if(list != null && list.size() > 0) {
			imi = (InquisitionMarkInfo)list.get(0);
		}		
		return imi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean isSave(Long issueID, Long smgkID,Long informantID) {
		boolean ret = true;
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.count("inquisitionMarkID"));
		query.add(Restrictions.eq("issueID", issueID));
		query.add(Restrictions.eq("smgkID", smgkID));
		query.add(Restrictions.eq("informantID", informantID));		
		query.setMaxResults(1);
		List list = query.list();
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
	public List<InquisitionMarkInfo> findByClient(final Long clientID, final Long projectID) {		
		List<InquisitionMarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionMarkInfo.class);		 
				 query.add(Restrictions.eq("clientID",clientID));
				 query.add(Restrictions.eq("projectID",projectID));
				 query.addOrder(Order.desc("inquisitionMarkID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InquisitionMarkInfo> findByInformant(final Long informantID,final Long projectID) {
		List<InquisitionMarkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionMarkInfo.class);		 
				 query.add(Restrictions.eq("informantID",informantID));
				 query.add(Restrictions.eq("projectID",projectID));
				 query.addOrder(Order.desc("inquisitionMarkID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getActualRound1Total(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("actualMarkRound1"));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("issueID",issueID));
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
	public int getActualRound1Total(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("actualMarkRound1"));
		query.add(Restrictions.eq("issueID",issueID));
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
	public int getActualRound2Total(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("actualMarkRound2"));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("issueID",issueID));
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
	public int getActualRound2Total(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("actualMarkRound2"));
		query.add(Restrictions.eq("issueID",issueID));
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
	public double getAverageTotal(Long issueID, Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Long issueID, Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Long informantID, Long issueID, Integer year,	Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Long informantID, Long issueID, Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("issueID",issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountQuarter(Long clientID, Long projectID,	Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("month")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.add(Restrictions.eq("informantID",informantID));
		query.setMaxResults(1);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountQuarter(Long clientID, Long projectID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("month")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.setMaxResults(1);
		return query.list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountWeek(Long clientID, Long projectID,Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("day")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
		query.setMaxResults(1);
		return query.list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountWeek(Long clientID, Long projectID,Long informantID, Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("day")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));		
		query.setMaxResults(1);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountYear(Long clientID, Long projectID,Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("year")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.add(Restrictions.eq("informantID",informantID));
		query.setMaxResults(1);
		return query.list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountYear(Long clientID, Long projectID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("year")));
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		query.setMaxResults(1);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getSmgkTotal(Long issueID, Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
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
	public int getSmgkTotal(Long issueID, Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("year",year));
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
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));
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
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("issueID",issueID));
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
	public int getWeightedRound1Total(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("weightMarkRound1"));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));
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
	public int getWeightedRound1Total(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("weightMarkRound1"));
		query.add(Restrictions.eq("issueID",issueID));
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
	public int getWeightedRound2Total(Long informantID, Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("weightMarkRound2"));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));
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
	public int getWeightedRound2Total(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("weightMarkRound2"));
		query.add(Restrictions.eq("issueID",issueID));
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
	public double getAverageTotal(Integer year, Integer month, Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
		query.add(Restrictions.eq("informantID",informantID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Integer year, Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("informantID",informantID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverageTotal(Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.sum("average"));
		query.add(Restrictions.eq("year",year));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getSmgkTotal(Integer year, Integer month, Long informantID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("informantID",informantID));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
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
	public int getSmgkTotal(Integer year, Integer month) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.countDistinct("smgkID"));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("month",month));
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
	public Long getLastIssue(Long informantID, Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("issueID")));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("informantID",informantID));
		query.addOrder(Order.desc("issueID"));
		query.setMaxResults(1);
		List list = query.list();
		Long result = null;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Long)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getLastIssue(Integer year) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.distinct(Projections.property("issueID")));
		query.add(Restrictions.eq("year",year));
		query.addOrder(Order.desc("issueID"));
		query.setMaxResults(1);
		List list = query.list();
		Long result = null;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Long)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public double getAverage(Long issueID) {
		Criteria query = this.getSession().createCriteria(InquisitionMarkInfo.class);
		query.setProjection(Projections.avg("average"));
		query.add(Restrictions.eq("issueID", issueID));
		query.setMaxResults(1);
		List list = query.list();
		double result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Double)obj;				
			}
		}		
		return result;
	}
}
