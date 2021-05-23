package com.ming.mp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestMp {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println();
        System.out.println("===========================dataSource:"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("connection==:"+connection);
        connection.close();
    }
}
