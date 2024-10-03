package br.com.cadastro_e_listagem_de_produtos.application.dto;

import java.math.BigDecimal;

public record ListAllProductsOutput(String productId, String name, String description, BigDecimal price, Boolean status) {
}
