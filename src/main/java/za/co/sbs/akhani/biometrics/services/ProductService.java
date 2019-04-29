package za.co.sbs.akhani.biometrics.services;


import za.co.sbs.akhani.biometrics.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
