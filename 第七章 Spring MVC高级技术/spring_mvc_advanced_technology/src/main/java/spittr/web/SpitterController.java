package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spittr.data.SpitterRepository;
import spittr.pojo.Spitter;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/spitter")
@PropertySource("classpath:/application.properties")
public class SpitterController {

    private final SpitterRepository spitterRepository;

    private final String uploadPath;

    private final String uploadUrl;

    @Autowired
    public SpitterController(
            SpitterRepository spitterRepository,
            @Value("${temp.spitter.upload.path}") String uploadPath,
            @Value("${temp.spitter.upload.api}") String uploadUrl) {
        this.spitterRepository = spitterRepository;
        this.uploadPath = uploadPath;
        this.uploadUrl = uploadUrl;
    }

    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute(new Spitter());
        return "register";
    }

    @PostMapping(value = "/register")
    public String processRegisteration(@RequestPart(value = "image") MultipartFile imageFile, @Valid Spitter spitter, Errors error) throws IOException {
        if (error.hasErrors()) {
            return "/register";
        }
        if (spitterRepository.countSpitterByUserName(spitter.getUserName()) > 0) {
            error.rejectValue("userName", "500", "用户名已存在");
            return "/register";
        }
        File dictionary = new File(uploadPath + spitter.getUserName());
        if (!dictionary.exists()) {
            dictionary.mkdirs();
        }
        if (imageFile.getSize() > 0) {
            String absolutePath = spitter.getUserName() + "/" + LocalDate.now() + " - " + imageFile.getOriginalFilename();
            // 去除空格
            absolutePath = absolutePath.replaceAll(" ", "");
            spitter.setImageUrl(uploadUrl + absolutePath);
            imageFile.transferTo(new File(uploadPath + absolutePath));
        }

        spitterRepository.save(spitter);
        return "redirect:/spitter/user/" + URLEncoder.encode(spitter.getUserName(), "UTF-8");
    }

    @GetMapping(value = "/user/{username}")
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute("spitter", spitterRepository.findOneByUserName(username));
        return "profile";
    }

}
