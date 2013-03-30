package org.xsaas.xstat.util;

import java.util.Date;

import com.danga.MemCached.ErrorHandler;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

@SuppressWarnings("unchecked")
public class CacheTool {
	// create a static client as most installs only need
	// a single instance
	protected static MemCachedClient mcc = new MemCachedClient();
	// server list and weights
	private static String[] servers = {""};
	private static Integer[] weights = { 1 };
 
	private CacheTool() {
		
	}
	
	// set up connection pool once at class load
	static {
		install();
	}

	public static void install() {
		// grab an instance of our connection pool
		SockIOPool pool = SockIOPool.getInstance();
		// set the servers and the weights
		pool.setServers(servers);
		pool.setWeights(weights);

		// set some basic pool settings
		// 5 initial, 5 min, and 250 max conns
		// and set the max idle time for a conn
		// to 6 hours
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 6);

		// set the sleep for the maint thread
		// it will wake up every x seconds and
		// maintain the pool size
		pool.setMaintSleep(30);

		// set some TCP settings
		// disable nagle
		// set the read timeout to 3 secs
		// and don't set a connect timeout
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);

		// initialize the connection pool
		pool.initialize();
		// lets set some compression on for the client
		// compress anything larger than 64k
		mcc.setCompressEnable(true);
		mcc.setCompressThreshold(64 * 1024);
	}

	public static boolean add(java.lang.String key, java.lang.Object value) {
		return mcc.add(key, value);
	}

	public static boolean add(java.lang.String key, java.lang.Object value,
			java.util.Date expiry) {
		return mcc.add(key, value, expiry);
	}

	public static boolean add(java.lang.String key, java.lang.Object value,
			java.util.Date expiry, java.lang.Integer hashCode) {
		return mcc.add(key, value, expiry, hashCode);
	}

	public static boolean add(java.lang.String key, java.lang.Object value,
			java.lang.Integer hashCode) {
		return mcc.add(key, value, hashCode);
	}

	public static long addOrDecr(java.lang.String key) {
		return mcc.addOrDecr(key);
	}

	public static long addOrDecr(java.lang.String key, long inc) {
		return mcc.addOrDecr(key, inc);
	}

	public static long addOrDecr(java.lang.String key, long inc,
			java.lang.Integer hashCode) {
		return mcc.addOrDecr(key, inc, hashCode);
	}

	public static long addOrIncr(java.lang.String key) {
		return mcc.addOrIncr(key);
	}

	public static long addOrIncr(java.lang.String key, long inc) {
		return mcc.addOrIncr(key, inc);
	}

	public static long addOrIncr(java.lang.String key, long inc,
			java.lang.Integer hashCode) {
		return mcc.addOrIncr(key, inc, hashCode);
	}

	public static long decr(java.lang.String key) {
		return mcc.decr(key);
	}

	public static long decr(java.lang.String key, long inc) {
		return mcc.decr(key, inc);
	}

	public static long decr(java.lang.String key, long inc,
			java.lang.Integer hashCode) {
		return mcc.decr(key, inc, hashCode);
	}

	public static boolean delete(java.lang.String key) {
		return mcc.delete(key);
	}

	public static boolean delete(java.lang.String key, java.util.Date expiry) {
		return mcc.delete(key, expiry);
	}

	public static boolean delete(java.lang.String key,
			java.lang.Integer hashCode, java.util.Date expiry) {
		return mcc.delete(key, hashCode, expiry);
	}

	public static boolean flushAll() {
		return mcc.flushAll();
	}

	public static boolean flushAll(java.lang.String[] servers) {
		return mcc.flushAll(servers);
	}

	public static java.lang.Object get(java.lang.String key) {
		return mcc.get(key);
	}

	public static java.lang.Object get(java.lang.String key,
			java.lang.Integer hashCode) {
		return mcc.get(key, hashCode);
	}

	public static java.lang.Object get(java.lang.String key,
			java.lang.Integer hashCode, boolean asString) {
		return mcc.get(key, hashCode, asString);
	}

	public static long getCounter(java.lang.String key) {
		return mcc.getCounter(key);
	}

	public static long getCounter(java.lang.String key,
			java.lang.Integer hashCode) {
		return mcc.getCounter(key, hashCode);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getMulti(
			java.lang.String[] keys) {
		return mcc.getMulti(keys);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getMulti(
			java.lang.String[] keys, java.lang.Integer[] hashCodes) {
		return mcc.getMulti(keys, hashCodes);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getMulti(
			java.lang.String[] keys, java.lang.Integer[] hashCodes,
			boolean asString) {
		return mcc.getMulti(keys, hashCodes, asString);
	}

	public static java.lang.Object[] getMultiArray(java.lang.String[] keys) {
		return mcc.getMultiArray(keys);
	}

	public static java.lang.Object[] getMultiArray(java.lang.String[] keys,
			java.lang.Integer[] hashCodes) {
		return mcc.getMultiArray(keys, hashCodes);
	}

	public static java.lang.Object[] getMultiArray(java.lang.String[] keys,
			java.lang.Integer[] hashCodes, boolean asString) {
		return mcc.getMultiArray(keys, hashCodes, asString);
	}

	public static long incr(java.lang.String key) {
		return mcc.incr(key);
	}

	public static long incr(java.lang.String key, long inc) {
		return mcc.incr(key, inc);
	}

	public static long incr(java.lang.String key, long inc,
			java.lang.Integer hashCode) {
		return mcc.incr(key, inc, hashCode);
	}

	public static boolean keyExists(java.lang.String key) {
		return mcc.keyExists(key);
	}

	public static boolean replace(java.lang.String key, java.lang.Object value) {
		return mcc.replace(key, value);
	}

	public static boolean replace(java.lang.String key, java.lang.Object value,
			java.util.Date expiry) {
		return mcc.replace(key, value, expiry);
	}

	public static boolean replace(java.lang.String key, java.lang.Object value,
			java.util.Date expiry, java.lang.Integer hashCode) {
		return mcc.replace(key, value, expiry, hashCode);
	}

	public static boolean replace(java.lang.String key, java.lang.Object value,
			java.lang.Integer hashCode) {
		return mcc.replace(key, value, hashCode);
	}

	public static boolean set(java.lang.String key, java.lang.Object value) {
		return mcc.set(key, value);
	}

	public static boolean set(java.lang.String key, java.lang.Object value,
			java.util.Date expiry) {
		return mcc.set(key, value, expiry);
	}

	public static boolean set(java.lang.String key, java.lang.Object value,
			java.util.Date expiry, java.lang.Integer hashCode) {
		return mcc.set(key, value, expiry, hashCode);
	}

	public static boolean set(java.lang.String key, java.lang.Object value,
			java.lang.Integer hashCode) {
		return mcc.set(key, value, hashCode);
	}

	public static void setClassLoader(java.lang.ClassLoader classLoader) {
		setClassLoader(classLoader);
	}

	public static void setCompressEnable(boolean compressEnable) {
		setCompressEnable(compressEnable);
	}

	public static void setCompressThreshold(long compressThreshold) {
		setCompressThreshold(compressThreshold);
	}

	public static void setDefaultEncoding(java.lang.String defaultEncoding) {
		setDefaultEncoding(defaultEncoding);
	}

	public static void setErrorHandler(ErrorHandler errorHandler) {
		setErrorHandler(errorHandler);
	}

	public static void setPrimitiveAsString(boolean primitiveAsString) {
		setPrimitiveAsString(primitiveAsString);
	}

	public static void setSanitizeKeys(boolean sanitizeKeys) {
		setSanitizeKeys(sanitizeKeys);
	}

	public static java.util.Map stats() {
		return mcc.stats();
	}

	public static java.util.Map stats(java.lang.String[] servers) {
		return mcc.stats(servers);
	}

	public static java.util.Map statsCacheDump(int slabNumber, int limit) {
		return mcc.statsCacheDump(slabNumber, limit);
	}

	public static java.util.Map statsCacheDump(java.lang.String[] servers,
			int slabNumber, int limit) {
		return mcc.statsCacheDump(servers, slabNumber, limit);
	}

	public static java.util.Map statsItems() {
		return mcc.statsItems();
	}

	public static java.util.Map statsItems(java.lang.String[] servers) {
		return mcc.statsItems(servers);
	}

	public static java.util.Map statsSlabs() {
		return mcc.statsSlabs();
	}

	public static java.util.Map statsSlabs(java.lang.String[] servers) {
		return mcc.statsSlabs(servers);
	}

	public static boolean storeCounter(java.lang.String key, long counter) {
		return mcc.storeCounter(key, counter);
	}

	public static boolean storeCounter(java.lang.String key,
			java.lang.Long counter) {
		return mcc.storeCounter(key, counter);
	}

	public static boolean storeCounter(java.lang.String key,
			java.lang.Long counter, java.lang.Integer hashCode) {
		return mcc.storeCounter(key, counter, hashCode);
	}
	/**
	 * 得到缓存失效时间
	 * @param cacheTime �?��缓存保留的时间大小（单位：毫秒）
	 * @return
	 */
	public static Date getCacheDate(int cacheTime){
		return new Date(new Date().getTime()+ cacheTime);
	}
}
