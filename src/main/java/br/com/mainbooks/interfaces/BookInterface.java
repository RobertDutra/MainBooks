package br.com.mainbooks.interfaces;

import br.com.mainbooks.models.Book;

import java.util.List;

public interface BookInterface {

    Book save(Book book);

    List<Book> books();

    Book findById(Long id);

    void delete(Long id);
}
