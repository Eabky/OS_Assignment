package assignment.hotel;

import java.io.Serializable;

public class Hotel implements Serializable
{
    public String hotelName;
    public String hotelLocation;
    public String hotelDesc;

    public Hotel(String hotelName, String hotelLocation, String hotelDesc)
    {
        this.hotelName = hotelName;
        this.hotelDesc = hotelDesc;
        this.hotelLocation = hotelLocation;
    }

    public class Room extends Hotel
    {
        public int roomPrice;
        public int numofBeds;
        public int reservationPeriod; //amount of days of the reservation
        public String roomDesc;

        public Room(String hotelName, String hotelLocation, String hotelDesc)
        {
            super(hotelName, hotelLocation, hotelDesc);
        }
    }
}

