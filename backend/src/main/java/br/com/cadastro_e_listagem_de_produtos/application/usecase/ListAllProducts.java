package br.com.cadastro_e_listagem_de_produtos.application.usecase;

import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllProducts {
  private final ProductRepository productRepository;

  @Autowired
  public ListAllProducts(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ListAllProductsOutput> execute() {
    return this.productRepository.listAll();
  }
}
