package ru.ekabardinsky.iit.local.search.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ekabardinsky.iit.local.search.system.searchEngine.SearchEngine;
import ru.ekabardinsky.iit.local.search.system.template.SearchResponseTemplate;
import ru.ekabardinsky.iit.local.search.system.template.SearchTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by ekabardinsky on 2/23/17.
 */
@RestController
public class SearchController {
    @Autowired
    private SearchEngine searchEngine;

    @RequestMapping(method = POST, value = "/api/search")
    public SearchResponseTemplate parser(@RequestBody SearchTemplate body) {
        return searchEngine.search(body);
    }
}
