package com.group.assignment.tickettracking.service;

import com.group.assignment.tickettracking.dao.TicketTrackingRepository;
import com.group.assignment.tickettracking.entity.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketTrackingServiceImpl implements TicketTrackingService {

    @Autowired
public TicketTrackingRepository ticketTrackingRepository;


    @Override
    public List<TicketDetails> getAllTicketDetails() {
        return ticketTrackingRepository.findAll();
    }

    @Override
    public TicketDetails saveTicketDetails(TicketDetails ticketDetails) {
        return ticketTrackingRepository.save(ticketDetails);
    }


    @Override
    public TicketDetails getTicketDetailsById(Long id) {
        return ticketTrackingRepository.getTicketDetailsById(id);
    }

    @Override
    public TicketDetails updateTicketDetails(TicketDetails ticketDetails) {
        return ticketTrackingRepository.save(ticketDetails);
    }

    @Override
    @Transactional
    public void deleteTicketDetailsById(Long id) {
ticketTrackingRepository.deleteTicketDetailsById(id);
    }

    @Override
    public List<TicketDetails> findByKeyword(String keyWord) {
        return ticketTrackingRepository.findByKeyword(keyWord);
    }
}
