package assignment.hotel;

import java.io.*;
import java.util.ArrayList;

public class Hotel implements Serializable {

    public String hotelName;
    public String hotelLocation;
    public String hotelDesc;

    public Hotel(String hotelName, String hotelLocation, String hotelDesc) {
        super();

        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hotelDesc = hotelDesc;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc)
    {
        this.hotelDesc = hotelDesc;
    }

    @Override
    public String toString()
    {
        return new StringBuffer("\n").append(this.hotelName).append(" - ").append(this.hotelLocation).append(" - ").append(this.hotelDesc).toString();
    }

    public static ArrayList<Hotel> getHotels(String fileName, String fileName2) throws IOException
    {
        BufferedReader bufferedReaderHotel = new BufferedReader(new FileReader(fileName));
        BufferedReader bufferedReaderRoom = new BufferedReader(new FileReader(fileName2));
        String lineHotel = null;
        String lineRoom = null;

        ArrayList<Hotel> hotelsfromFile = new ArrayList<>();
        ArrayList<Room> roomsfromFile = new ArrayList<>();

        System.out.println("+++++++++ HOTELS +++++++++");

        while ((lineHotel = bufferedReaderHotel.readLine()) != null)
        {
            String itemHotel[] = lineHotel.split("-");

            String name = itemHotel[0];
            String location = itemHotel[1];
            String description = itemHotel[2];

            Hotel hotel = new Hotel(name, location, description);
            hotelsfromFile.add(hotel);

            System.out.println("\n" + hotel.getHotelName() + "\n" + hotel.getHotelLocation() + "\n" + hotel.getHotelDesc());

            lineRoom = bufferedReaderRoom.readLine();

            String itemRoom[] = lineRoom.split("-");

            for (int roomCount = 0, i = 0; i < itemRoom.length; )
            {
                int price = Integer.parseInt(itemRoom[i]);
                i++;
                int beds = Integer.parseInt(itemRoom[i]);
                i++;
                int res = Integer.parseInt(itemRoom[i]);
                i++;
                String desc = itemRoom[i];
                i++;

                Room room = new Room(name, location, description, price, beds, res, desc);
                roomsfromFile.add(room);

                roomCount++;

                System.out.println("\nRoom" + roomCount + "\n" + room.getRoomPrice() + "\n" + room.getNumofBeds() + "\n" + room.getReservationPeriod() + "\n" + room.getRoomDesc());
                System.out.println(room.hotelName);
            }
        }

        bufferedReaderHotel.close();
        bufferedReaderRoom.close();


        return hotelsfromFile;
    }
}

