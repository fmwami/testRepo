package models;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by faima on 1/18/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@TableGenerator(name = "Books")
public class Books {
    @Id
    @GeneratedValue
    private String bookId;
    private int bookNumber;
    private String bookName;
    private String description;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


