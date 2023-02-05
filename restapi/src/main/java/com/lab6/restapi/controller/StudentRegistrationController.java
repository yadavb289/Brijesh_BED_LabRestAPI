package com.lab6.restapi.controller;

import com.lab6.restapi.entity.Student;
import com.lab6.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;

    // Displaying the list of students
    @RequestMapping("/list")
    public String listStudents(Model theModel) {
        List<Student> theStudents = studentService.findAll();
        theModel.addAttribute("Students", theStudents);
        return "homePage";
    }

    // Create model attribute for form data
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("Student", theStudent);
        return "updateDetails";
    }

    // Update methods
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
        Student theStudent = studentService.findById(theId);
        theModel.addAttribute("Student", theStudent);
        return "updateDetails";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName, @RequestParam("course") String course,
                              @RequestParam("country") String country) {

        System.out.println(id);
        Student theStudent;
        if (id != 0) {
            theStudent = studentService.findById(id);
            theStudent.setFirstName(firstName);
            theStudent.setLastName(lastName);
            theStudent.setCourse(course);
            theStudent.setCountry(country);
        } else
            theStudent = new Student(firstName, lastName, course, country);

        studentService.save(theStudent);
        return "redirect:/student/list";

    }

    // Deletion method
    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {

        studentService.deleteById(theId);
        return "redirect:/student/list";

    }


    @RequestMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName() + ", You are not authorized to access this page!");
        } else {
            model.addObject("msg", " You are not authorized to access this page!");
        }

        model.setViewName("403");
        return model;
    }
}
