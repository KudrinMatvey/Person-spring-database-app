package App.Controllers;

import App.Entities.Person;
import App.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping("/")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/findAll")
    public String findAll(Model model)
    {
        model.addAttribute("persons",
                personRepository.findAll());
        return "findAll";
    }

    @GetMapping(value="/findById")
    public String findById(@RequestParam Integer id, Model model) {
        Iterable<Person> person = personRepository.findAllById(Collections.singleton(id));
        model.addAttribute("person", person);
        return "findById";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam Integer id) {
        Person person = new Person();
        person.setId(id);
        personRepository.delete(person);
        return "redirect:/findAll";
    }
    @GetMapping(value = "/find")
    public String findForm(Model model)
    {     model.addAttribute("person", new Person());
        return "findForm";
    }

    @RequestMapping(value="/find", method=RequestMethod.POST)
    public String personSubmit(@ModelAttribute Person person, Model model) {
        String str = "redirect:/findById?id="+person.getId();
        return str;
    }

}
