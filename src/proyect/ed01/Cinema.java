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
public class Cinema 
{
    private Room[] rooms;
    
    public Cinema()
    {
        rooms = new Room[7];
    }
    public void setRooms(Room [] rooms)
    {
        this.rooms = rooms;
    }

    public void printBestRoomsM()
    {
        for(int i=0;i<rooms.length;i++)
        {
            System.out.println(rooms[i].getMostWatchedMovie());
        }
    }
    public void printBestMovie(Movie[] catalog)
    {
        Movie tmpMovie = new Movie("dummy",0);
        for (int i=0;i<rooms.length-1;i++)
        {
            for(int j=0;j<catalog.length-1;j++)
            {
                if(catalog[j].getAttendance() > tmpMovie.getAttendance())
                {
                    tmpMovie = catalog[j];
                }
            }
        }
        System.out.println("The most watched movie is "+tmpMovie.getName()+" with "+tmpMovie.getAttendance()+" attendees");
    }
}
