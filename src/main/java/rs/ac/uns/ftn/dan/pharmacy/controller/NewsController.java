package rs.ac.uns.ftn.dan.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(name = "/news")
public class NewsController {

    public static final String NEWS_KEY = "news";

    private ServletContext servletContext;
    private String bURL;

//    @Autowired
//    private NewsService newsService;

    @GetMapping
    @ResponseBody
    public void index(HttpServletResponse response){
//        TODO
//          Current date VirusReport (if exists when loading page) shows on Top of News
//          List all news under

    }
    @PostMapping(name = "")
    public void postNews(@RequestParam String name, @RequestParam String content, HttpServletResponse response){

    }
    @PostMapping(name = "/reports")
    public void postVirusReport(@RequestParam int sick,
                                @RequestParam int tested,
                                @RequestParam int sickTotal,
                                @RequestParam int hospitalized,
                                @RequestParam int onRespirators, HttpServletResponse response){

    }
}
