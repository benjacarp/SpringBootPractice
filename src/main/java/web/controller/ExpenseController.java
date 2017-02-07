package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.dto.ExpenseDTO;
import web.service.ExpenseService;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    @Autowired
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    @ResponseBody
    public List<ExpenseDTO> getAll() {
        return service.findAll();
    }

    @RequestMapping(value= "/new", method = RequestMethod.POST)
    @ResponseBody
    public ExpenseDTO create(@RequestParam(value = "desc", required = false, defaultValue = "No Description") String desc,
                             @RequestParam(value = "tags") String[] tags,
                             @RequestParam(value = "quantity", required = true) int quantity) {
        return service.createExpense(desc, tags, quantity);
    }
}
