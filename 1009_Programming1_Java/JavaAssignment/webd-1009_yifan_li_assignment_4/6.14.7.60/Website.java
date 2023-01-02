/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1 Module4
 * Created: 2022-10-27
 * Updated: 2022-10-28
 */  

import java.util.Scanner;

public class Website {
    public static void main(String[] args) {


        int count = 0;
        String website;

        Scanner keyboard = new Scanner(System.in);


        do{
            System.out.println("Please enter a website URL(e.g. www.rrc.ca):");
            website = keyboard.nextLine().toLowerCase();

            if(website.endsWith(".com")){
                count++;
            }

            //ignore  "stop" case sensitive
        } while (!website.equalsIgnoreCase("stop"));


        System.out.printf("There were %d commercial websites entered.", count);

        
     }

 }

