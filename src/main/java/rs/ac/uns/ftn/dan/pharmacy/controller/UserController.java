package rs.ac.uns.ftn.dan.pharmacy.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.dan.pharmacy.bean.SecondConfiguration;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import rs.ac.uns.ftn.dan.pharmacy.model.CreateUserDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.User;
import rs.ac.uns.ftn.dan.pharmacy.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    public static final String USERS_KEY = "users";

    @Autowired
    UserService userService;

    @Autowired
    private ServletContext servletContext;
    private String bURL;

//    @Autowired
//    private ApplicationContext applicationContext;

//    @Autowired
//    private SecondConfiguration.ApplicationMemory appMemory;

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }

    @PostConstruct
    public void init() {
        bURL = servletContext.getContextPath()+"/";
    }

//    @GetMapping
//    @ResponseBody
//    public void index(HttpServletResponse response) throws IOException {
//
//        Users users = (Users) appMemory.get(UserController.USERS_KEY);
//
//        PrintWriter out;
//        out = response.getWriter();
//        File htmlFile = new ClassPathResource("static/template.html").getFile();
//        Document doc = Jsoup.parse(htmlFile, "UTF-8");
//
//        Element body = doc.select("body").first();
//
//        Element ulTag = new Element(Tag.valueOf("ul"), "");
//        Element liTagUsers = new Element(Tag.valueOf("li"), "");
////        Element liTagSomething = new Element(Tag.valueOf("li"), "");
//        Element aTagUsers = new Element(Tag.valueOf("a"), "").attr("href", "users").text("Users");
////        Element aTagSomething = new Element(Tag.valueOf("a"), "").attr("href", "clanskeKarte").text("Clanske karte");
//        liTagUsers.appendChild(aTagUsers);
////        liTagSomething.appendChild(liTagSomething);
//        ulTag.appendChild(liTagUsers);
////        ulTag.appendChild(liTagSomething);
//
//        Element table = new Element(Tag.valueOf("table"), "");
//        Element caption = new Element(Tag.valueOf("caption"), "").text("Users");
//        Element trHeader = new Element(Tag.valueOf("tr"), "");
////        Element thRedniBroj = new Element(Tag.valueOf("th"), "").text("R. br.");
////        Element thDetails = new Element(Tag.valueOf("th"), "").text("Details");
////        Element thNaziv = new Element(Tag.valueOf("th"), "").text("Naziv");
////        Element thRBPrimerka = new Element(Tag.valueOf("th"), "").text("Registarski broj primerka");
////        Element thJezik = new Element(Tag.valueOf("th"), "").text("Jezik");
////        Element thBrStranica = new Element(Tag.valueOf("th"), "").text("Broj stranica");
//
////        trHeader.appendChild(thRedniBroj);
////        trHeader.appendChild(thDetails);
////        trHeader.appendChild(thNaziv);
////        trHeader.appendChild(thRBPrimerka);
////        trHeader.appendChild(thJezik);
////        trHeader.appendChild(thBrStranica);
//
//        table.appendChild(caption);
//        table.appendChild(trHeader);
//
//        List<Users> usersList = users.findAll();
//        for (int i=0; i < usersList.size(); i++) {
//            User iterUser = usersList.get(i);
//            if (iterUser.isIzdata()) {
//                Element trUser = new Element(Tag.valueOf("tr"), "");
//                Element tdRedniBroj = new Element(Tag.valueOf("td"), "").text(String.valueOf(i + 1));
//                Element tdDetails = new Element(Tag.valueOf("td"), "");
//                Element aDetails = new Element(Tag.valueOf("a"), "").attr("href","users/details?id="+iterUser.getId()).text(iterUser.getNaziv());
//                Element tdNaziv = new Element(Tag.valueOf("td"), "").text(iterUser.getNaziv());
//                Element tdRBPrimerka = new Element(Tag.valueOf("td"), "").text(iterUser.getRegistarskiBrojPrimerka());
//                Element tdJezik = new Element(Tag.valueOf("td"), "").text(iterUser.getJezik());
//                Element tdBrStranica = new Element(Tag.valueOf("td"), "").text(String.valueOf(iterUser.getBrojStranica()));
//
//                tdDetails.appendChild(aDetails);
//                trUser.appendChild(tdRedniBroj);
//                trUser.appendChild(tdDetails);
//                trUser.appendChild(tdNaziv);
//                trUser.appendChild(tdRBPrimerka);
//                trUser.appendChild(tdJezik);
//                trUser.appendChild(tdBrStranica);
//
//                Element tdForm = new Element(Tag.valueOf("td"), "");
//                Element form = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "users/delete");
//                Element inputHidden = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "id").attr("value", String.valueOf(iterUser.getId()));
//                Element inputSubmit = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Delete");
//                form.appendChild(inputHidden);
//                form.appendChild(inputSubmit);
//                tdForm.appendChild(form);
//                trUser.appendChild(tdForm);
//                table.appendChild(trUser);
//            }
//        }
//
//        Element ulTagAddUser = new Element(Tag.valueOf("ul"), "");
//        Element liTagAddUser = new Element(Tag.valueOf("li"), "");
//        Element aTagAddUser = new Element(Tag.valueOf("a"), "").attr("href", "users/add").text("Add user");
//        liTagAddUser.appendChild(aTagAddUser);
//        ulTagAddUser.appendChild(liTagAddUser);
//
//        body.appendChild(ulTag);
//        body.appendChild(table);
//        body.appendChild(ulTagAddUser);

