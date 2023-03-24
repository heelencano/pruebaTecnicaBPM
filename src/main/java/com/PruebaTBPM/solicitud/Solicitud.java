package com.PruebaTBPM.solicitud;

import com.PruebaTBPM.empleado.Empleado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String codigo;
	
	@Column(length = 50, nullable = false)
	private String descripcion;
	
	@Column(length = 50, nullable = false)
	private String resumen;

	
	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getResumen() {
		return resumen;
	}


	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Solicitud(Integer id, String codigo, String descripcion, String resumen, Empleado empleado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.resumen = resumen;
		this.empleado = empleado;
	}

	public Solicitud(Integer id) {
		super();
		this.id = id;
	}

	public Solicitud(String codigo, String descripcion, String resumen, Empleado empleado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.resumen = resumen;
		this.empleado = empleado;
	}

	public Solicitud() {
		super();
	}	
	
	
	
}
