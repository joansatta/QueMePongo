package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import utn.frba.disenio.tp.config.TestConfig;
import utn.frba.disenio.tp.guardarropas.CategoriaGuardarropas;
import utn.frba.disenio.tp.guardarropas.Guardarropas;
import utn.frba.disenio.tp.usuario.Usuario;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoGuardarropasTests {


    @BeforeEach
    void init() {
    }
	
	@Test
	void crearCategoriasYGuardarropasChequearUsuario() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Ropa de salida", categoria);
		assertEquals("jsatta",guardarropas.getUsuarioDuenio());
	}

	@Test
	void crearCategoriasYGuardarropasChequearCategorias() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Ropa de salida", categoria);
		assertEquals("Ropa de viaje",guardarropas.getCategoria());
	}
	
	@Test
	void crearCategoriasYGuardarropasChequearDescripcion() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Ropa de salida", categoria);
		assertEquals("Ropa de salida",guardarropas.getDescripcion());
	}

	@Test
	void crearGuardarropas() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Ropa de salida", categoria);
		assertTrue(guardarropas.usuarioPertenece(usuario));
	}
	
	@Test
	void crearGuardarropasCompartido() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Ropa de salida", categoria);
		Usuario usuario2 = new Usuario("jsatta2");
		guardarropas.agregarUsuario(usuario2);
		assertTrue(guardarropas.usuarioPertenece(usuario2));
	}
	
}
