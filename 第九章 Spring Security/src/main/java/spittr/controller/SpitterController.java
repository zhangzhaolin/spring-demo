package spittr.controller;

import spittr.dao.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spittr.pojo.Spitter;
import spittr.util.JsonUtils;
import spittr.util.ResultEnum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @Autowired
    private Environment environment;

    private final SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @GetMapping(value = "/register")
    public String showRegisterForm(){
        return "registerForm";
    }

    @GetMapping(value = "/user/{username}")
    public String showSpitterProfile(){
        return "profile";
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public JsonUtils processRegisteration(
            @Valid Spitter spitter,
            @RequestPart(value = "imgLogo") MultipartFile image, HttpServletRequest request,
            Errors error) throws IOException , SQLIntegrityConstraintViolationException {
        if (error.hasErrors()){
            return new JsonUtils(ResultEnum.ERROR,null,error.getAllErrors());
        }

        File file = new File(environment.getProperty("spitter.file"));
        if(!file.exists()){
            file.mkdirs();
        }

        String uuid = UUID.randomUUID().toString();

        String extention = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));

        image.transferTo(new File(environment.getProperty("spitter.file") + "/" + uuid + extention));

        spitter.setImgLogo("/spitter/image/" + uuid);

        spitterRepository.save(spitter);

        return new JsonUtils(ResultEnum.SUCCESS,null,spitter.getUserName());
    }

    @PostMapping(value = "/spittles/{username}")
    @ResponseBody
    public JsonUtils spitterProfile(@PathVariable String username) throws IncorrectResultSizeDataAccessException {
        return new JsonUtils(ResultEnum.SUCCESS,null,
                spitterRepository.findOneByUserName(username));
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> spitterNotFoundHandler(Exception exception){
        exception.printStackTrace();
        return new ResponseEntity<String>("抱歉.查无此人",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicateSpitterHandler(){
        return new ResponseEntity<String>("用户名已被占用.",HttpStatus.SERVICE_UNAVAILABLE);
    }

}
