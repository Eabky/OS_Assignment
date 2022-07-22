package assignment.server;

import assignment.hotel.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;

    }

    public void runServer()
    {
        try
        {
            while(!serverSocket.isClosed())
            {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

            }
        }
        catch (IOException e)
        {
            closeServerSocket();
        }
    }

    public void closeServerSocket()
    {
        try
        {
            if(serverSocket != null)
            {
                serverSocket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Hotel> getHotels(String fileName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = null;

        ArrayList<Hotel> hotelsfromFile = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null)
        {
            String item[] = line.split("-");

            String name = item[0];
            String location = item[1];
            String description = item[2];

            Hotel hotel = new Hotel(name, location, description);
            hotelsfromFile.add(hotel);

            System.out.println(hotel.getHotelName());
            System.out.println(hotel.getHotelLocation());
            System.out.println(hotel.getHotelDesc());

        }

        bufferedReader.close();

        return hotelsfromFile;
    }


    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.runServer();

    }
}
