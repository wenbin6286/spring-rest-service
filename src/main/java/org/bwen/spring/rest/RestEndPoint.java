package org.bwen.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestEndPoint {

    private static final String template ="Hello %s!";
    private final AtomicLong counter = new AtomicLong();
    //return in xml format
    @GetMapping(path="/greeting/xml/{name}",produces = {"application/xml"})
    public Greeting greetingXml(@RequestParam(value="name",defaultValue="world") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
    //default return in json format
    @GetMapping(path="/greeting/{name}")
    public Greeting greeting(@RequestParam(value="name",defaultValue="world") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
    //return in xml format
    @GetMapping(path="/greeting/html/{name}",produces = {"text/html"})
    public String greetingHtml(@RequestParam(value="name",defaultValue="world") String name){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name)).getHtml();
        //return new ResponseEntity<>("hello "+name+"!", HttpStatus.OK);
    }
}
