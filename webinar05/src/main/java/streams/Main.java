package streams;

import dto.Author;
import dto.XmlBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Author author1 = new Author("Name1", "Last1", 1950);
        Author author2 = new Author("Name2", "Last2", 1960);
        Author author3 = new Author("Name1", "Last3", 1970);

        XmlBook book1 = new XmlBook("Book1", List.of(author1, author2));
        XmlBook book2 = new XmlBook("Book2", List.of(author2, author3));
        XmlBook book3 = new XmlBook("Book3", List.of(author3));

        List<XmlBook> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        List<Author> collect = books.stream()
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
                .collect(Collectors.toList());

        for (Author author : collect) {
            System.out.println(author);
        }

        long count = books.stream()
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
//                .filter(new Predicate<Author>() {
//                    @Override
//                    public boolean test(Author author) {
//                        return author.getYearOfBirth() < 1960;
//                    }
//                })
                .filter(author -> author.getYearOfBirth() < 1960)
                .count();
        System.out.println(count);

        List<String> names = books.stream()
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
                .map(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getFirstName();
                    }
                })
                .collect(Collectors.toList());

        for (String name : names) {
            System.out.println(name);
        }


        books.stream()
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
                .map(author -> author.getFirstName())
                .forEach(System.out::println);

        books.stream()
                .peek(System.out::println)
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
                .map(author -> author.getFirstName())
                .forEach(System.out::println);

        Stream<String> stringStream = books.stream()
                .peek(System.out::println)
                .flatMap(book -> book.getAuthor().stream())
                .distinct()
                .map(author -> author.getFirstName());

        System.out.println("======");
        XmlBook xmlBook = new XmlBook();
        books.add(xmlBook);
        xmlBook.setAuthor(List.of(new Author("X", "X", 2000)));
        System.out.println(xmlBook);
        System.out.println("======");

        stringStream.forEach(System.out::println);

        Map<String, Author> collect1 = List.of(author1, author2, author3).stream()
                .collect(Collectors.toMap(item -> item.getLastName(), item -> item));

        System.out.println(collect1);

        Map<String, Author> collect2 = List.of(author1, author2, author3).stream()
                .collect(Collectors.toMap(item -> item.getFirstName(), item -> item, (item1, item2) -> item1));

        System.out.println(collect2);
    }

}
