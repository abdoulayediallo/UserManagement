package com.iepsevere.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class UsersDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/users";
    private String jdbcUsername = "webservice";
    private String jdbcPassword = "webservice";
    private Connection jdbcConnection;

    public UsersDAO(){}
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

       public String getRole(String login) throws SQLException {
        String sql = "SELECT role FROM user WHERE login = ?";
        String role = "";
        String message = "";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, login);
         
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
        	role = resultSet.getString("role");
        	message = role;
        }else{
        	message = "Erreur ! Veuillez verifier l'utilisateur";
        }
        
        resultSet.close();
        statement.close();
         
        return message;
    }

}
