package rs.ac.uns.ftn.dan.pharmacy.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(name = "/vaccines")
public class VaccineController {

    public static final String VACCINES_KEY = "vaccines";

    private ServletContext servletContext;
    private String bURL;

//    @Autowired
//    private VaccineService vaccineService;

    @GetMapping
    @ResponseBody
    public void getAllVaccines(HttpServletResponse response) {
//        TODO
//          list all vaccines & show a search form
//
    }
    @GetMapping(name = "/search")
    @ResponseBody
    public void getSearchedVaccines(@RequestParam String vaccineName, @RequestParam String makerName,
                                    @RequestParam String makerCountry, @RequestParam int amountMin,
                                    @RequestParam int amountMax, @RequestParam boolean sortDesc,
                                    HttpServletResponse response) {
//        TODO
//          list searched vaccines & the search form
//          sort vaccines
    }

    @GetMapping(value = "/details")
    @ResponseBody
    public void details(@RequestParam Long id, HttpServletResponse response) throws IOException {

//        TODO detailed view of 1 Vaccine
//         + edit form FOR ADMINISTRATORS
//        Vaccine foundVaccine = vaccineService.findOne(id);
//        System.out.println(foundVaccine);

        PrintWriter out = response.getWriter();

        File htmlFile = new ClassPathResource("static/template.html").getFile();
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
//
        Element body = doc.select("body").first();

//      HEADER
        Element ulTag = new Element(Tag.valueOf("ul"), "");
        Element liTagManufacturers = new Element(Tag.valueOf("li"), "");
        Element aTagManufacturers = new Element(Tag.valueOf("a"), "").attr("href", servletContext.getContextPath() + "/news").text("News");
        liTagManufacturers.appendChild(aTagManufacturers);
        ulTag.appendChild(liTagManufacturers);

        body.appendChild(ulTag);


//      MANUFACTURER OVERVIEW
        Element detailsH2 = new Element(Tag.valueOf("h2"), "").text("DETAILS");
//        Element detailsDiv = new Element(Tag.valueOf("div"), "").text(foundVaccine.getManufacturer().getName() + " " + foundVaccine.getName() + " " + foundVaccine.getManufacturer().getCountry());
        body.appendChild(detailsH2);
//        body.appendChild(detailsDiv);

        out.write(doc.html());
        return;
    }

    @PostMapping(name = "/")
    public void signUpForVaccination(@RequestParam String vaccineName, @RequestParam int doseNum,
                                     HttpServletResponse response) {

    }
    @DeleteMapping(name = "/")
    public void cancelOwnVaccinationRequest(@RequestParam Long vaccinationRequestId, HttpServletResponse response) {

    }
    @GetMapping(name = "/signups")
    public void getVaccinationSignups(@RequestParam String patientName, @RequestParam String patientSurname,
                                      @RequestParam String patientJmbg, HttpServletResponse response){

    }
    @PutMapping(name = "/vaccinate")
    public void vaccinatePatient(@RequestParam Long patientId, @RequestParam int doseNumBeingGiven,
                                 @RequestParam String vaccineName,  HttpServletResponse response){

    }
    @PutMapping(name = "/")
    public void editVaccineDetails(@RequestParam Long vaccineId, @RequestParam String vaccineName,
                                   @RequestParam String makerName, @RequestParam String makerCountry,
                                   HttpServletResponse response){

    }

}