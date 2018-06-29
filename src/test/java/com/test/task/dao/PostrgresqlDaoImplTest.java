package com.test.task.dao;

import com.test.task.entities.Filter;
import com.test.task.entities.PartEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by lollipop on 29.06.2018.
 */
public class PostrgresqlDaoImplTest {

    @Before
    public void init() {

    }

    @Test
    public void getPartsByFilter(){
        PostgresqlDaoImpl postgresqlDao = new PostgresqlDaoImpl();
        Filter filter = new Filter();
        List<PartEntity> result = postgresqlDao.getPartsByFilter(filter);
        assertEquals(4, result.size());
        filter = new Filter();
        filter.setPN("NO12-01");
        result = postgresqlDao.getPartsByFilter(filter);
        assertEquals(1, result.size());
        filter = new Filter();
        filter.setPN("NO12-01");
        filter.setPartName("HPK Io 11");
        result = postgresqlDao.getPartsByFilter(filter);
        assertEquals(0, result.size());
        filter = new Filter();
        filter.setVendor("CH-DAL");
        filter.setQty(64);
        result = postgresqlDao.getPartsByFilter(filter);
        assertEquals(2, result.size());
    }

    @After
    public void destroy() {
        try {
            PostgresqlDaoImpl.getStatement().close();
            PostgresqlDaoImpl.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
