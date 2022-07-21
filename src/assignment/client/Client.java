package assignment.client;

import java.io.*;
import java.net.Socket;

public class Client
{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private static String clientID;

    public Client(Socket socket, String clientID)
    {
        try
        {
            this.socket = socket; //sets the socket of the object created to the parameter socket

            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //sends messages to the client from the server by reading the sockets stream
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //sends messages from the client to the server
            this.clientID = clientID;
        }
        catch (IOException e)
        {
            shutDownEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void createClientID()
    {

    }

    public void roomReservation()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {

            }

        }).start();
    }

    public void shutDownEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader)
    {
        try
        {
            if(bufferedReader != null)
            {
                bufferedReader.close();
            }
            if(bufferedWriter != null)
            {
                bufferedWriter.close();
            }
            if(socket != null)
            {
                socket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("HELLO!");

        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, clientID);
    }

}
