package dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "book")
public class XmlBook implements Serializable {

    private static final long serialVersionUID = 2L;
//    @JacksonXmlProperty(localName = "name")
    @JacksonXmlProperty(isAttribute = true)
    private String title;
//    @JacksonXmlElementWrapper(localName = "authors")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Author> author;

    public int edition;

    public XmlBook() {
    }

    public XmlBook(String title, List<Author> author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
