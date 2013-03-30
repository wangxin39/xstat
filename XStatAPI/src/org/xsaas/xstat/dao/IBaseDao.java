package org.xsaas.xstat.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;

import org.xsaas.xstat.utils.page.Page;
import org.xsaas.xstat.utils.page.Results;

public interface IBaseDao<T> {
	
	/**
	 * 保存
	 * @param data 操作的对象
	 * @throws Exception 异常信息
	 */
	public void save(T data) throws DaoException;
	/**
	 * 通过指定的编号获取对象
	 * @param id 编号
	 * @return 对象
	 * @throws Exception 异常信息
	 */
	public T get(long id) throws DaoException;
	/**
	 * 通过指定的编号获取对象
	 * @param id 编号
	 * @return 对象
	 * @throws Exception 异常信息
	 */
	public T get(int id) throws DaoException;

	/**
	 * 更新操作的对象信息
	 * @param data 操作对象
	 * @throws Exception 抛出的异常
	 */
	public void update(T data) throws DaoException;
	/**
	 * 删除操作的对象信息
	 * @param data 操作对象
	 * @throws Exception 抛出的异常
	 */
	public void delete(T data) throws DaoException;
	/**
	 * 根据指定的条件，返回相应数量的对象列表
	 * @param firstResult 开始记录
	 * @param maxResult 最多返回的记录数
	 * @return 记录集合
	 * @throws Exception 抛出的异常
	 */
	public List<T> getList(final int firstResult,final int maxResult) throws DaoException;
	/**
	 * 获取总记录数量
	 * @return 总记录数
	 */
	public int getTotal() throws DaoException;
	/***
	 * 查询列表,使用原始SQL语句
	 * @param sql
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForSQLList(String sql,Page page) throws DaoException;
	/***
	 * 查询列表,使用原始SQL语句
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForSQLList(String sql) throws DaoException;
	/***
	 * 查询列表,使用hibernate SQL语句
	 * @param sql
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForList(String sql,Page page) throws DaoException;
	/***
	 * 查询列表,使用原始SQL语句
	 * @param sel_sql 查询SQL
	 * @param count_sql 统计SQL
	 * @param currentPage 当前页
	 * @param maxResult 最大页
	 * @return 返回实体列表
	 */
	public Results excuteForSQLEntityList(String sel_sql,String count_sql,int currentPage,int maxResult) throws DaoException;
	
	/***
	 * 查询列表,使用原始SQL语句
	 * @param sql
	 * @param page
	 * @return 返回实体列表
	 */
	public List excuteForSQLEntityList(String sel_sql) throws DaoException;
	
	/**
	 * 查询对象，使用原始SQL语句
	 * @param sql
	 * @return 实体对象
	 * @throws DaoException
	 */
	public T findSQLEntity(String sql) throws DaoException;
	/***
	 * 通过原始SQL语句来查询数据总数
	 * @param sql
	 * @return
	 */
	public int excuteForSQLCount(String sql) throws DaoException;
	/***
	 * 这种方式是用来原始SQL语句来获取信息总数，比如SQL语句中带有GROUP BY 等，
	 * 就只能通过先查询，然后通过LIST来获取其总数，
	 * 这样效率极低，找到好方法要换掉
	 * @param sql
	 * @return
	 */
	public int excuteForSQLCountFromList(String sql) throws DaoException;
	/****
	 * 直接通过HQL来获取数据条数
	 * @param sql
	 * @return
	 */
	public int excuteForCount(String sql) throws DaoException;
	/***
	 * 保存信息
	 * @param obj
	 * @return
	 */
	public boolean saveForObject(Object obj) throws DaoException;
	/***
	 * 执行SQL语句
	 * @param obj
	 * @return
	 */
	public boolean excuteForSQLObject(String sql) throws DaoException;
	/***
	 * 查询,使用原始SQL语句
	 * @param sql
	 * @return
	 */
	public Object[] excuteForSQLUnique(String sql) throws DaoException;
	/***
	 * 查询,使用SQL语句
	 * @param sql
	 * @param page
	 * @return
	 */
	public Object[] excuteForUnique(String sql) throws DaoException;

	/******
	 * sql查询，使用Spring来管理当前事务
	 * @param sql
	 * @return
	 */
	public SQLQuery creatSQLQuery(String sql) throws DaoException;

	/*****
	 * 分页集合查询
	 * @param page
	 * @param count_sql 
	 * @param sel_sql
	 * @return
	 */
	public Results Select_By_List(Page page,String count_sql,String sel_sql) throws DaoException;
	/****
	 * 查询语句
	 * @param page
	 * @param count_sql
	 * @param sel_sql
	 * @return
	 */
	public Results Select_ByHQL_List(Page page,String count_sql,String sel_sql) throws DaoException;

	/*****
	 * 转换为日期类型
	 * @param obj
	 * @param type
	 * @return
	 */	
	public Date checkForDate(Object obj,String type) throws DaoException;

	/****
	 * 查询条件，返回集合 带参数   2009-03-05  //by niyong
	 * @param page
	 * @param count_sql 查询分页总数
	 * @param sel_sql   查询语句
	 * @param obj       参数 
	 * @param type      查询类型，1:原始SQL查询，0：HQL查询
	 * @return
	 */
	public Results SearchQuery(Page page,String count_sql,String sel_sql,Object[] obj,int type) throws DaoException;

	/******
	 * 查询分页总数,   2009-03-05  //by niyong
	 * @param sql
	 * @param obj
	 * @param type 1:原始SQL查询，0：hql查询
	 * @return
	 */	
	public int getTotalRecords(String sql,Object[] obj,int type) throws DaoException;
	/****
	 * 分页查询   2009-03-05  //by niyong
	 * @param sql
	 * @param obj
	 * @param beginIndex
	 * @param everyPage
	 * @param type 1:原始SQL查询，0：hql查询
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getResultList(String sql,Object[] obj,Page page,int type) throws DaoException;
	/**
	 * 按HQL查询唯一对象.
	 */
	public Object findUnique(final String hql, final Object... values) throws DaoException;

	/**
	 * 按HQL查询Integer类型结果. 
	 */
	public Integer findInt(final String hql, final Object... values) throws DaoException;

	/**
	 * 按HQL查询Long类型结果. 
	 */
	public Long findLong(final String hql, final Object... values) throws DaoException;
	/**
	* 按Criterion查询对象列表.
	* 
	* @param criterion 数量可变的Criterion.
	*/
	public List<T> findByCriteria(final Criterion... criterion) throws DaoException;	
	
	
	public Results findBySqlForMap(String sel_sql,int currentPage,int maxResult) throws DaoException;	
	
	@SuppressWarnings("unchecked")
	public List<Map> findBySqlForMap(String sel_sql) throws DaoException;	
		

	/**
	* 根据查询HQL与参数列表创建Query对象,辅助函数.
	*/
	public Query createQuery(final String queryString, final Object... values) throws DaoException;
	/**
	 * 根据Criterion条件创建Criteria,辅助函数.
	 */
	public Criteria createCriteria(final Criterion... criterions) throws DaoException;		
	
}