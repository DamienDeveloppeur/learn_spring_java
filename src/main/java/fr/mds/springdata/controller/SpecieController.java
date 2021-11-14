package fr.mds.springdata.controller;

import fr.mds.springdata.domain.Specie;
import fr.mds.springdata.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/species")
public class SpecieController {
    // on peut récupérer les espéces par le biais du service

    @Autowired
    private SpecieService specieService;

    @Transactional
    @GetMapping
    public String all(Model model) {
        List<Specie> animalList = specieService.findAll();
        model.addAttribute("species", animalList);
        model.addAttribute("specie", new Specie());
        return "species";
    }

    @Transactional
    @PostMapping
    public String create(@ModelAttribute Specie specie) {
        if(specie.getId() == 0L) specieService.create(specie);
        else specieService.update(specie);

        return "redirect:/species";
    }

    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") long id) {
        Specie specie = specieService.get(id);
        if(specie != null) specieService.delete(id);
        return "redirect:/species";
    }
    @Transactional
    @GetMapping("/updateRedirect")
    public String updateRedirect(@RequestParam(name = "id") long id, Model model){
        Specie specie = specieService.get(id);
        if(specie == null) return "redirect:/species";
        model.addAttribute("specie",specie);
        return "update_specie";
    }

    @Transactional
    @PostMapping("/edit")
    public String edit(Specie specie) {
        System.out.print("id : "+ specie.getId());
        if(specie.getId() != null)
            specieService.update(specie);
        else{
            specieService.create(specie);
        }
        return "redirect:/species";
    }
}
