package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springecommerce.dao.ProducerRepo;
import pl.sda.springecommerce.model.Producer;

@Controller
public class ProducerController {


    @Autowired
    ProducerRepo producerRepo;

    @RequestMapping("/addProducer")
    public String addProducer(Producer producer) {
        producerRepo.save(producer);
        return "homeProducerTest.jsp";
    }

    @RequestMapping("/getProducer")
    public ModelAndView getProducer(@RequestParam int producerId) {
        ModelAndView mv = new ModelAndView("showProducer.jsp");

        //bad practise to use orElse
        Producer producer = producerRepo.findById(producerId).orElse(new Producer());

        mv.addObject(producer);
        return mv;
    }

}
