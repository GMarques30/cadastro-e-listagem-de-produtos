package br.com.cadastro_e_listagem_de_produtos.infra.repository;

import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;
import br.com.cadastro_e_listagem_de_produtos.infra.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryDatabase implements ProductRepository {
  private final DatabaseConnection connection;

  @Autowired
  public ProductRepositoryDatabase(DatabaseConnection connection) {
    this.connection = connection;
  }

  @Override
  public void save(Product product) {
    String stmt = "INSERT INTO app.products (product_id, name, description, price, status) VALUES (?, ?, ?, ?, ?)";
    System.out.println(product.productId);
    this.connection.command(stmt, new Object[]{product.productId, product.getName(), product.description, product.getPrice(), product.getStatus()});
  }

  @Override
  public List<ListAllProductsOutput> listAll() {
    List<ListAllProductsOutput> products = new ArrayList<>();
    String stmt = "SELECT * FROM app.products ORDER BY price ASC";
    ResultSet rs = this.connection.query(stmt);
    try {
      while (rs.next()) {
        ListAllProductsOutput product = new ListAllProductsOutput(rs.getString("product_id"), rs.getString("name"), rs.getString("description"), rs.getBigDecimal("price"), rs.getBoolean("status"));
        products.add(product);
      }
      return products;
    } catch (SQLException err) {
      throw new RuntimeException("Error executing the query", err);
    }
  }
}
