package br.com.cadastro_e_listagem_de_produtos.domain.entity;

import br.com.cadastro_e_listagem_de_produtos.domain.vo.Name;
import br.com.cadastro_e_listagem_de_produtos.domain.vo.Status;
import br.com.cadastro_e_listagem_de_produtos.domain.vo.StatusFactory;
import br.com.cadastro_e_listagem_de_produtos.domain.vo.Price;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
  public final String productId;
  private final Name name;
  public String description;
  private final Price price;
  public Status status;

  public Product(String name, String description, BigDecimal price, Boolean status) {
    this.productId = UUID.randomUUID().toString();
    this.name = new Name(name);
    this.description = description;
    this.price = new Price(price);
    this.status = StatusFactory.create(this, status);
  }

  public Product(String productId, String name, String description, BigDecimal price, Boolean status) {
    this.productId = productId;
    this.name = new Name(name);
    this.description = description;
    this.price = new Price(price);
    this.status = StatusFactory.create(this, status);
  }

  public String getName() {
    return this.name.getName();
  }
  
  public BigDecimal getPrice() {
    return this.price.getValue();
  }

  public Boolean getStatus() {
    return this.status.status;
  }

  public void available() {
    this.status.available();
  }

  public void unavailable() {
    this.status.unavailable();
  }
}
