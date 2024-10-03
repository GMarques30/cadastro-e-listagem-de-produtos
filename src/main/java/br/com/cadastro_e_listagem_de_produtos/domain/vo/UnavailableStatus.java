package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

public class UnavailableStatus extends Status{
  public UnavailableStatus(Product product) {
    super(product);
    this.status = false;
  }

  @Override
  public void available() {
    this.product.status = new AvailableStatus(this.product);
  }

  @Override
  public void unavailable() {
    throw new RuntimeException("Invalid status");
  }
}
