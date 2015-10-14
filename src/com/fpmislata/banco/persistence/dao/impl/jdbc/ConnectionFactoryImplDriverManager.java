/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDriverManager implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        Connection connection= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
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
