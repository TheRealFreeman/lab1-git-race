package es.unizar.webeng.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;


@Controller
public class HelloController {
    @Value("${app.message:Hello World}")
    private String message;

    /* Current day in string form */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String currentDay = sdf.format(new Date()).substring(0,2);


    @GetMapping("/")
    public String welcome(Map<String, Object> model) {

        /* Current day in integer form */
        Integer num = Integer.parseInt(currentDay); 
        if(num % 5 == 0 ){
            model.put("luckyColor", "black");
        } else if(num % 2 == 0){
            model.put("luckyColor", "blue");
        } else if(num % 3 == 0) {
            model.put("luckyColor", "white");
        } else {
            model.put("luckyColor", "red");
        }

        model.put("time", new Date());
        model.put("message", message);

        return "wellcome";
    }
}
