package br.com.cadastro_e_listagem_de_produtos.infra.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PostgresAdapter implements DatabaseConnection {
  private Connection connection;
  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String username;
  @Value("${spring.datasource.password}")
  private String password;

  @PostConstruct
  public void init() {
    try {
      this.connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException err) {
      throw new RuntimeException("Error connecting to the database", err);
    }
  }

  @Override
  public ResultSet query(String statement) {
    try {
      return this.connection.createStatement().executeQuery(statement);
    } catch (SQLException err) {
      throw new RuntimeException(err.getMessage());
    }
  }

  @Override
  public ResultSet query(String statement, Object[] params) {
    try {
      PreparedStatement ps = this.connection.prepareStatement(statement);
      for (int i = 0; i < params.length; i++) {
        ps.setObject(i + 1, params[i]);
      }
      return ps.executeQuery();
    } catch (SQLException err) {
      throw new RuntimeException(err.getMessage());
    }
  }

  @Override
  public void command(String statement, Object[] params) {
    try {
      PreparedStatement ps = this.connection.prepareStatement(statement);
      for (int i = 0; i < params.length; i++) {
        ps.setObject(i + 1, params[i]);
      }
      ps.execute();
    } catch (SQLException err) {
      throw new RuntimeException(err.getMessage());
    }
  }

  @PreDestroy
  public void close() {
    try {
      if (this.connection != null && !this.connection.isClosed()) {
        this.connection.close();
      }
    } catch (SQLException err) {
      throw new RuntimeException("Error closing connection", err);
    }
  }
}
