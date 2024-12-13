package com.azure.handler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebPubSubController {

    @RequestMapping(value = "/connect", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleConnect() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("WebHook-Allowed-Origin", "guestappwebpubsub.webpubsub.azure.com"); // Replace with your Web PubSub domain
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PostMapping("/{event}")
    public ResponseEntity<String> handleEvent(@PathVariable String event, @RequestBody Map<String, Object> payload) {
        System.out.println("Event: " + event);
        System.out.println("Payload: " + payload);
        return ResponseEntity.ok("Event processed: " + event);
    }
}