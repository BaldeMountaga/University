
package university;

public class Studentcourse implements java.io.Serializable {
    private int registrationnumber;
    private String courseid;
    
    public Studentcourse(){  
    }
    
    public Studentcourse(int registrationnumber) {
        this.registrationnumber = registrationnumber;
    }
    
    public Studentcourse( int registrationnumber, String courseid){
        this.registrationnumber = registrationnumber;
        this.courseid= courseid;
    }
    
    public int getRegistrationnumber(){
        return this.registrationnumber;
    }
    
    public void setRegistrationnumber(int registrationnumber){
        this.registrationnumber = registrationnumber;
    }
    
    public String getCourseid(){
        return this.courseid;
    }
    
    public void setCourseid(String courseid){
        this.courseid = courseid;
    }
}
