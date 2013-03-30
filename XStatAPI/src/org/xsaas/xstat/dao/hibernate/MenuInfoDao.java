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
import org.xsaas.xstat.dao.IMenuInfoDao;
import org.xsaas.xstat.po.MenuInfo;
import org.xsaas.xstat.util.CacheTool;




public class MenuInfoDao extends HibernateDaoSupport implements IMenuInfoDao {

	@Override
	public void delete(MenuInfo data) {
		this.getHibernateTemplate().delete(data);	
	}

	@Override
	public MenuInfo getMenuInfo(Long menuID) {
		return (MenuInfo)this.getHibernateTemplate().get(MenuInfo.class, menuID);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	
	public List<MenuInfo> getMenuInfoList(Long parentID, int type) {
		Criteria query = this.getSession().createCriteria(MenuInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("parentID", parentID));
		query.add(Restrictions.eq("type", new Integer(type)));
		query.setMaxResults(Integer.MAX_VALUE);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(MenuInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("menuID"));
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
	public List<MenuInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<MenuInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(MenuInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("menuID"));
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
		Criteria query = this.getSession().createCriteria(MenuInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("menuID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 分页信息
	 * @param firstResult 开始数
	 * @param maxResult 最大数
	 * @return 信息结果
	 */
	@SuppressWarnings("unchecked")
	public List<MenuInfo> findByPage(final int firstResult,final int maxResult) {
		Object obj = CacheTool.get("MENU_INFO_LIST");
		List<MenuInfo> list = null;
		if(obj == null) {
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
					 Criteria query = s.createCriteria(MenuInfo.class);		
					 query.add(Restrictions.eq("status", 1));
					 query.addOrder(Order.desc("menuID"));
					 query.setFirstResult(firstResult);
					 query.setMaxResults(maxResult);			 
					 return query.list();
				 }
			});
			CacheTool.delete("MENU_INFO_LIST");
			CacheTool.add("MENU_INFO_LIST", list);
		}else{
			list = (List<MenuInfo>)obj;
		}
		return list;
	}
	@Override
	public void save(MenuInfo data) {
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void update(MenuInfo data) {
		this.getHibernateTemplate().update(data);
	}

}
