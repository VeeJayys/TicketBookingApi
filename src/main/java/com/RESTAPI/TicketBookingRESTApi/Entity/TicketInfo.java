package com.RESTAPI.TicketBookingRESTApi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Entity
@Table(name="ticket_information")
public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String pnrNumber;
    private String status;
    @OneToMany(mappedBy = "ticketInfo", cascade = CascadeType.ALL)
    private List<PassengerInfo> passengerInfoList=new ArrayList<>();


    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PassengerInfo> getPassengerInfoList() {
        return passengerInfoList;
    }

    public void setPassengerInfoList(List<PassengerInfo> passengerInfoList) {
        this.passengerInfoList = passengerInfoList;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "ticketId=" + ticketId +
                ", pnrNumber='" + pnrNumber + '\'' +
                ", status='" + status + '\'' +
                ", passengerInfoList=" + passengerInfoList +
                '}';
    }

}
