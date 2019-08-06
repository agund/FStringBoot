package de.temdev.FSpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FController
{
    @Autowired
    private FService fService;

    @GetMapping
    public HelloDto hello(@RequestParam(required = false) String username)
    {
        return fService.hello(username);
    }


}
