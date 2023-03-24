package com.PruebaTBPM.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PruebaTBPM.categoria.Categoria;
import com.PruebaTBPM.categoria.CategoriaRepository;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("empleados/nuevo")
	public String formularioNuevoEmpleado(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		modelo.addAttribute("empleado", new Empleado());
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "empleado_formulario";
	}
	
	@PostMapping("/empleados/guardar")
	public String guardarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleados")
	public String listarEmpleados(Model modelo) {
		List<Empleado> listaEmpleados = empleadoRepository.findAll();
		modelo.addAttribute("listaEmpleados", listaEmpleados);
		return "empleado";
	}
	
	@GetMapping("/empleados/editar/{id}")
	public String fomularioModificarEmpleado(@PathVariable("id") Integer id,Model modelo) {
		Empleado empleado = empleadoRepository.findById(id).get();
		modelo.addAttribute("empleado", empleado);
		
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "empleado_formulario";
	}
	
	@GetMapping("/empleados/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable("id") Integer id, Model modelo) {
		empleadoRepository.deleteById(id);
		return "redirect:/empleados";
	}
	
}
