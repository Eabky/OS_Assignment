package assignment.hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Room extends Hotel {
    public int roomPrice;
    public int numofBeds;
    public int reservationPeriod; //amount of days of the reservation
    public String roomDesc;

    public Room(String hotelName, String hotelLocation, String hotelDesc, int roomPrice, int numofBeds, int reservationPeriod, String roomDesc)
    {
        super(hotelName, hotelLocation, hotelDesc);

        this.roomPrice = roomPrice;
        this.numofBeds = numofBeds;
        this.reservationPeriod = reservationPeriod;
        this.roomDesc = roomDesc;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNumofBeds() {
        return numofBeds;
    }

    public void setNumofBeds(int numofBeds) {
        this.numofBeds = numofBeds;
    }

    public int getReservationPeriod() {
        return reservationPeriod;
    }

    public void setReservationPeriod(int reservationPeriod) {
        this.reservationPeriod = reservationPeriod;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }
}