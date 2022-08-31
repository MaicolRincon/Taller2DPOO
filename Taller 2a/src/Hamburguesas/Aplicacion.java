package Hamburguesas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aplicacion {

	// Le muestra al usuario el menu disponible
	public void mostrarMenu(ArrayList<Object> restaurante) {
		System.out.println("------------ BIENVENIDO --------------");

		System.out.println("\n1. Mostrar el menu e iniciar pedido");
		System.out.println("2. Salir de la aplicaci�n");
		
		int opcion= Integer.parseInt(input("\nPor favor digite una opci�n: "));
		ejecutarOpcion(opcion,restaurante);
		
	}
	
	//Ejecuta la opci�n escogida por el usuario
	public void ejecutarOpcion(int opcionSeleccionada, ArrayList<Object> restaurante) {
		
		
		try
		{
			if (opcionSeleccionada == 1) {

				System.out.println("     PRODUCTO      ---       PRECIO");

				ArrayList<ProductoMenu> menu = new ArrayList<>();
				menu = (ArrayList<ProductoMenu>) restaurante.get(0);
				
				ArrayList<Combo> combos = new ArrayList<>();
				combos = (ArrayList<Combo>) restaurante.get(1);
				
				ArrayList<Ingrediente> ingredientes = new ArrayList<>();
				ingredientes = (ArrayList<Ingrediente>) restaurante.get(2);
				
				ArrayList<Integer> opcionesPedido = new ArrayList<>();
				
				ArrayList<String> pedidoEnPantalla = new ArrayList<>();
				
				ArrayList<Integer> opcionesIngredientes = new ArrayList<>();

				for(int i= 1; i<= menu.size() ; i++) {

					System.out.println(i + ". " + menu.get(i-1).getNombre() + "   $ " + menu.get(i-1).getPrecioBase());

				}
				
				System.out.println("\n     ------ COMBOS  ------       \n");
				for(int i= 1; i<= combos.size() ; i++) {
					int b = i + menu.size();

					System.out.println(b + ". " + combos.get(i-1).getNombre() + "   --->   " + combos.get(i-1).getHamburguesa() + " + " + combos.get(i-1).getPapas() + " + " + combos.get(i-1).getBebida());

				}
				
				int opcionPedido = 1;
				while(opcionPedido!=0) {
					opcionPedido = Integer.parseInt(input("\n Seleccione el numero correspodiente al producto que desea llevar, marque 0 cuando a finalice"));
		
					if (opcionPedido!=0) {
						if (opcionPedido>=1 && opcionPedido<=(menu.size()+combos.size())) {
							int a = 0;
							a = opcionPedido - 1;
							opcionesPedido.add(a);
							
							if (opcionPedido<=menu.size()) {
								System.out.println("Se agrego " + menu.get(opcionPedido-1).getNombre() + " a su pedido");
								pedidoEnPantalla.add(menu.get(opcionPedido-1).getNombre());
							}
							else {
								System.out.println("Se agrego " + combos.get(opcionPedido-1-menu.size()).getNombre() + " a su pedido");
								pedidoEnPantalla.add(combos.get(opcionPedido-1-menu.size()).getNombre());
							}
							

						}
						else System.out.println("\nLa opci�n marcada no se encuentra en el menu, intenta de nuevo");
					}
				
				}
				System.out.println("\nSu pedido es el siguiente: \n");
				
				for(int c = 0;c<pedidoEnPantalla.size(); c++) {
					System.out.println(pedidoEnPantalla.get(c));
				}
				
				System.out.println("\n1. Desea agregar un ingrediente");
				System.out.println("2. Desea Terminar el Pedido");
				
				int opcion2 = Integer.parseInt(input("\nMarque una opci�n para continuar"));
				
				if (opcion2==1) {
					
					for(int i= 1; i<= ingredientes.size() ; i++) {

						System.out.println(i + ". " + ingredientes.get(i-1).getNombre());
					
					}
					int opcion3=1;
					while (opcion3!=0) {
						opcion3 = Integer.parseInt(input("Seleccione el ingrediente que desea agregar y marque 0 para terminar"));
						if(opcion3!=0) {
							if(opcion3<=ingredientes.size()) {
								
								pedidoEnPantalla.add(ingredientes.get(opcion3-1).getNombre());
								opcionesIngredientes.add(opcion3);
								System.out.println("Se agrego " + ingredientes.get(opcion3-1).getNombre() + " a su pedido");
							}
							else System.out.println("Esa opci�n no esta disponible en el men�");
							
						}
						
					}
					
				}
				
				System.out.println("\nSu pedido es el siguiente: \n");
				for(int c = 0;c<pedidoEnPantalla.size(); c++) {
					System.out.println(pedidoEnPantalla.get(c));
				}
				
				
				System.out.println("\nPara efectuar el pedido necesitaremos los siguientes datos: \n");
				String nombreCliente = input("Nombre");
				String direccionCliente = input("Direcci�n");
				
				System.out.println("--Gracias. En momento estara listo su pedido--");
				
				double precioCombo = 0;
				
				for(int i=0;i<opcionesPedido.size();i++) {
					if(opcionesPedido.get(i)>menu.size()) {
						
						int x = opcionesPedido.get(i)-menu.size();	
						
						precioCombo = combos.get(x).getPrecio(menu);
						
					}
				}
				int precioProducto= 0;
				
				for(int i=0;i<opcionesPedido.size();i++) {
					if(opcionesPedido.get(i)<=menu.size()) {
						
						int x = opcionesPedido.get(i)-1;	
						
						precioProducto += menu.get(x).getPrecioBase();	
						System.out.println("a");
					}
				}
				
				int precioIngredientes= 0;
				
				for(int i=0;i<opcionesIngredientes.size();i++) {
					if(opcionesIngredientes.get(i)<=ingredientes.size()) {
						
						int x = opcionesPedido(i)-1;	
						
						precioIngredientes += ingredientes.get(x).getCostoAdicional();						
					}
				}
				
				double total =precioIngredientes+precioProducto+precioCombo;
				
				System.out.println("Precio Total: " + total);
			}
			else if (opcionSeleccionada == 2)
			{
				System.out.println("Saliendo de la aplicación ...");

			}

			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
	

	
	
	private int opcionesPedido(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	// M�todo Main
	public static void main(String[] args) throws IOException {
		Restaurante rest = new Restaurante();
		ArrayList<Object> restaurante = new ArrayList<>();
		restaurante = rest.cargarInformacionRestaurante();
		
		Aplicacion app = new Aplicacion();
		app.mostrarMenu(restaurante);
		
	}
}
