/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Autowired
    DataSourceFactory dataSourceFactory;
    
    @Override
    public Connection getConnection() {
        Connection connection;
        
        try {
            DataSource dataSource = dataSourceFactory.getDataSource();
            connection = dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return connection;
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
