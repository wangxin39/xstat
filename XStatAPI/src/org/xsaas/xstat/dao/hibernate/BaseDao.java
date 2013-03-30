package org.xsaas.xstat.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.xsaas.xstat.dao.DaoException;
import org.xsaas.xstat.dao.IBaseDao;
import org.xsaas.xstat.util.AppUtil;

import org.xsaas.xstat.utils.page.Page;
import org.xsaas.xstat.utils.page.PageUtil;
import org.xsaas.xstat.utils.page.Results;

public abstract class BaseDao<T> implements IBaseDao<T> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected SessionFactory sessionFactory;
	protected Class<T> entityClass;

	public BaseDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T data) throws DaoException {
		try {
			this.getSession().save(data);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public T get(long id) throws DaoException {
		return (T) this.getSession().get(entityClass, id);
	}

	public T get(int id) throws DaoException {
		return (T) this.getSession().get(entityClass, id);
	}

	public void delete(T data) throws DaoException {
		this.getSession().delete(data);

	}

	public List<T> getList(int firstResult, int maxResult) throws DaoException {

		Criteria query = this.getSession().createCriteria(entityClass);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	public int getTotal() throws DaoException {
		Criteria query = this.getSession().createCriteria(entityClass);
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if (list != null) {
			Object obj = list.get(0);
			if (obj != null) {
				result = (Integer) obj;
			}
		}
		return result;
	}

	public void update(T data) throws DaoException {
		this.getSession().update(data);
	}

	public List excuteForSQLList(String sql, Page page) throws DaoException {
		Session session = this.sessionFactory.openSession();
		List list = new ArrayList();
		try {
			list = session.createSQLQuery(sql).setFirstResult(
					page.getBeginIndex()).setMaxResults(page.getEveryPage())
					.list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForList()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return list;

	}

	public Results excuteForSQLEntityList(String sel_sql, String count_sql,
			int currentPage, int maxResult) throws DaoException {
		Session session = this.sessionFactory.openSession();
		List list = new ArrayList();
		Results results = null;
		try {
			int totalRecords = this.excuteForSQLCount(count_sql);
			Page page = PageUtil.createPage(maxResult, currentPage,
					totalRecords);
			list = session.createSQLQuery(sel_sql).addEntity(entityClass)
					.setFirstResult(page.getBeginIndex()).setMaxResults(
							page.getEveryPage()).list();
			results = new Results(page, list);
		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForSQLEntityList()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return results;
	}

	public List excuteForSQLEntityList(String sel_sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		List list = new ArrayList();
		try {
			list = session.createSQLQuery(sel_sql).addEntity(entityClass)
					.list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForList()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	public T findSQLEntity(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		T obj = null;
		try {
			List list = session.createSQLQuery(sql).addEntity(entityClass)
					.list();
			if (list != null && list.size() > 0) {
				obj = (T) list.get(0);
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->findSQLEntity()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return obj;
	}

	public List excuteForSQLList(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		List list = new ArrayList();
		try {
			list = session.createSQLQuery(sql).list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForList()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return list;

	}

	public List excuteForList(String sql, Page page) throws DaoException {
		Session session = this.sessionFactory.openSession();
		List list = new ArrayList();
		try {
			list = session.createCriteria(entityClass, sql).setFirstResult(
					page.getBeginIndex()).setMaxResults(page.getEveryPage())
					.list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForList()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return list;

	}

	public int excuteForSQLCount(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		int count = 0;
		try {
			List list = session.createSQLQuery(sql).list();
			count = Integer.parseInt(String.valueOf(list.get(0)));

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForSQLCount()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return count;
	}

	public int excuteForSQLCountFromList(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		int count = 0;
		try {
			count = session.createSQLQuery(sql).list().size();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForSQLCount()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return count;
	}

	public int excuteForCount(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		int count = 0;
		try {
			Long cou = (Long) session.createQuery(sql).uniqueResult();
			count = Integer.parseInt(String.valueOf(cou));

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForCount()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return count;
	}

	public boolean saveForObject(Object obj) throws DaoException {
		Session session = this.sessionFactory.openSession();
		boolean flag = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			flag = true;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			logger.error("BaseDao.class->saveForObject()  :: "
					+ ex.getMessage());

		} finally {
			session.close();
		}
		return flag;
	}

	public boolean excuteForSQLObject(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		boolean flag = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int num = session.createSQLQuery(sql).executeUpdate();
			tx.commit();
			if (num > 0)
				flag = true;
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForSQLObject()  :: "
					+ ex.getMessage());

		} finally {
			session.close();
		}
		return flag;
	}

	public Object[] excuteForSQLUnique(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		Object[] obj = null;
		try {
			obj = (Object[]) session.createSQLQuery(sql).uniqueResult();

		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForSQLUnique()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return obj;

	}

	public Object[] excuteForUnique(String sql) throws DaoException {
		Session session = this.sessionFactory.openSession();
		Object[] obj = null;
		try {
			obj = (Object[]) session.createQuery(sql).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			logger.error("BaseDao.class->excuteForUnique()  :: "
					+ ex.getMessage());
		} finally {
			session.close();
		}
		return obj;

	}

	public SQLQuery creatSQLQuery(String sql) throws DaoException {
		return this.sessionFactory.getCurrentSession().createSQLQuery(sql);
	}

	public Results Select_By_List(Page page, String count_sql, String sel_sql)
			throws DaoException {
		Results result = null;
		try {
			int totalRecords = this.excuteForSQLCount(count_sql);
			if (totalRecords == 0)
				logger.error("BaseDao.class -->Select_By_List() is not data");
			else {
				page = PageUtil.createPage(page, totalRecords);
				List list = this.excuteForSQLList(sel_sql, page);
				result = new Results(page, list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public Results findBySqlForMap(String sel_sql, int currentPage,
			int maxResult) throws DaoException {
		Session session = this.getSessionFactory().openSession();
		Connection conn = null;

		Results result = null;
		try {

			QueryRunner qRun = new QueryRunner();
			conn = session.connection();
			int totalRecords = 0;
			totalRecords = getCount(sel_sql);
			if (totalRecords == 0)
				logger.error("BaseDao.class -->findBySqlForMap() is not data");
			else {
				Page page = PageUtil.createPage(maxResult, currentPage,
						totalRecords);
				sel_sql += " limit " + page.beginIndex + ", " + maxResult;
				List list = (List) qRun.query(conn, sel_sql,
						new MapListHandler());
				result = new Results(page, list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List findBySqlForMap(String sel_sql) throws DaoException {
		Session session = this.getSessionFactory().openSession();
		Connection conn = null;
		List list = null;
		Results result = null;
		try {
			QueryRunner qRun = new QueryRunner();
			conn = session.connection();
			list = (List) qRun.query(conn, sel_sql, new MapListHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public int getCount(String sql) {
		String countSql = "select count(*) con from (" + sql + ") t";
		Session session = this.getSessionFactory().openSession();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = session.connection();
			ps = con.prepareStatement(countSql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			session.close();
		}
		return count;
	}

	public Results Select_ByHQL_List(Page page, String count_sql, String sel_sql)
			throws DaoException {
		Results result = null;
		try {
			int totalRecords = this.excuteForCount(count_sql);
			if (totalRecords == 0)
				logger
						.error("BaseDao.class -->Select_ByHQL_List() is not data");
			else {
				page = PageUtil.createPage(page, totalRecords);
				List list = this.excuteForList(sel_sql, page);
				result = new Results(page, list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public Date checkForDate(Object obj, String type) throws DaoException {
		return AppUtil.StringToDate(String.valueOf(obj), type);

	}

	public Results SearchQuery(Page page, String count_sql, String sel_sql,
			Object[] obj, int type) throws DaoException {
		Results result = null;
		try {
			int totalRecords = this.getTotalRecords(count_sql, obj, type);
			if (totalRecords == 0)
				logger.error("BaseDaoSupport.class -->sql is not data");
			else {
				page = PageUtil.createPage(page, totalRecords);
				List list = this.getResultList(sel_sql, obj, page, type);
				result = new Results(page, list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int getTotalRecords(String sql, Object[] obj, int type)
			throws DaoException {
		Query query = null;
		if (type == 1)
			query = this.sessionFactory.getCurrentSession().createSQLQuery(
					"select count(*) " + sql);
		else
			query = this.sessionFactory.getCurrentSession().createQuery(
					"select count(*) " + sql);
		for (int i = 0, j = 0; i < obj.length;) {
			query.setParameter(i++, obj[j++]);
		}
		return Integer.parseInt(String.valueOf(query.uniqueResult()));
	}

	public List getResultList(String sql, Object[] obj, Page page, int type)
			throws DaoException {
		List list = null;
		try {
			Query query = null;
			if (type == 1)
				query = this.sessionFactory.getCurrentSession().createSQLQuery(
						sql);
			else
				query = this.sessionFactory.getCurrentSession()
						.createQuery(sql);
			for (int i = 0, j = 0; i < obj.length;) {
				query.setParameter(i++, obj[j++]);
			}
			list = query.setFirstResult(page.getBeginIndex()).setMaxResults(
					page.getEveryPage()).list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;

	}

	public Object findUnique(final String hql, final Object... values)
			throws DaoException {
		return createQuery(hql, values).uniqueResult();
	}

	public Integer findInt(final String hql, final Object... values)
			throws DaoException {
		return (Integer) findUnique(hql, values);
	}

	public Long findLong(final String hql, final Object... values)
			throws DaoException {
		return (Long) findUnique(hql, values);
	}

	public T findUniqueByProperty(final String propertyName, final Object value)
			throws DaoException {
		Assert.hasText(propertyName);
		return (T) createCriteria(Restrictions.eq(propertyName, value))
				.uniqueResult();
	}

	public List<T> findByCriteria(final Criterion... criterion)
			throws DaoException {
		return createCriteria(criterion).list();
	}

	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString);
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject;
	}

	public Criteria createCriteria(final Criterion... criterions)
			throws DaoException {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
}
