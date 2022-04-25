package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminPageController {

    private final ClientService clientService;

    @Autowired
    public AdminPageController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/admin")
    public String findAllClients(Model model){
        List<Client> client = clientService.findAllClient();
        model.addAttribute("clients",client);
        return "adminPage";
    }



    @GetMapping("/admin/AddInfo")
    public String createAddInfoForm(Client client){
        return "adminPageAddInfo";
    }

    @PostMapping("/admin/AddInfo")
    public String addInfo(Client client){
        clientService.saveClient(client);
        return "redirect:/admin";
    }


    @GetMapping("/admin/DeleteInfo/{id_client}")
    public String deleteInfo(@PathVariable("id_client") Integer id){
        clientService.deleteClientById(id);
        return "redirect:/admin";
    }


    @GetMapping("/admin/UpdateInfo/{id_client}")
    public  String updateClientForm(@PathVariable("id_client") Integer id, Model model){
        Client client = clientService.findClientById(id);
        model.addAttribute("client", client);
        return  "/adminPageUpdateInfo";
    }

    @PostMapping("/admin/UpdateInfo")
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/admin";
    }
}
