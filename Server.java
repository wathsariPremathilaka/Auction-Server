/*
E/15/211-E/15/208
Department of Computer Engineering-UoP
Semester4-CO225
*/

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

class Server implements Runnable{

  Socket socket_connection;

  public Server(Socket socket){

    try{
      System.out.println("Client got connected");
      socket_connection = socket;
    }catch(Exception e){
      e.printStackTrace();
    }

  }

public void run(){

  try {

    //read the input from the client
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket_connection.getInputStream()));

    //output what is read from the client
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket_connection.getOutputStream()));

    writer.write("Welcome to the auction server !!!! \r\n");
    writer.write("Please type your name : \r\n");
    writer.flush();
    String namex = reader.readLine().trim();

    //call the GUI here
    Gui gui = new Gui();
    gui.initComponents();
    gui.main();


    //ask the client to enter the symbol that he or she wants to bid
    writer.write("\nPlease enter symbol : \r\n");
    writer.flush();
    String symbolx = reader.readLine().trim();


    //find the symbol in the stocks.csv file
    Stock table1 = new Stock("stocks.csv");
    // String x = Arrays.toString(table1.finditem(symbolx));
    String itemDetails =table1.getitem(symbolx);
    String itemPresent =table1.finditem(symbolx);


    if(itemPresent != "-1"){
          Bid table3 = new Bid("stocks.csv");
          // String y =Arrays.toString(table3.latestBid(symbolx));
          String latestbid =table3.latestBid(symbolx);

          writer.write("\nLatest Bid : \r\n");
          writer.flush();

          //print the latest bid details
          writer.write(latestbid);
          writer.newLine();
          writer.flush();

          //ask the client to enter the bid price
          writer.write("\nPlease enter your Bid Price : \r\n");
          writer.flush();
          //read the entered  bid price
          String bidPrice = reader.readLine().trim();

          writer.write("\nThank You!!! \r\n");
          writer.flush();

          /*if the symbol is present in the original stocks.csv file
          add the bid price to the new bidstock.csv file*/
          Bid table2 = new Bid("stocks.csv");
          table2.addBid(itemDetails+","+bidPrice+","+namex);
    }else{
          writer.write("\n#Please enter a valid symbol#\r\n");
          writer.flush();
    }


  }catch(Exception e){
    e.printStackTrace();
  }
}

}
