package com.iepsevere.webservice;  

import java.sql.SQLException;
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
@Path("/UserService") 

public class UserService {  
   UsersDAO dao = new UsersDAO();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.TEXT_PLAIN)
   public Response Role(@QueryParam("user") String user) throws SQLException{
		return Response.ok(dao.getRole(user)).build();
   }  
}