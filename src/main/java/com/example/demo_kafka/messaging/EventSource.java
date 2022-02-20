package com.example.demo_kafka.messaging;

import com.example.demo_kafka.messaging.events.MessageEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EventSource {
    @Inject
    Event<MessageEvent> messageEvent;

    public void fireEvent(MessageEvent msgEvent){
        messageEvent.fireAsync(msgEvent);
    }

}
