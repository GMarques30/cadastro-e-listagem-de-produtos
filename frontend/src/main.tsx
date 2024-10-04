import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { ProductList } from "./components/ProductList";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <ProductList />
  </StrictMode>
);
