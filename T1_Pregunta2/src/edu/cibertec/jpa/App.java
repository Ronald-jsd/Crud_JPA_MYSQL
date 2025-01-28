package edu.cibertec.jpa;

import java.util.Scanner;

import models.Producto;
import repository.ProductoRepository;

public class App {
	static Scanner teclado = new Scanner(System.in);
	static ProductoRepository operaciones = new ProductoRepository();

	public static void main(String[] args) {
		imprimir("*************************");
		imprimir("*       Bienvenido      *");
		imprimir("*************************");

		try {
			int opcion = 0;
			do {
				imprimir("- Por favor escoja una opción:\n" 
						+ "1. Ingresar un nuevo producto." 
						+ "\n2. Actualizar un producto."
						+ "\n3. Listar todos los productos." 
						+ "\n4. Buscar producto por id." 
						+ "\n5. Eliminar producto."
						+ "\n- Inserte 0 para cerrar sesion.");
				try {
					opcion = teclado.nextInt();
					teclado.nextLine();
					
					switch (opcion) {
					case 1:
						insertarProductos();
						break;
					case 2:
						actualizarProductos();
						break;
					case 3:
						listarPedidos();
						break;
					case 4:
						buscarProductoPorID();
						break;
					case 5:
						eliminarProductoPorID();
						break;
					default:
						imprimir("OPCION NO VALIDA.");
					}
				} catch (Exception e) {
					imprimir("Error: " + e.getMessage() + "\nIngrese un valor valido");
					teclado.nextLine();//clear buffer
				}
			} while (opcion != 0);
			imprimir("SESION CERRADA");
			teclado.close();
		} catch (Exception ex) {
			System.err.println("Ocurrió un error durante las operaciones: " + ex.getMessage());
		} finally {
			operaciones.cerrarRecursos();
			imprimir("\nRecursos cerrados correctamente.");
		}
	}

	
	//----------------------------------------------------------------------------
	// METODOS CRUD
	static void insertarProductos() {
		imprimir("*REGISTRAR NUEVO PRODUCTO");

		// CREAR
		Producto nuevoProducto = pedirDaatos();
		imprimir("Insertando un nuevo empleado...");
		// agregar nuevo producto a la DB
		operaciones.insertar(nuevoProducto);
	}

	static void actualizarProductos() {
		imprimir("Escoja el numero de producto a actualizar: ");
		imprimir("--------------------------------------");
		listarPedidos();

		int nProductoUpdate = teclado.nextInt();
		teclado.nextLine();

		// ACTUALIZAR POR ID
		Producto productoActualizado = pedirDaatos();
		productoActualizado.setId(nProductoUpdate);

		imprimir("\nIntentando actualizar el producto con codigo " + productoActualizado.getId() + "...");
		operaciones.actualizar(productoActualizado);
	}

	static void listarPedidos() {
		// LISTAR
		imprimir("--------------------------------------");
		imprimir("---Lista de productos---");
		operaciones.seleccionarTodo().forEach(System.out::println);
		imprimir("--------------------------------------");
	}

	static void buscarProductoPorID() {

		imprimir("BUSCAR PRODUCTO POR SU ID");
		imprimir("Ingrese el codigo del producto");

		// Buscar por id
		int idBusqueda = teclado.nextInt();
		imprimir("\nSe esta buscando el empleado con ID " + idBusqueda + "...");

		// llamada al metodo buscar
		Producto productoBuscado = operaciones.buscar(idBusqueda);

		if (productoBuscado != null) {
			imprimir("Producto encontrado: \n" + productoBuscado);
		} else {
			imprimir("Producto con el codigo \n" + idBusqueda + " no fue encontrado.");

		}
	}

	static void eliminarProductoPorID() {
		System.out.println("Eliminar Producto");
		System.out.println("Escriba el numero de producto a eliminar:\n");
		listarPedidos();

		// ELIMINAR POR ID
		int idEliminar = teclado.nextInt();
		imprimir("\nIntentando eliminar el producto con ID " + idEliminar + "...");
		operaciones.eliminar(idEliminar);
	}

	// METODOS ADICIONALES-----------------------------------------------------------------
	static void imprimir(String cad) {
		System.out.println(cad);
	}

	static Producto pedirDaatos() {
		System.out.println("Escriba el nombre del producto:");
		String producto = teclado.nextLine();
		imprimir("Escriba la descripción del producto:");
		String descripcion = teclado.nextLine();
		imprimir("Escriba el stock del producto:");
		int stock = teclado.nextInt();
		imprimir("Escriba el precio del producto:");
		double precio = teclado.nextDouble();
		teclado.nextLine();
		imprimir("Escriba la fecha del producto (Formato: año-mes-dia):");
		String fecha = teclado.nextLine();
		Producto nuevoProducto = new Producto(producto, descripcion, stock, precio, fecha);
		return nuevoProducto;
	}
	
}
