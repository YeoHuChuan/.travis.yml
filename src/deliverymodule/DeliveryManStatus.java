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
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DeliveryManStatus {

    public static void main(String[] args) {

        ArrayList<DeliveryMan> deliveryMen = new ArrayList<DeliveryMan>();
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        try {
            FileReader inputFile = new FileReader("DeliveryMen.txt");
            try {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine()) {
                    String line = parser.nextLine();

                    String[] att = line.split(",");
                    int foo = Integer.parseInt(att[0]);

                    deliveryMen.add(new DeliveryMan(foo, att[1], att[2], att[3]));
                }

            } finally {
                inputFile.close();
            }
        } catch (FileNotFoundException exception) {

        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occured.");
        }

//        deliveryMen.add(new DeliveryMan(1001, "Reid", "abc123"));
//        deliveryMen.add(new DeliveryMan(1002, "Farach", "abc456"));
//        deliveryMen.add(new DeliveryMan(1003, "Meredy", "abc789"));
        System.out.println(date);
        int choice;
        System.out.print("Please enter your Delivery Man Id : ");
        int deliveryId = scanner.nextInt();

        System.out.print("Please enter your password : ");
        String password = scanner.next();

        DeliveryMan user = checkPassword(deliveryMen, deliveryId, password);

        System.out.println("Delivery Man Id : " + user.getDeliveryId());
        System.out.println("Delivery Man Name : " + user.getDeliveryName());
        System.out.println("Your Status : " + user.getStatus());

        do {
            choice = menu();

            if (choice == 5) {
                File realName = new File("DeliveryMen.txt");
                realName.delete();
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DeliveryMen.txt", true)));

                    String status = status();
                    for (int i = 0; i < deliveryMen.size(); i++) {
                        if (user.getDeliveryId() == deliveryMen.get(i).getDeliveryId()) {
                            deliveryMen.get(i).setStatus(status);

                        }
                        out.println(deliveryMen.get(i).getDeliveryId() + "," + deliveryMen.get(i).getDeliveryName() + "," + deliveryMen.get(i).getPassword() + "," + deliveryMen.get(i).getStatus());
                    }
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } while (choice != 5);
    }

    public static DeliveryMan checkPassword(ArrayList<DeliveryMan> deliveryMen, int deliveryId, String password) {

        DeliveryMan user = new DeliveryMan();

        for (int i = 0; i < deliveryMen.size(); i++) {

            if (deliveryMen.get(i).getDeliveryId() == deliveryId && deliveryMen.get(i).getPassword().equals(password)) {

                user = deliveryMen.get(i);
            }

        }

        return user;
    }

    public static int menu() {

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Clock In");
        System.out.println("2. Clock out");
        System.out.println("3. Logout");
        System.out.println("4. Record");
        System.out.println("5. Change Status");
        System.out.print("choice :");
        choice = scanner.nextInt();
        return choice;
    }

    public static String status() {

        int status;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Avaliable");
            System.out.println("2. Delivery");
            System.out.println("3. break");
            System.out.print("Status :");

            status = scanner.nextInt();
        } while (status > 3);

        

            if (status == 1) {
                return "Avaliable";
            } else if (status == 2) {
                return "Delivery";
            } else if (status == 3) {
                return "break";
            }
        

        return "Avaliable";
    }

    public static void goBack() {
        String[] args = {};

        main(args);
    }

}
