/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.security.Authorization;

/**
 *
 * @author alumno
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, String metodo) {
        boolean success;

        if (url.equals("/banco-api/api/login")) {
            success = true;
        } else {
            success = usuario != null;
        }
        return success;
    }

}
