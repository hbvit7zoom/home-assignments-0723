package serialization.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dto.Author;
import dto.Book;
import dto.XmlBook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlSerialization {


//    public static void main(String[] args) throws IOException {
//        Author pushkin = new Author("Александр", "Пушкин", 1799);
//        Book book = new Book("Евгений Онегин", pushkin);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        String s = xmlMapper.writeValueAsString(book);
//        System.out.println(s);
//
//        xmlMapper.writeValue(new File("book.xml"), book);
//    }

    public static void main(String[] args) throws IOException {
        Author pushkin = new Author("Александр", "Пушкин", 1799);
        Author lermontov = new Author("Михаил", "Лермонтов", 1815);
        List<Author> authors = new ArrayList<>();
        authors.add(pushkin);
        authors.add(lermontov);


        XmlBook book = new XmlBook("Неизвестное", authors);

        XmlMapper xmlMapper = new XmlMapper();
        String s = xmlMapper.writeValueAsString(book);
        System.out.println(s);

        xmlMapper.writeValue(new File("book.xml"), book);
    }

}
