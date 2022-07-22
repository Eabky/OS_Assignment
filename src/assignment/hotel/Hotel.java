package assignment.hotel;

import assignment.client.ClientHandler;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable
{
    public static ArrayList<Hotel> hotels = new ArrayList<>(); //list of hotels
    public String hotelName;
    public String hotelLocation;
    public String hotelDesc;

    public Hotel(String hotelName, String hotelLocation, String hotelDesc)
    {
        this.hotelName = hotelName;
        this.hotelDesc = hotelDesc;
        this.hotelLocation = hotelLocation;

        hotels.add(this);
    }

    public void printHotelInfo(String name, String location, String description)
    {
        hotelName = name;
        hotelLocation = location;
        hotelDesc = description;

    }
}

