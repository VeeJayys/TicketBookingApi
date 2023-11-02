package com.RESTAPI.TicketBookingRESTApi.Service;

import com.RESTAPI.TicketBookingRESTApi.Entity.PassengerInfo;
import com.RESTAPI.TicketBookingRESTApi.Entity.PassengerRepository;
import com.RESTAPI.TicketBookingRESTApi.Entity.TicketInfo;
import com.RESTAPI.TicketBookingRESTApi.Entity.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PassengerRepository passengerRepository;


    @Override
    public TicketInfo bookTicket(List<PassengerInfo> passengerInfoList, TicketInfo ticketInfo) {
        ticketRepository.save(ticketInfo);
        for (PassengerInfo pi:passengerInfoList)
        {
            pi.setTicketInfo(ticketInfo);
            passengerRepository.save(pi);
        }
        return ticketInfo;
    }
    @Override
    public TicketInfo findTicket(Integer ticketId) {
        Optional<TicketInfo> ticketInfo=ticketRepository.findById(ticketId);
        return ticketInfo.orElse(null);
    }
    @Override
    public void updateTicket(List<PassengerInfo> passengerInfoList, TicketInfo ticketInfo) {
        List<PassengerInfo> existPassList=passengerRepository.findByTicketInfo(ticketInfo);
        passengerRepository.deleteAll(existPassList);
        for (PassengerInfo pi:passengerInfoList)
        {
            pi.setTicketInfo(ticketInfo);
            passengerRepository.save(pi);
        }
    }

    @Override
    public void deleteTicket(TicketInfo ticketInfo) {
        ticketRepository.delete(ticketInfo);
        passengerRepository.deleteByTicketInfo(ticketInfo);
    }
    @Override
    public String pnrGenerator(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomChar;
            do {
                randomChar = (char) (random.nextInt(94) + 33); // ASCII printable characters (from 33 to 126)
            } while (Character.isWhitespace(randomChar));

            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
