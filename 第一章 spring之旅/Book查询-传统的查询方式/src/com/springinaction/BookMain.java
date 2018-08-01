package com.springinaction;

import java.sql.*;

public class BookMain {
    public static void main(String []args){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Book book = new Book();
        try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/graduate?serverTimezone=GMT&useSSL=true","root","root");
			statement = con.prepareStatement("SELECT * FROM BOOK WHERE author = ?");

			statement.setString(1,"施瓦辛格");
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				book.setId(resultSet.getLong("id"));
				book.setDescription(resultSet.getString("description"));
				book.setTitle(resultSet.getString("title"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setAuthor(resultSet.getString("author"));
				System.out.println(book);
			}
		}catch(Exception e){

			e.printStackTrace();

        	if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (statement != null){
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null){

				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		}

    }
}
