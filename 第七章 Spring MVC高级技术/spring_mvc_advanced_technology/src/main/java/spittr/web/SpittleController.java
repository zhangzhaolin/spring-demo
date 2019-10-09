package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.data.SpittleRepository;
import spittr.exception.SpittleNotFoundException;
import spittr.pojo.Spitter;
import spittr.pojo.Spittle;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = "2147483647";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @GetMapping
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "15") int count, Model model) {
        return spittleRepository.findSpittles(max, count);
    }


    @GetMapping(value = "/show/{spittleId}")
    public String spittlePost(@PathVariable Long spittleId, Model model) {
        try {
            model.addAttribute("spittle", spittleRepository.findSpittle(spittleId));
        } catch (DataAccessException exception) {
            throw new SpittleNotFoundException("Spittle没有找到");
        }
        return "spittle";
    }

}
