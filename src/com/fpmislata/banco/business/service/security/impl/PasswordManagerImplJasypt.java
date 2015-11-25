/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.security.impl;

import com.fpmislata.banco.business.service.security.PasswordManager;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author alumno
 */
public class PasswordManagerImplJasypt implements PasswordManager {

    @Override
    public String encrypt(String password) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = strongPasswordEncryptor.encryptPassword(password);
        return encryptedPassword;
    }

    @Override
    public boolean check(String password, String encryptedPassword) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        boolean checked = strongPasswordEncryptor.checkPassword(password, encryptedPassword);
        return checked;
    }
    
}
