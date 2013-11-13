package introsde.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class client {
  
  public static Map<Integer,String> ModelA = new HashMap<Integer,String>();
  public static Map<String,ArrayList<String>> ModelB = new HashMap<String,ArrayList<String>>();

  public static void main(String[] args) {
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI());
    
	ModelA.put(1, "Pinco Pallino");
	ModelA.put(2, "Pinco Pallo");
	ModelA.put(3, "John Doe");
	
	@SuppressWarnings("serial")
	ArrayList<String> list1 = new ArrayList<String>() {{
	    add("98");
	    add("1.72");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> list2 = new ArrayList<String>() {{
	    add("83");
	    add("1.80");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> list3 = new ArrayList<String>() {{
	    add("66");
	    add("1.75");
	}};
	
	ModelB.put("Pinco Pallino",list1);		
	ModelB.put("Pinco Pallo",list2);
	ModelB.put("John Doe",list3);
	
 
    for(int i = 0; i < ModelA.size(); i++){
    	System.out.println(service.path("SET").path(""+(i+1)).path(ModelA.get((i+1))).accept(MediaType.APPLICATION_JSON).get(String.class).toString());
    }

    for(int i = 0; i < ModelA.size(); i++){
    	System.out.println(service.path("GET").path(""+(i+1)).accept(MediaType.APPLICATION_JSON).get(String.class).toString());
    }

    Iterator<String> itr = ModelB.keySet().iterator();
    while(itr.hasNext()){
      String tmp = itr.next();
      for(int i = 0; i < (ModelB.get(tmp).size()-1); i++){
    	  System.out.println(service.path("HMSET").path(tmp).path("weight").path(ModelB.get(tmp).get(i).toString()).path("height").path(ModelB.get(tmp).get(i+1).toString()).accept(MediaType.APPLICATION_JSON).get(String.class).toString());
      }
  	}
 
    Iterator<String> itr2 = ModelB.keySet().iterator();
    while(itr2.hasNext()){
      System.out.println(service.path("HGETALL").path(itr2.next()).accept(MediaType.APPLICATION_JSON).get(String.class).toString());
  	}

    Iterator<String> itr3 = ModelB.keySet().iterator();
    while(itr3.hasNext()){
      System.out.println(service.path("HMGET").path(itr3.next()).path("height").path("weight").accept(MediaType.APPLICATION_JSON).get(String.class).toString());
  	}
    
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://test.lifeparticipation.org/webdis/").build();
  }

} 