package com.analizador.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.analizador.demo.dto.Respuesta;
import com.analizador.demo.service.IAnalizadorLexicoBasico;

@CrossOrigin
@RestController
public class AnalizadorLexico {

	@Autowired
	IAnalizadorLexicoBasico iAnalizadorLexico;
	
	
	@GetMapping("obtiene-version")
	public String obtieneVersion() {
		return "0.0.1";
	}
	
	@PostMapping("analizador")
	public ResponseEntity<Respuesta> analizador(@RequestBody String cadena) {
		return new ResponseEntity<>(iAnalizadorLexico.analizador(cadena), HttpStatus.OK); 
	}
	
}
