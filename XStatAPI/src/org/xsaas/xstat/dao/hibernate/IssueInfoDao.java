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
import org.xsaas.xstat.dao.IIssueInfoDao;
import org.xsaas.xstat.po.IssueInfo;


public class IssueInfoDao extends HibernateDaoSupport implements
		IIssueInfoDao {
	/**
	 * 删除项目培训信息
	 */
	public void delete(IssueInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public IssueInfo getIssueInfo(Long ptID) {
		
		return (IssueInfo) this.getHibernateTemplate().get(IssueInfo.class, ptID);
	}
	/**
	 * 保存项目培训信息
	 */
	public void save(IssueInfo data) {
		this.getHibernateTemplate().save(data);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IssueInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("issueID"));
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
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("issueID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 更新项目培训信息
	 */
	public void update(IssueInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<IssueInfo> getIssueInfoList() {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("issueID"));
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
	 * @return list<IssueInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<IssueInfo> findByPage(final int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("issueID"));				
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
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("issueID"));		
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
	public List<IssueInfo> findByPage(final long smgkID,final  int status,final int firstResult,final  int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("smgkID",smgkID ));
				 query.add(Restrictions.eq("status", status));
				 query.addOrder(Order.desc("issueID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@Override
	public IssueInfo getIssueInfoSmgk(long smgkID) {
		
		return (IssueInfo) this.getHibernateTemplate().get(IssueInfo.class, smgkID);
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(final long smgkID,final  int status) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		 query.add(Restrictions.eq("smgkID",smgkID ));
		 query.add(Restrictions.eq("status", status));
		query.setProjection(Projections.count("issueID"));
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
	public boolean isRegister(String issue) {
		boolean yes = false;
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("issue", issue));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
//			当数据库有记录时，返回值为已注册过此用户，如果为0，则表示没有注册
			int num = (Integer) list.get(0);
			if(num > 0){
				yes = true;
			}
		}
		return yes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IssueInfo> findByPage(final Long projectID,final int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("projectID",projectID));
				 query.addOrder(Order.desc("issueID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long projectID) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("projectID",projectID ));
		query.setProjection(Projections.count("issueID"));
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
	public List<IssueInfo> findIssueInfoByPage(final Long issueID,final int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("issueID",issueID));
				 query.addOrder(Order.desc("issueID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getIssueInfoTotal(Long issueID) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("issueID",issueID ));
		query.setProjection(Projections.count("issueID"));
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
	public List<IssueInfo> findByPage(final Long clientID,final Long issueID,final	int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("issueID",issueID));
				 query.add(Restrictions.eq("clientID",clientID ));
				 query.addOrder(Order.desc("issueID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long clientID, Long issueID) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("clientID",clientID));
		query.setProjection(Projections.count("issueID"));
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
	public List<IssueInfo> getList(final Long inquisitionID) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID",inquisitionID));
				 query.addOrder(Order.desc("issueID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IssueInfo> findIssueInfoByPage(final Long projectID,final Long issueID,final	int firstResult,final int maxResult) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("issueID",issueID));
				 query.add(Restrictions.eq("projectID",projectID ));
				 query.addOrder(Order.desc("issueID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getIssueInfoTotal(Long projectID, Long issueID) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("projectID",projectID));
		query.setProjection(Projections.count("issueID"));
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
	public List<IssueInfo> getList(final Long inquisitionID , final Long projectID) {
		List<IssueInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(IssueInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID",inquisitionID));
				 query.add(Restrictions.eq("projectID",projectID));
				 query.addOrder(Order.desc("issueID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IssueInfo> findIssueInfoListByReportStatus() {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("reportStatus",1)); //检查所有报告没有生成的期次
		query.addOrder(Order.desc("issueID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public IssueInfo getLastIssueID(Long clientID,Long projectID, String issue) {
		Criteria query = this.getSession().createCriteria(IssueInfo.class);
		query.add(Restrictions.eq("clientID",clientID));
		query.add(Restrictions.eq("projectID",projectID));
		// 小于当前期次的倒序，最接近当前期次的排在最前(相当于上期）
		query.add(Restrictions.lt("issue", issue));
		IssueInfo info = null;
		query.addOrder(Order.desc("issue"));
		query.setMaxResults(1);
		List list = query.list();
		if(list != null && list.size() > 0) {
			info = (IssueInfo)list.get(0);
		}
		return info;
	}
}
