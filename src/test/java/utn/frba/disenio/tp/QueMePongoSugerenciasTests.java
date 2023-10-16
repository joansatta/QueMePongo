package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import utn.frba.disenio.tp.config.TestConfig;
import utn.frba.disenio.tp.guardarropas.AccionesPropuesta;
import utn.frba.disenio.tp.guardarropas.CategoriaGuardarropas;
import utn.frba.disenio.tp.guardarropas.Guardarropas;
import utn.frba.disenio.tp.guardarropas.PropuestaPrenda;
import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.Trama;
import utn.frba.disenio.tp.prenda.constructores.MaterialFactory;
import utn.frba.disenio.tp.prenda.constructores.PrendaBuilder;
import utn.frba.disenio.tp.prenda.constructores.TipoPrendaFactory;
import utn.frba.disenio.tp.prenda.constructores.TramaFactory;
import utn.frba.disenio.tp.prenda.constructores.excepciones.GuardarropasNoValidoExcepcion;
import utn.frba.disenio.tp.usuario.Usuario;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoSugerenciasTests {

	@Autowired private TramaFactory tramaFactory;
	@Autowired private MaterialFactory materialFactory;
	@Autowired private PrendaBuilder prendaBuilder;
	@Autowired private TipoPrendaFactory tipoPrendaFactory;
	private Trama tramaLisa;
	private Color azul; 
	private Material cuero;
	private Tipo pantalon;
	
	
    @BeforeEach
    void init() {
		tramaLisa = tramaFactory.getInstance("lisa");
		cuero = materialFactory.getInstance("Cuero",tramaLisa);
		pantalon = tipoPrendaFactory.getInstance("Pantalon",CategoriaEnum.ParteInferior);
		azul = new Color("Azul");
		prendaBuilder.reset();
    }

	private PropuestaPrenda generarPropuesta(Usuario usuario,AccionesPropuesta accion) {
		Usuario usuario2 = new Usuario("jsatta2");
		Prenda pantalonCueroAzul = new Prenda(cuero, pantalon, azul);
		PropuestaPrenda propuesta = usuario2.crearPropuesta(pantalonCueroAzul,accion);
		return propuesta;
	}

	
	@Test
	void realizarSugerenciaAgregar() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Guardarropas", categoria);
		PropuestaPrenda propuesta = generarPropuesta(usuario,AccionesPropuesta.AGREGAR);
		guardarropas.agregarPropuesta(propuesta);
		assertEquals(guardarropas.getPropuestas().get(0), propuesta);
	}
	
	@Test
	void realizarSugerenciaQuitar() {
		Usuario usuario = new Usuario("jsatta");
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Guardarropas", categoria);
		PropuestaPrenda propuesta = generarPropuesta(usuario,AccionesPropuesta.REMOVER);
		guardarropas.agregarPropuesta(propuesta);
		assertEquals(guardarropas.getPropuestas().get(0), propuesta);
	}	

	@Test
	void aceptarSugerenciaAgregar() {
		Usuario usuario = new Usuario("jsatta");
		PropuestaPrenda propuesta = generarPropuesta(usuario,AccionesPropuesta.AGREGAR);
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Guardarropas", categoria);
		guardarropas.agregarPropuesta(propuesta);
		assertEquals(0,guardarropas.getCantidadPartesInferiores());
		guardarropas.aceptarPropuesta(propuesta);
		assertEquals(1,guardarropas.getCantidadPartesInferiores());
	}
	
	@Test
	void aceptarSugerenciaAgregarYDespuesRechazarla() {
		Usuario usuario = new Usuario("jsatta");
		PropuestaPrenda propuesta = generarPropuesta(usuario,AccionesPropuesta.AGREGAR);
		CategoriaGuardarropas categoria = usuario.crearCategoria("Ropa de viaje");
		Guardarropas guardarropas = usuario.crearGuardarropasPropio("Guardarropas", categoria);
		guardarropas.agregarPropuesta(propuesta);
		assertEquals(0,guardarropas.getCantidadPartesInferiores());
		guardarropas.aceptarPropuesta(propuesta);
		assertEquals(1,guardarropas.getCantidadPartesInferiores());
		guardarropas.rechazarPropuesta(propuesta);
		assertEquals(0,guardarropas.getCantidadPartesInferiores());
	}
	
	
}
