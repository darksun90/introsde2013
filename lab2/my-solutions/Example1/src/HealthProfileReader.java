import java.util.HashMap;
import java.util.Map;

import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {
	
	public static Map<String,Person> database = new HashMap<String,Person>();
	
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initializeDatabase();
		int argCount = args.length;
		if (argCount == 0) {
			System.out.println("I cannot create people out of thing air. Give me at least a name and lastname.");
		} else if (argCount == 1) {
			System.out.println("Are you sure you gave me a first and lastname?");
		} else if (argCount == 2) {
			System.out.println("Can you give me something else?");
		} else if (argCount == 3) {
			String fname = args[0];
			String lname = args[1];
			String bhw = args[2];
			// read the person from the DB

			Person p= database.get(fname+" "+lname);
			if (p!=null) { 
				if (bhw.equals("bmi")){
					System.out.println(fname+" "+lname+"'s BMI is: "+p.gethProfile().getBmi());
				}else if (bhw.equals("height")){
					System.out.println(fname+" "+lname+"'s Height is: "+p.gethProfile().getHeight());
				}else if (bhw.equals("weight")){
					System.out.println(fname+" "+lname+"'s Weight is: "+p.gethProfile().getWeight());
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
		
		database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
		database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
		database.put(john.getFirstname()+" "+john.getLastname(), john);
	}
}
