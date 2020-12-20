/*
E/15/211-E/15/208
Department of Computer Engineering-UoP
Semester4-CO225
*/

import java.io.*;
import java.util.*;

public class Stock {

  BufferedReader reader = null;
  String file_name = "";

  //constructor
	public Stock(String file_name){
    this.file_name = file_name;
  }


  //get the ietm details relevant to the symbolentered by the Client
  public String getitem(String symbol) {

    String[] stockItem =new String[2];

					try {
					// read the given file line by line
						reader = new BufferedReader(new FileReader(this.file_name));
						String line = reader.readLine();

					  while ((line = reader.readLine()) !=null) {
    						//split the string line into comma seperated fields
    		          List<String> list = Arrays.asList(line.split("\\s*,\\s*"));

    		          if(list.get(0).equals(symbol)){
                      stockItem[0] = list.get(0);
                      stockItem[1] = list.get(1);
                  }else{
                    continue;
                  }
		      }
          reader.close();

          //make the array 'stockItem' to a string
          String comma = String.join(",",stockItem);
          return comma;


    			} catch (IOException e) {
    				e.printStackTrace();
    			}

          return "-1";
	}


  //see the presence or absence ofhe item of the symbol entered by the client
  public String finditem(String symbol) {
          try {
          // read the given file line by line
            reader = new BufferedReader(new FileReader(this.file_name));
            String line = reader.readLine();

            while ((line = reader.readLine()) !=null) {
                //split the string line into comma seperated fields
                  List<String> list = Arrays.asList(line.split("\\s*,\\s*"));

                  if(list.get(0).equals(symbol)){
                    return list.get(0);
                  }else{
                    continue;
                  }
          }
          reader.close();

          } catch (IOException e) {
            e.printStackTrace();
          }
          return "-1";
  }


}
