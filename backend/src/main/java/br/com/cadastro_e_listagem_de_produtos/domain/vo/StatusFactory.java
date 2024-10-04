package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

public class StatusFactory {
  public static Status create(Product product, Boolean status) {
    if(!status) return new UnavailableStatus(product);
    if(status) return new AvailableStatus(product);
    throw new RuntimeException("Invalid status");
  }
}
