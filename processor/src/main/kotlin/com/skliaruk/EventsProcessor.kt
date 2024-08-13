package com.skliaruk


import io.smallrye.reactive.messaging.annotations.Blocking
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing


@ApplicationScoped
class EventsProcessor {

    @Incoming("requests")
    @Outgoing("events")
    @Transactional
    @Blocking
    fun process(postRequest: Event): Event {
        postRequest.persist()
        return postRequest;
    }
}