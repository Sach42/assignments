package com.expense.expensetracker.Service;

import com.expense.expensetracker.Model.User;
import com.expense.expensetracker.Repository.IUserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepository;

    public User registerUser(User user) throws NoSuchAlgorithmException {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }


        String hashedPassword = md5Hash(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    @SneakyThrows
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(md5Hash(password))) {
            return null;
        }
        return null;
    }

    public static String md5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(input.getBytes());
        byte[] digested = md5.digest();

        return DatatypeConverter.printHexBinary(digested);

    }
}
