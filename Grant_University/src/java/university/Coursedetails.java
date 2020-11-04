
package university;

public class Coursedetails implements java.io.Serializable {
    private String courseid, coursename, courseduration, courseeligibility, coursefee;
    
    public Coursedetails(){    
    }
    public Coursedetails (String courseid){
        this.courseid = courseid;
    }
    
    public Coursedetails (String courseid, String coursename, String courseduration, String courseeligibility, String coursefee){
        this.courseid = courseid;
        this.coursename = coursename;
        this.courseduration = courseduration;
        this.courseeligibility = courseeligibility;
        this.coursefee = coursefee;
    }
    
    public String getCourseid(){
        return this.courseid;
    }
    public void setCourseid(String courseid){
        this.courseid = courseid;
    }
    
    public String getCoursename(){
        return this.coursename;
    }
    public void setCoursename(String coursename){
        this.coursename = coursename; 
    }
    
    public String getCourseduration(){
        return this.courseduration;
    }
    public void setCourseduration(String courseduration){
        this.courseduration = courseduration; 
    }
    
    public String getCourseeligibility(){
        return this.courseeligibility;
    }
    public void setCourseeligibility(String courseeligibility){
        this.courseeligibility = courseeligibility; 
    }
    
    public String getCoursefee(){
        return this.coursefee;
    }
    public void setCoursefee(String coursefee){
        this.coursefee = coursefee; 
    }
}
