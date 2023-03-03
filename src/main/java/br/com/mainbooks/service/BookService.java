package br.com.mainbooks.service;

import br.com.mainbooks.interfaces.BookInterface;
import br.com.mainbooks.models.Book;
import br.com.mainbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements BookInterface {

    @Autowired
    BookRepository repository;


    @Override
    public Book save(Book book) {
        this.repository.save(book);
        return book;
    }

    @Override
    public List<Book> books() {
        return this.repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> book = this.repository.findById(id);
        if (book.isPresent()){
            return book.get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Book> book = this.repository.findById(id);
        if (book.isPresent()){
            this.repository.delete(book.get());
        }
    }
}
