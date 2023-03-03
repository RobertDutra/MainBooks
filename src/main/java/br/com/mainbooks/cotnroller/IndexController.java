package br.com.mainbooks.cotnroller;

import br.com.mainbooks.models.Book;
import br.com.mainbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    BookService service;

    @GetMapping("/")
    public ModelAndView getList(){
        ModelAndView mv =  new ModelAndView("mainbooks");
        List<Book> bookList = this.service.books();
        mv.addObject("bookList", bookList);
        return mv;
    }
}
