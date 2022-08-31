package Hamburguesas;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Restaurante {
	
	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	public Pedido getPedidoEnCurso() {
		
		return null;
	}
	
	public ArrayList<Producto> getMenuBase(){
		return null;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return null;
		
			
	}
	
	public ArrayList<Object> cargarInformacionRestaurante() throws FileNotFoundException, IOException {
		
		ArrayList<Ingrediente> ingredientes = cargarIngredientes();
		ArrayList<ProductoMenu> menu = cargarMenu();
		ArrayList<Combo> combos = cargarCombos();
		
		ArrayList<Object> restaurante = new ArrayList<>();
		restaurante.add(menu);
		restaurante.add(combos);
		restaurante.add(ingredientes);
		
		return restaurante;
		
	}
	
	private ArrayList<Ingrediente> cargarIngredientes() throws FileNotFoundException, IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("./data/ingredientes.txt"));
		String linea = br.readLine();

		
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		
		
		while (linea != null) {
			
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			Ingrediente _ingrediente = new Ingrediente(nombre,precio);
			ingredientes.add(_ingrediente);
			linea = br.readLine();
		}
		
		return ingredientes;
		
		
		
	}
	
	private ArrayList<ProductoMenu> cargarMenu () throws FileNotFoundException, IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("./data/menu.txt"));
		String linea = br.readLine();

		
		ArrayList<ProductoMenu> productos = new ArrayList<>();
		
		
		while (linea != null) {
			
			String[] partes = linea.split(";");
			String producto = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			ProductoMenu _productoMenu = new ProductoMenu(producto,precio);
			productos.add(_productoMenu);
			linea = br.readLine();
		}
		
		return productos;
		
	}
	
	private ArrayList<Combo> cargarCombos () throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader("./data/combos.txt"));
		String linea = br.readLine();

		
		ArrayList<Combo> combos = new ArrayList<>();
		
		
		while (linea != null) {
			
			String[] partes = linea.split(";");
			String nombre = partes[0];
			double descuento = Double.parseDouble(partes[1]);
			String hamburguesa = partes[2];
			String papas = partes[3];
			String bebida = partes[4];
			
			Combo _combo = new Combo(nombre,descuento,hamburguesa,papas, bebida);
			combos.add(_combo);
			linea = br.readLine();
		}
		
		return combos;
		
		
	}

}
