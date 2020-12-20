/*
E/15/211-E/15/208
Department of Computer Engineering-UoP
Semester4-CO225
*/

import java.io.*;
import java.util.*;

public class Gui extends javax.swing.JFrame {

    private Map<String, String[]> stockList;

    public Gui() {
        initComponents();

        stockList = new HashMap<String, String[]>();//create hashmap for list
        String[] arr = new String[8];

        //to read the file line by line
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader("stocks.csv");//identify the file that we want to read
            reader = new BufferedReader(fileReader);//read the given csv file
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                //split into comma seperated fields
                String[] splitedLine = line.split("\\s*,\\s*");
                stockList.put(splitedLine[0], splitedLine);
            }
          reader.close();
          fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] symbols = {"FB","VRTU","MSFT","GOOGL","YHOO","XLNX","TSLA","TXN"};//create array for special items


    for( String  key : symbols){
        String [] item = stockList.get(key);
     jTextArea1.append(item[0]+" , "+item[1]+" , "+item[2]+"\n");//print item details in jTextArea in gui
    }
}

@SuppressWarnings("unchecked")
    public void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();//create JScrollPane for the text area
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);//set text area size
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//set window settings
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }


//main method
//public Gui(){
    public void main() {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                  }
            }
          } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);


          } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);


          } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);


          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);//display the gui
            }
        });
    }

    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;

}
