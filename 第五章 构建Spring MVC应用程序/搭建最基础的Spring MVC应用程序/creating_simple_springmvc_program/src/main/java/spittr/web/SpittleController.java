package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spittr.data.SpittleRepository;
import spittr.pojo.Spitter;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

import javax.xml.transform.Result;
import java.util.Map;

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
    public String spittlesGet(){
        return "spittles";
    }

    @PostMapping
    @ResponseBody
    public JsonUtils spittlesPost(
            @RequestParam(value = "max" , defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count" , defaultValue = "10") int count){
        return new JsonUtils(ResultEnum.SUCCESS,null,
                spittleRepository.findSpittles(max,count));
    }

    @GetMapping(value = "/show/{spittleId}")
    public String spittleGet(){
        return "spittle";
    }

    @PostMapping(value = "/show/{spittleId}")
    @ResponseBody
    public JsonUtils spittlePost(@PathVariable Long spittleId){
        return new JsonUtils(ResultEnum.SUCCESS,null,spittleRepository.findSpittle(spittleId));
    }

}
