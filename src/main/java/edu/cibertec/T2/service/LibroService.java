package edu.cibertec.T2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.T2.model.Libro;
import edu.cibertec.T2.repository.ILibroRepository;

@Service
public class LibroService {

	@Autowired
	private ILibroRepository LibroRepository;
	
	public List<Libro> listarLibro(){
		return LibroRepository.findAll();
	}
	
	public Libro hallarLibro(int codigo) {
		return LibroRepository.findById(codigo).orElse(null);
	}
	
	public Libro guardarLibro(Libro libro) {
		return LibroRepository.save(libro);
	}
	
	public void eliminarLibro(int codigo) {
		LibroRepository.deleteById(codigo);
	}
}
