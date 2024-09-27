package org.example.persona.controllers;

import org.example.persona.entities.Libro;
import org.example.persona.servicies.LibroServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl> {

}
