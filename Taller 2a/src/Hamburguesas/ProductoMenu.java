package Hamburguesas;

public class ProductoMenu {

	private String nombre;
	private int precioBase;
	
	// Método Constructor
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecioBase() {
		return precioBase;
	}
	
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		
	}
	
	public String generarTextoFactura() {
		
		return null;
		
	}
}
