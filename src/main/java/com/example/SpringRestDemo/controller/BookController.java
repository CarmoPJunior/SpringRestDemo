package com.example.SpringRestDemo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.SpringRestDemo.exception.BookNotFoundException;
import com.example.SpringRestDemo.model.Book;
import com.example.SpringRestDemo.repository.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {
 
    @Autowired
    private BookRepository bookRepository;
    
    
    @RequestMapping("/")    
    public ModelAndView viewemp(Model m){  
    	
    	List<Book> bookList = (List<Book>) bookRepository.findAll();
        ModelAndView mav = new ModelAndView("book/list");
        mav.addObject("bookList", bookList);
        return mav;
        
    }    
    
    @RequestMapping("/newBook")
    public String newCustomerForm(Map<String, Object> model) {
    	
    	Book book = new Book();
        model.put("book", book);
        
        return "/book/newBook";
    }
    
    @RequestMapping(value = "book/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
    	
    	bookRepository.save(book);
        
        return "redirect:/book/";
    }
    
    @RequestMapping("/editBook")
    public ModelAndView editBookForm(@RequestParam long id) {
    	
        ModelAndView mav = new ModelAndView("book/editBook");
        Book book =  bookRepository.findById(id)
                			.orElseThrow(BookNotFoundException::new);
        mav.addObject("book", book);
     
        return mav;
    }
    
    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam long id) {
    	
    	 bookRepository.findById(id)
         				.orElseThrow(BookNotFoundException::new);
       
    	 bookRepository.deleteById(id);
       
    	 return "redirect:/book/";      
        
    }
    
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
    	
        List<Book> result = bookRepository.findByTitle(keyword);
        ModelAndView mav = new ModelAndView("book/listSearch");
        mav.addObject("result", result);
     
        return mav;    
    }
         
}