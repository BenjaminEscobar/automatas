package com.analizador.demo.dto;

public class TokenAnalizador {
	
	private String tipo;
    private String lexeme;
    private String name;

    public TokenAnalizador(String tipo, String lexeme, String name) {
        this.tipo = tipo;
        this.lexeme = lexeme;
        this.name = name;
    }
    
    public String getTipo() {
    	return tipo;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getName() {
        return name;
    }

}
