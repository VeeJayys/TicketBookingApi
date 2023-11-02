package com.RESTAPI.TicketBookingRESTApi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
public class PassengerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;
    private String passengerName;
    private Integer passengerAge;
    private String fromStation;
    private String toStation;
    private String dateOfJourney;
    private String trainNumber;
    @ManyToOne
    @JoinColumn(name = "ticketId")
    @JsonIgnore
    private TicketInfo ticketInfo;


    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    @Override
    public String toString() {
        return "PassengerInfo{" +
                "passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", dateOfJourney='" + dateOfJourney + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", ticketInfo=" + ticketInfo +
                '}';
    }
}
