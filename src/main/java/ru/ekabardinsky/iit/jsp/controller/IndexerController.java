package ru.ekabardinsky.iit.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartarus.snowball.ext.englishStemmer;
import ru.ekabardinsky.iit.jsp.indexer.Indexer;
import ru.ekabardinsky.iit.jsp.parser.Parser;
import ru.ekabardinsky.iit.jsp.template.IndexerTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by ekabardinsky on 2/20/17.
 */

@RestController
public class IndexerController {

    @Autowired
    private Indexer indexer;

    @RequestMapping(method = POST, value = "/api/index")
    public IndexerTemplate parser(@RequestBody IndexerTemplate body) {
        return indexer.index(body);
    }
}
