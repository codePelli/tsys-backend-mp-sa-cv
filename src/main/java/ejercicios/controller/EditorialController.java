package ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Editorial;
import ejercicios.service.EditorialServiceImpl;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

	@Autowired
	private EditorialServiceImpl editorialService;
	
	@GetMapping
	public List<Editorial> getAllEditorials(){
		
		return editorialService.getEditorials();
	}
	
	@GetMapping("/{id}")
	public Editorial editorialPerId(@PathVariable Long id) {
		
		return editorialService.editorialPerId(id);
	}
	
	@PostMapping("/add")
	public Editorial insertEditorial(@RequestBody Editorial editorial) {
		
		return editorialService.updateEditorial(editorial);
	}
	
	@PutMapping("/{id}")
	public Editorial updateEditorial(@PathVariable(name = "id") Long id, @RequestBody Editorial editorial) {
		
		Editorial editorialSelected = new Editorial();
		
		editorialSelected.setEditorialName(editorial.getEditorialName());
		
		return editorialSelected;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEditorial(@PathVariable Long id) {
		editorialService.deleteEditorial(id);
	}
}
