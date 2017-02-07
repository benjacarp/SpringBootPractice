package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dto.ExpenseDTO;
import web.model.Expense;
import web.repository.Repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseService {

    @Autowired
    private Repo repo;

    public List<ExpenseDTO> findAll() {

        List<Expense> expenses = repo.getExpenses();
        List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>();

        for (Expense expense : expenses) {
            expenseDTOList.add(expense.toDTO());
        }

        return expenseDTOList;
    }

    public ExpenseDTO createExpense(String desc, String[] tags, int quantity) {
        Expense expense = new Expense();

        expense.setTime(new Timestamp(System.currentTimeMillis()));
        expense.setDescription(desc);
        expense.setTags(tags);
        expense.setQuantity(quantity);

        repo.save(expense);

        return expense.toDTO();
    }
}
