package timetablegenerator;
import java.util.*;


public class Department
{
    private String name;
    private int level;
    private final ArrayList<Course> coursesOffered;
    private final ArrayList<Venue> venuesAvailableToDepartment; 
    
    public Department(String name,int level)
    {
        this.name=name;
        this.level=level;
        coursesOffered=new ArrayList<>();
        venuesAvailableToDepartment=new ArrayList<>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setLevel(int level)
    {
        this.level=level;
    }
    
    public ArrayList<Course> getCoursesOffered()
    {
        return coursesOffered;
    }
    
    public ArrayList<Venue> getVenuesAvailableToDepartment()
    {
        return venuesAvailableToDepartment;
    }
}
