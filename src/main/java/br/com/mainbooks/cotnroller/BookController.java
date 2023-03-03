package br.com.mainbooks.cotnroller;

import br.com.mainbooks.models.Book;
import br.com.mainbooks.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios!");
            return "redirect:/book/form/add";
        }
        this.service.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd(){
        ModelAndView mv = new ModelAndView("/book");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("/book");
        Book book = this.service.findById(id);
        mv.addObject("book", book);
        return mv;

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        this.service.delete(id);
        return "redirect:/";
    }
}
