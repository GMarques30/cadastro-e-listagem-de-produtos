package br.com.cadastro_e_listagem_de_produtos.application.usecase;

import br.com.cadastro_e_listagem_de_produtos.application.dto.CreateProductInput;
import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.infra.repository.ProductRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreateProductTest {
  private CreateProduct sut;
  private ProductRepository productRepository;

  @BeforeEach
  public void beforeEach() {
    this.productRepository = new ProductRepositoryMemory();
    this.sut = new CreateProduct(productRepository);
  }

  @Test
  @DisplayName("Should be able to create product")
  public void should_be_able_to_create_product() {
    CreateProductInput input = new CreateProductInput("Sal", "Sal refinado cisne 1KG", BigDecimal.valueOf(3.89), true);
    this.sut.execute(input);
    var output = this.productRepository.listAll();
    assertNotNull(output.get(0).productId());
    assertEquals("Sal", output.get(0).name());
    assertEquals("Sal refinado cisne 1KG", output.get(0).description());
    assertEquals(BigDecimal.valueOf(3.89), output.get(0).price());
    assertEquals(true, output.get(0).status());
  }
}
