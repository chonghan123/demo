package com.example.demo.invoke;

/**
 * @author hc
 * @classname Book
 * @description TODO
 * @date 2020/5/11
 */
public class Book {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 0 !";
                break;
            case 1:
                string = "I am declaredMethod 1 !";
                break;
            default:
                string = "I am declaredMethod 2 !";
        }

        return string;
    }
}
