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
import org.springframework.beans.factory.annotation.Autowired;


public class EntidadBancariaServiceImpl implements EntidadBancariaService {
    
    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria get(int id) {

        EntidadBancaria entidadBancaria = entidadBancariaDAO.get(id);

        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) {
        return entidadBancariaDAO.insert(t);
    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        return entidadBancariaDAO.delete(id);
    }

    @Override
    public List<EntidadBancaria> findAll() {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
        return entidadesBancarias;
    }

}
