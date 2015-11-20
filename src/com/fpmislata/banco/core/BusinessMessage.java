/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

/**
 *
 * @author alumno
 */
public class BusinessMessage {
    private String fieldName;
    private String message;

    public BusinessMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public BusinessMessage() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
