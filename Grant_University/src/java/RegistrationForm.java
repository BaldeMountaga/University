import javax.inject.Named;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import university.Studentcourse;
import university.Student;
import university.RegistrationHelper;

@Named("registrationForm")
@RequestScoped
public class RegistrationForm {
private String firstName;
private String lastName;
private String gender;
    private String address;
    private String contactNumber;
    private String emailID;
    private String userID;
    private String password;
    private String confirmPassword;
    private String FinalPassword;
    private Date dateofBirth;
    private String course;
    
    private String userIdError;
    
    public RegistrationForm() {
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserID() {
        return userID;
    }
    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    public String getFinalPassword() {
        return FinalPassword;
    }
    
    public void setFinalPassword(String FinalPassword) {
        this.FinalPassword = FinalPassword;
    }
    
    public String getUserIdError(){
        return userIdError;
    }
    
    public void setUserIdError (String userIdError){
        this.userIdError = userIdError;
    }
    
    public String getCourse(){
        return course;
    }
   
    public void setCourse(String course){
        this.course = course;
    }
    public String submitAction(){
        RegistrationHelper rghp = new RegistrationHelper();
        Student std = new Student();
        
        std.setFirstname(getFirstName().toString());
        std.setLastname(getLastName().toString());
        std.setGender(getGender().toString());
        std.setDob(getDateofBirth());
        std.setAddress(getAddress().toString());
        std.setPhone(getContactNumber().toString());
        std.setEmail(getEmailID().toString());
        std.setUserid(getUserID().toString());
        std.setPassword(getPassword().toString());
        
        
        Studentcourse sc = new Studentcourse();
        sc.setCourseid(getCourse().toString());
        String msg = rghp.insertStudent(std, sc);
        
        if(msg.equals("error")){
            setUserIdError("User Id already exists. Please select another User Id.");
            setUserID("");
            return "Registration";
        }
        else {
            return "Success";
        }
    }
    
    public void validateEmail(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        String email= (String)value;
        Pattern mask = null;
        mask = Pattern.compile(".+@.+\\.[a-z]+");
       Matcher matcher = mask.matcher(email);
        if (!matcher.matches())
         {
           FacesMessage message = new FacesMessage();
           message.setDetail("Invalid e-mail ID");
           message.setSummary("Invalid e-mail ID");
           throw new ValidatorException(message);
        }
    }
public void validateFinalPassword(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        setFinalPassword((String) value);
    }
    public void validateCPassword(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        String cPassword= (String)value;
        RegistrationForm rf=new RegistrationForm();
        System.out.println(getFinalPassword());
        if (cPassword.compareTo(getFinalPassword())!=0 )
         {
           FacesMessage message = new FacesMessage();
           message.setSummary("Password does not match");
           throw new ValidatorException(message);
        }
    }


}
