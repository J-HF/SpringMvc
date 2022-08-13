package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UseMapper;
import com.pojo.MyException;
import com.pojo.Use;
import com.service.UseService;
import com.service.UseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UseController {
    @Autowired
    private UseService useService;
    @RequestMapping("/getAllUse")
    public String getAllUse(Model model) throws MyException {
        List<Use> allUse = useService.getAllUse();
//        if (1!=2){
//            throw new MyException("Sorry,你好");
//        }
//        int i=1/0;
        model.addAttribute("uses",allUse);
        return "allUse";
    }

    @PostMapping("/fileUpLoad")
    public String fileUpLoader(Model model,@RequestParam("upload") MultipartFile multipartFile){

        String w = UUID.randomUUID().toString();
//        获取源文件的后缀
        String originalFilename = multipartFile.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(i);
        File file = new File("D:/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = file+"/"+w+substring;
        System.out.println(path+"*****");
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/list")
    public String list(Model model,Integer pageNum) {
        PageInfo<Use> pageInfo = useService.findByPage(pageNum,2);
        model.addAttribute("pageInfo", pageInfo);
        return "/purchase/list";
    }
}
