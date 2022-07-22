package assignment.hotel;

import assignment.client.ClientHandler;

import java.io.*;
import java.util.ArrayList;

public class Hotel implements Serializable
{

    public String hotelName;
    public String hotelLocation;
    public String hotelDesc;

    public Hotel(String hotelName, String hotelLocation, String hotelDesc)
    {
        super();

        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hotelDesc = hotelDesc;
    }

    public void printHotelInfo()
    {

    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getHotelLocation()
    {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation)
    {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelDesc()
    {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc)
    {
        this.hotelDesc = hotelDesc;
    }

    public static void main(String[] args)
    {


    }
}

