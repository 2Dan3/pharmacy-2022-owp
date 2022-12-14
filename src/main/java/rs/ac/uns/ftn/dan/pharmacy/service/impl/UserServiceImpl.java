package rs.ac.uns.ftn.dan.pharmacy.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.dan.pharmacy.bean.SecondConfiguration;
import rs.ac.uns.ftn.dan.pharmacy.controller.UserController;
import rs.ac.uns.ftn.dan.pharmacy.model.CreateUserDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.User;
import rs.ac.uns.ftn.dan.pharmacy.model.Users;
import rs.ac.uns.ftn.dan.pharmacy.service.UserService;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SecondConfiguration.ApplicationMemory appMemory;

    @Autowired ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        appMemory = applicationContext.getBean(SecondConfiguration.ApplicationMemory.class);
        Users users = new Users();
        appMemory.put(UserController.USERS_KEY, users);
    }

    @Override
    public void save(CreateUserDTO userDTO) throws ParseException {
        Users users = (Users) appMemory.get(UserController.USERS_KEY);

        User user = new User(userDTO);
        user = users.save(user);
    }
}
