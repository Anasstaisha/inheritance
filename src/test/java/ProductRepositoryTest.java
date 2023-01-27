import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product product1 = new Product(75, "Кукла", 3_000);
    Product product2 = new Product(12, "Книга", 470);
    Smartphone smartphone1 = new Smartphone(25, "IPhone", 25_200, "Apple");


    @Test
    public void shouldAdd() {
        ProductRepository repo = new ProductRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(smartphone1);

        Product[] expected = {product1, product2, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(smartphone1);
        repo.removeById(smartphone1.getId());

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldZeroIfRemoveAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(smartphone1);
        repo.removeById(product1.getId());
        repo.removeById(product2.getId());
        repo.removeById(smartphone1.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductIfOne() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.removeById(product1.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    /*@Test
    public void shouldNotRemoveProductIfDidNotAdd() {
        ProductRepository repo = new ProductRepository();
       repo.add(product2);
        repo.removeById(product1.getId());

        Product[] expected = {null};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }*/

}
