/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg;

import com.sg.controller.Controller;
import com.sg.dao.AuditDao;
import com.sg.dao.AuditDaoFileImpl;
import com.sg.dao.Dao;
import com.sg.dao.DaoFileImpl;
import com.sg.service.Service;
import com.sg.service.ServiceFileImpl;
import com.sg.ui.UserIO;
import com.sg.ui.UserIOConsoleImpl;
import com.sg.ui.View;

/**
 *
 * @author shaharfin
 */
public class App {
    public static void main(String[] args) {
        AuditDao Auditdaofileimpl = new AuditDaoFileImpl();
        Dao dao = new DaoFileImpl();
        Service service = new ServiceFileImpl(dao);
        // user new Scanner(System.in)
        UserIO io = new UserIOConsoleImpl();
        View view = new View(io);
        Controller controller = new Controller(service,view);
        controller.run();
    }
}
