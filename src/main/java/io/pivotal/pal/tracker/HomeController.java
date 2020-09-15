package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Value("${port:NOT SET}") String port;
    @Value("${memory.limit:NOT SET}") String memoryLimit;
    @Value("${cf.instance.addr:NOT SET}") String instanceAddr;

    @RequestMapping("/index.html")
    @ResponseBody
    public String get(){
        return "<html>" +
                    "<h2>Welcome to Smart Impala</h2>" +
                    "<div>This is Cody Yandura's training class page \n Here's some Environment Variables</div> " +
                    "<ul>" +
                        "<li>Port: " + port + "</li>" +
                        "<li>Memory Limit: " + memoryLimit + "</li>" +
                        "<li>Instance Address: " + instanceAddr + "</li>" +
                    "</ul>" +
                "</html>";
    }
}
