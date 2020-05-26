/*
 * Project Tittle: DVD Library
 * Created By: Shah Arfin
 * Last Updated: 05/26/2020
 */
package com.mycompany.dvdlibrary;

import com.mycompany.dvdlibrary.controller.DVDLibraryController;
import com.mycompany.dvdlibrary.dao.DVDLibraryDao;
import com.mycompany.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.mycompany.dvdlibrary.ui.DVDView;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;


/**
 *
 * @author shaharfin
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
    
}
