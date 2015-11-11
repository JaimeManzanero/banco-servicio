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
    public String encrypt(String plain) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = strongPasswordEncryptor.encryptPassword(plain);
        return encryptedPassword;
    }

    @Override
    public boolean check(String plain, String encrypt) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        boolean checked = strongPasswordEncryptor.checkPassword(plain, encrypt);
        return checked;
    }
    
}
