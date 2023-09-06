package server;

import java.util.HashMap;
import java.util.Map;

public class AuthorRepository {

    private Map<Integer, Author> map = new HashMap<>();

    public Author create(Author author) {
        int id = map.size() + 1;
        author.setId(id);

        map.put(id, author);
        return author;
    }
}
