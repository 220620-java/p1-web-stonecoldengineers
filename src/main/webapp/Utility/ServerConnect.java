package com.revature.berhanu.Utlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ServerConnect {
    
    public Connection connectToServer()
    {
        String dbURL ="jdbc:postgresql://postgressdbinstance1.c5a1xliscqxz.us-east-2.rds.amazonaws.com:5432/BankSystemDB";
        String UserName = "postgresAdmin";
        String Password = "PG1234567890.";

        try{
            Connection objConnection = DriverManager.getConnection(dbURL, UserName, Password);
            return objConnection;
        }
        catch(SQLException e)
        {
            throw new Error(e);
        }
         
    }
}
