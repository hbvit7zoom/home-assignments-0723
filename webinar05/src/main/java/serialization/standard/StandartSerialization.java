package serialization.standard;

import dto.Author;
import dto.Book;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StandartSerialization {

//    public static void main(String[] args) throws IOException {
//        String hello = "HELLO";
//
//        OutputStream os = Files.newOutputStream(Paths.get("string.bin"));
//        ObjectOutputStream oos = new ObjectOutputStream(os);
//
//        oos.writeObject(hello);
//        oos.close();
//    }

    public static void main(String[] args) throws IOException {
        Author pushkin = new Author("Александр", "Пушкин", 1799);
        Book book = new Book("Евгений Онегин", pushkin);
//        book.edition = 1;

        OutputStream os = Files.newOutputStream(Paths.get("book.bin"));
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(book);
        oos.close();
    }

}
