package com.skliaruk

import io.smallrye.mutiny.Multi
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.*

@Path("/post-events")
class ExampleResource {
    @Channel("event-requests")
    lateinit var eventRequests: Emitter<Event>

    @Channel("events")
    lateinit var events: Multi<Event>

    @POST
    @Path("/request")
    @Produces(MediaType.APPLICATION_JSON)
    fun createRequest(body: Event): Response {
        eventRequests.send(body)
        return Response.status(201).entity(body).build();

    }

    @GET
    @Path("events")
    fun getAll(): List<Event> {
        return Event.listAll()
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    fun stream(): Multi<Event> {
        return events
    }

}