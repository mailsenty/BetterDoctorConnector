package org.mule.modules.betterdoctor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.betterdoctor.config.ConnectorConfig;

@Connector(name="better-doctor", friendlyName="BetterDoctor")
public class BetterDoctorConnector {

    @Config
    ConnectorConfig config;

    private final String BETTERDOC = "https://api.betterdoctor.com/2016-03-01/doctors?user_key=f5c9e3fe7117ce0a0ee4df4176f74775";
	
   	private  URL url;


   	HttpURLConnection con ;

       
       public ConnectorConfig getConfig() {
           return config;
       }

       public void setConfig(ConnectorConfig config) {
           this.config = config;
       }
       
       

       @Processor
       public String getBetterDoctor(String first_name, String last_name,String gender, String location, String specialtyuid) {
           String response;
       	try {
       		
       		String reqStr=BETTERDOC;
       		if(first_name != null && !first_name.equals(""))
       			reqStr +="&first_name="+first_name;
       		if(last_name != null && !last_name.equals(""))
       			reqStr +="&last_name="+last_name;
       		if(location != null && !location.equals(""))
       			reqStr +="&location="+location;
       		if(gender != null && !gender.equals(""))
       			reqStr +="&gender="+gender;
       		if(specialtyuid != null && !specialtyuid.equals(""))
       			reqStr +="&specialty_uid="+specialtyuid;
       		
       		url  = new URL(reqStr);
      	response=processConnection(url);
   		} catch (MalformedURLException e) {
   			response="Error connecting to endpoint Please retry";
   			e.printStackTrace();
   		}
       	catch (Exception e) {
       		response="Error connecting to endpoint Please retry" ;  				
   			e.printStackTrace();
   		}
       	return response;
     

       }
       private String processConnection(URL url){
       	
       	StringBuffer response = new StringBuffer();
       	
       	try {
   			con = (HttpURLConnection) url.openConnection();
   			
   			con.setRequestMethod("GET");

   			// add request header
   			int responseCode = con.getResponseCode();
   			System.out.println("\nSending 'GET' request to URL : " + url);
   			System.out.println("Response Code : " + responseCode);

   			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
   			String inputLine;
   			

   			while ((inputLine = in.readLine()) != null) {
   				response.append(inputLine);
   			}
   			in.close();
   		}  catch (Exception e) {
   			response=new StringBuffer("Error getting Yoda Speak");
   			e.printStackTrace();
   		}

   		// print result
   		return response.toString();
       }
}