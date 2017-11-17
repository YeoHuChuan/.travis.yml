/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymodule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DeliveryModule {
    
    public static ArrayList<DeliveryRecord> deliveryRecords = new ArrayList<DeliveryRecord>();
    public static ArrayList<DeliveryMan> deliveryMen = new ArrayList<DeliveryMan>();
        
       
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
        Date date = new Date();
        
        deliveryMen.add(new DeliveryMan(1001, "Reid", "abc123"));
        deliveryMen.add(new DeliveryMan(1002, "Farach", "abc456"));
        deliveryMen.add(new DeliveryMan(1003, "Meredy", "abc789"));
        int choice;
        
        System.out.println(date);
        
        System.out.print("Please enter your Delivery Man Id : ");
        int deliveryId = scanner.nextInt();
        
        System.out.print("Please enter your password : ");
        String password = scanner.next();
        
        boolean user = checkPassword(deliveryMen, deliveryId, password);
        
        if(user == true) {
            
            do {
                choice = menu();
                
                if (choice == 1) {
                    
                    for (int i = 0 ; i < deliveryMen.size() ; i++) {
           
                        if (deliveryMen.get(i).getDeliveryId() == deliveryId) { 
                            
                           
                                
                                deliveryRecords.add(new DeliveryRecord(deliveryMen.get(i), date, null));
                                System.out.println("clock in success");    
                                goBack();
          
                        }
                    }
                }
                    
                
                else if(choice == 2) {
                    
                    for (int i = 0 ; i < deliveryMen.size() ; i++) {
           
                        if (deliveryMen.get(i).getDeliveryId() == deliveryId) { 
              
                            for (int j = 0 ; j < deliveryRecords.size() ; j++) { 

                                if (deliveryRecords.get(j).getDeliveryMan().getDeliveryId() == deliveryMen.get(i).getDeliveryId() && deliveryRecords.get(j).getClockOut() == null) {
                                    deliveryRecords.get(j).setClockOut(date);
                                    System.out.println("clock out success");    
                                    goBack();
                                }
                                
                            }
                            System.out.println("Please clock in first");
                            goBack();
                        }
                    }
                }
                
                else if(choice == 3) {
                    System.out.println("The account logout");
                    goBack();
                }
                
                else if(choice == 4) {
                    
                    for (int i = 0 ; i < deliveryRecords.size() ; i++) {
                        
                        System.out.println("\nStaff ID :" + deliveryRecords.get(i).getDeliveryMan().getDeliveryId() +"\nStaff Name" + deliveryRecords.get(i).getDeliveryMan().getDeliveryName() + 
                                "\nClock in :" + deliveryRecords.get(i).getClockIn() + "\nClock out :" + deliveryRecords.get(i).getClockOut());
                        
                    }
                   
                    
                }
                else {
                    System.out.println("Please enter 1 or 2");
                }
                
            } while(choice > 4);
        } 
        else if(user == false) {
            goBack();
        }

       
    }
    
    public static int menu() {
        
        int choice;
        
        System.out.println("1. Clock In");
        System.out.println("2. Clock out");
        System.out.println("3. Logout");
        System.out.println("4. Record");
        System.out.print("choice :");
        choice = scanner.nextInt();
        return choice;
    }
    
    public static boolean checkPassword(ArrayList<DeliveryMan> deliveryMen, int deliveryId, String password) {
        
    
        for (int i = 0 ; i < deliveryMen.size() ; i++) {
           
            if (deliveryMen.get(i).getDeliveryId() == deliveryId && deliveryMen.get(i).getPassword().equals(password)) {
               
               return true;
               
                
            }
            
            
        }
        
        return false;
    }
 
    public static void goBack() {
       String[] args = {};
    
       main(args);
    }
}
