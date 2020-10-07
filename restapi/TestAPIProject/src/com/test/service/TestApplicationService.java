package com.test.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.dao.TestApplicationDAO;
import com.test.dto.Register;
import com.test.dto.StudentDto;

@Path("/v1")
public class TestApplicationService {
	TestApplicationDAO testAplicationDao=new TestApplicationDAO();
	ArrayList tempVal=new ArrayList();
	
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/getMethod")
public Response getTestApplication() {
	System.out.println("callinnnnng methoddddddd");
	
	System.out.println("calling method111111111111");
	testAplicationDao.callDB();
	return Response.status(Response.Status.OK).entity("Testing page").build();
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/owners")
public Response getOwners() {
	
	System.out.println("inside spring method call");
	StudentDto stuinfo=new StudentDto();
	tempVal=testAplicationDao.callDB();
	System.out.println(stuinfo.getDob());
	
	//Collection<Owner> owners = this.clinicService.findAllOwners();
	//if (owners.isEmpty()) {
	//	return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
	//}

	return Response.status(Response.Status.OK).entity(tempVal).build();
}

@POST
@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
public Response register(StudentDto stuInfo) {
	//HttpHeaders headers = new HttpHeaders();
	System.out.println("MAnikandan ");
	System.out.println(stuInfo.getStudent_name());
	int resultStatus=testAplicationDao.callDB(stuInfo);
	System.out.println("result Status"+resultStatus);
//	System.out.println("got my values heyyyyyy====>"+register.getId());
	//this.clinicService.saveOwner(owner);
//	headers.setLocation(ucBuilder.path("/api/owners/{id}").buildAndExpand(owner.getId()).toUri());
	return Response.status(Response.Status.OK).entity(stuInfo).build();
}
}
