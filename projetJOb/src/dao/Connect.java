/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author king9
 */
    public class Connect {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBNAME = "ppe";
    private static final String URL = "jdbc:mysql://localhost/"+DBNAME;
    private static final String USER = "root";
    private static final String PASSWORD ="";
    private static Connect instance;
    

    private Connect() {
        try {
            Class.forName(DRIVER).newInstance();
            System.out.println("*** Driver loaded. ***");
        }
        catch (ClassNotFoundException e) {
            System.err.println("*** ERROR: Driver " + DRIVER + " non trouvé ***");
        }
        catch (InstantiationException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + "org.apache.derby.jdbc.ClientDriver");
            System.err.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + "org.apache.derby.jdbc.ClientDriver");
            System.err.println(e.getMessage());
        }
    }
// 
    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    
    public Connection getConnection() throws SQLException {
        Connection cnx = DriverManager.getConnection(URL, USER, PASSWORD);
        return cnx;
    }

    public void close(final Connection cnx) {
        if (cnx != null) {
            try {
                cnx.close();
            }
            catch (SQLException e) {
                // très rare a priori donc pas de throws
                System.err.println("Impossible to close connection");
                System.err.println(e.getMessage());
            }
        }
    }

   
    
}
