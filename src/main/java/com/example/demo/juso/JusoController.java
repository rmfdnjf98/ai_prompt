package com.example.demo.juso;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class JusoController {

    @GetMapping("/juso/popup")
    public String jusoPopup() {
        return "juso/popup";
    }

    @PostMapping("/juso/popup")
    public String jusoCheck(JusoRequest.Address addr, Model model) {
        model.addAttribute("addr", addr);
        return "juso/popup_callback";
    }
}
