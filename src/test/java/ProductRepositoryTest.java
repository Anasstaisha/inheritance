import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product product1 = new Product(75, "Смартфон", 75_000);
    Product product2 = new Product(12, "Книга", 470);
    Product product3 = new Product(80, "Конструктор", 7_500);


    @Test
    public void getProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product2.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchProduct() {
        ProductManager repo = new ProductManager();
        repo.searchBy(String.valueOf(product1));
        repo.searchBy(String.valueOf(product2));
        repo.searchBy(String.valueOf(product3));

        Product[] expected = {product2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }
}
