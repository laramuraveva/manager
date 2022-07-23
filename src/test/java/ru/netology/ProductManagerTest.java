package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.Product;
import ru.netology.ProductRepo;
import ru.netology.Book;
import ru.netology.Smartphone;
import ru.netology.ProductManager;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1,"Book Name1", 100, "Slava");
    Book book2 = new Book(2,"Journal Name2", 200, "Kolya");
    Book book3 = new Book(3,"Book Name3", 300, "Pasha");

    @Test
    public void addAllBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindAuthor() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Grisha");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findOneAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Slava");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNameBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Book");
        Product[] expected = { book1, book3 };

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findOneNameBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Journal");
        Product[] expected = { book2 };

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Kniga");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindId() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("4");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findId() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("2");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindPrice() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("400");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }


}




