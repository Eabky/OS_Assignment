package assignment.client;

import assignment.hotel.Hotel;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable
{
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>(); //list of clienthandler objects

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientID;

    public ClientHandler(Socket socket)
    {
        try
        {
            this.socket = socket; //sets the socket of the object created to the parameter socket

            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //sends messages to the client from the server by reading the sockets stream
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //sends messages from the client to the server

            clientHandlers.add(this); //adds the new clienthandler to the array

            broadcastInfo("Client has connected");
        }
        catch (IOException e)
        {
            shutDownEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    @Override
    public void run() //everything in here runs on a separate thread, so we don't have to wait for one reservation to be finished in order to start another
    {
        while(socket.isConnected()) //runs while a client is still connected
        {

        }
    }

    public void broadcastInfo(String info)
    {
        for(ClientHandler clientHandler : clientHandlers)
        {
            try
            {
                clientHandler.bufferedWriter.write(info);
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            }
            catch (IOException e)
            {
                shutDownEverything(socket, bufferedWriter, bufferedReader);
            }
        }
    }

    public void removeClientHandler() //removes a clientHandler from the array
    {
        clientHandlers.remove(this);
    }

    public void shutDownEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) //to close down the connection and streams
    {
        removeClientHandler();

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

}
