import axios from "axios";
import { useEffect, useState } from "react";
import "./ProductList.css";

interface Product {
  productId: string;
  name: string;
  description: string;
  price: number;
  status: boolean;
}

export const ProductList = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [newProduct, setNewProduct] = useState<{
    name: string;
    description: string;
    price: number | undefined;
    status: boolean;
  }>({
    name: "",
    description: "",
    price: undefined,
    status: true,
  });

  const fetchProducts = async () => {
    const response = await axios.get("http://localhost:8080/product");
    setProducts(response.data);
  };

  const handleAddProduct = async (event: React.FormEvent) => {
    event.preventDefault();

    await axios.post("http://localhost:8080/product/create", newProduct);
    fetchProducts();

    setNewProduct({
      name: "",
      description: "",
      price: undefined,
      status: true,
    });
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="container">
      <h1 className="title">Cadastro de produtos</h1>
      <form className="form-product" onSubmit={handleAddProduct}>
        <input
          type="text"
          placeholder="Nome do produto"
          value={newProduct.name}
          onChange={(e) =>
            setNewProduct({ ...newProduct, name: e.target.value })
          }
          required
        />
        <input
          type="text"
          placeholder="Descrição do produto"
          value={newProduct.description}
          onChange={(e) =>
            setNewProduct({ ...newProduct, description: e.target.value })
          }
          required
        />
        <input
          type="number"
          placeholder="Valor do produto"
          value={newProduct.price}
          onChange={(e) => {
            const value = e.target.value;
            if (value) {
              setNewProduct({ ...newProduct, price: Number(value) });
            } else {
              setNewProduct({ ...newProduct, price: undefined });
            }
          }}
          required
          step="0.01"
        />
        <div className="status-radio">
          Está disponível para venda?
          <label>
            <input
              type="radio"
              value="true"
              checked={newProduct.status === true}
              onChange={() => setNewProduct({ ...newProduct, status: true })}
            />
            Sim
          </label>
          <label>
            <input
              type="radio"
              value="false"
              checked={newProduct.status === false}
              onChange={() => setNewProduct({ ...newProduct, status: false })}
            />
            Não
          </label>
        </div>
        <input type="submit" value="Cadastrar" />
      </form>
      <table className="form-product">
        <thead>
          <tr>
            <th>Nome do produto</th>
            <th>Valor do produto</th>
          </tr>
        </thead>
        <tbody>
          {products.length > 0 ? (
            products.map((product) => (
              <tr key={product.productId}>
                <td>{product.name}</td>
                <td>{product.price.toFixed(2)}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan={2}>Não há produtos</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
