package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springecommerce.dao.ProducerRepo;
import pl.sda.springecommerce.model.Producer;

@Controller
public class ProducerController {


    @Autowired
    ProducerRepo producerRepo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

@RequestMapping("/addProducer")
    public String addProducer(Producer producer){
        producerRepo.save(producer);
        return "home.jsp";
    }

}
