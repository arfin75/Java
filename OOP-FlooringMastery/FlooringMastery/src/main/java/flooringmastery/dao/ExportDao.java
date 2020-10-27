/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dao;

import flooringmastery.dto.Order;

import java.util.List;

/**
 *
 * @author shaharfin
 */
public interface ExportDao {

    abstract void saveOrdersToFile(List<Order> allOrders) throws FlooringPersistenceException;
    
}
