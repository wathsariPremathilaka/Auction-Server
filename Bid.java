/*
E/15/211-E/15/208
Department of Computer Engineering-UoP
Semester4-CO225
*/

import java.io.*;
import java.util.*;

public class Bid{

  BufferedReader reader = null;
  BufferedWriter writer = null;
  String file_name = "";
  String[] array = null;
  String q = "";

  public Bid(String file_name){
    this.file_name = file_name;
  }


  /*
  *add the  bid to the csv file
  */
  public void addBid(String line) {
    try {
      // read the given file line by line
      BufferedWriter writer = new BufferedWriter(new FileWriter("stocks.csv", true));
      writer.write(line);
      writer.newLine();
      writer.flush();

      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


/*
*search for the latest bid
*/
  public String latestBid(String symbol) {

    //String latest = null;
    String[] latest =new String[3];
    // latest[0] = "-1";

          try {
            reader = new BufferedReader(new FileReader(this.file_name));
            String line = reader.readLine();


          while ((line = reader.readLine()) !=null) {
                  List<String> list = Arrays.asList(line.split("\\s*,\\s*"));
                    if(list.get(0).equals(symbol)){                      
                      latest[0] = list.get(0);
                      latest[1] = list.get(1);
                      latest[2] = list.get(2);
                    }else{
                      continue;
                    }
          }
          reader.close();
          //return latest;
          String latestComma = String.join(",",latest);
          return latestComma;

      } catch (IOException e) {
        e.printStackTrace();
      }

      // String latestComma = String.join(",",latest);
      // return latestComma;
      return "-1";
  }


}
