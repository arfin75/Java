/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.service;


/**
 *
 * @author shaharfin
 */
public class NoTaxesFoundException extends Exception {
    public NoTaxesFoundException(String message) {
        super(message);
    }

    public NoTaxesFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

