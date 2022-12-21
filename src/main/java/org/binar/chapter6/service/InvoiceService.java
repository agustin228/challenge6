package org.binar.chapter6.service;

import org.binar.chapter6.model.*;


public interface InvoiceService {

     Films getFilmName(String filmName);

     Schedules getScheduleFilmByFilmName(String filmName);

     Seats getStudioSeats(Integer number, String studio);

     UsersMovie getUser(String username);


}
