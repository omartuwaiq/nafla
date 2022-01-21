package com.example.eventms.model.Services;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AdminService {


    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admins> getAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admins> getAdmin(String adminId) {
        return adminRepository.findById(adminId);

    }

    public void addNewAdmin(Admins admin) {
        adminRepository.save(admin);

    }


    public void deleteAdmin(String adminId) {
        adminRepository.deleteById(adminId);
    }

    public String getCheck(String adminname ,String password) {
        if( adminRepository.existsById(adminname)  ) {

            String Admins = adminRepository.findByUsername(adminname);
            if (Admins.equals(password)) {
                return "welcome you Authentication Admin";
            } else {
                return " sorry not  Authentication ";
            }
        }
        return "sorry not  Authentication ";
    }

    }

