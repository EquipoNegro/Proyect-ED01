/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect.ed01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Salvador
 */
public class ProyectED01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //SETUP
        //Movie definitions, these serve as placeholders, and are added to a catalog array.
        //These will be later used to store the movie total attendance rates.
        Movie[] catalog = new Movie[15];
        catalog[0] =new Movie("The Shining");
        catalog[1]= new Movie("IT");
        catalog[2] = new Movie("Rings");
        catalog[3] = new Movie("Zootopia");
        catalog[4] = new Movie("Black Swan");
        catalog[5] = new Movie("UP");
        catalog[6] = new Movie("Finding Dory");
        catalog[7] = new Movie("Inferno");
        catalog[8] = new Movie("50 first dates");
        catalog[9] = new Movie("Beauty and the Beast");
        catalog[10] = new Movie("Interstellar");
        catalog[11] = new Movie("Alien : Covenant");
        catalog[12] = new Movie("Mimi");
        catalog[13] = new Movie("The mummy");
        catalog[14] = new Movie("I, Robot");
        //Room definitions
        //Much like the movies, these are predefined and will contain a list that contains movies.
        Room[] rooms = new Room[7];
        rooms[0] = new Room("A");
        rooms[1] = new Room("B");
        rooms[2] = new Room("C");
        rooms[3] = new Room("D");
        rooms[4] = new Room("E");
        rooms[5] = new Room("F");
        rooms[6] = new Room("G");
        //This will play all of the movies in all of the rooms, with attendance being randomized
        for (Room room : rooms) //Iterating over the array...
        {
            catalog = room.playMovies(catalog); //Actually generating the movie attendances in the rooms.
        }
        //Cinema class
        //Contains a list of rooms that contain lists of movies.
        Cinema cinemex = new Cinema();
        //Fills up the list of rooms with the predefined arrays.
        cinemex.setRooms(rooms);
        //MENU loops for as long as the user wants to use the program
        boolean flag = true; //Uses this flag to determine wether the user wants to keep going or stop the program.
        boolean intFlag = false;
        do
        {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            //Printing options
            System.out.println("------------- Welcome to Cinemex's ticket office -------------");
            System.out.println("Please select an option:");
            System.out.println("1) Get the tickets bought to a specific movie");
            System.out.println("2) Get the movies displayed in a specific room");
            System.out.println("3) Get the most watched movie - room combination");
            System.out.println("4) Get the most watched movie cinema-wide");
            int n=0;
            try
            {
                n = reader.nextInt(); reader.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Only numbers are valid! Please enter a number.");
            }
            //options...
            switch (n)
            {
                case 1:
                    System.out.println("Which movie do you want to display?");
                    String st = reader.nextLine();
                    flag = MovieMenu(st, catalog);
                    break;
                case 2:
                    System.out.println("In which room?");
                    String s = reader.nextLine();
                    s = String.valueOf(s.charAt(0));
                    flag = RoomMenu(s,rooms);
                    break;
                case 3:
                    cinemex.printBestRoomsM();
                    flag = returnMenu();
                    break;
                case 4:
                    cinemex.printBestMovie(catalog);
                    flag = returnMenu();
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    flag = true;
                    break;
            }        
        }
        while(flag==true); 
    }
    public static boolean MovieMenu(String movie, Movie[]catalog)
    {
        for(int i=0;i<catalog.length;i++)
        {
            if(catalog[i].getName().equals(movie))
            {
                System.out.println("The movie "+catalog[i].getName()
                +" had "+catalog[i].getAttendance()+" total tickets bought");
                return returnMenu();
            }
        }
        System.out.println("The movie "+movie+" couldn't be found");
        return returnMenu();
    }
    public static boolean RoomMenu(String c, Room [] rooms)
    {
        for(int i=0;i<rooms.length;i++)
        {
            if(rooms[i].getCode().equals(c))
            {
                System.out.println("Room "+rooms[i].getCode());
                for(int j=0;j<rooms[i].movies.length;j++)
                {
                    System.out.println("The movie "+rooms[i].movies[j].getName()
                    +" had "+rooms[i].movies[j].getAttendance()+" tickets bought");
                }
                return returnMenu();
            }
            else
            {
                System.out.println("The room "+c+" couldn't be found");
            }
        }
        return returnMenu();
    }
    public static boolean returnMenu()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Do you want to go back to the menu?");
        System.out.println("Type Y or y if yes");
        System.out.println("Type anything else to end the program");
        String s = reader.nextLine();
        s = String.valueOf(s.charAt(0));
        if(s.equals("Y")||s.equals("y"))
        {
            return true;
        }
        return false;
    }
}
