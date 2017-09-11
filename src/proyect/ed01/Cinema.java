/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect.ed01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salvador
 */
public class Cinema 
{
    private List <Room> rooms;
    
    public Cinema()
    {
        rooms = new ArrayList <> ();
    }
    public void addRoom(Room room)
    {
        rooms.add(room);
    }
    public void sort(int start, int end)
    {
        int left = start +1;
        int right =  end;
        int pivot = start;
        int pivotV=rooms.get(start).getMostWatchedMovie().getAttendance();
        while(left <= right) //while the start and end don't cross
        {
            //Moves throughout the vector comparing the values with the pivot, moving one by one, forwards or backwards
            while(left <= end && pivotV >=rooms.get(left).getMostWatchedMovie().getAttendance())
            {
                left++;
            }
            while(right > start && pivotV < rooms.get(right).getMostWatchedMovie().getAttendance())
            {
                right--;
            }
            if(left < right)
            {
                swap(left,right); //Uses the swap function to exchange the values
                left++;right--;
            }
        }
        swap(pivot, left-1);
        //Uses recursivity to sort all of the values set by set
        //Uses recursivity to sort all of the values set by set
        if(start<right-1)
        {
            sort(start, right-1);
        }
        if(left < end)
        {
            sort(right+1, end);
        }
    }
    public void swap(int p1, int p2) //function used to switch two values in this class's array.
    {
        Room tmp=rooms.get(p1);
        rooms.set(p1,rooms.get(p2));
        rooms.set(p2,tmp);
    }
    public void getBestRM()
    {
        sort(0, rooms.size() -1);
        System.out.println("The most watched movie is "+rooms.get(rooms.size()-1).getMostWatchedMovie().getName()+" in the room "+rooms.get(rooms.size()-1).getCode()+" with "+rooms.get(rooms.size()-1).getMostWatchedMovie().getAttendance());
    }
    public void getBestMovie()
    {
        sort(0, rooms.size() -1);
        Movie tmp = new Movie("Dummy movie");
        int totalViews = 0;
        int index = 0;
        for(int i=0;i<rooms.size();i++)
        {
            for(int j=0;j<rooms.get(i).getMovies().size();j++)
            {
                index = secuentialSearch(rooms.get(i).getMovies(),rooms.get(i).getMovie(j).getName());
                if(index != 1)
                {
                    totalViews += rooms.get(i).getMovie(index).getAttendance();
                }
            }
            if(tmp.getAttendance()<=totalViews)
            {
                tmp = rooms.get(i).getMovie(index);
            }
        }
    }
    public int secuentialSearch(ArrayList<Movie> mov, String movieTitle)
    {
        for(int i=0;i<mov.size()-1;i++) //Searches manually through all of the items in the vector
        {
            if(mov.get(i).getName().equals(movieTitle))
            {
                return i;
            }
        }
        return -1;
    }
}
