package com.PruebaTBPM.solicitud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.PruebaTBPM.empleado.Empleado;
import com.PruebaTBPM.empleado.EmpleadoRepository;

@Controller
public class SolicitudController {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	

	@GetMapping("solicitudes/nuevo")
	public String formularioNuevoEmpleado(Model modelo) {
		List<Empleado> listaEmpleados = empleadoRepository.findAll();
		modelo.addAttribute("solicitud", new Solicitud());
		
		modelo.addAttribute("listaEmpleados", listaEmpleados);
		
		return "solicitud_formulario";
	}
	
	@PostMapping("/solicitudes/guardar")
	public String guardarSolicitud(Solicitud solicitud) {
		solicitudRepository.save(solicitud);
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/solicitudes")
	public String listarSolicitudes(Model modelo) {
		List<Solicitud> listaSolicitudes = solicitudRepository.findAll();
		modelo.addAttribute("listaSolicitudes", listaSolicitudes);
		return "solicitud";
	}
	
	@GetMapping("/solicitudes/editar/{id}")
	public String fomularioModificarSolicitud(@PathVariable("id") Integer id,Model modelo) {
		Solicitud solicitud = solicitudRepository.findById(id).get();
		modelo.addAttribute("solicitud",solicitud);
		
		List<Empleado> listaEmpleados = empleadoRepository.findAll();
		modelo.addAttribute("listaEmpleados", listaEmpleados);
		
		return "solicitud_formulario";
	}
	
	@GetMapping("/solicitudes/eliminar/{id}")
	public String eliminarSolicitud(@PathVariable("id") Integer id, Model modelo) {
		solicitudRepository.deleteById(id);
		return "redirect:/solicitudes";
	}
	
}
