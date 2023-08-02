package com.expense.expensetracker.Repository;


import com.expense.expensetracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}