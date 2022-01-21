package com.example.eventms.controller;

import com.example.eventms.model.Entities.Admins;
import com.example.eventms.model.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path ="api/admin")
public class AdminController {


        private AdminService adminService ;

        @Autowired
        public AdminController(AdminService adminService) {
            this.adminService = adminService;
        }

        @GetMapping
        public List<Admins> getAdmins() {
            return adminService.getAdmins();
        }

        @GetMapping(path = "{adminId}")
        public Optional<Admins> getAdmin(@PathVariable(name = "adminId") String adminId) {
            return adminService.getAdmin(adminId);
        }

        @PostMapping(path= "add")
        public void registerNewAdmin(@RequestBody Admins admin){
            adminService.addNewAdmin(admin);
        }

        @DeleteMapping(path = "delete/{adminId}")
        public void deleteAdmin(@PathVariable ("adminId") String adminId){
            adminService.deleteAdmin(adminId);
        }

//
//
    @GetMapping(path = "login")
   public String checkLogin(@RequestParam (name = "adminname") String adminname , @RequestParam (name = "password")
            String password ) {
     return adminService.getCheck(adminname,password);

   }
    }






