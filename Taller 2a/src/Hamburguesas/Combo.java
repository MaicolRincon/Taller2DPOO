package Hamburguesas;

import java.util.ArrayList;

public class Combo {


	private double descuento;
	private String nombre;
	private String hamburguesa;
	private String bebida;
	private String papas;
	
	public Combo(String nombre, double descuento, String hamburguesa,String papas, String bebida) {
		this.nombre = nombre;
		this.descuento = descuento;
		this.bebida = bebida;
		this.descuento = descuento;
		this.hamburguesa = hamburguesa;
		this.papas=papas;
	}
	
	public void agregarItemACombo(Producto itemCOmbo) {
		
	}
	
	public double getPrecio(ArrayList<ProductoMenu> menu) {
		
		double precioConDescuentoHamburguesa = 0;
		double precioConDescuentoPapas = 0;
		double precioConDescuentoBebida = 0;
		double precioCombo=0;
	
		for(int i=0;i<menu.size();i++) {
			System.out.println(menu.get(i).getNombre());
			
			if(menu.get(i).getNombre().equals(hamburguesa)) {
		
				double valorDescuentoHamburguesa = menu.get(i).getPrecioBase()*descuento/100;
				precioConDescuentoHamburguesa = menu.get(i).getPrecioBase()-valorDescuentoHamburguesa;
				
			}
			
			if(menu.get(i).getNombre().equals(papas)) {
				double valorDescuentoPapas = menu.get(i).getPrecioBase()*descuento/100;
				precioConDescuentoPapas = menu.get(i).getPrecioBase()-valorDescuentoPapas;
				
			}
			
			if(menu.get(i).getNombre().equals(bebida)) {
				double valorDescuentoBebida = menu.get(i).getPrecioBase()*descuento/100;
				precioConDescuentoBebida = menu.get(i).getPrecioBase()-valorDescuentoBebida;
				
			}
			
			precioCombo = precioConDescuentoHamburguesa+precioConDescuentoPapas+precioConDescuentoBebida;
			
		}
		
		return precioCombo;
	}
	
	public String generarTextoFactura() {
		return null;
	}
	
	public String getNombre() {
		return nombre;
		
	}
	public String getHamburguesa() {
		return hamburguesa;
	}

	public String getBebida() {
		return bebida;
	}

	public String getPapas() {
		return papas;
	}
	
	
}
