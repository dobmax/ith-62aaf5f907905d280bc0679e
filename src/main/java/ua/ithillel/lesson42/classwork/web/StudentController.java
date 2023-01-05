package ua.ithillel.lesson42.classwork.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.ithillel.lesson42.classwork.dataaccess.entity.Student;
import ua.ithillel.lesson42.classwork.dataaccess.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student findById(@PathVariable long id) {
        return studentService.findById(1L).orElse(null);
    }
}
