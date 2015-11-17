/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class DataSourceFactoryImpl implements DataSourceFactory{

    @Override
    public DataSource getDataSource() {
        DataSource dataSource;
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/MySQLDS");
        } catch (NamingException ex) {
            dataSource = null;
            throw new RuntimeException("He petado");
        }
        return dataSource;
    }
    
}
