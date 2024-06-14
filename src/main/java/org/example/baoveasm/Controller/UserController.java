package org.example.baoveasm.Controller;


import org.example.baoveasm.Entity.User;
import org.example.baoveasm.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/Home") // gọi ra trang chủ ở đường dẫn /Home
    public String getHome(Model model){
        return "index"; // trả về giao diện ở thư mục templates
    }

    @GetMapping("/All") // gọi ra trang chủ ở đường dẫn /Home
    public String getAll(Model model){
        model.addAttribute("User",userRepo.findAll()); //lấy danh sách user ra để show bên html
        return "index"; // trả về giao diện ở thư mục templates
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("User") Model model){
        User user =(User) model;

    }
}
