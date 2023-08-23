package serialization.standard;

import dto.Book;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StandartDeserialization {

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        InputStream is = Files.newInputStream(Paths.get("string.bin"));
//        ObjectInputStream ois = new ObjectInputStream(is);
//
//        Object object = ois.readObject();
//        String str = (String) object;
//
//        System.out.println(str);
//    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream is = Files.newInputStream(Paths.get("book.bin"));
        ObjectInputStream ois = new ObjectInputStream(is);

        Object object = ois.readObject();
        Book book = (Book) object;

        System.out.println(book);
    }
}
