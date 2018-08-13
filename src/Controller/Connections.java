package Controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import model.Person;

import com.mysql.cj.xdevapi.Statement;


public class Connections {
	
		Connection connect = null;
		 Statement statement = null;
		 PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		public void readDB(Person person) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect =  DriverManager.getConnection("jdbc:mysql://localhost/DB?" + "user=user&password=password");

			// PreparedStatements can use variables and are more efficient
		//	Person person =new Person();
			preparedStatement =  connect
			      .prepareStatement("insert into  DB.Person values (?, ?, ?, ? );");
			// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.setString(3, person.getPassword());
			preparedStatement.setString(4, person.getPhonenumber());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		}
		
	}
}


