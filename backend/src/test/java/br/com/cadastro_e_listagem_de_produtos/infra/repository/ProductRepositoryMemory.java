package br.com.cadastro_e_listagem_de_produtos.infra.repository;

import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryMemory implements ProductRepository {
  private final List<Product> products;

  public ProductRepositoryMemory() {
    this.products = new ArrayList<>();
  }

  @Override
  public void save(Product product) {
    this.products.add(product);
  }

  @Override
  public List<ListAllProductsOutput> listAll() {
    List<ListAllProductsOutput> output = new ArrayList<>();
    for(Product product : this.products) {
      output.add(new ListAllProductsOutput(product.productId, product.getName(), product.description, product.getPrice(), product.getStatus()));
    }
    return output;
  }
}
