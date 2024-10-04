package br.com.cadastro_e_listagem_de_produtos.application.usecase;

import br.com.cadastro_e_listagem_de_produtos.application.dto.CreateProductInput;
import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.infra.repository.ProductRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ListAllProductsTest {

  private ListAllProducts sut;
  private CreateProduct createProduct;
  private ProductRepository productRepository;

  @BeforeEach
  public void beforeEach() {
    this.productRepository = new ProductRepositoryMemory();
    this.createProduct = new CreateProduct(productRepository);
    this.sut = new ListAllProducts(productRepository);
  }
  @Test
  @DisplayName("Should be able to list all products")
  public void should_be_able_to_list_all_products() {
    CreateProductInput createProductInput = new CreateProductInput("Sal", "Sal fino", new BigDecimal("2.99"), true);
    CreateProductInput createProductInput2 = new CreateProductInput("Sal", "Sal grosso", new BigDecimal("5.99"), true);
    this.createProduct.execute(createProductInput);
    this.createProduct.execute(createProductInput2);
    List<ListAllProductsOutput> output = this.sut.execute();
    assertNotNull(output);
    assertEquals(2, output.size());
    ListAllProductsOutput product1 = output.get(0);
    assertEquals("Sal", product1.name());
    assertEquals("Sal fino", product1.description());
    assertEquals(new BigDecimal("2.99"), product1.price());
    assertTrue(product1.status());
    ListAllProductsOutput product2 = output.get(1);
    assertEquals("Sal", product2.name());
    assertEquals("Sal grosso", product2.description());
    assertEquals(new BigDecimal("5.99"), product2.price());
    assertTrue(product2.status());
  }
}
