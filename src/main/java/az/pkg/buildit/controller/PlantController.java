package az.pkg.buildit.controller;

import az.pkg.buildit.entity.Plant;
import az.pkg.buildit.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlantController {

    @Autowired
    PlantService service;

    @RequestMapping(method = RequestMethod.POST, value = "/plant/create")
    public String createPlant(@RequestBody MultiValueMap<String,String> map, Model model) {
        Plant plant = new Plant();
        plant.setName(map.getFirst("name"));
        plant.setDescription(map.getFirst("desc"));
        plant.setPrice(Double.parseDouble(map.getFirst("price")));
        service.create(plant);
        model.addAttribute("name", map.getFirst("name"));
        return "list";
    }
}
