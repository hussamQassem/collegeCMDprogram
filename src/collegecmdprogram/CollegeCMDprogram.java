/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collegecmdprogram;

import java.sql.SQLException;

/**
 *
 * @author hussa
 */
public class CollegeCMDprogram {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        // gethub link: https://github.com/hussamQassem/collegeCMDprogram/tree/main/src/collegecmdprogram
        
        /*
        when the programe start it will ask for the admin username and password
        then the admin menu will display
        as start we should create users office or lecturer as when the program start the array of users will be empty
        then when creating users press exit to go back to main log in then they can put login credentials and the other functions of the programe will run
        Note: we creating users in the begining is importand as if there is no users the program will display error that user not exist and won't let other menus to be displaied.

        */
        Menu m = new Menu();
        m.display();
    }

}
