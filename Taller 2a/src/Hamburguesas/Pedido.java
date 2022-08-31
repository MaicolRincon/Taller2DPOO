package Hamburguesas;

import java.io.File;

public class Pedido {

	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		
	}
	
	public void guardarFactura(File archivo) {
		
	}

	public int getIdPedido() {
		return idPedido;
	}
	
	private int getPrecioNetoPedido() {
		return 0;
	}
	
	private int getPrecioTotalPedido() {
		return 0;
	}
	
	private int getPrecioIVAPedudo() {
		return 0;
	}
	
	private String generarTextoFactura() {
		return null;
	}
}
