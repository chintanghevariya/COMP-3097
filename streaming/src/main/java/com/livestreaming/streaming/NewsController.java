package com.livestreaming.streaming;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class NewsController {

    public static Map<String,String> getOptions(){
        Map<String,String> options = new HashMap<>();
        options.put("Argentina","ar");
        options.put("Australia","au");
        options.put("Austria","at");
        options.put("Belgium","be");
        options.put("Brazil","br");
        options.put("Bulgaria","bg");
        options.put("Canada","ca");
        options.put("China","cn");
        options.put("Colombia","co");
        options.put("Cuba","cu");
        options.put("Czech Republic","cz");
        options.put("Egypt","eg");
        options.put("France","fr");
        options.put("Germany","de");
        options.put("Greece","gr");
        options.put("Hong Kong","hk");
        options.put("Hungary","hu");
        options.put("India","in");
        options.put("Indonesia","id");
        options.put("Ireland","ie");
        options.put("Israel","il");
        options.put("Italy","it");
        options.put("Japan","jp");
        options.put("Latvia","lv");
        options.put("Lithuania","lt");
        options.put("Malaysia","my");
        options.put("Morocco","ma");
        options.put("Mexico","mx");
        options.put("Netherlands","nl");
        options.put("New Zealand","nz");
        options.put("Nigeria","ng");
        options.put("Norway","no");
        options.put("Philippines","ph");
        options.put("Poland","pl");
        options.put("Portugal","pt");
        options.put("Romania","ro");
        options.put("Russia","ru");
        options.put("Saudi Arabia","sa");
        options.put("Serbia","rs");
        options.put("Singapore","sg");
        options.put("Slovakia","sk");
        options.put("Slovenia","si");
        options.put("South Africa","za");
        options.put("South Korea","kr");
        options.put("Sweden","se");
        options.put("Switzerland","ch");
        options.put("Taiwan","tw");
        options.put("Thailand","th");
        options.put("Turkey","tr");
        options.put("UAE","ae");
        options.put("Ukraine","ua");
        options.put("United Kingdom","gb");
        options.put("United States","us");
        options.put("Venezuela","ve");
        return options;
    }
    List<articles> articlesList = new ArrayList<>();
    private final static String API1="63671d6217394612b34cec61fab9696c";
    private final static String API2="6c87b22445f04cc2882e94c26ebece46";
    private final static String API3="9708ab96ee9942d39add815b0dcf56ea";



    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the map
    }
    @GetMapping("/")
    public String demo(Model model) {
        model.addAttribute("options", getOptions());
        String uri= "https://newsapi.org/v2/everything?q=cricket&apiKey="+API1;

        RestTemplate restTemplate = new RestTemplate();
        Object[] object = new Object[]{restTemplate.getForObject(uri,Object.class)};

        ObjectMapper objectMapper = new ObjectMapper();
        articlesList = Arrays.stream(object)
                .map(o->objectMapper.convertValue(o,DataResponse.class))
                .map(DataResponse::getArticles)
                .toList().get(0);
        model.addAttribute("articlesList",articlesList);

        return "homepage";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @GetMapping("/politics")
    public String politics(){
        return "politics";
    }

    @GetMapping("/technology")
    public String technology(){
        return "technology";
    }

    @GetMapping("business")
    public String business(){
        return "business";
    }

    @GetMapping("/cricket")
    public String welcomeHome(Model model){
        model.addAttribute("options", getOptions());
        return "form1";
    }
    @PostMapping("/news")
    public String news(@RequestParam("selectedOption") String selectedOption, Model model) {
        model.addAttribute("options", getOptions());
        String uri= "https://newsapi.org/v2/top-headlines?country="+selectedOption+"&apiKey="+API1;
        RestTemplate restTemplate = new RestTemplate();
        Object[] object = new Object[]{restTemplate.getForObject(uri,Object.class)};

        ObjectMapper objectMapper = new ObjectMapper();
        articlesList = Arrays.stream(object)
                .map(o->objectMapper.convertValue(o,DataResponse.class))
                .map(DataResponse::getArticles)
                .toList().get(0);

        model.addAttribute("selectedOption",getKeyByValue(getOptions(),selectedOption));
        model.addAttribute("articlesList",articlesList);
        System.out.println(articlesList.get(1).getPublishedAt());
        return "articles";
    }

    @PostMapping("/searchnews")
    public String searchnews(@RequestParam("searchQuery") String searchQuery, Model model){
        String uri= "https://newsapi.org/v2/everything?q="+searchQuery+"&apiKey="+API1;

        RestTemplate restTemplate = new RestTemplate();
        Object[] object = new Object[]{restTemplate.getForObject(uri,Object.class)};

        ObjectMapper objectMapper = new ObjectMapper();
        articlesList = Arrays.stream(object)
                .map(o->objectMapper.convertValue(o,DataResponse.class))
                .map(DataResponse::getArticles)
                .toList().get(0);
        model.addAttribute("searchQuery",searchQuery);
        model.addAttribute("articlesList",articlesList);
        return "articles";
    }

    @GetMapping("/businessNews")
    public String businessNews(Model model){
        String uri= "https://newsapi.org/v2/everything?q=global-business&apiKey="+API3;

        RestTemplate restTemplate = new RestTemplate();
        Object[] object = new Object[]{restTemplate.getForObject(uri,Object.class)};

        ObjectMapper objectMapper = new ObjectMapper();
        articlesList = Arrays.stream(object)
                .map(o->objectMapper.convertValue(o,DataResponse.class))
                .map(DataResponse::getArticles)
                .toList().get(0);
        model.addAttribute("searchQuery", "Business News");
        model.addAttribute("articlesList",articlesList);
        return "business";
    }
}
