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
import org.xsaas.xstat.dao.IPlanInfoDao;
import org.xsaas.xstat.po.PlanInfo;


public class PlanInfoDao extends HibernateDaoSupport implements
		IPlanInfoDao {
	/**
	 * 删除问卷试题类型信息
	 */
	public void delete(PlanInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public PlanInfo getPlanInfo(Long planID) {
		
		return (PlanInfo) this.getHibernateTemplate().get(PlanInfo.class, planID);
	}
	/**
	 * 保存问卷试题类型信息
	 */
	public void save(PlanInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷试题类型信息
	 */
	public void update(PlanInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<PlanInfo> getPlanInfoList() {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("planID"));
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
	 * @return list<PlanInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PlanInfo> findByPage(final int firstResult,final int maxResult) {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("planID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("planID"));
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
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("planID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
	/**
	 * 通过指定的起始数获取总集合
	 * @return 集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("planID"));
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
	public List<PlanInfo> findByClientPage(final long clientID,final  int type,
			final int firstResult, final int maxResult) {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.add(Restrictions.eq("type", type));	
				 query.addOrder(Order.desc("planID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findByPage(final long smgkID, final int type,final  int firstResult,
			final int maxResult) {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("smgkID", smgkID));
				 query.add(Restrictions.eq("type", type));	
				 query.addOrder(Order.desc("planID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getClientTotal(long clientID, int type) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("planID"));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("type", type));		
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
	public int getTotal(long smgkID, int type) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("planID"));
		query.add(Restrictions.eq("smgkID", smgkID));
		query.add(Restrictions.eq("type", type));				
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
	public List<PlanInfo> findByPage(final long clientID,final long smgkID,final long inquisitionID,final int firstResult,final int maxResult) {
		List<PlanInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PlanInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("smgkID", smgkID));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.addOrder(Order.desc("planID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(long clientID, long smgkID, long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("smgkID", smgkID));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.setProjection(Projections.count("planID"));
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
	public List<PlanInfo> findByAccount(Long accountID) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		query.add(Restrictions.eq("accountID", accountID));
		query.addOrder(Order.desc("planID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findByClient(Long clientID) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("clientID", clientID));
		query.addOrder(Order.desc("planID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findBySmgk(Long smgkID) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("smgkID", smgkID));
		query.addOrder(Order.desc("planID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findBySmgk(Long smgkID, int inquisitionType) {
		String hsql = "from cn.iaicc.smgk.po.PlanInfo where smgkID = ? and issueID in (select issueID from cn.iaicc.smgk.po.IssueInfo where inquisitionType="+inquisitionType+") order by planID desc";
		List list = this.getHibernateTemplate().find(hsql, smgkID);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PlanInfo> findByIssue(Long issueID) {
		Criteria query = this.getSession().createCriteria(PlanInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("issueID", issueID));
		query.addOrder(Order.desc("planID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

}
