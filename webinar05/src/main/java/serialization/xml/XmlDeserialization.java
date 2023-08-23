package serialization.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dto.XmlBook;
import java.io.File;
import java.io.IOException;

public class XmlDeserialization {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        XmlBook xmlBook = xmlMapper.readValue(new File("book.xml"), XmlBook.class);

        System.out.println(xmlBook);
    }

}
