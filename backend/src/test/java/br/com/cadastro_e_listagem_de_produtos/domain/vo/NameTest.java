package br.com.cadastro_e_listagem_de_produtos.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {
  @Test
  @DisplayName("Should be able to create a valid names")
  void should_be_able_to_create_a_valid_names() {
    assertDoesNotThrow(() -> new Name("Hello"));
    assertDoesNotThrow(() -> new Name("World"));
    assertDoesNotThrow(() -> new Name("abcXYZ"));
  }

  @Test
  @DisplayName("Should not be able to create a invalid names")
  void should_not_be_able_to_create_a_invalid_names() {
    assertThrows(IllegalArgumentException.class, () -> new Name("Hello123"));
    assertThrows(IllegalArgumentException.class, () -> new Name("Hello World!"));
    assertThrows(IllegalArgumentException.class, () -> new Name(""));
    assertThrows(IllegalArgumentException.class, () -> new Name("123"));
  }
}
