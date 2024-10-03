package br.com.cadastro_e_listagem_de_produtos.infra.http;

import br.com.cadastro_e_listagem_de_produtos.application.dto.CreateProductInput;
import br.com.cadastro_e_listagem_de_produtos.application.usecase.CreateProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final CreateProduct createProduct;

  public ProductController(CreateProduct createProduct) {
    this.createProduct = createProduct;
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody CreateProductInput input) {
    try {
      this.createProduct.execute(input);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }
  }

}
