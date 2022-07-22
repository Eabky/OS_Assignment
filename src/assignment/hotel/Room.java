package assignment.hotel;

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