//        out.write("doc.html() index get");
//        return;
//    }

    @GetMapping(value="/register")
    @ResponseBody
    public void registerForm(HttpServletResponse response) throws IOException {
        Document doc = Jsoup.parse(new ClassPathResource("static/register.html").getFile(), "UTF-8");
        response.getWriter().write(doc.html());
        return;
    }

    @PostMapping(value="/register")
    public void register(@ModelAttribute CreateUserDTO userDTO, HttpServletResponse response) throws IOException {

        userService.save(userDTO);

        response.sendRedirect(bURL + "/users/login");
    }

//    @PostMapping(value="/edit")
//    public void Edit(@ModelAttribute CreateUserDTO bookDTO, HttpServletResponse response) throws IOException {

//        Users users = (Users) appMemory.get(UserController.USERS_KEY);
//
//        User user = users.findOne(userEdited.getId());
//        if(user != null) {
//            if(userEdited.getNaziv() != null && !userEdited.getNaziv().trim().equals(""))
//                user.setNaziv(userEdited.getNaziv());
//            if(userEdited.getJezik() != null && !userEdited.getJezik().trim().equals(""))
//                user.setJezik(userEdited.getJezik());
//            if(userEdited.getBrojStranica() > 0)
//                user.setBrojStranica(userEdited.getBrojStranica());
//        }
//        User saved = users.save(user);
//        response.sendRedirect(bURL+"usersu");
//    }

//    @PostMapping(value="/delete")
//    public void delete(@RequestParam Long id, HttpServletResponse response) throws IOException {
//
////        Users users = (Users) appMemory.get(UserController.USERS_KEY);
////
////        User deleted = users.delete(id);
//        response.sendRedirect(bURL+"userss");
//    }


    // GET: users/details?id=1
