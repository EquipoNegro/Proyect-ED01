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
public class Movie 
{
    private String name;
    private int attendance = 0;
    
    public Movie(String name)
    {
        this.name= name;
    }
    public Movie(String name, int attendance)
    {
        this.name= name;
        this.attendance=attendance;
    }
    public int getAttendance() 
    {
        return attendance;
    }

    public void setAttendance(int attendance) 
    {
        this.attendance = attendance;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void addTotalViews(int views)
    {
        this.attendance +=views;
    }
    @Override
    public String toString() 
    {
        return "Movie ["  + name +", attendance=" +this.attendance+ ']';
    }
    
}
