package Utilities;

	import com.datastax.driver.core.*;
	import com.datastax.driver.core.Cluster.Builder;
	import com.datastax.driver.core.ColumnDefinitions.Definition;
	import org.apache.log4j.Logger;
	import Utilities.ConstantVariables.CassandraConnection;

	import java.util.*;

	/**
	 * @author jxavier general utility to connect/query/close cassandra database
	 * connection
	 */
	public class DatabaseUtil {
	    ConfigReader config = null;
	    Properties prop = null;
	    private Cluster cluster;
	    private Session session;

	    private Logger log = null;

	    public DatabaseUtil() {
	        config = new ConfigReader();
	        prop = config.init_properties();
	        log = Logger.getLogger(DatabaseUtil.class);
	    }

	    /**
	     * connect to cassandra database
	     */
	    private void connectCassandra() {
	        try {
	            String environment = prop.getProperty("dbEnvironment");
	            String username = CassandraConnection.valueOf(environment).getUsername();
	            String password = CassandraConnection.valueOf(environment).getPassword();
	            String host = CassandraConnection.valueOf(environment).getHost();
	            Integer port = CassandraConnection.valueOf(environment).getPort();

	            Builder connectionBuilder = Cluster.builder().withCredentials(username, password).addContactPoint(host)
	                    .withPort(port);
	            cluster = connectionBuilder.build();
	            session = cluster.connect();
	            log.info("Connected to cassandra in " + environment + " environment");
	        } catch (Exception e) {
	            log.error("Unable to connect to Cassandra. " + e);
	        }
	    }

	    /**
	     * close database connection
	     */
	    private void closeCassandraConnection() {
	        try {
	            if (!session.isClosed())
	                session.close();
	            if (!cluster.isClosed())
	                cluster.close();
	            log.info("Cassandra connection closed");
	        } catch (Exception e) {
	            log.error("Unable to close cassandra connection. " + e.getStackTrace());
	        }
	    }

	    /**
	     * @param query
	     * @return list of maps containing rows of data
	     */
	    public List<Map<String, String>> executeQuery(String query) {
	        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	        try {
	            connectCassandra();
	            log.info("Executing query: " + query);
	            Map<String, String> recordMap = new LinkedHashMap<>();
	            Map<String, String> columnMap = new LinkedHashMap<>();
	            ResultSet resultSet = session.execute(query);

	            ColumnDefinitions columnDefs = resultSet.getColumnDefinitions();
	            Iterator<Definition> columnDefIter = columnDefs.iterator();
	            while (columnDefIter.hasNext()) {
	                Definition columnDef = columnDefIter.next();
	                columnMap.put(columnDef.getName().toString(), columnDef.getType().toString());
	            }

	            for (Row row : resultSet) {
	                recordMap = new LinkedHashMap<>();
	                for (String columnName : columnMap.keySet()) {
	                    String value = "";
	                    String columnType = columnMap.get(columnName);
	                    if (columnType.equalsIgnoreCase("varchar"))
	                        value = row.getString(columnName);
	                    else if (columnType.equalsIgnoreCase("int"))
	                        value = Integer.toString(row.getInt(columnName));
	                    else if (columnType.equalsIgnoreCase("timestamp"))
	                        value = row.getTimestamp(columnName).toString();
	                    else if (columnType.equalsIgnoreCase("date"))
	                        value = row.getDate(columnName).toString();
	                    recordMap.put(columnName, value);
	                }
	                resultList.add(recordMap);
	            }
	            log.info("Query Result: ");
	            if (resultList.size() == 0)
	                log.info("No records retrieved.");
	            else {
	                for (Map<String, String> record : resultList)
	                    log.info(record.toString());
	            }
	            return resultList;
	        } catch (Exception e) {
	            log.error("Unable to execute query in Cassandra. " + e.getStackTrace());
	            return null;
	        } finally {
	            closeCassandraConnection();
	        }

	    }
	}

