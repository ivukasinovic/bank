package com.project.controller;

import com.project.domain.Faktura;
import com.project.domain.FakturaStatus;
import com.project.domain.Preduzece;
import com.project.repository.PreduzeceRepository;
import com.project.service.FakturaService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@RestController
@RequestMapping(value = "faktura")
public class FakturaController {

    @Autowired
    private FakturaService fakturaService;

    @Autowired
    private PreduzeceRepository preduzeceRepository;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faktura>> getAll(){
        List<Faktura> cenovnici = fakturaService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> getOne(@PathVariable Long id){
        Faktura cenovnici = fakturaService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> delete(@PathVariable Long id){
        Faktura faktura = fakturaService.findOne(id);
        fakturaService.delete(faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> delete(@RequestBody Faktura faktura){
        Faktura noviFaktura = fakturaService.save(faktura);
        return new ResponseEntity<>(noviFaktura, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/stornirana/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> stornirati(@PathVariable Long id){       // @RequestBody Faktura faktura

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzeceF = (Preduzece)session.getAttribute("preduzece");

        Faktura faktura = fakturaService.findOne(id);

        double preostaliIznosZaUplatu = (faktura.getUkupnoZaPlacanje() - faktura.getPreostaliIznos());

        // kod izlaznih
        if(!faktura.getPrimalac().getNaziv().equals(preduzeceF.getNaziv()) ) {

            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrometKorist(preostaliIznosZaUplatu);
            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrometTeret(preostaliIznosZaUplatu * (-1));

            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrethodnoStanje((faktura.getDuznik().getDnevnoStanjes().get(0).getNovoStanje()  ));
            faktura.getPrimalac().getDnevnoStanjes().get(0).setNovoStanje( (faktura.getUkupnoZaPlacanje() - faktura.getPreostaliIznos() + faktura.getDuznik().getDnevnoStanjes().get(0).getPrethodnoStanje())  );


            faktura.getDuznik().getDnevnoStanjes().get(0).setPrethodnoStanje((faktura.getDuznik().getDnevnoStanjes().get(0).getNovoStanje()));
            faktura.getDuznik().getDnevnoStanjes().get(0).setNovoStanje( (faktura.getUkupnoZaPlacanje() - faktura.getPreostaliIznos() + faktura.getDuznik().getDnevnoStanjes().get(0).getPrethodnoStanje()) );

        }else {
            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrometKorist(preostaliIznosZaUplatu * (-1));
            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrometTeret(preostaliIznosZaUplatu);

            faktura.getPrimalac().getDnevnoStanjes().get(0).setPrethodnoStanje((faktura.getDuznik().getDnevnoStanjes().get(0).getNovoStanje()) * (-1));
            faktura.getPrimalac().getDnevnoStanjes().get(0).setNovoStanje( (faktura.getUkupnoZaPlacanje() - faktura.getPreostaliIznos() + faktura.getDuznik().getDnevnoStanjes().get(0).getPrethodnoStanje()) * (-1) );

            faktura.getDuznik().getDnevnoStanjes().get(0).setPrethodnoStanje((faktura.getDuznik().getDnevnoStanjes().get(0).getNovoStanje()));
            faktura.getDuznik().getDnevnoStanjes().get(0).setNovoStanje( (faktura.getUkupnoZaPlacanje() - faktura.getPreostaliIznos() + faktura.getDuznik().getDnevnoStanjes().get(0).getPrethodnoStanje()) );

        }
//        faktura.getDuznik().getDnevnoStanjes().get(0).setPrethodnoStanje(faktura.getPreostaliIznos());
//        faktura.getDuznik().getDnevnoStanjes().get(0).setNovoStanje(faktura.getPreostaliIznos() * (-1));

        faktura.setPreostaliIznos(faktura.getUkupnoZaPlacanje());
        faktura.setStatus(FakturaStatus.STORNIRANA);

        fakturaService.save(faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/neplacene", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Faktura>> getNeplacene(){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece)session.getAttribute("preduzece");

        List<Faktura> fakture = fakturaService.getNeplacene(preduzece);

        return  new ResponseEntity<>(fakture, HttpStatus.OK);

    }

    @RequestMapping(
            value  = "/ulazne",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faktura>> ulazneFakture(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece)session.getAttribute("preduzece");

       List<Faktura> faktura = fakturaService.findByPrimalac(preduzece);  // findOne(preduzece.getId());

        return new ResponseEntity<>(faktura,HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/izlazne",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faktura>> izlazneFakture(){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece)session.getAttribute("preduzece");

        List<Faktura> fakture = fakturaService.findByDuznik(preduzece);


        return new ResponseEntity<>(fakture,HttpStatus.OK);
    }
    @RequestMapping(value = "/ios", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIOS(HttpServletResponse response) throws JRException, SQLException {
        InputStream kifReport = getClass().getResourceAsStream("/IOS.jrxml");
        JasperPrint jasperPrint = generateJasperPring(kifReport);

        String naziv = "ios";
        boolean success = exportToDesktop(jasperPrint,naziv);
        if(success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/kif", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getKIF(HttpServletResponse response) throws JRException, SQLException {
        InputStream kifReport = getClass().getResourceAsStream("/KIF.jrxml");
        JasperPrint jasperPrint = generateJasperPring(kifReport);

        String naziv = "kif";
        boolean success = exportToDesktop(jasperPrint,naziv);
        if(success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/kp", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getKp(HttpServletResponse response) throws JRException, SQLException {
        InputStream kufReport = getClass().getResourceAsStream("/KP.jrxml");
        JasperPrint jasperPrint = generateJasperPring(kufReport);

        String naziv = "kp";
        boolean success = exportToDesktop(jasperPrint,naziv);
        if(success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/kuf", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getKuf(HttpServletResponse response) throws JRException, SQLException {
        InputStream kufReport = getClass().getResourceAsStream("/KUF.jrxml");
        JasperPrint jasperPrint = generateJasperPring(kufReport);

        String naziv = "kuf";
        boolean success = exportToDesktop(jasperPrint,naziv);
        if(success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    private JasperPrint generateJasperPring(InputStream jReport) throws JRException, SQLException {
        JasperReport jasperReport = JasperCompileManager.compileReport(jReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource.getConnection());
        return jasperPrint;
    }

    private boolean exportToDesktop(JasperPrint jasperPrint, String naziv) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();
        Random rand = new Random();
        int  n = rand.nextInt(1000) + 1;
        String desktop = System.getProperty("user.home") + "/Desktop/" + naziv + n + ".pdf";
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(desktop));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("baeldung");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
        return true;
    }

}
