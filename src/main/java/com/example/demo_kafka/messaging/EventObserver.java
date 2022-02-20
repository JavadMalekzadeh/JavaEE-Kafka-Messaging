package com.example.demo_kafka.messaging;

import com.example.demo_kafka.messaging.events.MessageEvent;
import com.example.demo_kafka.messaging.kafkabroker.KafkaBrokerProducer;

import javax.enterprise.event.ObservesAsync;
import javax.inject.Named;

@Named
public class EventObserver {
    public void onMessageEvent(@ObservesAsync MessageEvent messageEvent){
        KafkaBrokerProducer.sendMessage(messageEvent);
        System.out.println("message sent!");
    }
}
