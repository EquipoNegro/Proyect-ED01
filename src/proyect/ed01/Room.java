/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect.ed01;

import java.util.*;

/**
 *
 * @author Salvador
 */
public class Room 
{
    private String code;
    private ArrayList <Movie> movies;

    public Room(String code) 
    {
        this.code = code;
        movies = new ArrayList<>();
    }

    public String getCode() 
    {
        return code;
    }
    public ArrayList <Movie> getMovies()
    {
        return movies;
    }
    public Movie getMovie(int index)
    {
        return movies.get(index);
    }
    public void setCode(String code) 
    {
        this.code = code;
    }
    
    public int playMovie(Movie mov)
    {
        Random r = new Random();
        int Low = 10;
        int High = 100;
        int Result = r.nextInt(High-Low) + Low;
        Movie dummy = new Movie(mov.getName());
        dummy.setAttendance(Result);
        System.out.println("The movie "+dummy.getName()+" was played at the room: "+this.code+" with "+dummy.getAttendance()+" tickets bought");
        movies.add(dummy);
        sort(0,movies.size()-1);
        return Result;
    }
    public void sort(int start, int end)
    {
        int left = start +1;
        int right =  end;
        int pivot = start;
        int pivotV=this.movies.get(start).getAttendance();
        while(left <= right) //while the start and end don't cross
        {
            //Moves throughout the vector comparing the values with the pivot, moving one by one, forwards or backwards
            while(left <= end && pivotV >=movies.get(left).getAttendance())
            {
                left++;
            }
            while(right > start && pivotV < movies.get(right).getAttendance())
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
        Movie tmp=movies.get(p1);
        movies.set(p1,movies.get(p2));
        movies.set(p2,tmp);

    }
    public Movie getMostWatchedMovie()
    {
        return movies.get(movies.size()-1);
    }
    
}
