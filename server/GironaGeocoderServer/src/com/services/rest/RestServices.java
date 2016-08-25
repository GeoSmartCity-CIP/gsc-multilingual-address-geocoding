package com.services.rest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

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

@Path("/RestService")
@ApplicationPath("/geo")
public class RestServices  extends Application{
	
	//http://localhost:8080/GironaGeocoderServer/geo/RestService/sayHello
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetHelloMessage(){
		return "Hello World";		
	}
	
	//http://localhost:8080/GironaGeocoderServer/geo/RestService/getaddress?address=Carrer de Bonastruc de Porta
	@GET
	@Path("/getaddress")
	@Produces(MediaType.APPLICATION_JSON  + ";charset=utf-8")
	public String GetAddress(@QueryParam("address") String f )
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(Geocoder.GetAddress(f));
		System.out.println(json);
		return json; 
	}
	
	//http://localhost:8080/GironaGeocoderServer/geo/RestService/postaddress?address=‚
	@POST
	@Path("/postaddress/address?={f}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String PostAddress(@QueryParam("address") String f)
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(Geocoder.GetAddress(f));
		return json; 
	}
	
	//http://localhost:8080/GironaGeocoderServer/geo/RestService/getcoordinates?lng=2.83386&lat=42.00351&srs=4326
		@GET
		@Path("/getcoordinates")
		@Produces(MediaType.APPLICATION_JSON  + ";charset=utf-8")
		public String GetAddress(@QueryParam("lat") double lat, @QueryParam("lng") double lng, @QueryParam("srs") int srs )
		{
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			String json = gson.toJson(Geocoder.GetAddress(lat, lng));
			System.out.println(json);
			return json; 
		}
		
		//http://localhost:8080/GironaGeocoderServer/geo/RestService/postaddress?lng=2.83386&lat=42.00351&srs=4326‚
		@POST
		@Path("/postcoordinates?lng={lng}&lat={lat}&srs={srs}")
		@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
		public String PostAddress(@QueryParam("lat") double lat, @QueryParam("lng") double lng, @QueryParam("srs") int srs )
		{
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			String json = gson.toJson(Geocoder.GetAddress(lat, lng));
			return json; 
		}
}
