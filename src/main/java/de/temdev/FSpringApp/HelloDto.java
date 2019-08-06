package de.temdev.FSpringApp;

public class HelloDto{
    private String text = "";

    public HelloDto(String text)
    {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}