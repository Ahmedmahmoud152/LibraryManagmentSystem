package com.example.LibraryManagementSystem.Book;

import com.example.LibraryManagementSystem.Parton.PartonRepo;
import com.example.LibraryManagementSystem.Parton.Parton;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.*;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(PartonRepo partonRepo){

        return args -> {
            Parton parton1=new Parton("Ahmed","01111570767");
            Parton parton2=new Parton("Mazen","01151181472");
            Parton parton3=new Parton("Mama","01552551665");

            partonRepo.saveAll(List.of(parton1,parton2,parton3));

        };

    }

}
