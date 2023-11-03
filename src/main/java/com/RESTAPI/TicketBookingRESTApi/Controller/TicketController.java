package com.RESTAPI.TicketBookingRESTApi.Controller;

import com.RESTAPI.TicketBookingRESTApi.Entity.PassengerInfo;
import com.RESTAPI.TicketBookingRESTApi.Entity.TicketInfo;
import com.RESTAPI.TicketBookingRESTApi.Service.TicketService;
import com.RESTAPI.TicketBookingRESTApi.Service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity<TicketInfo> bookTheTicket(@RequestBody List<PassengerInfo> passengerInfoList){
        TicketInfo ticketInfo=new TicketInfo();
        ticketInfo.setPnrNumber(ticketService.pnrGenerator());

        ticketInfo.setStatus("Confirmed");
        ticketInfo.setPassengerInfoList(passengerInfoList);
        return new ResponseEntity<>( ticketService.bookTicket(passengerInfoList,ticketInfo), HttpStatus.CREATED);
    }

    @PutMapping("/changeTicket/{ticketId}")
    public ResponseEntity<TicketInfo> updateTheTicket(@PathVariable("ticketId") Integer ticketId,@RequestBody List<PassengerInfo> passengerInfoList){
        TicketInfo ticketInfo=new TicketInfo();
        ticketInfo=ticketService.findTicket(ticketId);
        if(ticketInfo!=null)
        {
            ticketInfo.setPassengerInfoList(passengerInfoList);
            ticketService.updateTicket(passengerInfoList, ticketInfo);
        }
        return new ResponseEntity<>( ticketInfo, HttpStatus.OK);
    }
    @DeleteMapping("/cancelTicket/{ticketId}")
    public ResponseEntity<String> cancelTheTicket(@PathVariable("ticketId") Integer ticketId){
        TicketInfo ticketInfo=new TicketInfo();
        ticketInfo=ticketService.findTicket(ticketId);
        if(ticketInfo!=null) {
            ticketService.deleteTicket(ticketInfo);
            return new ResponseEntity<>("Ticket cancelled", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Ticket status not found",HttpStatus.OK);
    }
    @GetMapping("/ticketDetails/{ticketId}")
    public ResponseEntity<TicketInfo> getTicketDetails(@PathVariable("ticketId") Integer ticketId){
        TicketInfo ticketInfo=new TicketInfo();
        ticketInfo=ticketService.findTicket(ticketId);
        return new ResponseEntity<>(ticketInfo,HttpStatus.FOUND);
    }
}
