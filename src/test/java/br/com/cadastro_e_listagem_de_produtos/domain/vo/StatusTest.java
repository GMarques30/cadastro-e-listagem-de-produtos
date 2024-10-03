package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import br.com.cadastro_e_listagem_de_produtos.domain.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    @DisplayName("Should be able to create a available status")
    void should_be_able_to_create_a_available_status() {
      Product product = new Product("Example", "Example description", BigDecimal.valueOf(0.01), false);
      Status status = StatusFactory.create(product, true);
      assertInstanceOf(AvailableStatus.class, status);
    }

    @Test
    @DisplayName("Should be able to create a unavailable status")
    void should_be_able_to_create_a_unavailable_status() {
      Product product = new Product("Example", "Example description", BigDecimal.valueOf(0.01), false);
      Status status = StatusFactory.create(product, false);
      assertInstanceOf(UnavailableStatus.class, status);
    }

    @Test
    @DisplayName("Should not be able to create a invalid status")
    void should_not_be_able_to_create_a_invalid_status() {
      Product product = new Product("Example", "Example description", BigDecimal.valueOf(0.01), false);
      assertThrows(RuntimeException.class, () -> StatusFactory.create(product, null));
    }
}
