package com.ipiecoles.java.mdd324.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")

public class QuoteController {
    @Autowired
    private Sortie sortie;

    public String getQuote() {
        return sortie.getQuote() + " " + sortie.getAuthor();
    }
}
}
