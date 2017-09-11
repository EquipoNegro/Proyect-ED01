/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect.ed01;

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
        //Movie definitions, these only serve as place-holders and have no attendance in them.
        //This is useful if there's a case where the same movie is played in two different rooms.
        Movie m1 = new Movie("The Shining");
        Movie m2 = new Movie("IT");
        Movie m3 = new Movie("Rings");
        Movie m4 = new Movie("Zootopia");
        Movie m5 = new Movie("Black Swan");
        Movie m6 = new Movie("UP");
        Movie m7 = new Movie("Finding Dory");
        Movie m8 = new Movie("Inferno");
        Movie m9 = new Movie("50 first dates");
        Movie m10 = new Movie("Beauty and the Beast");
        Movie m11 = new Movie("Interstellar");
        Movie m12 = new Movie("Alien : Covenant");
        Movie m13 = new Movie("Mimi");
        Movie m14 = new Movie("The mummy");
        Movie m15 = new Movie("I, Robot");
        //Room definitions
        Room r1 = new Room("A");
        Room r2 = new Room("B");
        Room r3 = new Room("C");
        Room r4 = new Room("D");
        Room r5 = new Room("E");
        Room r6 = new Room("F");
        Room r7 = new Room("G");
        
        m1.addTotalViews(r1.playMovie(m1));
        m2.addTotalViews(r1.playMovie(m2));
        m3.addTotalViews(r1.playMovie(m3));
        m3.addTotalViews(r2.playMovie(m3));
        m4.addTotalViews(r2.playMovie(m4));
        m2.addTotalViews(r2.playMovie(m2));
        m15.addTotalViews(r3.playMovie(m15));
        m5.addTotalViews(r3.playMovie(m5));
        m12.addTotalViews(r4.playMovie(m12));
        Cinema cinemex = new Cinema();
        cinemex.addRoom(r1);
        cinemex.addRoom(r2);
        cinemex.getBestRM();
    }
    
}
