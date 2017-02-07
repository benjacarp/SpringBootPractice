package web.model;

import web.dto.ExpenseDTO;

import java.sql.Timestamp;

public class Expense {

    private Timestamp time;
    private String description;
    private int quantity;
    private String[] tags;

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getTags() {
        return tags;
    }

    public ExpenseDTO toDTO() {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setTime(String.valueOf(time));
        expenseDTO.setTags(tags);
        expenseDTO.setDescription(description);
        expenseDTO.setQuantity(quantity);

        return expenseDTO;
    }
}
