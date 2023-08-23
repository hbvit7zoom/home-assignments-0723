package serialization.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.JsonBook;
import java.io.File;
import java.io.IOException;

public class JsonDeserialization {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonBook jsonBook = mapper.readValue(new File("book.json"), JsonBook.class);

        System.out.println(jsonBook);
    }
}
