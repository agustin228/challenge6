package org.binar.chapter5.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.chapter5.model.*;
import org.binar.chapter5.service.FilmServiceImpl;
import org.binar.chapter5.service.InvoiceService;
import org.binar.chapter5.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;


    @GetMapping("/ticket_movie")
    public void generateInvoice(HttpServletResponse response,
                                @RequestParam("username") String username,
                                @RequestParam("film_name") String filmName,
                                @RequestParam("number") Integer number,
                                @RequestParam("studio") String studio){

        try{
            JasperReport sourceFileName = JasperCompileManager.compileReport(
                    ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "invoice.jrxml").getAbsolutePath());

            List<Map<String,Object>> dataInvoice = new ArrayList<>();
            Map<String, Object> invoice = new HashMap<>();


            UsersMovie usersMovie = invoiceService.getUser(username);
            invoice.put("username", usersMovie.getUsername());
            Films films = invoiceService.getFilmName(filmName);
            invoice.put("filmName", films.getFilmName());
            Schedules schedules = invoiceService.getScheduleFilmByFilmName(filmName);
            invoice.put("showDate", schedules.getShowDate());
            invoice.put("startTime", schedules.getStartTime());
            invoice.put("endTime", schedules.getEndTime());
            Seats seatsBooked = invoiceService.getStudioSeats(number, studio);
            invoice.put("chairNumber", seatsBooked.getChairNumber());
            dataInvoice.add(invoice);


            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataInvoice);
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanCollectionDataSource);

            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=invoice.pdf;");

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());


        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
