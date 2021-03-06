import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Main {  
	
    @XmlRootElement
    static class Person {
        @XmlAttribute String name;
        @XmlElement int age;
        @XmlElement String address;
        Person(){
        	name="Thomas";
        	age=35;
        	address="Via Malpensada 140";
        		}
    }    
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        jc.createMarshaller().marshal(new Person(),new FileOutputStream("person.xml"));
    }
}
