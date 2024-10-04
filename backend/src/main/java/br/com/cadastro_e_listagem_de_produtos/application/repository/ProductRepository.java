package br.com.cadastro_e_listagem_de_produtos.application.repository;

import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
  void save(Product product);
  List<ListAllProductsOutput> listAll();
}
