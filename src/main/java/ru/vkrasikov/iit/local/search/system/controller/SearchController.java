package ru.vkrasikov.iit.local.search.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vkrasikov.iit.local.search.system.searchEngine.SearchEngine;
import ru.vkrasikov.iit.local.search.system.template.SearchResponseTemplate;
import ru.vkrasikov.iit.local.search.system.template.SearchTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class SearchController {
    @Autowired
    private SearchEngine searchEngine;

    @RequestMapping(method = GET, value = "/api/search")
    public SearchResponseTemplate parser(@RequestBody SearchTemplate body) {
        return searchEngine.search(body);
    }
}
