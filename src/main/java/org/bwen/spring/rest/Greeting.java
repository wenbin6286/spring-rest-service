package org.bwen.spring.rest;


public class Greeting {
    private final long count;
    private final String content;
    public Greeting() {
        count = 0;
        content = "hello world!";
    }
    public Greeting(long count,String word) {
        this.count = count;
        this.content = word;
    }
    public long getId() {
        return count;
    }
    public String getContent() {
        return content;
    }
    public String getHtml() {
        return "<p> "+content + "</p>";
    }
}
