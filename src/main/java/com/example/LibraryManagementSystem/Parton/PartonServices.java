package com.example.LibraryManagementSystem.Parton;

import com.example.LibraryManagementSystem.Book.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartonServices {

    @Autowired
    private PartonRepo partonRepo;

    PartonServices(PartonRepo partonRepo) {
        this.partonRepo = partonRepo;
    }

    public List<Parton> getAllParton() {
        return partonRepo.findAll();
    }

    public Parton customParton(Long id) {
        Optional<Parton> parton = partonRepo.findById(id);
        return parton.orElseThrow(() -> new IllegalStateException("Book is not found"));
    }

    public void addParton(Parton parton) {
        Optional<Parton> optionalBook = partonRepo.findById(parton.getId());
        if (optionalBook.isPresent()) {
            throw new IllegalStateException("Book is exist");
        }
        partonRepo.save(parton);
    }

    public void deleteParton(Long partonId) {
        boolean exists = partonRepo.existsById(partonId);
        if (!exists) {
            throw new IllegalStateException("Book with id: " + partonId + " does not found");
        }

        partonRepo.deleteById(partonId);
    }

    @Transactional
    public void updateParton(Long id, String name, String contactInfo) {
        Parton parton = partonRepo.findById(id).
                orElseThrow(() -> new IllegalStateException("Parton with id " + id + "does not dounde"));

        if (name != null && !name.isEmpty() && !Objects.equals(parton.getName(),name)){
            parton.setName(name);
        }
        if (contactInfo != null && !contactInfo.isEmpty() && !Objects.equals(parton.getContactInfo(),contactInfo)){
            parton.setContactInfo(contactInfo);
        }



    }


}
