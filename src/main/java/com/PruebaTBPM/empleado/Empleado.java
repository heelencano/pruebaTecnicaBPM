package com.PruebaTBPM.empleado;



import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.PruebaTBPM.categoria.Categoria;
import com.PruebaTBPM.solicitud.Solicitud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false)
	private LocalDate fechaIngreso;
	
	@Column(length = 50, nullable = false,unique = true)
	private String nombre;
	
	@Column(nullable = false)
	private float salario;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
	public Empleado(Integer id, LocalDate fechaIngreso, String nombre, float salario, Solicitud solicitud,
			Categoria categoria) {
		super();
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.nombre = nombre;
		this.salario = salario;
		this.categoria = categoria;
	}
	
	public Empleado() {
		super();
	}

	public Empleado(LocalDate fechaIngreso, String nombre, float salario, Solicitud solicitud, Categoria categoria) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.nombre = nombre;
		this.salario = salario;
		this.categoria = categoria;
	}

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Empleado(Integer id, LocalDate fechaIngreso, String nombre, float salario, Categoria categoria) {
		super();
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.nombre = nombre;
		this.salario = salario;
		this.categoria = categoria;
	}




	
}
