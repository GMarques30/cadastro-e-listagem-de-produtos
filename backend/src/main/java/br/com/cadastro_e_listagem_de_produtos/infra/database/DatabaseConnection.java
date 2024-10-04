package br.com.cadastro_e_listagem_de_produtos.infra.database;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DatabaseConnection {
  ResultSet query(String statement);
  ResultSet query(String statement,  Object[] params);
  void command(String statement, Object[] params);
  void close();
}
