package de.tr7zw.skinserver;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorHandler implements ExceptionMapper<NotFoundException> {

    @Inject
    StatisticsProvider statistics;

    @Override
    public Response toResponse(NotFoundException exception) {
        statistics.notFoundCounter.add(1);
        return Response.status(404).entity("404").build();
    }
}