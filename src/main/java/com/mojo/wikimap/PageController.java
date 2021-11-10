package com.mojo.wikimap;

import java.util.logging.Logger;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PageController {

    @Autowired
    RestTemplate restTemplate;
    private final String host = "mediawiki.org/w/api.php";
    private final String searchPath = "action=query&list=search&";
	protected final Logger logger = Logger.getLogger(getClass().getName());


    @GetMapping("/search")
    public String searchPage(@RequestParam String searchValue, @RequestParam int limit) {
        URI uri = null;
        try {
            uri = new URIBuilder()
                        .setScheme("https")
                        .setHost(host)
                        .setPath("api.php")
                        .setPath(searchPath)
                        .setParameter("action", "query")
                        .setParameter("list", "search")
                        .setParameter("srsearch", searchValue)
                        .build();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.warning(uri.toString());
        String response = restTemplate.getForObject(uri, String.class);
        return response;
    }

    /**
     * Todo: 
     * execute search  for title with string value 
     * - use exact if exists, if not then return near match 
     * - create Page obj from 
     * - if found page match, return body
     */
    
}
