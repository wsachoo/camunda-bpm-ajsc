package com.att.pricerd.service.rs;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.att.pricerd.model.HelloWorld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/service")
@Path("/service")
@Produces({ MediaType.APPLICATION_JSON })
public interface RestService {

	@GET
	@Path("/hello")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Respond Hello <name>!", notes = "Returns a JSON object with a string to say hello. "
			+ "Uses 'world' if a name is not specified", response = HelloWorld.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not available"),
			@ApiResponse(code = 500, message = "Unexpected Runtime error") })
	public HelloWorld getQuickHello(@QueryParam("name") String name);
	
	
	@GET
	@Path("/sample")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Respond Hello <name>!", notes = "Returns a JSON object with a string to say hello. "
			+ "Uses 'world' if a name is not specified", response = HelloWorld.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not available"),
			@ApiResponse(code = 500, message = "Unexpected Runtime error") })
	public String getSampleResponse();
	
	
	@GET
	@Path("/myOffer")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Respond Hello <name>!", notes = "Returns a JSON object with a string to say hello. "
			+ "Uses 'world' if a name is not specified", response = HelloWorld.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not available"),
			@ApiResponse(code = 500, message = "Unexpected Runtime error") })
	
	public String printProductName(@QueryParam("product") String product);
	
	
	
	@GET
	@Path("/offer")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Respond Hello <name>!", notes = "Returns a JSON object with a string to say hello. "
			+ "Uses 'world' if a name is not specified", response = HelloWorld.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not available"),
			@ApiResponse(code = 500, message = "Unexpected Runtime error") })
	
	public String getMicroserviceName(@QueryParam("product") String product);
	
}