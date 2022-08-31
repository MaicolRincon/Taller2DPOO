package Hamburguesas;

public class Ingrediente {

	
	private String nombre;
	private int costoAdicional;
	
	//Metodo Constructor
	public String getNombre() {
		return nombre;
	}
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	public Ingrediente(String nombre, int costoAdicional) {
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}
	
	
	
	
}
