package org.example.persona.controllers;

import org.example.persona.entities.Autor;
import org.example.persona.servicies.AutorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {

}
