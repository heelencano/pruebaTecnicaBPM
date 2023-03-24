package com.PruebaTBPM;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.PruebaTBPM.categoria.Categoria;
import com.PruebaTBPM.categoria.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	@Test
	public void testCrearCategoria() {
		Categoria categoriaGuardada = repositorio.save(new Categoria("Administrador"));
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}
}
