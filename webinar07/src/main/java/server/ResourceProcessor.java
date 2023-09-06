package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResourceProcessor {

    private AuthorRepository authorRepository = new AuthorRepository();
    public String process(String method, String resource, String body) {

        String response = "";

        switch (method) {
            case "GET":
                response = doGet(resource);
                break;
            case "POST":
                response = doPost(resource, body);
                break;
            default:
                throw new UnsupportedOperationException();
        }

        return response;
    }

    private String doPost(String resource, String body) {
        String response = "";

        if("/author".equals(resource)) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Author author = mapper.readValue(body, Author.class);
                Author savedAuthor = authorRepository.create(author);
                String responseBody = mapper.writeValueAsString(savedAuthor);

                response = new StringBuilder()
                        .append("HTTP/1.1 200 OK").append("\n")
                        .append("Content-Type: application/json").append("\n")
                        .append("Content-Length: ").append(responseBody.length()).append("\n")
                        .append("\n")
                        .append(responseBody)
                        .toString();

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            response = notFoundResponse();
        }

        return response;
    }

    private String doGet(String resource) {
        String response = "";

        if ("/".equals(resource)) {
            String responseBody = "<html><body><h1>HELLO</h1></body></html>";
            response = new StringBuilder()
                    .append("HTTP/1.1 200 OK").append("\n")
                    .append("Content-Type: text/html").append("\n")
                    .append("Content-Length: ").append(responseBody.length()).append("\n")
                    .append("\n")
                    .append(responseBody)
                    .toString();
        } else {
            response = notFoundResponse();
        }

        return response;
    }

    private String notFoundResponse() {

        return new StringBuilder()
                .append("HTTP/1.1 400 NOT FOUND")
                .append("\n")
                .append("\n")
                .toString();
    }
}
