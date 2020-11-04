import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import university.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestScoped
@Named("courseDetailsBean")
public class CourseDetailsBean
{
    private String CourseName;
    private HtmlOutputText CourseId, CourseDuration, CourseEligibility, CourseFee;  
    
    public CourseDetailsBean() {    }
    public void CourseDetailsAction(ValueChangeEvent vce)
    {
        
        String cName = vce.getNewValue().toString();
        StringBuilder  cID = new StringBuilder();
        StringBuilder cDuration = new StringBuilder();
        StringBuilder  cEligibility = new StringBuilder();
        StringBuilder cFee = new StringBuilder();
        performLookup (cID, cName, cDuration, cEligibility, cFee);
        
        getCourseId().setValue(cID.toString());
        getCourseDuration().setValue(cDuration.toString());
        getCourseEligibility().setValue(cEligibility.toString());
        getCourseFee().setValue(cFee.toString());
    }
    
    void performLookup(StringBuilder cID, String cName, StringBuilder cDuration, 
                StringBuilder cEligibility, StringBuilder cFee)
    {
        CourseHelper helper = new CourseHelper();
        List <Coursedetails> courses = new ArrayList<Coursedetails>();
        courses = helper.getcourseByName(cName);
        Iterator iterator;
        iterator = courses.iterator();
        
        while(iterator.hasNext()){
            course = (Coursedetails)iterator.next();
        }
        cID.append(course.getCourseid().toString());
        cDuration.append(course.getCourseduration().toString());
        cEligibility.append(course.getCourseeligibility().toString());
        cFee.append(course.getCoursefee().toString());
    }
     
    public String getCourseName()
    {
        return CourseName;
    }
    public void setCourseName(String CourseName)
    {
        this.CourseName = CourseName;
    }
    public HtmlOutputText getCourseId()
    {
        return CourseId;
    }
    public void setCourseId(HtmlOutputText CourseId)
    {
        this.CourseId = CourseId;
    }
    public HtmlOutputText getCourseDuration()
    {
        return CourseDuration;
    }
    public void setCourseDuration(HtmlOutputText CourseDuration)
    {
        this.CourseDuration = CourseDuration;
    }
    public HtmlOutputText getCourseEligibility()
    {
        return CourseEligibility;
    }
    public void setCourseEligibility(HtmlOutputText       
    CourseEligibility)
    {
        this.CourseEligibility = CourseEligibility;
    }
    public HtmlOutputText getCourseFee()
    {
        return CourseFee;
    }
    public void setCourseFee(HtmlOutputText CourseFee)
    {
        this.CourseFee = CourseFee;
    }
    Coursedetails course = new Coursedetails();
}


