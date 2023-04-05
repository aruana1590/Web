package kz.aruana15.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/Web";
		String username = "postgres";
		String password = "475752";
		System.out.println("Connecting...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connection successful!");
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

		SpringApplication.run(WebApplication.class, args);
	}

}
