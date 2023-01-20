package com.group.assignment.tickettracking.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="ticketdetails")
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="ticket_title")
    private String ticketTitle;

    @Column(name="ticket_short_desc")
    private String tcktShortDesc;

    @Column(name="ticket_created_date")
    private Date tcktCreatedOn;


    public TicketDetails(){

    }

    public TicketDetails(long id, String ticketTitle, String tcktShortDesc, Date tcktCreatedOn) {
        this.id = id;
        this.ticketTitle = ticketTitle;
        this.tcktShortDesc = tcktShortDesc;
        this.tcktCreatedOn = tcktCreatedOn;
    }

    public TicketDetails(String ticketTitle, String tcktShortDesc, Date tcktCreatedOn) {
        this.ticketTitle = ticketTitle;
        this.tcktShortDesc = tcktShortDesc;
        this.tcktCreatedOn = tcktCreatedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTcktShortDesc() {
        return tcktShortDesc;
    }

    public void setTcktShortDesc(String tcktShortDesc) {
        this.tcktShortDesc = tcktShortDesc;
    }

    public Date getTcktCreatedOn() {
        return tcktCreatedOn;
    }

    public void setTcktCreatedOn(Date tcktCreatedOn) {
        this.tcktCreatedOn = tcktCreatedOn;
    }
}
