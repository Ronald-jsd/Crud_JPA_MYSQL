package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private int stock;
    @Column
    private double precio;
    @Column
    private String fecha_ingreso;
    
	public Producto() {
	}
    
	public Producto(String nombre, String descripcion, int stock, double precio, String fechaIngreso) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.fecha_ingreso = fechaIngreso;
	}

	public Producto(Integer id, String nombre, String descripcion, int stock, double precio, String fechaIngreso) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.fecha_ingreso = fechaIngreso;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFechaIngreso() {
		return fecha_ingreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fecha_ingreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Producto id=" + id + ", nombre=" + nombre;
	}

   

	
}
