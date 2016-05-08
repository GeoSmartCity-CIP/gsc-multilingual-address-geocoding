package com.services.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestServices  extends Application{
	
	//http://localhost:8080/Geosmartcity/resources/MyRestService/sayHello
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetHelloMessage(){
		return "Hello World";		
	}
	
	//http://localhost:8080/Geosmartcity/resources/MyRestService/getturkuaddress?address=Helsingin%20valtatie
	@GET
	@Path("/getturkuaddress")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetAddress(@QueryParam("address") String f )
	{
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(Geocoder.GetAddress(f));
		System.out.println(json);
		return json; 
	}
	
	//http://localhost:8080/Geosmartcity/resources/MyRestService/getturkuaddress?address=Helsingin%20valtatie
	@POST
	@Path("/postturkuaddress/address?={f}")
	@Produces(MediaType.APPLICATION_JSON)
	public String PostAddress(@QueryParam("address") String f)
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(Geocoder.GetAddress(f));
		return json; 
	}
}
