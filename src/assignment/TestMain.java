package assignment;

import assignment.hotel.Hotel;
import assignment.hotel.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestMain
{

    public static ArrayList<Room> getHotels(String fileName, String fileName2) throws IOException
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


        return roomsfromFile;
    }

    public static void showRooms(ArrayList<Room> rooms, String name)
    {
        for(int i= 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).hotelName.equals(name))
            {
                System.out.println(rooms.get(i));
            }
        }

    }

    //main
    public static void main(String[] args)
    {
        ArrayList<Room> hotels = new ArrayList<>();

        try
        {
            hotels = getHotels("hotelInfo.txt", "roomInfo.txt");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println(hotels);


    }
}
