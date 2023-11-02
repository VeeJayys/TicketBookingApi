package com.RESTAPI.TicketBookingRESTApi.Service;


import com.RESTAPI.TicketBookingRESTApi.Entity.PassengerInfo;
import com.RESTAPI.TicketBookingRESTApi.Entity.TicketInfo;

import java.util.List;

public interface TicketService {
    public TicketInfo bookTicket(List<PassengerInfo> passengerInfoList, TicketInfo ticketInfo);
    public TicketInfo findTicket(Integer ticketId);
    public void updateTicket(List<PassengerInfo> passengerInfoList, TicketInfo ticketInfo);

    void deleteTicket(TicketInfo ticketInfo);
    public String pnrGenerator();

}
