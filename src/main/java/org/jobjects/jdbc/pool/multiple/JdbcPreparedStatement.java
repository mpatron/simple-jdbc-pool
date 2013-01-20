package org.jobjects.jdbc.pool.multiple;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
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
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcPreparedStatement implements PreparedStatement {

	private PreparedStatement preparedStatement;
	private String sql;
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	private Vector<String> parameters = new Vector<String>();

	public JdbcPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public JdbcPreparedStatement(PreparedStatement preparedStatement, String sql) {
		this.preparedStatement = preparedStatement;
		this.sql = sql;
	}

	public static String ObjectUtilsToString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	@Override
	public void addBatch() throws SQLException {
		preparedStatement.addBatch();
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		preparedStatement.addBatch(sql);
	}

	@Override
	public void cancel() throws SQLException {
		preparedStatement.cancel();
	}

	@Override
	public void clearBatch() throws SQLException {
		preparedStatement.clearBatch();
	}

	@Override
	public void clearParameters() throws SQLException {
		preparedStatement.clearParameters();
	}

	@Override
	public void clearWarnings() throws SQLException {
		preparedStatement.clearWarnings();
	}

	@Override
	public void close() throws SQLException {
		preparedStatement.close();
	}

	@Override
	public boolean execute() throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.execute();
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.execute(sql, autoGeneratedKeys);
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.execute(sql, columnIndexes);
	}

	@Override
	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.execute(sql, columnNames);
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.execute(sql);
	}

	@Override
	public int[] executeBatch() throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeBatch();
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		String message = "";
		Iterator<String> iter = parameters.iterator();
		while (iter.hasNext()) {
			String element = (String) iter.next();
			message += " " + element;
		}
		LOGGER.log(Level.FINE, sql + message);
		return preparedStatement.executeQuery();
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeQuery(sql);
	}

	@Override
	public int executeUpdate() throws SQLException {
		String message = "";
		Iterator<String> iter = parameters.iterator();
		while (iter.hasNext()) {
			String element = (String) iter.next();
			message += " " + element;
		}
		LOGGER.log(Level.FINE, sql + message);
		return preparedStatement.executeUpdate();
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeUpdate(sql, autoGeneratedKeys);
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeUpdate(sql, columnIndexes);
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeUpdate(sql, columnNames);
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		LOGGER.log(Level.FINE, sql);
		return preparedStatement.executeUpdate(sql);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return preparedStatement.getConnection();
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return preparedStatement.getFetchDirection();
	}

	@Override
	public int getFetchSize() throws SQLException {
		return preparedStatement.getFetchSize();
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return preparedStatement.getGeneratedKeys();
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return preparedStatement.getMaxFieldSize();
	}

	@Override
	public int getMaxRows() throws SQLException {
		return preparedStatement.getMaxRows();
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return preparedStatement.getMetaData();
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return preparedStatement.getMoreResults();
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		return preparedStatement.getMoreResults(current);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return preparedStatement.getParameterMetaData();
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return preparedStatement.getQueryTimeout();
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return preparedStatement.getResultSet();
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return preparedStatement.getResultSetConcurrency();
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return preparedStatement.getResultSetHoldability();
	}

	@Override
	public int getResultSetType() throws SQLException {
		return preparedStatement.getResultSetType();
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return preparedStatement.getUpdateCount();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return preparedStatement.getWarnings();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return preparedStatement.isClosed();
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return preparedStatement.isPoolable();
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return preparedStatement.isWrapperFor(iface);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setAsciiStream(parameterIndex, x);
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBigDecimal(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBlob(parameterIndex, x);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		preparedStatement.setBlob(parameterIndex, inputStream, length);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		preparedStatement.setBlob(parameterIndex, inputStream);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBoolean(parameterIndex, x);
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		preparedStatement.setByte(parameterIndex, x);
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setBytes(parameterIndex, x);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		preparedStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		preparedStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		preparedStatement.setCharacterStream(parameterIndex, reader);
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		preparedStatement.setClob(parameterIndex, x);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		preparedStatement.setClob(parameterIndex, reader, length);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		preparedStatement.setClob(parameterIndex, reader);
	}

	@Override
	public void setCursorName(String name) throws SQLException {
		preparedStatement.setCursorName(name);
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setDate(parameterIndex, x, cal);
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setDate(parameterIndex, x);
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setDouble(parameterIndex, x);
	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		preparedStatement.setEscapeProcessing(enable);
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		preparedStatement.setFetchDirection(direction);
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		preparedStatement.setFetchSize(rows);
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setFloat(parameterIndex, x);
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setInt(parameterIndex, x);
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setLong(parameterIndex, x);
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		preparedStatement.setMaxFieldSize(max);
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		preparedStatement.setMaxRows(max);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException {
		preparedStatement.setNCharacterStream(parameterIndex, value, length);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException {
		preparedStatement.setNCharacterStream(parameterIndex, value);
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		preparedStatement.setNClob(parameterIndex, value);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		preparedStatement.setNClob(parameterIndex, reader, length);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		preparedStatement.setNClob(parameterIndex, reader);
	}

	@Override
	public void setNString(int parameterIndex, String value)
			throws SQLException {
		parameters.add(value);
		preparedStatement.setNString(parameterIndex, value);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName)
			throws SQLException {
		parameters.add("NUL");
		preparedStatement.setNull(parameterIndex, sqlType, typeName);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		parameters.add("NULL");
		preparedStatement.setNull(parameterIndex, sqlType);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scaleOrLength) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setObject(parameterIndex, x, targetSqlType,
				scaleOrLength);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setObject(parameterIndex, x);
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		preparedStatement.setPoolable(poolable);
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		preparedStatement.setQueryTimeout(seconds);
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setRef(parameterIndex, x);
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setRowId(parameterIndex, x);
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setShort(parameterIndex, x);
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		preparedStatement.setSQLXML(parameterIndex, xmlObject);
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setString(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setTime(parameterIndex, x, cal);
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setTime(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setTimestamp(parameterIndex, x, cal);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		parameters.add(ObjectUtilsToString(x));
		preparedStatement.setTimestamp(parameterIndex, x);
	}

	/**
	 * @deprecated
	 * @param parameterIndex
	 * @param x
	 * @param length
	 * @throws SQLException
	 */
	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		preparedStatement.setUnicodeStream(parameterIndex, x, length);
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		preparedStatement.setURL(parameterIndex, x);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return preparedStatement.unwrap(iface);
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		preparedStatement.setArray(parameterIndex, x);
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		preparedStatement.closeOnCompletion();

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return preparedStatement.isCloseOnCompletion();
	}

}
