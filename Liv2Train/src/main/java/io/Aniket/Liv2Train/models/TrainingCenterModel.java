package io.Aniket.Liv2Train.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "TrainingCenter")
public class TrainingCenterModel {
	
	@Id
	private String _id;
	
	@Length(min=12, max=12, message = "Center Code has to be exactly 12 characters")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Indexed(unique=true)
	private String centerCode;
	
	
	@Size(max = 40)
	private String centerName;
	private Address address;
	
	private int student_Capacity;
	private List<String> courses_Offered;
	private Date createdOn;
	
//	@Email(message = "Please enter a valid Email Address.")
	@Pattern(message="Please enter a valid Email Address.", regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String contactEmail;
	
	@Pattern(message = "Phone Number must be a number", regexp="[0-9]*")
	private String contactPhone;
	
	
	
	public void TrainingCenterModel(String centerCode, String centerName, Address address, int student_Capacity, List<String> courses_Offered, Date createdOn, String contactEmail, String contactPhone) {
        this.centerCode = centerCode;
        this.centerName = centerName;
        this.address = address;
        this.student_Capacity = student_Capacity;
        this.courses_Offered = courses_Offered;
        this.createdOn = createdOn;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;

    }

    //Methods

    public String getCenterCode(){
        return this.centerCode;
    }

    public void setCenterCode(String centerCode){
    	this.centerCode = centerCode;
    }

    public String getCenterName(){
        return this.centerName;
    }

    public void setCenterName(String centerName){
    	this.centerName = centerName;
    }
    
    public Address getAddress(){
        return this.address;
    }

    public void setAddress(Address address){
    	this.address = address;
    }
    
    public int getStudent_Capacity(){
        return this.student_Capacity;
    }

    public void setStudent_Capacity(int student_Capacity){
    	this.student_Capacity = student_Capacity;
    }
    
    public List<String> getCourses_Offered(){
        return this.courses_Offered;
    }

    public void setCourses_Offered(List<String> courses_Offered){
    	this.courses_Offered = courses_Offered;
    }
    
    public Date getCreatedOn(){
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn){
    	this.createdOn = createdOn;
    }
    
    public String getContactEmail(){
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail){
    	this.contactEmail = contactEmail;
    }
    
    public String getContactPhone(){
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone){
    	this.contactPhone = contactPhone;
    }

}