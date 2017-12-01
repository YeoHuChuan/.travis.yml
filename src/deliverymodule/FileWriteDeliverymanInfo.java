/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymodule;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author B1
 */
public class FileWriteDeliverymanInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<DeliveryMan> deliveryMen = new ArrayList<DeliveryMan>();
        deliveryMen.add(new DeliveryMan(1001, "Reid", "abc123"));
        deliveryMen.add(new DeliveryMan(1002, "Farach", "abc456"));
        deliveryMen.add(new DeliveryMan(1003, "Meredy", "abc789"));
        File realName = new File("DeliveryMen.txt");
        realName.delete();
        
        
            
            try {
               PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DeliveryMen.txt", true)));
               for (int i = 0 ; i < deliveryMen.size() ; i++) {
                  out.println(deliveryMen.get(i).getDeliveryId() + "," + deliveryMen.get(i).getDeliveryName() + "," + deliveryMen.get(i).getPassword() + "," + deliveryMen.get(i).getStatus());
              }
              out.close();
         } catch (IOException e) {
              e.printStackTrace();
           }
    }
//        try
//{
//	FileReader inputFile = new FileReader("DeliveryMen.txt");
//    try
//    {
//    	Scanner parser = new Scanner(inputFile);
//        while (parser.hasNextLine())
//        {
//		String line = parser.nextLine();
//	        
//		 String[] att = line.split(",");
//                 if (att[0].equals("1002")) {
//                     System.out.println(att[0]);
//                 }
//		    System.out.println(att[0]);
//			System.out.println(att[1]);
//			System.out.println(att[2]);
//                
//                 
//        }
//                
//    }
//    finally
//    {
//    	inputFile.close();
//    }
//    }
//    catch(FileNotFoundException exception)
//    {
//
//    }
//    catch(IOException exception)
//    {
//            System.out.println("Unexpected I/O error occured.");
//    }
//            }
        }
    

