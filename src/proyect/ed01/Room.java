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
    public Movie[] movies;

    public Room(String code) 
    {
        this.code = code;
        this.movies = new Movie[15];
    }

    public String getCode() 
    {
        return code;
    }
    public Movie[] getMovies()
    {
        return movies;
    }
    public Movie getMovie(int index)
    {
        return movies[index];
    }
    public void setCode(String code) 
    {
        this.code = code;
    }
    
    public Movie[] playMovies(Movie [] catalog)
    {
        for(int i=0;i<catalog.length;i++)
        {
            this.movies[i] = new Movie(catalog[i].getName());
        }
        Random r = new Random();
        int Low = 10;
        int High = 100;
        for(int i=0;i<catalog.length;i++)
        {
            int Result = r.nextInt(High-Low) + Low;
            this.movies[i].setAttendance(Result);
            catalog[i].addTotalViews(Result);
        }
        return catalog;
    }
    public String getMostWatchedMovie()
    {
        int tmp=0;
        for(int i = 0; i<movies.length;i++)
        {
            if(movies[i].getAttendance()>tmp)
            {
                tmp = movies[i].getAttendance();
            }
        }
        for(int i = 0; i<movies.length;i++)
        {
            if(movies[i].getAttendance()==tmp)
            {
                return"The most watched movie ("+this.movies[i].getName()+ ") in the room "+this.code+" had "+
                        movies[i].getAttendance()+" attendants";
            }
        }
        return "There are no movies being played right now";
    }
}
