package com.example.LibraryManagementSystem.Parton;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partons")
public class PartonController {

    private PartonServices partonServices;
    @Autowired
    PartonController(PartonServices partonServices){
        this.partonServices=partonServices;
    }
    @GetMapping
    public List<Parton> getParton(){
        return partonServices.getAllParton();
    }
    @GetMapping("{partonId}")
    public Parton specificParton(@PathVariable("partonId") Long id){
        return partonServices.customParton(id);
    }
    @PostMapping
    public void addParton(@RequestBody Parton parton){
         partonServices.addParton(parton);
    }
    @DeleteMapping("{partonId}")
    public void deleteParton(@PathVariable("partonId") Long id){
        partonServices.deleteParton(id);
    }

    @PutMapping("{partonId}")
   public void updateParton(@PathVariable("partonId")Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String contactInfo){
        partonServices.updateParton(id,name,contactInfo);
        System.out.println("every thing updated");


    }



}
