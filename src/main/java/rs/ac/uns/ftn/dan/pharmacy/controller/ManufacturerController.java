package rs.ac.uns.ftn.dan.pharmacy.controller;
//
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.parser.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.*;
//import rs.ac.uns.ftn.dan.pharmacy.model.entity.Manufacturer;
//import rs.ac.uns.ftn.dan.pharmacy.service.ManufacturerService;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URISyntaxException;
//
@Controller
@RequestMapping(value="/manufacturers")
public class ManufacturerController {
//    public static final String MANUFACTURERS_KEY = "manufacturers";
//
//    @Autowired
//    private ManufacturerService manufacturerService;
//
//    @Autowired
//    private ServletContext servletContext;
//    private  String bURL;
//
////    @Autowired
////    private ApplicationContext applicationContext;
//
////    @Autowired
////    private SecondConfiguration.ApplicationMemory appMemory;
//
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        this.applicationContext = applicationContext;
////    }
//
//    @SuppressWarnings("unchecked")
//    @PostConstruct
//    public void init() {
//        bURL = servletContext.getContextPath() + "/";
//    }
//
//    @GetMapping
//    @ResponseBody
//    public void getManufacturers(HttpServletResponse response) throws IOException {
//
//        PrintWriter out = response.getWriter();
//
//        File htmlFile = new ClassPathResource("static/template.html").getFile();
//        Document doc = Jsoup.parse(htmlFile, "UTF-8");
//        Element body = doc.select("body").first();
//
////      HEADER
//
//        Element ulTag = new Element(Tag.valueOf("ul"), "");
//
//        Element liTagRegister = new Element(Tag.valueOf("li"), "");
//        Element aTagRegister = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/users/register").text("Register");
//        liTagRegister.appendChild(aTagRegister);
//        ulTag.appendChild(liTagRegister);
//
//        Element liTagManufacturers = new Element(Tag.valueOf("li"), "");
//        Element aTagManufacturers = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/manufacturers").text("Manufacturers");
//        liTagManufacturers.appendChild(aTagManufacturers);
//        ulTag.appendChild(liTagManufacturers);
//
//        Element liTagAddManufacturers = new Element(Tag.valueOf("li"), "");
//        Element aTagAddManufacturers = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/manufacturers/add").text("Add manufacturer");
//        liTagAddManufacturers.appendChild(aTagAddManufacturers);
//        ulTag.appendChild(liTagAddManufacturers);
//
//        body.appendChild(ulTag);
//
////      ALL MANUFACTURERS LIST
//        Element listh2 = new Element(Tag.valueOf("h2"), "").text("ALL MANUFACTURERS");
//        body.appendChild(listh2);
//
//        for (Manufacturer m : manufacturerService.findAll()) {
//            Element div = new Element(Tag.valueOf("div"), "").text(m.getCode() + " - " + m.getCountry() + " - ");
//            Element aLink = new Element(Tag.valueOf("a"), "").attr("href", "manufacturers/details?code=" + m.getCode()).text(m.getName());
//
//            div.appendChild(aLink);
//            body.appendChild(div);
//        }
//
//
//        out.write(doc.html());
//        return;
//    }
//
//    @GetMapping(value="/add")
//    @ResponseBody
//    public void create(HttpServletResponse response) throws IOException{
//
//        PrintWriter out = response.getWriter();
//
//        File htmlFile = new ClassPathResource("static/template.html").getFile();
//        Document doc = Jsoup.parse(htmlFile, "UTF-8");
////
//        Element body = doc.select("body").first();
//
////      HEADER
//
//        Element ulTag = new Element(Tag.valueOf("ul"), "");
//
//        Element liTagManufacturers = new Element(Tag.valueOf("li"), "");
//        Element aTagManufacturers = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/manufacturers").text("Manufacturers");
//        liTagManufacturers.appendChild(aTagManufacturers);
//        ulTag.appendChild(liTagManufacturers);
//
//        body.appendChild(ulTag);
//
////      ADD FORM:
//
//        Element formh2 = new Element(Tag.valueOf("h2"), "").text("ADD NEW MANUFACTURER:");
//
//        Element form = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "add");
//        Element inputCode = new Element(Tag.valueOf("input"), "").attr("type", "number").attr("name", "code").attr("min", "100").attr("minLength", "3").attr("placeholder", "Code ID (min 3)").attr("required", "true");
//        Element inputName = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "name").attr("placeholder", "Name").attr("required", "true");
//        Element inputCountry = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "country").attr("maxLength", "3").attr("minLength", "3").attr("placeholder", "Country (3 char)").attr("required", "true").attr("regex", "[a-Z]");
//
//        Element inputSubmit = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Add New");
//
//        form.appendChild(inputCode);
//        form.appendChild(inputName);
//        form.appendChild(inputCountry);
//        form.appendChild(inputSubmit);
//
//        body.appendChild(formh2);
//        body.appendChild(form);
//
//        out.write(doc.html());
//        return;
//    }
//
//    @PostMapping(value="/add")
//    public void create(@RequestParam Long code, @RequestParam String name,
//                       @RequestParam String country, HttpServletResponse response) throws IOException {
//
//        manufacturerService.save(new Manufacturer(code, name, country.toUpperCase()));
//
//        response.sendRedirect(bURL + "manufacturers");
//    }
//
//    @PostMapping(value="/edit")
//    public void edit(@ModelAttribute Manufacturer manufacturerEdited , HttpServletResponse response) throws IOException, URISyntaxException {
//
//        manufacturerService.edit(manufacturerEdited);
//
//        response.sendRedirect(bURL + "manufacturers");
//    }
//
//    @PostMapping(value="/delete")
//    public void delete(@RequestParam Long code, HttpServletResponse response) throws IOException, URISyntaxException {
//
//        manufacturerService.delete(code);
//
//        response.sendRedirect(bURL + "manufacturers");
//    }
//
//    @GetMapping(value="/details")
//    @ResponseBody
//    public void details(@RequestParam Long code, HttpServletResponse response) throws IOException {
//
//        Manufacturer foundManufacturer = manufacturerService.findOne(code);
//        System.out.println(foundManufacturer);
//
//        PrintWriter out = response.getWriter();
//
//        File htmlFile = new ClassPathResource("static/template.html").getFile();
//        Document doc = Jsoup.parse(htmlFile, "UTF-8");
////
//        Element body = doc.select("body").first();
//
////      HEADER
//        Element ulTag = new Element(Tag.valueOf("ul"), "");
//        Element liTagManufacturers = new Element(Tag.valueOf("li"), "");
//        Element aTagManufacturers = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/manufacturers").text("Manufacturers");
//        liTagManufacturers.appendChild(aTagManufacturers);
//        ulTag.appendChild(liTagManufacturers);
//
//        body.appendChild(ulTag);
//
//
////      MANUFACTURER OVERVIEW
//        Element detailsH2 = new Element(Tag.valueOf("h2"), "").text("DETAILS");
//        Element detailsDiv = new Element(Tag.valueOf("div"), "").text(foundManufacturer.getCode() + " " + foundManufacturer.getCountry() + " " + foundManufacturer.getName());
//        body.appendChild(detailsH2);
//        body.appendChild(detailsDiv);
//
//
////         EDIT FORM
//        Element editH2 = new Element(Tag.valueOf("h2"), "").text("EDIT");
//        Element formEdit = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "edit");
//        Element inputCode = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "code").attr("min", "1").attr("value", String.valueOf(foundManufacturer.getCode())).attr("required", "true");
//        Element inputName = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "name").attr("placeholder", "Name").attr("required", "true");
//        Element inputCountry = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "country").attr("maxLength", "3").attr("minLength", "3").attr("placeholder", "Country").attr("required", "true").attr("regex", "[a-z]");
//
//        Element inputSubmit = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Save changes");
//
//        formEdit.appendChild(inputCode);
//        formEdit.appendChild(inputName);
//        formEdit.appendChild(inputCountry);
//        formEdit.appendChild(inputSubmit);
//
//        body.appendChild(editH2);
//        body.appendChild(formEdit);
//
//
//
////         DELETE FORM
//        Element deleteH2 = new Element(Tag.valueOf("h2"), "").text("DELETE");
//        Element formDel = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "delete");
//        Element inputCodeForDel = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "code").attr("value", String.valueOf(foundManufacturer.getCode())).attr("required", "true");
////        Element inputName = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "name");
////        Element inputCountry = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "country").attr("maxLength", "3").attr("minLength", "3");
////
//        Element deleteSubmit = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Delete");
//
//        formDel.appendChild(inputCodeForDel);
//        formDel.appendChild(deleteSubmit);
//
//        body.appendChild(deleteH2);
//        body.appendChild(formDel);
//
//        out.write(doc.html());
//        return;
//    }
}
