package com.agustrocha.api.controller;

import com.agustrocha.api.models.entity.Cliente;
import com.agustrocha.api.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("cliente")
@RequestMapping("/")
public class ClienteController {

    @Autowired
    @Qualifier("clienteService") //En caso de que hubiesen varias implementaciones de la interfaz, se deberá especificar cual queremos usar.
    private IClienteService clienteService; //Se recomienda utilizar la clase más genérica posible, el Autowired usará la clase que tenga implementada esta interfaz.

    @GetMapping("/listar") //Request del tipo GET
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());

        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);

        return "form";
    }

    @PostMapping("/form") //Request del tipo POST
    public String guardar(@Valid Cliente cliente, BindingResult result, SessionStatus status){
        if(result.hasErrors()){ //Determinamos si lo recogido en el formulario tiene errores o no y devuelve mensajes de error en caso de que los tenga.
            return "form";
        }
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Cliente cliente = null;

        if(id > 0){
            cliente = clienteService.findOne(id);
        } else {
            return "redirect:/listar";
        }

        model.addAttribute("cliente", cliente);

        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if(id > 0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }

}
