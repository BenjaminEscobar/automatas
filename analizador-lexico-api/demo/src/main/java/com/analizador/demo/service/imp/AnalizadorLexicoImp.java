package com.analizador.demo.service.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.analizador.demo.dto.AttributeAnalizador;
import com.analizador.demo.dto.Respuesta;
import com.analizador.demo.dto.TokenAnalizador;
import com.analizador.demo.service.IAnalizadorLexicoBasico;

@Service
public class AnalizadorLexicoImp implements IAnalizadorLexicoBasico {
	
	
	@Override
	public Respuesta analizador(String cadena) {
		
		Respuesta respuesta = new Respuesta();

		// Se definen los patrones para tokens
		Pattern classPattern = Pattern.compile("class ([a-zA-Z][a-zA-Z0-9_]*)");
		Pattern attributePattern = Pattern
				.compile("(private|public|protected)\\s+(int|string|decimal)\\s+([a-zA-Z][a-zA-Z0-9_]*)");
		Pattern curlyBracesPattern = Pattern.compile("([{}])");
		//Pattern spacePattern = Pattern.compile("\\s+");

		// Inicializar listas para almacenar resultados
		List<TokenAnalizador> tokens = new ArrayList<>();
		Set<String> uniqueTokens = new HashSet<>();
		String className = null;
		List<AttributeAnalizador> attributes = new ArrayList<>();

		// Buscar tokens y datos en el texto de entrada
		Matcher classMatcher = classPattern.matcher(cadena);
		Matcher attributeMatcher = attributePattern.matcher(cadena);

		while (classMatcher.find()) {
			if (uniqueTokens.add(classMatcher.group())) {
				className = classMatcher.group(1);
				tokens.add(new TokenAnalizador("CLASS_NAME", className, "Nombre de Clase"));
			}
		}

		while (attributeMatcher.find()) {
			String visibility = attributeMatcher.group(1);
			String type = attributeMatcher.group(2);
			String attributeName = attributeMatcher.group(3);
			if (uniqueTokens.add(attributeMatcher.group())) {
				tokens.add(new TokenAnalizador("VISIBILITY", visibility, "Visibilidad"));
				tokens.add(new TokenAnalizador("DATA_TYPE", type, "Tipo de Dato"));
				tokens.add(new TokenAnalizador("ATTRIBUTE_NAME", attributeName, "Nombre de Atributo"));
				attributes.add(new AttributeAnalizador(visibility, type, attributeName));
			}
		}

		Matcher curlyBracesMatcher = curlyBracesPattern.matcher(cadena);
		while (curlyBracesMatcher.find()) {
			String braceLexeme = curlyBracesMatcher.group(1);
			if (uniqueTokens.add(braceLexeme)) {
				String braceName = braceLexeme.equals("{") ? "Llave de Apertura" : "Llave de Cierre";
				tokens.add(new TokenAnalizador("BRACE", braceLexeme, braceName));
			}
		}

		// Imprimir la tabla de tokens reconocidos con lexema y nombre personalizado
		/*
		System.out.println("Tabla de Tokens Reconocidos:");
		for (TokenAnalizador token : tokens) {
			System.out.println("Lexema: " + token.getLexeme() + ", Nombre: " + token.getName());
		}*/
		
		respuesta.setListaToken(tokens);

		// Imprimir el nombre de la clase
		/*
		if (className != null) {
			System.out.println("Nombre de la Clase: " + className);
		}
		*/
		
		respuesta.setNombreClase(className);

		// Imprimir la tabla de atributos declarados con información detallada
		/*
		System.out.println("Tabla de Atributos Declarados:");
		for (AttributeAnalizador attribute : attributes) {
			System.out.println("Método: " + attribute.getVisibility() + ", Tipo: " + attribute.getType() + ", Nombre: "
					+ attribute.getName());
		}*/
		
		respuesta.setListaAtributo(attributes);
		
		return respuesta;

	}

}
