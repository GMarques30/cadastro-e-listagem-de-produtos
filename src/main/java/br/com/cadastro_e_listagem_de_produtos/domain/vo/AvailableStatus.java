package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

public class AvailableStatus extends Status{

  public AvailableStatus(Product product) {
    super(product);
    this.status = true;
  }

  @Override
  public void available() {
    throw new RuntimeException("Invalid status");
  }

  @Override
  public void unavailable() {
    this.product.status = new UnavailableStatus(this.product);
  }


}
