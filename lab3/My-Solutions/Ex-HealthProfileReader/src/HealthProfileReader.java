import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {

	public static void main(String[] args)  throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

	    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse("books.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("/people/person/healthprofile/weitgh/text()");
		XPathExpression expr2 = xpath.compile("/people/person/healthprofile/height/text()");

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
		Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
		NodeList nodes2 = (NodeList) result2;
	    for (int i = 0; i < nodes.getLength() && i < nodes2.getLength() ; i++) {
				System.out.println("person n"+i+": weight:"+nodes.item(i).getNodeValue()+", height:"+nodes2.item(i).getNodeValue());
			}	

	}
	
	/**
	public static Map<String,Person> database = new HashMap<String,Person>();
	
	
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args

	public static void main(String[] args) {
		initializeDatabase();
		int argCount = args.length;
		if (argCount == 0) {
			System.out.println("I cannot create people out of thing air. Give me at least a name and lastname.");
		} else if (argCount < 2) {
			System.out.println("Are you sure you gave me a first and lastname?");
		} else if (argCount == 2) {
			String fname = args[0];
			String lname = args[1];
			// read the person from the DB
			Person p= database.get(fname+" "+lname);
			if (p!=null) { 
				System.out.println(fname+" "+lname+"'s health profile is: "+p.gethProfile().toString());
			} else {
				System.out.println(fname+" "+lname+" is not in the database");
			}
		} else if (argCount == 3) {
			String fname = args[0];
			String lname = args[1];
			String measure = args[2];
			// read the person from the DB
			Person p= database.get(fname+" "+lname);
			
			if (p!=null) {
		    	String measureValue="";
	    		HealthProfile hp = p.gethProfile();
    			double height = hp.getWeight();
    			double weight = hp.getWeight();
    			double bmi = hp.getBMI();

				System.out.println("Searching parameter %" +measure+"%");


    			if (measure.equals("weight")) {
			        measureValue = hp.getWeight()+"";
		        } else if (measure.equals("height")) {
	    		    measureValue = hp.getHeight()+"";
    		    } else if (measure.equals("bmi")) {
			        measureValue = hp.getBMI()+"";
		        }  

    			if (measureValue!="") { 
				    System.out.println(fname+" "+lname+"'s "+measure+" is "+measureValue);
				} else {
				    System.out.println(measure+" does not exist in the database");
				}
			} else {
				System.out.println(fname+" "+lname+" is not in the database");
			}
		}	
	}
	
	public static void initializeDatabase() {
		Person pallino = new Person();
		Person pallo = new Person("Pinco","Pallo");
		HealthProfile hp = new HealthProfile(68.0,1.72);
		Person john = new Person("John","Doe",hp);
		john.sethProfile(hp);
		
		database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
		database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
		database.put(john.getFirstname()+" "+john.getLastname(), john);
	}
    */
}