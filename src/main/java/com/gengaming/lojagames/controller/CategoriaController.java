package com.gengaming.lojagames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gengaming.lojagames.model.Categoria;
import com.gengaming.lojagames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> getByTipo(@PathVariable String genero){
		return ResponseEntity.ok(categoriaRepository.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria) {
		if(categoria.getId() == null)
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.ok().body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategoria(@PathVariable Long id) {
		Optional <Categoria> resposta = categoriaRepository.findById(id);
		if(resposta.isPresent()) {
			categoriaRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
}
