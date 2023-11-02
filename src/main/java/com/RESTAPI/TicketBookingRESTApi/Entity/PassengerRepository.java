package com.RESTAPI.TicketBookingRESTApi.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerInfo,Integer> {
    public List<PassengerInfo> findByTicketInfo(TicketInfo ticketInfo);
    public void deleteByTicketInfo(TicketInfo ticketInfo);
}
