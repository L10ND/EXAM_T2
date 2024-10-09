package edu.cibertec.T2.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrden;
	
	private int idCliente;
	
	private int idLibro;
	
	private LocalDate fechaOrden;
	
	 @ManyToMany
	    @JoinTable(
	        name = "ordenes_libros", 
	        joinColumns = @JoinColumn(name = "idOrden"), 
	        inverseJoinColumns = @JoinColumn(name = "idLibro")
	    )
	    private List<Libro> libros;

	public Orden() {
	}

	public Orden(int idOrden, int idCliente, int idLibro, LocalDate fechaOrden, List<Libro> libros) {
		this.idOrden = idOrden;
		this.idCliente = idCliente;
		this.idLibro = idLibro;
		this.fechaOrden = fechaOrden;
		this.libros = libros;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
