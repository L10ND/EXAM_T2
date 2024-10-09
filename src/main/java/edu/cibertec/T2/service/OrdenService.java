package edu.cibertec.T2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.T2.model.Orden;
import edu.cibertec.T2.repository.IOrdenRepository;

@Service
public class OrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;
	
	public List<Orden> listarOrden(){
		return ordenRepository.findAll();
	}
	
	public Orden hallarOrden(int codigo) {
		return ordenRepository.findById(codigo).orElse(null);
	}
	
	public Orden guardarOrden(Orden Orden) {
		return ordenRepository.save(Orden);
	}
	
	public void eliminarOrden(int codigo) {
		ordenRepository.deleteById(codigo);
	}
}
