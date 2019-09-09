package spittr.controller;

import spittr.dao.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = "2147483647";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @GetMapping
    public String showSpittles(){
        return "spittles";
    }

    @PostMapping
    @ResponseBody
    public JsonUtils spittlesList(
            @RequestParam(value = "max" , defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count" , defaultValue = "10") int count){
        return new JsonUtils(ResultEnum.SUCCESS,null,
                spittleRepository.findSpittles(max,count));
    }

    @GetMapping(value = "/show/{spittleId}")
    public String showSpittle(){
        return "spittle";
    }

    @PostMapping(value = "/show/{spittleId}")
    @ResponseBody
    public JsonUtils spittle(@PathVariable Long spittleId){
        return new JsonUtils(ResultEnum.SUCCESS,null,spittleRepository.findSpittle(spittleId));
    }

}
