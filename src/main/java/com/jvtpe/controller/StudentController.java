package com.jvtpe.controller;

import com.jvtpe.domain.Student;
import com.jvtpe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/hi")
    public ModelAndView sayHi(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Hello");
        modelAndView.addObject("messagebody","This app student project");
        modelAndView.setViewName("hi");
        return modelAndView;
    }

    @GetMapping("new")
    public String sendStudentForm(@ModelAttribute("student") Student student) {

        return "studentForm";

    }

    @PostMapping("/saveStudent")
    public String createStudent(@ModelAttribute Student student) {
        iStudentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping
    public ModelAndView getStudents(){
        List<Student> list = iStudentService.getAllStudent();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",list);
        mav.setViewName("students");
        return mav;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Student student = iStudentService.findStudentById(id);
        model.addAttribute(student);
        return "studentForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudent(id);
        return "redirect:/students";
    }
}
