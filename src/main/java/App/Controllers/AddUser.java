package App.Controllers;

import App.Entities.Person;
import App.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddUser {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String addPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String personSubmit(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        personRepository.save(person);
        return "findForm";
    }

}
