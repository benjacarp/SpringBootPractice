package web.repository;

import org.springframework.stereotype.Component;
import web.model.Expense;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repo {

    private List<Expense> expenses = new ArrayList<Expense>();

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void save(Expense expense) {
        expenses.add(expense);
    }
}
