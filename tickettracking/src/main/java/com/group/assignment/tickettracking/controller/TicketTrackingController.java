package com.group.assignment.tickettracking.controller;

import com.group.assignment.tickettracking.entity.TicketDetails;
import com.group.assignment.tickettracking.service.TicketTrackingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class TicketTrackingController {

    @Autowired
    public TicketTrackingServiceImpl ticketTrackingService;

    @GetMapping("/ticketdetails")
    public  String getList(Model model){


        model.addAttribute("ticketdetails", ticketTrackingService.getAllTicketDetails());
        return "ticketdetails";
    }

    @GetMapping("/ticketdetails/new")
    public  String createTicketDetailsForm(Model model){

        TicketDetails ticketDetails = new TicketDetails();
        //ticketDetails.setTcktCreatedOn(new Date(System.currentTimeMillis()));

        model.addAttribute("ticketdetails", ticketDetails);
        return "create_ticket";
    }


    @PostMapping("/ticketdetails")
    public String saveTicketDetails(@ModelAttribute("ticketdetails") TicketDetails ticketDetails){

        ticketDetails.setTcktCreatedOn(new Date(System.currentTimeMillis()));
        TicketDetails ticketDetails1 = ticketTrackingService.saveTicketDetails(ticketDetails);
        return  "ticketdetails";
    }

    @GetMapping("/ticketdetails/edit/{id}")
    public String editTicketDetails(@PathVariable Long id,Model model){

        model.addAttribute("ticketdetails", ticketTrackingService.getTicketDetailsById(id));
        return "edit_ticket";
    }

    @PostMapping("/ticketdetails/{id}")
    public String updateTicketDetails(@PathVariable Long id, @ModelAttribute ("ticketdetails") TicketDetails ticketDetails, Model model){

        TicketDetails e1 = ticketTrackingService.getTicketDetailsById(id);
        e1.setId(id);
        e1.setTicketTitle(ticketDetails.getTicketTitle());
        e1.setTcktShortDesc(ticketDetails.getTcktShortDesc());
        e1.setTcktCreatedOn(new Date(System.currentTimeMillis()));
        TicketDetails ticketDetails1 = ticketTrackingService.updateTicketDetails(e1);
        return  "redirect:/ticketdetails";
    }

    @GetMapping("/ticketdetails/{id}")
    public String deleteTicketDetails(@PathVariable Long id){

        ticketTrackingService.deleteTicketDetailsById(id);
        return "redirect:/ticketdetails";
    }

    @GetMapping(path = {"/search"})
    public String search(TicketDetails ticketdetails, Model model, String keyword) {
        if(keyword!=null) {
            List<TicketDetails> list = ticketTrackingService.findByKeyword(keyword);
            model.addAttribute("ticketdetails", list);
        }else {
            List<TicketDetails> list = ticketTrackingService.findByKeyword(keyword);
            model.addAttribute("ticketdetails", list);}
        return "ticketdetails";
    }
}
