package org.binar.chapter4.controller;

import org.binar.chapter4.model.Films;
import org.binar.chapter4.model.Schedules;
import org.binar.chapter4.model.response.FilmResponse;
import org.binar.chapter4.model.response.SchedulesResponse;
import org.binar.chapter4.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmServiceImpl filmService;

    @PutMapping("/update")
    public ResponseEntity updateFilm(@RequestParam("filmName") String filmName,
                                     @RequestParam("showing") Boolean showing,
                                     @RequestParam("filmCode") Integer filmCode) {
        try {
            filmService.updateFilm(filmName, showing, filmCode);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new_film")
    public ResponseEntity insertFilm(@RequestParam("filmName") String filmName,
                                     @RequestParam("showing") Boolean showing) {
        try {
            filmService.addNewFilm(filmName, showing);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteFilm(@RequestParam("filmName") String filmName) {

        try {
            filmService.deleteFilm(filmName);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search_film_by_showing")
    public ResponseEntity searchShowingFilm(@RequestParam("showing") Boolean showing) {
        try {
            List<Films> filmsList = filmService.showingFilm(showing);
            Map<String, List<Films>> resp = new HashMap<>();
            resp.put("Film yang sedang rilis", filmsList);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/search_schedule_by_film")
    public ResponseEntity searchFilmSchedule(
            @RequestParam("filmCode") Integer filmCode) {
         try{ List<Schedules> schedulesList = filmService.showingScheduleFilm(filmCode);

             Map<String, List<Schedules>> resp = new HashMap<>();
             resp.put("message", schedulesList);
         return new ResponseEntity(resp, HttpStatus.OK);}
                catch (Exception e){
                    System.out.println(e.getMessage());
             return new ResponseEntity(HttpStatus.NOT_FOUND);
                }

    }

}
