/*
E/15/211-E/15/208
Department of Computer Engineering-UoP
Semester4
*/



import java.net.*;
import java.io.*;

class App{

  public static void main(String[] args) throws Exception {

    System.out.println("Server is running");

    ServerSocket mysocket = new ServerSocket(2000);

    //Server is running always. This is done using this while(true) loop
    while(true){

      //Reading the message from the client
      Socket sock = mysocket.accept();
      Server server = new Server(sock);

      Thread serverThread = new Thread(server);
      serverThread.start();
    }

  }

}