//    @GetMapping(value="/details")
//    @ResponseBody
//    public void details(@RequestParam Long id, HttpServletResponse response) throws IOException {
//
////        Knjige knjige = (Knjige) memorijaAplikacije.get(KnjigeController.KNJIGE_KEY);
////
////        Knjiga knjiga = knjige.findOne(id);
////
//        PrintWriter out;
//        out = response.getWriter();
////        File htmlFile = new ClassPathResource("static/template.html").getFile();
////        Document doc = Jsoup.parse(htmlFile, "UTF-8");
////
////        Element body = doc.select("body").first();
////
////        Element ulTag = new Element(Tag.valueOf("ul"), "");
////        Element liTagKnjige = new Element(Tag.valueOf("li"), "");
//////        Element liTagClanskeKarte = new Element(Tag.valueOf("li"), "");
////        Element aTagKnjige = new Element(Tag.valueOf("a"), "").attr("href", "/pharmacy/knjige").text("Knjige");
//////        Element aTagClanskeKarte = new Element(Tag.valueOf("a"), "").attr("href", "/pharmacy/clanskeKarte").text("Clanske karte");
////        liTagKnjige.appendChild(aTagKnjige);
//////        liTagClanskeKarte.appendChild(aTagClanskeKarte);
////        ulTag.appendChild(liTagKnjige);
//////        ulTag.appendChild(liTagClanskeKarte);
////
////        Element form = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "edit");
////        Element table = new Element(Tag.valueOf("table"), "");
////        Element caption = new Element(Tag.valueOf("caption"), "").text("Knjiga");
////
////        Element inputHidden = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "id").attr("value", String.valueOf(knjiga.getId()));
////
////        Element trNaziv = new Element(Tag.valueOf("tr"), "");
////        Element thNaziv = new Element(Tag.valueOf("th"), "").text("Naziv");
////        Element tdNaziv = new Element(Tag.valueOf("td"), "");
////        Element inputNaziv = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "naziv").attr("value", knjiga.getNaziv());
////
////        tdNaziv.appendChild(inputNaziv);
////        trNaziv.appendChild(thNaziv);
////        trNaziv.appendChild(tdNaziv);
////
////        Element trRBPrimerka = new Element(Tag.valueOf("tr"), "");
////        Element thRBPrimerka = new Element(Tag.valueOf("th"), "").text("Redni broj primerka");
////        Element tdRBPrimerka = new Element(Tag.valueOf("td"), "");
////        Element inputRBPrimerka = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "registarskiBrojPrimerka").attr("value", knjiga.getRegistarskiBrojPrimerka());
////
////        tdRBPrimerka.appendChild(inputRBPrimerka);
////        trRBPrimerka.appendChild(thRBPrimerka);
////        trRBPrimerka.appendChild(tdRBPrimerka);
////
////        Element trJezik = new Element(Tag.valueOf("tr"), "");
////        Element thJezik = new Element(Tag.valueOf("th"), "").text("Jezik");
////        Element tdJezik = new Element(Tag.valueOf("td"), "");
////        Element inputJezik = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "jezik").attr("value", knjiga.getJezik());
////
////        tdJezik.appendChild(inputJezik);
////        trJezik.appendChild(thJezik);
////        trJezik.appendChild(tdJezik);
////
////        Element trBrStranica = new Element(Tag.valueOf("tr"), "");
////        Element thBrStranica = new Element(Tag.valueOf("th"), "").text("Broj stranica");
////        Element tdBrStranica = new Element(Tag.valueOf("td"), "");
////        Element inputBrStranica = new Element(Tag.valueOf("input"), "").attr("type", "number").attr("name", "brojStranica").attr("min", "1").attr("value", String.valueOf(knjiga.getBrojStranica()));
////
////        tdBrStranica.appendChild(inputBrStranica);
////        trBrStranica.appendChild(thBrStranica);
////        trBrStranica.appendChild(tdBrStranica);
////
////        Element trSubmit = new Element(Tag.valueOf("tr"), "");
////        Element thSubmit = new Element(Tag.valueOf("th"), "");
////        Element tdSubmit = new Element(Tag.valueOf("td"), "");
////        Element inputSubmit = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Izmeni");
////
////        tdSubmit.appendChild(inputSubmit);
////        trSubmit.appendChild(thSubmit);
////        trSubmit.appendChild(tdSubmit);
////
////        table.appendChild(caption);
////
////        table.appendChild(trNaziv);
////        table.appendChild(trRBPrimerka);
////        table.appendChild(trJezik);
////        table.appendChild(trBrStranica);
////        table.appendChild(trSubmit);
////
////        form.appendChild(inputHidden);
////        form.appendChild(table);
////
////        Element formBrisanje = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "delete");
////        Element inputSubmitBrisanje = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Obrisi");
////        Element inputHiddenBrisanje = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "id").attr("value", String.valueOf(knjiga.getId()));;
////        formBrisanje.appendChild(inputHiddenBrisanje);
////        formBrisanje.appendChild(inputSubmitBrisanje);
////
////
////        if (!knjiga.isIzdata()) {
////            Element formIzdajKnjigu = new Element(Tag.valueOf("form"), "").attr("method", "post").attr("action", "clanskeKarte/izdajKnjigu");
////
////            Element inputHiddenIzdajKnjigu = new Element(Tag.valueOf("input"), "").attr("type", "hidden").attr("name", "idKnjige").attr("value", String.valueOf(knjiga.getId()));
////
////            Element tableIzdajKnjigu = new Element(Tag.valueOf("table"), "");
////            Element captionIzdajKnjigu = new Element(Tag.valueOf("caption"), "").text("Izdaj primerak knjige");
////
////            Element trBrClanskeKarte = new Element(Tag.valueOf("tr"), "");
////            Element thBrClanskeKarte = new Element(Tag.valueOf("th"), "").text("Registarski broj clanske karte");
////            Element tdBrClanskeKarte = new Element(Tag.valueOf("td"), "");
////            Element inputBrClanskeKarte = new Element(Tag.valueOf("input"), "").attr("type", "text").attr("name", "registarskiBroj");
////
////            tdBrClanskeKarte.appendChild(inputBrClanskeKarte);
////            trBrClanskeKarte.appendChild(thBrClanskeKarte);
////            trBrClanskeKarte.appendChild(tdBrClanskeKarte);
////
////            Element inputSubmitIzdajKnjigu = new Element(Tag.valueOf("input"), "").attr("type", "submit").attr("value", "Izdaj");
////
////            tableIzdajKnjigu.appendChild(captionIzdajKnjigu);
////            tableIzdajKnjigu.appendChild(trBrClanskeKarte);
////            tableIzdajKnjigu.appendChild(inputSubmitIzdajKnjigu);
////
////            formIzdajKnjigu.appendChild(inputHiddenIzdajKnjigu);
////            formIzdajKnjigu.appendChild(tableIzdajKnjigu);
////        }
////
////        body.appendChild(ulTag);
////        body.appendChild(form);
////        body.appendChild(formBrisanje);
//
//        out.write("doc.html() get details");
//        return;
//    }

    @GetMapping("/login")
    public void getLoginForm(HttpServletResponse response) throws IOException {
        Document doc = Jsoup.parse(new ClassPathResource("static/login.html").getFile(), "UTF-8");
        response.getWriter().write(doc.html());
        return;
    }
    @PostMapping("/login")
    public void login(HttpServletResponse response){

    }
    @PostMapping("/logout")
    public void logout(HttpServletResponse response){

    }
    @GetMapping("/profile")
    public void getProfilePage(HttpServletResponse response){

    }
}
