package resources;

import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.PersonDao;

/*
 * TODO 
 * - There is a problem with the EntityManager injection through @PersistenceUnit or @PersistenceContext
 * - will look into it later
 */

@Stateless
@LocalBean//Will map the resource to the URL /ehealth/v2
@Path("/person")
public class PeopleResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// THIS IS NOT WORKING
	@PersistenceUnit(unitName="introsde-jpa")
	EntityManager entityManager;
	
	// THIS IS NOT WORKING
    @PersistenceContext(unitName = "introsde-jpa",type=PersistenceContextType.TRANSACTION)
    private EntityManagerFactory entityManagerFactory;

	// Return the list of people to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Person> getPersonsBrowser() {
	    List<Person> people = Person.getAll();
		return people;
	}

	// Return the list of people for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	public List<Person> getPersonListXML() {
		//EntityManager entityManager = entityManagerFactory.createEntityManager();
		//EntityManager entityManager = PersonDao.instance.createEntityManager();       
//        try {
//            List<Person> people = entityManager.createNamedQuery("Person.findAll", Person.class).getResultList();
//            return people;
//        } finally {
//            entityManager.close();
//        }
	    List<Person> people = Person.getAll();
		return people;
	}
	
	// Return the list of people for applications
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Person> getPersonListJson() {
	    List<Person> people = Person.getAll();
		return people;
	}

	// retuns the number of people
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		System.out.println("Getting count...");
	    //List<Person> list = entityManager.createNamedQuery("Person.findAll", Person.class).getResultList();
	    List<Person> people = Person.getAll();
		int count = people.size();
		return String.valueOf(count);
	}

//	// let's create this service for responding a submission form
//	@POST
//	@Produces(MediaType.TEXT_HTML)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public void newPerson(@FormParam("id") String id,
//			@FormParam("firstname") String firstname,
//			@FormParam("lastname") String lastname,
//			@Context HttpServletResponse servletResponse) throws IOException {
//		Person p = new Person(id, firstname, lastname);
//		PersonDao.instance.getModel().put(id, p);
//		servletResponse.sendRedirect("../NewPerson.html");
//	}
	
	
	// let's create this service for responding a submission form
	// 
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Person newPerson(Person person) throws IOException {
		System.out.println("Creating new person...");
		//EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityManager entityManager = PersonDao.instance.createEntityManager();
//        try {
//    		entityManager.persist(person);
//    		entityManager.refresh(person);
//    		return person;
//        } finally {
//            entityManager.close();
//        }
		
		return Person.savePerson(person);
	}
	

	// Defines that the next path parameter after the base url is
	// treated as a parameter and passed to the PersonResources
	// Allows to type http://localhost:599/base_url/1
	// 1 will be treaded as parameter todo and passed to PersonResource
	@Path("{personId}")
	public PersonResource getPerson(@PathParam("personId") Long id) {
//		//EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityManager em = PersonDao.instance.createEntityManager();
//        try {
//    		System.out.println("Person by id..."+id);
//    		return new PersonResource(uriInfo, request, id, em);
//        } finally {
//            em.close();
//        }
		
		return new PersonResource(uriInfo, request, id);
	}
}
