package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

public abstract class Status {
  public Boolean status;
  public final Product product;

  public Status(Product product) {
    this.product = product;
  }

  public abstract void available();
  public abstract void unavailable();
}
