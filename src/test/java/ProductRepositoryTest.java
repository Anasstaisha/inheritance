import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product product1 = new Product(75, "Смартфон", 75_000);
    Product product2 = new Product(12, "Книга", 470);
    Product product3 = new Product(80, "Игрушка", 7_500);


    @Test
    public void shouldAdd() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductIfOne() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.removeById(product1.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    /*@Test
    public void shouldNotRemoveProductIfDidNotSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(product2);
        repo.removeById(product1.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }*/

}
