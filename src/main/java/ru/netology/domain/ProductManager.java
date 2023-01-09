package ru.netology.domain;

import ru.netology.repository.ProductRepository;


public class ProductManager {

    private ProductRepository repo;
    private static Product[] items = new Product[0];

    public Product[] getItems() {
        return items;
    }

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : ProductRepository.findAll()) {
            if (matches(product, text)) {
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
