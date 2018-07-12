package com.springinaction;

import java.sql.*;

public class BookMain {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Book book = null;
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate","root","root");
        	statement = connection.prepareStatement
        					("SELECT * FROM book");
        	resultSet = statement.executeQuery();
        	while(resultSet.next()){

        	}
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(resultSet != null){

        	}
        	if(statement != null){

        	}
        	if (connection != null) {
        		
        	}
        }
    }
}
