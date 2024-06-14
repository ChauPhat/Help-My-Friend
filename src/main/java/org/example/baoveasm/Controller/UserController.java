package org.example.baoveasm.Controller;

import org.example.baoveasm.Entity.User;
import org.example.baoveasm.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/Home")
    public String getAll(Model model) {
        model.addAttribute("users", userRepo.findAll()); // thêm thuộc tính là danh sách người dùng
        model.addAttribute("user", new User()); // thêm một đối tượng người dùng mới vào model
        return "index"; // trả về template index
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute User user) {
        userRepo.save(user); // lưu người dùng mới
        return "redirect:/Home"; // chuyển hướng về trang chủ
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        userRepo.save(user); // cập nhật người dùng
        return "redirect:/Home"; // chuyển hướng về trang chủ
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id) {
        userRepo.deleteById(id); // xóa người dùng theo id
        return "redirect:/Home"; // chuyển hướng về trang chủ
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        User user = userRepo.findById(id).orElse(null);
        model.addAttribute("user", user); // thêm người dùng vào model
        model.addAttribute("users", userRepo.findAll()); // thêm danh sách người dùng vào model
        return "index"; // trả về template index
    }

    // Phương thức mới để filter người dùng theo vai trò
    @GetMapping("/filter")
    public String filterByRole(@RequestParam String role, Model model) {
        model.addAttribute("users", userRepo.findByRole(role)); // thêm danh sách người dùng theo vai trò vào model
        model.addAttribute("user", new User()); // thêm một đối tượng người dùng mới vào model
        return "index"; // trả về template index
    }
}

