package timetablegenerator;


public class Course
{
    public final int FIRST_SEMSTER=1;
    public final int SECOND_SEMSTER=2;
    private String name;
    private String courseCode;
    private int semester;
    private int level;
    private int units;
    
    
    public Course(String name,String courseCode,int semester,int level,int units)
    {
        this.name=name;
        this.courseCode=courseCode;
        this.semester=semester;
        this.level=level;
        this.units=units;
    }
    public int getUnits()
    {
        return units;
    }
    
    public void setUnits(int units)
    {
        this.units=units;
    }
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
   
    public String getCourseCode()
    {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode)
    {
        this.courseCode=courseCode;
    }
    
    public int getSemester()
    {
        return semester;
    }
    
    public void setSemester(int semester)
    {
        this.semester=semester;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setLevel(int level)
    {
        this.level=level;
    }
    
    
    // saves the course object to memory
    public void save()
    {
        
    }
    
    
    //deletes the course object from memory
    public void delete()
    {
        
    }
}
