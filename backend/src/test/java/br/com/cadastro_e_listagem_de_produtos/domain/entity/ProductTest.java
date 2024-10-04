package br.com.cadastro_e_listagem_de_produtos.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

  @Test
  @DisplayName("Should be able to create a product")
  public void should_be_able_to_create_product() {
    Product product = new Product("Sal", "Sal refinado cisne 1KG", BigDecimal.valueOf(3.89), true);
    assertNotNull(product.productId);
    assertEquals("Sal", product.getName());
    assertEquals("Sal refinado cisne 1KG", product.description);
    assertEquals(BigDecimal.valueOf(3.89), product.getPrice());
    assertEquals(true, product.getStatus());
  }
}
