/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class BusinessException extends Exception{
    private List<BusinessMessage> businessMessages = new ArrayList<>();

    public BusinessException(List<BusinessMessage> businessMessages) {
        this.businessMessages.addAll(businessMessages);
    }
    
    public BusinessException(BusinessMessage businessMessage) {
        this.businessMessages.add(businessMessage);
    }
    
    public BusinessException(Exception ex) {
        businessMessages.add(new BusinessMessage(null, ex.toString()));
    }
    
}
