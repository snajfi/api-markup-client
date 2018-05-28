package cz.api.markup.client.tests.data;


import cz.api.markup.client.annotations.Endpoint;
import cz.api.markup.client.annotations.Optional;
import cz.api.markup.client.annotations.Required;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *  This class exists only like object for automated testing and do not offer real functionality.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@Path("path/to/test/endpoint")
public final class TestClass {

    @GET
    @Endpoint(description = "Testing endpoint used as object for automated testing.")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response testEndpoint(@Required @QueryParam("requiredParam") String requiredParam,
                                 @Optional @QueryParam("optionalParam") String optionalParam) {
        return Response.ok().build();
    }

}