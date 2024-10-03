package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {
  @Test
  @DisplayName("Should be able to create a valid values")
  void should_be_able_to_create_a_valid_values() {
    assertDoesNotThrow(() -> new Price(BigDecimal.valueOf(0.00)));
    assertDoesNotThrow(() -> new Price(BigDecimal.valueOf(10.00)));
    assertDoesNotThrow(() -> new Price(BigDecimal.valueOf(100.50)));
  }

  @Test
  @DisplayName("Should not be able to create an invalid values")
   void should_not_be_able_to_create_an_invalid_values() {
    assertThrows(IllegalArgumentException.class, () -> new Price(BigDecimal.valueOf(-1.00)));
    assertThrows(IllegalArgumentException.class, () -> new Price(BigDecimal.valueOf(-0.01)));
  }
}
