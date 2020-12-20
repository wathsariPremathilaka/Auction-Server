# Auction-Server
Auction Server

FILES INCLUDED:-

-App.java
-Server.java
-Stock.java
-Bid.java
-Gui.java
-stocks.csv


RUNNING AND COMPILING PROCESS:-

1.Put all the files(App.java,Server.java,Stock.java,Bid.java,Gui.java) including specially stocks.csv file, into one folder
2.Compile all the java files
3.Run App.java file
4.Open nc Command line and enter >> nc <ip address> 2000
5.Enter the details as the command line requests and carry the bidding process


Here,
App.java class includes the main method and create the server connection with the other files.And make the combination between server and the socket with localhost port 2000.
Server.java is used to create socket connetion in reading input file,stocks.csv  and make the combination with client and the server.
Bid.java file is used to add new bid values which is bid by the clients and update all the informations that the client provides (client's name,time etc).And can find the latest bid of of each Symbol.
From Stock.java file we can get comma seperated file and then we can find whether the Symbol that client is going to bid is valid or not valid by searching the csv file.
Gui.java file display updated details of special set of items while client is in the process.
The file stocks.csv is included initial bid values of bid items.From this file we can get known Symbol,Name and Prices of all items. And when any client is bid,the file is updated. 



 
 

