package br.com.cadastro_e_listagem_de_produtos.domain.vo;

public class Name {
  private final String name;

  public Name(String name) {
    if(!name.matches("^[a-zA-Z]+$")) {
      throw new IllegalArgumentException("Invalid name");
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
