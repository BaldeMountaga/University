import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import university.BeanHelper;
import university.Student;


@ApplicationScoped
@Named("bean")
public class Bean {
    private String ID;
    private String PASS;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String address;
    private String phoneNumber;
    private String emailID;
    Student std = new Student();
 /** Creates a new instance of Bean */
    public Bean() {
    }
public String Action() {   
    
    StringBuilder fName = new StringBuilder();
    StringBuilder lName = new StringBuilder();
    StringBuilder gndr = new StringBuilder();
    StringBuilder db = new StringBuilder();
    StringBuilder add= new StringBuilder();
    StringBuilder ph = new StringBuilder();
    StringBuilder email = new StringBuilder();
    BeanHelper bhp = new BeanHelper();
    String uname = getID();
    String pass = getPASS();
    boolean b = false;
    List<Student> students = new ArrayList<Student>();
    students=bhp.getStudent();
    for(Iterator it =students.iterator();it.hasNext();)
    {
        std=(Student)it.next();
        if((std.getUserid().toString().equals(uname))&&(std.getPassword().toString().equals(pass)))
        {
            b=true;
            fName.append(std.getFirstname().toString());
            lName.append(std.getLastname().toString());
            gndr.append(std.getGender().toString());
            db.append(std.getDob().toString());
            add.append(std.getAddress().toString());
            ph.append(std.getPhone().toString());
            email.append(std.getEmail().toString());
            setValues(fName, lName, gndr, db, add, ph, email);
            break; 
        }
        else
            b=false;
    }
    if (b=true)
    {
        return "student";
    }
    else
        return "error";
}

public void setValues(StringBuilder fName, StringBuilder lName, StringBuilder gndr, StringBuilder db, StringBuilder add, StringBuilder ph,
        StringBuilder email)
{
    setFirstName(fName.toString());
    setLastName(lName.toString());
    setGender(gndr.toString());
    setDob(db.toString());
    setAddress(add.toString());
    setPhoneNumber(ph.toString());
    setEmailID(email.toString());   
}

public String getID() {
    return ID;
}
public void setID(String ID) {
    this.ID = ID;
}

public String getPASS() {
    return PASS;
}
public void setPASS(String PASS) {
    this.PASS = PASS;
}

/**
 * @return the firstName
 */

public String getFirstName() {
    return firstName;
}

/**
 * @para, firstName the firstName to set
 */
public void setFirstName(String firstName) {
    this.firstName = firstName;
}

/**
 * @return the lastName
 */

public String getLastName() {
    return lastName;
}

/**
 * @para, lastName the lastName to set
 */
public void setLastName(String lastName) {
    this.lastName = lastName;
}

/**
 * @return the gender
 */

public String getGender() {
    return gender;
}

/**
 * @para, gender the gender to set
 */
public void setGender(String gender) {
    this.gender = gender;
}

/**
 * @return the dob
 */

public String getDob() {
    return dob;
}
/**
 * @para, dob the dob to set
 */
public void setDob(String dob) {
    this.dob = dob;
}

/**
 * @return the address
 */

public String getAddress() {
    return address;
}
/**
 * @para, dob the dob to set
 */
public void setAddress(String address) {
    this.address = address;
}

/**
 * @return the phoneNumber
 */

public String getPhoneNumber() {
    return phoneNumber;
}
/**
 * @para, phoneNumber the phoneNumber to set
 */
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
/**
 * @return the emailID
 */

public String getEmailID() {
    return emailID;
}
/**
 * @para, emailID the emailID to set
 */
public void setEmailID(String emailID) {
    this.emailID = emailID;
}
}