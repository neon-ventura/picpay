package com.picpay.services;


import com.picpay.domain.user.User;
import com.picpay.domain.user.UserType;
import com.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User user, BigDecimal amount) throws Exception {
        if (user.getUserType() == UserType.MERCHANT) {
            throw new Exception("The user type Merchant do not is authorized for realized transactions");
        }

        if (user.getBalance().compareTo(amount) < 0) {
            throw new Exception("insufficient amount");
        }
    }

}
