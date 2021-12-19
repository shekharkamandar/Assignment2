package com.program.Demo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.rest.webservice.StudentService;

//import com.sun.tools.classfile.Opcode.Set;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("webapi")
public class MyResource extends Application
{
	private Set set;
	public MyResource()
	{
		set=new HashSet();
		set.add(new StudentService());
	}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
   @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() 
    {
        return "Got itt!";
    }
    public Set getSingletons()
    {
    	return set;

   }
	
}


