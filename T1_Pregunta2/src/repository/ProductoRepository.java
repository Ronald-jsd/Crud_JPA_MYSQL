package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.Producto;

public class ProductoRepository {

    // Inicialización de EntityManagerFactory y EntityManager
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    // instancia para interactuar con la base de datos.
    private EntityManager em = emf.createEntityManager();

    // cerrar recursos
    public void cerrarRecursos() {
        if (em.isOpen())
            em.close();
        
        if (emf.isOpen())
            emf.close();
    }
    
    // Insertar un producto
    public void insertar(Producto producto) {
        try {
            // Inicia una transacción.
            em.getTransaction().begin();

            // Insertar nuevo producto a la BD
            em.persist(producto);

            // Confirma transacción.
            em.getTransaction().commit();

            System.out.println("El producto se insertó correctamente.");
            
        } catch (Exception e) {
        	
        	if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } // Si ocurre un error, rollback para deshacer los cambios.

            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }


    // METODO LISTAR
    public List<Producto> seleccionarTodo() {
        try {
            String jpql = "SELECT e FROM Producto e";

            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            // consulta tipada que devuelve objetos de la clase `Producto`.

            return query.getResultList();
            // Ejecuta la consulta y devuelve una lista de todos los productos.

        } catch (Exception ex) {
            System.err.println("Error al seleccionar todos los productos: " + ex.getMessage());
            return null;
        }
    }

    
    // BMETODO BUSCAR POR ID
    public Producto buscar(int id) {
        try {
            // Busca un producto en la base de datos utilizando su ID y lo retorna.
            return em.find(Producto.class, id);
        } catch (Exception ex) {
            System.err.println("Error al buscar producto: " + ex.getMessage());
            return null;
        }
    } 
   
    // METODO ACTUALIZAR
    public void actualizar(Producto e) {
        try {
            em.getTransaction().begin();
            // Inicia una transacción.

            // Busca al producto existente en la base de datos por su ID.
            Producto producto = em.find(Producto.class, e.getId());

            if (producto != null) {
                producto.setNombre(e.getNombre());
                producto.setDescripcion(e.getDescripcion());
                producto.setStock(e.getStock());
                producto.setPrecio(e.getPrecio());
                producto.setFechaIngreso(e.getFechaIngreso());
                // Actualiza los datos del producto encontrado con los nuevos valores.

                em.getTransaction().commit();

                System.out.println("El producto se actualizó correctamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.err.println("Error al actualizar producto: " + ex.getMessage());
        }
    }

    // METODO ELIMINAR POR ID
    public void eliminar(int id) {
        try {
            em.getTransaction().begin();

            Producto p = em.find(Producto.class, id);
            
 
            if (p != null) {
                // Elimina producto encontrado.
                em.remove(p);

                em.getTransaction().commit();

                System.out.println("El producto se eliminó correctamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.err.println("Error al eliminar empleado: " + ex.getMessage());
        }
    }

}
