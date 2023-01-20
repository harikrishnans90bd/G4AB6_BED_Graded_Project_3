package com.group.assignment.tickettracking.dao;

import com.group.assignment.tickettracking.entity.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTrackingRepository extends JpaRepository<TicketDetails,Long> {

    public List<TicketDetails> findAll();

    public TicketDetails save(TicketDetails ticketDetails);

     public TicketDetails findById(long id);

     TicketDetails getTicketDetailsById(Long id);

     void deleteTicketDetailsById(Long id);

    @Query(value = "select * from ticketdetails td where td.ticket_title like %:keyword% or td.ticket_short_desc like %:keyword%", nativeQuery = true)
    List<TicketDetails> findByKeyword(@Param("keyword") String keyword);
}


