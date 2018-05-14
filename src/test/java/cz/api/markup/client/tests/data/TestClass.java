package cz.api.markup.client.tests.data;


import cz.api.markup.client.annotations.Api;
import cz.api.markup.client.annotations.Optional;
import cz.api.markup.client.annotations.Required;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *  This class exists only like object for automated testing and do not offer real functionality.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public final class TestClass {

    @Api(description = "Testing endpoint used as object for automated testing.")
    @GET
    public Response testEndpoint(@Required @QueryParam("requiredParam") String requiredParam,
                                 @Optional @QueryParam("optionalParam") String optionalParam) {
        return Response.ok().build();
    }

}
