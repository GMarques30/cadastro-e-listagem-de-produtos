package br.com.cadastro_e_listagem_de_produtos;

import br.com.cadastro_e_listagem_de_produtos.application.repository.ProductRepository;
import br.com.cadastro_e_listagem_de_produtos.application.usecase.CreateProduct;
import br.com.cadastro_e_listagem_de_produtos.infra.database.DatabaseConnection;
import br.com.cadastro_e_listagem_de_produtos.infra.database.PostgresAdapter;
import br.com.cadastro_e_listagem_de_produtos.infra.http.ProductController;
import br.com.cadastro_e_listagem_de_produtos.infra.repository.ProductRepositoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CadastroEListagemDeProdutosApplication {

	public static void main(String[] args) {

		SpringApplication.run(CadastroEListagemDeProdutosApplication.class, args);
	}
}
