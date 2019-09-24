package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spittr.data.SpitterRepository;
import spittr.pojo.Spitter;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private final SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @GetMapping(value = "/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public JsonUtils processRegisteration(@Valid Spitter spitter, Errors error) {
        if (error.hasErrors()) {
            return new JsonUtils(ResultEnum.ERROR, "", error.getAllErrors());
        }
        spitterRepository.save(spitter);
        return new JsonUtils(ResultEnum.SUCCESS, "", spitter.getUserName());
    }

    @GetMapping(value = "/user/{username}")
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute("spitter", spitterRepository.findOneByUserName(username));
        return "profile";
    }

}
