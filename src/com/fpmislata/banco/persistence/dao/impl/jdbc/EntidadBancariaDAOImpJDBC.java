
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class EntidadBancariaDAOImpJDBC implements EntidadBancariaDAO {
    
    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        
        try {
            Connection connection = connectionFactory.getConnection();
            EntidadBancaria entidadbancaria = new EntidadBancaria();
            String sql = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                entidadbancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadbancaria.setNombre(resultSet.getString("nombre"));
                entidadbancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));
                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());
                entidadbancaria.setFechaCreacion(utilDate);
                entidadbancaria.setDireccion(resultSet.getString("direccion"));
                entidadbancaria.setCIF(resultSet.getString("CIF"));
            } else {
                entidadbancaria = null;
            }

            connectionFactory.close(connection);

            return entidadbancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {

        try {
            int idEntidadBancaria;
            String sql = "INSERT INTO entidadbancaria (nombre,codigoEntidad,fechaCreacion,direccion,CIF) VALUES (?,?,?,?,?)";
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            java.sql.Date sqlDate = new java.sql.Date((new java.util.Date()).getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCIF());

            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted == 0) {
                throw new RuntimeException("Ninguna fila insertada");
            } else if (rowsInserted != 1) {
                throw new RuntimeException("Demasiadas o pocas filas insertadas: " + rowsInserted);
            }
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idEntidadBancaria = generatedKeys.getInt(1);
            } else {
               throw new RuntimeException("No se ha encontrado de clave primaria"); 
            }
            connectionFactory.close(connection); 
            entidadBancaria = this.get(idEntidadBancaria);
           
            return entidadBancaria;
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {

        try {
            String sql = "UPDATE entidadbancaria SET nombre = ?, codigoEntidad = ?, direccion = ?, CIF = ? WHERE idEntidadBancaria = ?";
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setString(3, entidadBancaria.getDireccion());
            preparedStatement.setString(4, entidadBancaria.getCIF());
            preparedStatement.setInt(5, entidadBancaria.getIdEntidadBancaria());

            int rowsChanged = preparedStatement.executeUpdate();

            if (rowsChanged == 0) {
                throw new RuntimeException("Ninguna fila cambiada");
            } else if (rowsChanged != 1) {
                throw new RuntimeException("Demasiadas filas cambiadas: " + rowsChanged);
            }
            
            connectionFactory.close(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int idEntidadBancaria) {
        try {
            String sql = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idEntidadBancaria);

            int rowsDeleted = preparedStatement.executeUpdate();

            connectionFactory.close(connection);

            if (rowsDeleted == 0) {
                return false;
            } else if (rowsDeleted == 1) {
                return true;
            } else if (rowsDeleted > 1) {
                throw new RuntimeException("Demasiadas filas borradas: " + rowsDeleted);
            } else {
                throw new RuntimeException("Soy un paranoico: " + rowsDeleted);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        
        try {
            String sql = "SELECT * FROM entidadbancaria";
            List<EntidadBancaria> listaEntidadBancaria = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            
            while (resultSet.next()) {

                EntidadBancaria entidadbancaria = new EntidadBancaria();

                entidadbancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadbancaria.setNombre(resultSet.getString("nombre"));
                entidadbancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));

                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());

                entidadbancaria.setFechaCreacion(utilDate);
                entidadbancaria.setDireccion(resultSet.getString("direccion"));
                entidadbancaria.setCIF(resultSet.getString("CIF"));

                listaEntidadBancaria.add(entidadbancaria);
            }

            connectionFactory.close(connection);

            return listaEntidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        String sql = "SELECT * FROM entidadbancaria WHERE nombre = ?";
        EntidadBancaria entidadbancaria = null;
        List<EntidadBancaria> listaEntidadBancaria = new ArrayList<>();

        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                entidadbancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadbancaria.setNombre(resultSet.getString("nombre"));
                entidadbancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));
                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());
                entidadbancaria.setFechaCreacion(utilDate);
                entidadbancaria.setDireccion(resultSet.getString("direccion"));
                entidadbancaria.setCIF(resultSet.getString("CIF"));

                listaEntidadBancaria.add(entidadbancaria);
            }

            connectionFactory.close(connection);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return listaEntidadBancaria;
    }

}
