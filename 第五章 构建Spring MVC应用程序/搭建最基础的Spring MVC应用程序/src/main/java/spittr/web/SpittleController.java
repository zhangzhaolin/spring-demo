package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spittr.data.SpittleRepository;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

import java.util.Map;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

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
    public JsonUtils spittlesPost(){
        return new JsonUtils(ResultEnum.SUCCESS,null,
                spittleRepository.findSpittles(Integer.MAX_VALUE,20));
    }

}
