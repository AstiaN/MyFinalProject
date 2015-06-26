package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Driver;


import javax.faces.bean.ApplicationScoped;

import domain.Patient;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import utils.HibernateUtil;

@ManagedBean(name="patient")
@SessionScoped

public class PatientManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<Patient> db = new ArrayList<Patient>();

	
	public void addPatient(Patient patient) {
		Patient newPatient = new Patient();
		
		newPatient.setFirstName(patient.getFirstName());
		newPatient.setLastName(patient.getLastName());
		newPatient.setPesel(patient.getPesel());
		newPatient.setDateOfBirth(patient.getDateOfBirth());
		newPatient.setAddress(patient.getAddress());
		newPatient.setPhoneNumber(patient.getPhoneNumber());
		newPatient.setWeight(patient.getWeight());
		newPatient.setHeight(patient.getHeight());
		//db.add(newPatient);
                
                Session s = HibernateUtil.getSessionFactory().openSession();
                s.beginTransaction();
                
                s.save(newPatient);
                s.getTransaction().commit();
                
                HibernateUtil.shutdown();
                
                
	}

       //@Resource(name="jdbc:mysql://localhost:3306/mydb")
        //private DataSource ds;
        
	public List<Patient> getAllPatients() {
             Session s = HibernateUtil.getSessionFactory().openSession();
             return s.createQuery("SELECT p FROM Patient p").list();
           /* if(ds==null)
			throw new SQLException("Can't get data source");
 
		//get database connection
		Connection con = ds.getConnection();
 
		if(con==null)
			throw new SQLException("Can't get database connection");
 
		PreparedStatement ps 
			= con.prepareStatement(
			   "select entryDate, firstName, lastName, pesel, weight, height from Patients"); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		List<Patient> db = new ArrayList<Patient>();
                
                while(result.next()){
			Patient pat = new Patient();
 
			pat.setEntryDate(result.getString("entryDate"));
			pat.setFirstName(result.getString("firstName"));
                        pat.setLastName(result.getString("lastName"));
                        pat.setPesel(result.getString("pesel"));
                        pat.setWeight(result.getInt("weight"));
                        pat.setHeight(result.getInt("height"));
                        
 
			//store all data into a List
			db.add(pat);
		}
 */
		//return db;
           
                




//return em.createNamedQuery("patient.all").getResultList();
                
                /*Session sg = HibernateUtil.getSessionFactory().openSession();
                sg.beginTransaction();
                
               
                
                sg.getTransaction().commit();
                
                HibernateUtil.shutdown();*/
		//return em.createNamedQuery("person.all").getResultList();
            //return db;
	}

}
