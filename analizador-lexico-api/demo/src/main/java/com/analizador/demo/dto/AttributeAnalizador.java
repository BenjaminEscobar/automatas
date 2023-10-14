package com.analizador.demo.dto;

public class AttributeAnalizador {

	private String visibility;
    private String type;
    private String name;

    public AttributeAnalizador(String visibility, String type, String name) {
        this.visibility = visibility;
        this.type = type;
        this.name = name;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
