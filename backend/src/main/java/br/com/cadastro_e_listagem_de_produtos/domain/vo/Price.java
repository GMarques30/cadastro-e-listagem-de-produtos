package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import java.math.BigDecimal;

public class Price {
  private final BigDecimal price;

  public Price(BigDecimal price) {
    if(price.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    this.price = price;
  }

  public BigDecimal getValue() {
    return this.price;
  }
}
