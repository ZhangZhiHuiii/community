package com.zzh.community.controller;

import com.zzh.community.dto.PaginationDTO;
import com.zzh.community.dto.QuestionDTO;
import com.zzh.community.mapper.QuestionMapper;
import com.zzh.community.mapper.UserMapper;
import com.zzh.community.model.Question;
import com.zzh.community.model.User;
import com.zzh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request,Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "2")Integer size,
                        @RequestParam(name = "search",required = false)String  search){
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null){
//            return "redirect:/";
//        }
        PaginationDTO pagination = questionService.list(search,page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
