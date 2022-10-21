import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {


    public static void displayMainMenu(){
        System.out.println("<<<<< Welcome To Bus Company >>>>>");
        System.out.println("Press 1 for owner options");
        System.out.println("Press 2 for customer options");
        System.out.println("Press 3 to quit");
    }
    public static void main (String[]args) throws ParseException {

        Scanner input=new Scanner(System.in);
        ArrayList<Expedetion> expedetion = new ArrayList<Expedetion>();
        int[][]seats={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},
                {21,22,23,24},{25,26,27,28}};
        Random rand=new Random();
        int choice=0;
        boolean bool=true;
        while(bool){
            Expedetion expedition=new Expedetion();
            System.out.println();
            displayMainMenu();
            boolean a = true;
            do {
                try {
                    choice = Integer.parseInt(input.nextLine());
                    a = false;
                } catch (Exception exc) {
                    System.err.println("Enter a number (1,2,3)");
                }
            } while (a);
            switch (choice) {
                case 1:
                    Owner owner=new Owner();
                    System.out.println("Please enter owner password");
                    String pass=input.next();
                    if(pass.equals(owner.getPassword())) {
                        System.out.println("Press 1 to add expeditions");
                        System.out.println("Press 2 to delete expeditions");
                        System.out.println("Press 3 to determine profit for per seat,gasoline cost per km and driver salary");
                        int options=0;
                        boolean b = true;
                        do {
                            try {
                                options = Integer.parseInt(input.nextLine());
                                b= false;
                            } catch (Exception exc) {
                                System.err.println("Enter a number (1,2,3)");
                            }
                        } while (b);
                        if (options == 1) {
                            System.out.println("How many expeditions will you add?");
                            int iteration = input.nextInt();
                            for (int i = 0; i < iteration; i++) {
                                System.out.println("Please enter start point: ");
                                String startPoint = input.next();
                                System.out.println("Please enter destination: ");
                                String destin = input.next();
                                input.nextLine();
                                System.out.println("Please enter destination time and date in this format: \"hh:mm:ss a dd-MMM-yyyy\" ");
                                String dateTime = input.nextLine();
                                Expedetion expeditionReference = new Expedetion(startPoint, destin, dateTime);
                                expeditionReference.setDistance(startPoint, destin, dateTime);
                                expedetion.add(expeditionReference);
                                System.out.println();
                            }
                        } else if (options == 2) {
                            for (int i = 0; i < expedetion.size(); i++) {
                                System.out.println(i + ".");
                                expedetion.get(i).displayExpeditions();
                            }

                            System.out.println("Please enter the number of the expedition you want to delete");
                            int index = input.nextInt();
                            System.out.println(index + " . expedition has deleted");
                            expedetion.remove(index);
                        } else if (options == 3) {

                            System.out.println("Enter the profit you want for per seat");

                            double prof = input.nextDouble();
                            expedition.setProfit(prof);
                            System.out.println("Enter the gasoline cost");
                            double gas = input.nextDouble();
                            System.out.println("Enter the driver salary");
                            double salary = input.nextDouble();
                            for (int i = 0; i < expedetion.size(); i++) {
                                expedetion.get(i).calculateTicketPrice(gas, salary, prof);
                            }
                        }
                    }
                    else{
                        System.out.println("You've entered wrong password please try again");
                    }

                    break;
                case 2:
                    System.out.println("Press 1 to purchase bus ticket");
                    System.out.println("Press 2 to delete your ticket");
                    int optionsCustomer = 0;
                    boolean c = true;
                    do {
                        try {
                            optionsCustomer = Integer.parseInt(input.nextLine());
                            c= false;
                        } catch (Exception exc) {
                            System.err.println("Enter a number (1,2,3)");
                        }
                    } while (c);
                    if(optionsCustomer==1){
                        for (int i = 0; i < expedetion.size(); i++) {
                            System.out.println(i+".");
                            expedetion.get(i).displayExpeditions();
                        }
                        System.out.println("Which expedition you want to choose please enter its number ");
                        int index2=input.nextInt();
                        expedetion.get(index2).printSeats(seats);
                        System.out.println("Now please enter seat number you want to reserve");
                        int reserve=input.nextInt();
                        expedetion.get(index2).setReserve(reserve);
                        int row=0;
                        int column=0;
                        for(int i=0;i<seats.length;i++){
                            for(int j=0;j<seats[i].length;j++) {
                                if (seats[i][j] == reserve){
                                    seats[i][j]=0;
                                    System.out.println("YOUR SEAT IS RESERVED: ");
                                    expedetion.get(index2).printSeats(seats);
                                }
                            }
                        }
                        System.out.println("Press 1 to pay the bill");
                        int paying=input.nextInt();
                        if(paying==1){
                            System.out.println("Thank you for purchase");
                            int ID=rand.nextInt(2000);
                            Customer customer=new Customer();
                            expedetion.get(index2).setID(ID);
                            System.out.println("Your Customer ID is: "+ID);
                            System.out.println("Please save your ID in case of deleting your order");

                        }
                    }
                    else if(optionsCustomer==2) {
                        //DELETE PROCESS
                        System.out.println("Please enter your customer ID");
                        int inputID = input.nextInt();


                        int order = 0;
                        for (int i = 0; i < expedetion.size(); i++) {
                            if (expedetion.get(i).getCustomerID() == inputID) {
                                order = i;
                            }

                        }




                        if (DateTime.formatDate(expedetion.get(order).getTime())) {
                            System.out.println("HERE IS YOUR TICKET INFORMATION");
                            expedetion.get(order).displayExpeditions();
                            expedetion.get(order).printSeats(seats);
                            System.out.println("Press 1 to delete");
                            int del = input.nextInt();
                            if (del == 1) {
                                for (int i = 0; i < expedetion.size(); i++) {
                                    if (expedetion.get(i).getCustomerID() == inputID) {
                                        order = i;
                                    }
                                }
                                System.out.println("What was your seat number?");
                                int no = input.nextInt();
                                if(no==28) {
                                    seats[6][3] = 28;
                                    System.out.println("YOUR SEAT IS DELETED:");
                                }
                                for (int i = 0; i < seats.length; i++) {
                                    for (int j = 0; j < seats[i].length; j++) {
                                        if (no + 1 == seats[i][j]) {
                                            if((no+1)%4==1){
                                                seats[i-1][j +3] = expedetion.get(order).getReserve();
                                                System.out.println("YOUR SEAT IS DELETED: ");
                                            }
                                            else {
                                                seats[i][j - 1] = expedetion.get(order).getReserve();
                                                System.out.println("YOUR SEAT IS DELETED: ");
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        else{
                            System.out.println("Sorry it is too late to delete :( ");
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}

