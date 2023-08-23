package serialization.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Author;
import dto.JsonBook;
import dto.XmlBook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonSerialization {

    public static void main(String[] args) throws IOException {
        Author pushkin = new Author("Александр", "Пушкин", 1799);
        Author lermontov = new Author("Михаил", "Лермонтов", 1815);
        List<Author> authors = new ArrayList<>();
        authors.add(pushkin);
        authors.add(lermontov);


        JsonBook book = new JsonBook("Неизвестное", authors);

        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(book);
        System.out.println(str);

        objectMapper.writeValue(new File("book.json"), book);
    }
}
