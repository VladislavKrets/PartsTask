package com.test.task.dao;

import com.test.task.entities.Filter;
import com.test.task.entities.PartEntity;
import com.test.task.servlets.PartsServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class for working with postgresql db
 */
public class PostgresqlDaoImpl implements Dao {
    final static Logger logger = LogManager.getLogger(PostgresqlDaoImpl.class);

    private static Connection connection;
    private static Statement statement;

    /**
     * static block allows us to initialize connection
     */
    static {
        logger.debug("connecting to db");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/root", "postgres", "postgres");
            //url, username and password are hardcoded because of this task
            //it is better to input them from configuration file
            statement = connection.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error during connecting to db");
            logger.catching(e);
        }
    }

    /**
     * this method realises getting Parts by filter from db
     * @param filter - we get this entity from servlet
     * @return list of parts
     */
    @Override
    public List<PartEntity> getPartsByFilter(Filter filter) {
        List<PartEntity> partEntities = new ArrayList<>();
        if (connection != null && statement != null) {
            logger.debug("building query");
            String sql;
            if (isAllValuesNull(filter)) sql = "select * from partsdb.parts";
            //if all values is filter are null or empty we are selecting all parts
            else sql = buildSql(filter); //else building sql using "where"
            try {
                PartEntity partEntity;
                logger.debug("Executing query");
                ResultSet set = statement.executeQuery(sql); //executing our query
                while (set.next()) {
                    partEntity = buildPartEntity(set); //and building part entities
                    partEntities.add(partEntity);
                }
            } catch (SQLException e) {
                logger.error("Error during executing query");
                logger.catching(e);
            }
        }
        return partEntities;
    }

    /**
     * this method allows us to build part entity
     * @param set result set we get from executed query
     * @return ready PartEntity
     * @throws SQLException method set.getSMTH throws
     */
    private PartEntity buildPartEntity(ResultSet set) throws SQLException {
        PartEntity partEntity;
        partEntity = new PartEntity();
        partEntity.setPN(set.getString("PN"));
        partEntity.setPartName(set.getString("Part_Name"));
        partEntity.setQty(set.getInt("Qty"));
        partEntity.setVendor(set.getString("vendor"));
        partEntity.setReceived(set.getDate("received"));
        partEntity.setShipped(set.getDate("shipped"));
        return partEntity;
    }

    /**
     * this method allows us to build sql query
     * @param filter from getPartsByFilter method
     * @return ready sql query
     */
    private String buildSql(Filter filter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder();
        //we are using StringBuilder because it's faster
        builder.append("select * from partsdb.parts where ");
        if (filter.getPartName() != null && !filter.getPartName().isEmpty())
            builder.append("\'").append(filter.getPartName()).append("\' like \"Part_Name\"").append(" and ");
        if (filter.getPN() != null && !filter.getPN().isEmpty())
            builder.append("\'").append(filter.getPN()).append("\' like \"PN\"").append(" and ");
        if (filter.getQty() != null) builder.append("\"Qty\" >= ").append(filter.getQty()).append(" and ");
        if (filter.getVendor() != null && !filter.getVendor().isEmpty())
            builder.append("\'").append(filter.getVendor()).append("\' like \"vendor\"").append(" and ");
        if (filter.getShippedAfter() != null)
            builder.append("\"shipped\" >= \'").append(dateFormat.format(filter.getShippedAfter())).append("\' and ");
        if (filter.getShippedBefore() != null)
            builder.append("\"shipped\" <= \'").append(dateFormat.format(filter.getShippedBefore())).append("\' and ");
        if (filter.getReceivedAfter() != null)
            builder.append("\"received\" >= \'").append(dateFormat.format(filter.getReceivedAfter())).append("\' and ");
        if (filter.getReceivedBefore() != null)
            builder.append("\"received\" <= \'").append(dateFormat.format(filter.getReceivedBefore())).append("\' and ");
        //checking all filter criteria for null and empty values
        //building sql using this data
        return builder.substring(0, builder.length() - 5);
        //in the end of sql will be 2 spaces and "and"
        //cutting this 5 symbols
    }

    /**
     * checking all values by null
     * @param filter from getPartsByFilter
     * @return boolean
     */
    private boolean isAllValuesNull(Filter filter) {
        return filter.getPartName() == null
                && filter.getPN() == null && filter.getQty() == null && filter.getReceivedAfter() == null
                && filter.getReceivedBefore() == null && filter.getShippedAfter() == null
                && filter.getShippedBefore() == null && filter.getVendor() == null;
    }

    /**
     * for normal closing
     * @return connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * for normal closing
     * @return statement
     */
    public static Statement getStatement() {
        return statement;
    }
}
