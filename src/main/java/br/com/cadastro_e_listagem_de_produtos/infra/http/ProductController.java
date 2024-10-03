package br.com.cadastro_e_listagem_de_produtos.infra.http;

import br.com.cadastro_e_listagem_de_produtos.application.dto.CreateProductInput;
import br.com.cadastro_e_listagem_de_produtos.application.dto.ListAllProductsOutput;
import br.com.cadastro_e_listagem_de_produtos.application.usecase.CreateProduct;
import br.com.cadastro_e_listagem_de_produtos.application.usecase.ListAllProducts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final CreateProduct createProduct;
  private final ListAllProducts listAllProducts;

  public ProductController(CreateProduct createProduct, ListAllProducts listAllProducts) {
    this.createProduct = createProduct;
    this.listAllProducts = listAllProducts;
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

  @GetMapping
  public ResponseEntity<List<ListAllProductsOutput>> listAll() {
    try {
      List<ListAllProductsOutput> output = this.listAllProducts.execute();
      return ResponseEntity.ok(output);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }
  }
}
