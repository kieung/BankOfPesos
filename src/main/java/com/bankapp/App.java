package com.bankapp;


import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.controller.UserController;
import com.bankapp.model.User;

/**
 * Hello world!
 *
 */


@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);;

    }

}
