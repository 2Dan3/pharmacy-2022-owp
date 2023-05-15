package rs.ac.uns.ftn.dan.pharmacy.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.dan.pharmacy.model.dto.CreateNewsDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.dto.CreateVirusReportDTO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    public static final String NEWS_KEY = "news";

    @Autowired
    private ServletContext servletContext;
    private String bURL;

//    @Autowired
//    private NewsService newsService;

    @GetMapping
    @ResponseBody
    public void index(HttpServletResponse response) throws IOException {
        Document doc = Jsoup.parse(new ClassPathResource("static/index.html").getFile(), "UTF-8");
//        TODO
//          Current date VirusReport (if exists when loading page) shows on Top of News
//          List all news under
//          Header login/logout button, depending on Logged User in session
//          Post virus Report/News if Admin is Logged
//        ...



//        ...
        response.getWriter().write(doc.html());
        return;

    }
    @PostMapping(value = "/publish")
    public void postNews(@RequestBody CreateNewsDTO newsDTO, HttpServletResponse response){

    }
    @PostMapping(value = "/report")
    public void postVirusReport(@RequestBody CreateVirusReportDTO virusReportDTO, HttpServletResponse response){

    }
}
