package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Patients")


public class Patient implements Serializable  {
    
    private static final long serialVersionUID = -1798070786993154676L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "ID", unique = true, nullable = false)
        private Long id;
        
    @Column(name = "firstName", unique = false, nullable = false)
	private String firstName = "";
    @Column(name = "lastName", unique = false, nullable = false)
	private String lastName = "";
    @Column(name = "pesel", unique = true, nullable = false)
	private String pesel = "";
    @Column(name = "dateOfBirth", unique = false, nullable = false)
@Temporal(TemporalType.DATE)
	private Date dateOfBirth = new Date();
    @Column(name = "address", unique = false, nullable = false)
	private String address = "";
    @Column(name = "phoneNumber", unique = false, nullable = false)
	private String phoneNumber = null;
    @Column(name = "weight", unique = false, nullable = false)
	private int weight;
    @Column(name = "height", unique = false, nullable = false)
	private int height;
    @Column(name = "entryDate", unique = false, nullable = false)
	private String entryDate = String.format("%tF", new Date());
 
	public Patient() {}
        
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
        
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	

}
