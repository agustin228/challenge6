package org.binar.chapter5.service;

import org.binar.chapter5.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InvoiceService {

     Films getFilmName(String filmName);

     Schedules getScheduleFilmByFilmName(String filmName);

     Seats getStudioSeats(Integer number, String studio);

     UsersMovie getUser(String username);


}
