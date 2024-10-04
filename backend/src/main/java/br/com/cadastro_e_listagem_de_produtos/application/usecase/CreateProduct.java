package br.com.cadastro_e_listagem_de_produtos.application.usecase;

import br.com.cadastro_e_listagem_de_produtos.application.dto.CreateProductInput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProduct {
  private final ProductRepository productRepository;

  @Autowired
  public CreateProduct(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void execute(CreateProductInput input) {
    Product product = new Product(input.name(), input.description(), input.price(), input.status());
    this.productRepository.save(product);
  }
}
