package org.jobjects.jdbc.pool.multiple;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcCallableStatement implements CallableStatement {
	private CallableStatement callableStatement;
	private String sql;
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public JdbcCallableStatement(CallableStatement callableStatement) {
		this.callableStatement = callableStatement;
	}

	public JdbcCallableStatement(CallableStatement callableStatement, String sql) {
		this.callableStatement = callableStatement;
		this.sql = sql;
	}

	public void addBatch() throws SQLException {
		callableStatement.addBatch();
	}

	public void addBatch(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		callableStatement.addBatch(sql);
	}

	public void cancel() throws SQLException {
		callableStatement.cancel();
	}

	public void clearBatch() throws SQLException {
		callableStatement.clearBatch();
	}

	public void clearParameters() throws SQLException {
		callableStatement.clearParameters();
	}

	public void clearWarnings() throws SQLException {
		callableStatement.clearWarnings();
	}

	public void close() throws SQLException {
		callableStatement.close();
	}

	public boolean execute() throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.execute();
	}

	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.execute(sql, autoGeneratedKeys);
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.execute(sql, columnIndexes);
	}

	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.execute(sql, columnNames);
	}

	public boolean execute(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.execute(sql);
	}

	public int[] executeBatch() throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeBatch();
	}

	public ResultSet executeQuery() throws SQLException {
		return callableStatement.executeQuery();
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeQuery(sql);
	}

	public int executeUpdate() throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeUpdate();
	}

	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeUpdate(sql, autoGeneratedKeys);
	}

	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeUpdate(sql, columnIndexes);
	}

	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeUpdate(sql, columnNames);
	}

	public int executeUpdate(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return callableStatement.executeUpdate(sql);
	}

	public Array getArray(int parameterIndex) throws SQLException {
		return callableStatement.getArray(parameterIndex);
	}

	public Array getArray(String parameterName) throws SQLException {
		return callableStatement.getArray(parameterName);
	}

	/**
	 * @deprecated
	 * @see java.sql.CallableStatement#getBigDecimal(int, int)
	 */
	public BigDecimal getBigDecimal(int parameterIndex, int scale)
			throws SQLException {
		return callableStatement.getBigDecimal(parameterIndex, scale);
	}

	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
		return callableStatement.getBigDecimal(parameterIndex);
	}

	public BigDecimal getBigDecimal(String parameterName) throws SQLException {
		return callableStatement.getBigDecimal(parameterName);
	}

	public Blob getBlob(int parameterIndex) throws SQLException {
		return callableStatement.getBlob(parameterIndex);
	}

	public Blob getBlob(String parameterName) throws SQLException {
		return callableStatement.getBlob(parameterName);
	}

	public boolean getBoolean(int parameterIndex) throws SQLException {
		return callableStatement.getBoolean(parameterIndex);
	}

	public boolean getBoolean(String parameterName) throws SQLException {
		return callableStatement.getBoolean(parameterName);
	}

	public byte getByte(int parameterIndex) throws SQLException {
		return callableStatement.getByte(parameterIndex);
	}

	public byte getByte(String parameterName) throws SQLException {
		return callableStatement.getByte(parameterName);
	}

	public byte[] getBytes(int parameterIndex) throws SQLException {
		return callableStatement.getBytes(parameterIndex);
	}

	public byte[] getBytes(String parameterName) throws SQLException {
		return callableStatement.getBytes(parameterName);
	}

	public Reader getCharacterStream(int parameterIndex) throws SQLException {
		return callableStatement.getCharacterStream(parameterIndex);
	}

	public Reader getCharacterStream(String parameterName) throws SQLException {
		return callableStatement.getCharacterStream(parameterName);
	}

	public Clob getClob(int parameterIndex) throws SQLException {
		return callableStatement.getClob(parameterIndex);
	}

	public Clob getClob(String parameterName) throws SQLException {
		return callableStatement.getClob(parameterName);
	}

	public Connection getConnection() throws SQLException {
		return callableStatement.getConnection();
	}

	public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
		return callableStatement.getDate(parameterIndex, cal);
	}

	public Date getDate(int parameterIndex) throws SQLException {
		return callableStatement.getDate(parameterIndex);
	}

	public Date getDate(String parameterName, Calendar cal) throws SQLException {
		return callableStatement.getDate(parameterName, cal);
	}

	public Date getDate(String parameterName) throws SQLException {
		return callableStatement.getDate(parameterName);
	}

	public double getDouble(int parameterIndex) throws SQLException {
		return callableStatement.getDouble(parameterIndex);
	}

	public double getDouble(String parameterName) throws SQLException {
		return callableStatement.getDouble(parameterName);
	}

	public int getFetchDirection() throws SQLException {
		return callableStatement.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {
		return callableStatement.getFetchSize();
	}

	public float getFloat(int parameterIndex) throws SQLException {
		return callableStatement.getFloat(parameterIndex);
	}

	public float getFloat(String parameterName) throws SQLException {
		return callableStatement.getFloat(parameterName);
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return callableStatement.getGeneratedKeys();
	}

	public int getInt(int parameterIndex) throws SQLException {
		return callableStatement.getInt(parameterIndex);
	}

	public int getInt(String parameterName) throws SQLException {
		return callableStatement.getInt(parameterName);
	}

	public long getLong(int parameterIndex) throws SQLException {
		return callableStatement.getLong(parameterIndex);
	}

	public long getLong(String parameterName) throws SQLException {
		return callableStatement.getLong(parameterName);
	}

	public int getMaxFieldSize() throws SQLException {
		return callableStatement.getMaxFieldSize();
	}

	public int getMaxRows() throws SQLException {
		return callableStatement.getMaxRows();
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		return callableStatement.getMetaData();
	}

	public boolean getMoreResults() throws SQLException {
		return callableStatement.getMoreResults();
	}

	public boolean getMoreResults(int current) throws SQLException {
		return callableStatement.getMoreResults(current);
	}

	public Reader getNCharacterStream(int parameterIndex) throws SQLException {
		return callableStatement.getNCharacterStream(parameterIndex);
	}

	public Reader getNCharacterStream(String parameterName) throws SQLException {
		return callableStatement.getNCharacterStream(parameterName);
	}

	public NClob getNClob(int parameterIndex) throws SQLException {
		return callableStatement.getNClob(parameterIndex);
	}

	public NClob getNClob(String parameterName) throws SQLException {
		return callableStatement.getNClob(parameterName);
	}

	public String getNString(int parameterIndex) throws SQLException {
		return callableStatement.getNString(parameterIndex);
	}

	public String getNString(String parameterName) throws SQLException {
		return callableStatement.getNString(parameterName);
	}

	public Object getObject(int arg0, Map<String, Class<?>> arg1)
			throws SQLException {
		return callableStatement.getObject(arg0, arg1);
	}

	public Object getObject(int parameterIndex) throws SQLException {
		return callableStatement.getObject(parameterIndex);
	}

	public Object getObject(String arg0, Map<String, Class<?>> arg1)
			throws SQLException {
		return callableStatement.getObject(arg0, arg1);
	}

	public Object getObject(String parameterName) throws SQLException {
		return callableStatement.getObject(parameterName);
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		return callableStatement.getParameterMetaData();
	}

	public int getQueryTimeout() throws SQLException {
		return callableStatement.getQueryTimeout();
	}

	public Ref getRef(int parameterIndex) throws SQLException {
		return callableStatement.getRef(parameterIndex);
	}

	public Ref getRef(String parameterName) throws SQLException {
		return callableStatement.getRef(parameterName);
	}

	public ResultSet getResultSet() throws SQLException {
		return callableStatement.getResultSet();
	}

	public int getResultSetConcurrency() throws SQLException {
		return callableStatement.getResultSetConcurrency();
	}

	public int getResultSetHoldability() throws SQLException {
		return callableStatement.getResultSetHoldability();
	}

	public int getResultSetType() throws SQLException {
		return callableStatement.getResultSetType();
	}

	public RowId getRowId(int parameterIndex) throws SQLException {
		return callableStatement.getRowId(parameterIndex);
	}

	public RowId getRowId(String parameterName) throws SQLException {
		return callableStatement.getRowId(parameterName);
	}

	public short getShort(int parameterIndex) throws SQLException {
		return callableStatement.getShort(parameterIndex);
	}

	public short getShort(String parameterName) throws SQLException {
		return callableStatement.getShort(parameterName);
	}

	public SQLXML getSQLXML(int parameterIndex) throws SQLException {
		return callableStatement.getSQLXML(parameterIndex);
	}

	public SQLXML getSQLXML(String parameterName) throws SQLException {
		return callableStatement.getSQLXML(parameterName);
	}

	public String getString(int parameterIndex) throws SQLException {
		return callableStatement.getString(parameterIndex);
	}

	public String getString(String parameterName) throws SQLException {
		return callableStatement.getString(parameterName);
	}

	public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
		return callableStatement.getTime(parameterIndex, cal);
	}

	public Time getTime(int parameterIndex) throws SQLException {
		return callableStatement.getTime(parameterIndex);
	}

	public Time getTime(String parameterName, Calendar cal) throws SQLException {
		return callableStatement.getTime(parameterName, cal);
	}

	public Time getTime(String parameterName) throws SQLException {
		return callableStatement.getTime(parameterName);
	}

	public Timestamp getTimestamp(int parameterIndex, Calendar cal)
			throws SQLException {
		return callableStatement.getTimestamp(parameterIndex, cal);
	}

	public Timestamp getTimestamp(int parameterIndex) throws SQLException {
		return callableStatement.getTimestamp(parameterIndex);
	}

	public Timestamp getTimestamp(String parameterName, Calendar cal)
			throws SQLException {
		return callableStatement.getTimestamp(parameterName, cal);
	}

	public Timestamp getTimestamp(String parameterName) throws SQLException {
		return callableStatement.getTimestamp(parameterName);
	}

	public int getUpdateCount() throws SQLException {
		return callableStatement.getUpdateCount();
	}

	public URL getURL(int parameterIndex) throws SQLException {
		return callableStatement.getURL(parameterIndex);
	}

	public URL getURL(String parameterName) throws SQLException {
		return callableStatement.getURL(parameterName);
	}

	public SQLWarning getWarnings() throws SQLException {
		return callableStatement.getWarnings();
	}

	public boolean isClosed() throws SQLException {
		return callableStatement.isClosed();
	}

	public boolean isPoolable() throws SQLException {
		return callableStatement.isPoolable();
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return callableStatement.isWrapperFor(iface);
	}

	public void registerOutParameter(int parameterIndex, int sqlType, int scale)
			throws SQLException {
		callableStatement.registerOutParameter(parameterIndex, sqlType, scale);
	}

	public void registerOutParameter(int parameterIndex, int sqlType,
			String typeName) throws SQLException {
		callableStatement.registerOutParameter(parameterIndex, sqlType,
				typeName);
	}

	public void registerOutParameter(int parameterIndex, int sqlType)
			throws SQLException {
		callableStatement.registerOutParameter(parameterIndex, sqlType);
	}

	public void registerOutParameter(String parameterName, int sqlType,
			int scale) throws SQLException {
		callableStatement.registerOutParameter(parameterName, sqlType, scale);
	}

	public void registerOutParameter(String parameterName, int sqlType,
			String typeName) throws SQLException {
		callableStatement
				.registerOutParameter(parameterName, sqlType, typeName);
	}

	public void registerOutParameter(String parameterName, int sqlType)
			throws SQLException {
		callableStatement.registerOutParameter(parameterName, sqlType);
	}

	public void setArray(int parameterIndex, Array x) throws SQLException {
		callableStatement.setArray(parameterIndex, x);
	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		callableStatement.setAsciiStream(parameterIndex, x, length);
	}

	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		callableStatement.setAsciiStream(parameterIndex, x, length);
	}

	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException {
		callableStatement.setAsciiStream(parameterIndex, x);
	}

	public void setAsciiStream(String parameterName, InputStream x, int length)
			throws SQLException {
		callableStatement.setAsciiStream(parameterName, x, length);
	}

	public void setAsciiStream(String parameterName, InputStream x, long length)
			throws SQLException {
		callableStatement.setAsciiStream(parameterName, x, length);
	}

	public void setAsciiStream(String parameterName, InputStream x)
			throws SQLException {
		callableStatement.setAsciiStream(parameterName, x);
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		callableStatement.setBigDecimal(parameterIndex, x);
	}

	public void setBigDecimal(String parameterName, BigDecimal x)
			throws SQLException {
		callableStatement.setBigDecimal(parameterName, x);
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		callableStatement.setBinaryStream(parameterIndex, x, length);
	}

	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		callableStatement.setBinaryStream(parameterIndex, x, length);
	}

	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException {
		callableStatement.setBinaryStream(parameterIndex, x);
	}

	public void setBinaryStream(String parameterName, InputStream x, int length)
			throws SQLException {
		callableStatement.setBinaryStream(parameterName, x, length);
	}

	public void setBinaryStream(String parameterName, InputStream x, long length)
			throws SQLException {
		callableStatement.setBinaryStream(parameterName, x, length);
	}

	public void setBinaryStream(String parameterName, InputStream x)
			throws SQLException {
		callableStatement.setBinaryStream(parameterName, x);
	}

	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		callableStatement.setBlob(parameterIndex, x);
	}

	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		callableStatement.setBlob(parameterIndex, inputStream, length);
	}

	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		callableStatement.setBlob(parameterIndex, inputStream);
	}

	public void setBlob(String parameterName, Blob x) throws SQLException {
		callableStatement.setBlob(parameterName, x);
	}

	public void setBlob(String parameterName, InputStream inputStream,
			long length) throws SQLException {
		callableStatement.setBlob(parameterName, inputStream, length);
	}

	public void setBlob(String parameterName, InputStream inputStream)
			throws SQLException {
		callableStatement.setBlob(parameterName, inputStream);
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		callableStatement.setBoolean(parameterIndex, x);
	}

	public void setBoolean(String parameterName, boolean x) throws SQLException {
		callableStatement.setBoolean(parameterName, x);
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		callableStatement.setByte(parameterIndex, x);
	}

	public void setByte(String parameterName, byte x) throws SQLException {
		callableStatement.setByte(parameterName, x);
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		callableStatement.setBytes(parameterIndex, x);
	}

	public void setBytes(String parameterName, byte[] x) throws SQLException {
		callableStatement.setBytes(parameterName, x);
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		callableStatement.setCharacterStream(parameterIndex, reader, length);
	}

	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		callableStatement.setCharacterStream(parameterIndex, reader, length);
	}

	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		callableStatement.setCharacterStream(parameterIndex, reader);
	}

	public void setCharacterStream(String parameterName, Reader reader,
			int length) throws SQLException {
		callableStatement.setCharacterStream(parameterName, reader, length);
	}

	public void setCharacterStream(String parameterName, Reader reader,
			long length) throws SQLException {
		callableStatement.setCharacterStream(parameterName, reader, length);
	}

	public void setCharacterStream(String parameterName, Reader reader)
			throws SQLException {
		callableStatement.setCharacterStream(parameterName, reader);
	}

	public void setClob(int parameterIndex, Clob x) throws SQLException {
		callableStatement.setClob(parameterIndex, x);
	}

	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		callableStatement.setClob(parameterIndex, reader, length);
	}

	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		callableStatement.setClob(parameterIndex, reader);
	}

	public void setClob(String parameterName, Clob x) throws SQLException {
		callableStatement.setClob(parameterName, x);
	}

	public void setClob(String parameterName, Reader reader, long length)
			throws SQLException {
		callableStatement.setClob(parameterName, reader, length);
	}

	public void setClob(String parameterName, Reader reader)
			throws SQLException {
		callableStatement.setClob(parameterName, reader);
	}

	public void setCursorName(String name) throws SQLException {
		callableStatement.setCursorName(name);
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		callableStatement.setDate(parameterIndex, x, cal);
	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		callableStatement.setDate(parameterIndex, x);
	}

	public void setDate(String parameterName, Date x, Calendar cal)
			throws SQLException {
		callableStatement.setDate(parameterName, x, cal);
	}

	public void setDate(String parameterName, Date x) throws SQLException {
		callableStatement.setDate(parameterName, x);
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		callableStatement.setDouble(parameterIndex, x);
	}

	public void setDouble(String parameterName, double x) throws SQLException {
		callableStatement.setDouble(parameterName, x);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		callableStatement.setEscapeProcessing(enable);
	}

	public void setFetchDirection(int direction) throws SQLException {
		callableStatement.setFetchDirection(direction);
	}

	public void setFetchSize(int rows) throws SQLException {
		callableStatement.setFetchSize(rows);
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		callableStatement.setFloat(parameterIndex, x);
	}

	public void setFloat(String parameterName, float x) throws SQLException {
		callableStatement.setFloat(parameterName, x);
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		callableStatement.setInt(parameterIndex, x);
	}

	public void setInt(String parameterName, int x) throws SQLException {
		callableStatement.setInt(parameterName, x);
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		callableStatement.setLong(parameterIndex, x);
	}

	public void setLong(String parameterName, long x) throws SQLException {
		callableStatement.setLong(parameterName, x);
	}

	public void setMaxFieldSize(int max) throws SQLException {
		callableStatement.setMaxFieldSize(max);
	}

	public void setMaxRows(int max) throws SQLException {
		callableStatement.setMaxRows(max);
	}

	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException {
		callableStatement.setNCharacterStream(parameterIndex, value, length);
	}

	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException {
		callableStatement.setNCharacterStream(parameterIndex, value);
	}

	public void setNCharacterStream(String parameterName, Reader value,
			long length) throws SQLException {
		callableStatement.setNCharacterStream(parameterName, value, length);
	}

	public void setNCharacterStream(String parameterName, Reader value)
			throws SQLException {
		callableStatement.setNCharacterStream(parameterName, value);
	}

	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		callableStatement.setNClob(parameterIndex, value);
	}

	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		callableStatement.setNClob(parameterIndex, reader, length);
	}

	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		callableStatement.setNClob(parameterIndex, reader);
	}

	public void setNClob(String parameterName, NClob value) throws SQLException {
		callableStatement.setNClob(parameterName, value);
	}

	public void setNClob(String parameterName, Reader reader, long length)
			throws SQLException {
		callableStatement.setNClob(parameterName, reader, length);
	}

	public void setNClob(String parameterName, Reader reader)
			throws SQLException {
		callableStatement.setNClob(parameterName, reader);
	}

	public void setNString(int parameterIndex, String value)
			throws SQLException {
		callableStatement.setNString(parameterIndex, value);
	}

	public void setNString(String parameterName, String value)
			throws SQLException {
		callableStatement.setNString(parameterName, value);
	}

	public void setNull(int parameterIndex, int sqlType, String typeName)
			throws SQLException {
		callableStatement.setNull(parameterIndex, sqlType, typeName);
	}

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		callableStatement.setNull(parameterIndex, sqlType);
	}

	public void setNull(String parameterName, int sqlType, String typeName)
			throws SQLException {
		callableStatement.setNull(parameterName, sqlType, typeName);
	}

	public void setNull(String parameterName, int sqlType) throws SQLException {
		callableStatement.setNull(parameterName, sqlType);
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scaleOrLength) throws SQLException {
		callableStatement.setObject(parameterIndex, x, targetSqlType,
				scaleOrLength);
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		callableStatement.setObject(parameterIndex, x, targetSqlType);
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		callableStatement.setObject(parameterIndex, x);
	}

	public void setObject(String parameterName, Object x, int targetSqlType,
			int scale) throws SQLException {
		callableStatement.setObject(parameterName, x, targetSqlType, scale);
	}

	public void setObject(String parameterName, Object x, int targetSqlType)
			throws SQLException {
		callableStatement.setObject(parameterName, x, targetSqlType);
	}

	public void setObject(String parameterName, Object x) throws SQLException {
		callableStatement.setObject(parameterName, x);
	}

	public void setPoolable(boolean poolable) throws SQLException {
		callableStatement.setPoolable(poolable);
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		callableStatement.setQueryTimeout(seconds);
	}

	public void setRef(int parameterIndex, Ref x) throws SQLException {
		callableStatement.setRef(parameterIndex, x);
	}

	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		callableStatement.setRowId(parameterIndex, x);
	}

	public void setRowId(String parameterName, RowId x) throws SQLException {
		callableStatement.setRowId(parameterName, x);
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		callableStatement.setShort(parameterIndex, x);
	}

	public void setShort(String parameterName, short x) throws SQLException {
		callableStatement.setShort(parameterName, x);
	}

	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		callableStatement.setSQLXML(parameterIndex, xmlObject);
	}

	public void setSQLXML(String parameterName, SQLXML xmlObject)
			throws SQLException {
		callableStatement.setSQLXML(parameterName, xmlObject);
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		callableStatement.setString(parameterIndex, x);
	}

	public void setString(String parameterName, String x) throws SQLException {
		callableStatement.setString(parameterName, x);
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		callableStatement.setTime(parameterIndex, x, cal);
	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		callableStatement.setTime(parameterIndex, x);
	}

	public void setTime(String parameterName, Time x, Calendar cal)
			throws SQLException {
		callableStatement.setTime(parameterName, x, cal);
	}

	public void setTime(String parameterName, Time x) throws SQLException {
		callableStatement.setTime(parameterName, x);
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		callableStatement.setTimestamp(parameterIndex, x, cal);
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		callableStatement.setTimestamp(parameterIndex, x);
	}

	public void setTimestamp(String parameterName, Timestamp x, Calendar cal)
			throws SQLException {
		callableStatement.setTimestamp(parameterName, x, cal);
	}

	public void setTimestamp(String parameterName, Timestamp x)
			throws SQLException {
		callableStatement.setTimestamp(parameterName, x);
	}

	/**
	 * @deprecated
	 * @see java.sql.PreparedStatement#setUnicodeStream(int,
	 *      java.io.InputStream, int)
	 */
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		callableStatement.setUnicodeStream(parameterIndex, x, length);
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		callableStatement.setURL(parameterIndex, x);
	}

	public void setURL(String parameterName, URL val) throws SQLException {
		callableStatement.setURL(parameterName, val);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return callableStatement.unwrap(iface);
	}

	public boolean wasNull() throws SQLException {
		return callableStatement.wasNull();
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		callableStatement.closeOnCompletion();
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return callableStatement.isCloseOnCompletion();
	}

	@Override
	public <T> T getObject(int parameterIndex, Class<T> type)
			throws SQLException {
		return callableStatement.getObject(parameterIndex, type);
	}

	@Override
	public <T> T getObject(String parameterName, Class<T> type)
			throws SQLException {
		return callableStatement.getObject(parameterName, type);
	}
}
