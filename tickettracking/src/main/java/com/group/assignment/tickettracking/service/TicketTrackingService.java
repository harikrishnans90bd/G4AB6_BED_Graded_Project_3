package com.group.assignment.tickettracking.service;

import com.group.assignment.tickettracking.entity.TicketDetails;

import java.util.List;

public interface TicketTrackingService {

    public List<TicketDetails> getAllTicketDetails();

    public TicketDetails saveTicketDetails(TicketDetails ticketDetails);

    TicketDetails getTicketDetailsById(Long id);

    TicketDetails updateTicketDetails(TicketDetails ticketDetails);

    void deleteTicketDetailsById(Long id);

    List<TicketDetails> findByKeyword(String keyWord);

}
