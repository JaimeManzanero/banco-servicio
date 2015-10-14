/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistence.dao.impl.jdbc.EntidadBancariaDAOImpJDBC;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaServiceImpl implements EntidadBancariaService{

    @Override
    public EntidadBancaria get(int id) {
        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
        
        EntidadBancaria entidadBancaria = entidadBancariaDAO.get(id);
        
        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadBancaria> findAll() {
        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
        return entidadesBancarias;
    }
    
}