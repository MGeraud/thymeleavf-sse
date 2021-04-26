package com.example.thymeleavfsse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;


@Controller
public class ControllerToThymeleaf {


    /**
     * controller de la page générique entourant le fragment gérant le flux SSE
     * @return
     */
    @GetMapping("/fizzbuzz")
    public String welcomeFizzBuzz(){
        return "fizzbuzz";
    }


    /**
     * controller du fragment de thymeleaf lui envoyant le stream de données SSE
     * @param model
     * @return fragment thymeleaf affichant la mise à jour du flux de données
     */
    @GetMapping(value="/fizzbuzz-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String streamingFizzBuzz(Model model){
        var fizzbuzz = FizzBuzzFluxGenerator.createFlux();
        var updatesFizzBuzz = new ReactiveDataDriverContextVariable(fizzbuzz, 1);
        model.addAttribute("updates" , updatesFizzBuzz);
        return "fizzbuzz :: #updateBlock";
    }

}
