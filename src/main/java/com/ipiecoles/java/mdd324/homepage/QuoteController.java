package com.ipiecoles.java.mdd324.homepage;

import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/quote")

public class QuoteController {
    @GetMapping
    public Sortie getQuote() throws IOException {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        final String pageContents = Utils.getPageContents("http://quotes.rest/qod.json");
        Quotes quotes = genson.deserialize(pageContents, Quotes.class);
        return quotes.getContents().getQuotes().get(0);

    }
}

       // {autho"elon Musk" "Persistance is....up." }