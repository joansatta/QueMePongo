package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tela;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.factory.AccesorioFactory;
import utn.frba.disenio.tp.prenda.factory.CalzadoFactory;
import utn.frba.disenio.tp.prenda.factory.PrendaInferiorFactory;
import utn.frba.disenio.tp.prenda.factory.PrendaSuperiorFactory;

@SpringBootTest
class QueMePongoApplicationTests {
	
	private CalzadoFactory calzadoFactory = new CalzadoFactory();
	private AccesorioFactory accesorioFactory = new AccesorioFactory();
	private PrendaInferiorFactory prendaInferiorFactory = new PrendaInferiorFactory();
	private PrendaSuperiorFactory prendaSuperiorFactory = new PrendaSuperiorFactory();
	private Color azul = new Color("Azul");
	private Tela tela = new Tela("Almidon");
	private Material material = new Material("Cuero");


	@Test
	void crearPrendaInferior() {
		Tipo tipo = new Tipo("Pantalon Largo");
		Prenda pantalonLargo = prendaInferiorFactory.crearPrenda(tela, tipo, azul);
		assertEquals(CategoriaEnum.ParteInferior, pantalonLargo.getCategoria());
		assertEquals(azul.getDescripcion(),pantalonLargo.getColorPrimario());
		assertEquals(tela.getDescripcion(),pantalonLargo.getComposicion());

	}
	
	@Test
	void crearPrendaSuperior() {
		Tipo tipo = new Tipo("Remera");
		Prenda remera = prendaSuperiorFactory.crearPrenda(tela, tipo, azul);
		assertEquals(CategoriaEnum.ParteSuperior, remera.getCategoria());
		assertEquals(azul.getDescripcion(),remera.getColorPrimario());
		assertEquals(tela.getDescripcion(),remera.getComposicion());

	}

	@Test
	void crearCalzado() {
		Tipo tipo = new Tipo("Zapatilla");
		Prenda zapatilla = calzadoFactory.crearPrenda(material, tipo, azul);
		assertEquals(CategoriaEnum.Calzado, zapatilla.getCategoria());
		assertEquals(azul.getDescripcion(),zapatilla.getColorPrimario());
		assertEquals(material.getDescripcion(),zapatilla.getComposicion());

	}
	
	@Test
	void crearAccesorio() {
		Tipo tipo = new Tipo("Pulcera");
		Prenda pulcera = accesorioFactory.crearPrenda(material, tipo, azul);
		assertEquals(CategoriaEnum.Accesorio, pulcera.getCategoria());
		assertEquals(azul.getDescripcion(),pulcera.getColorPrimario());
		assertEquals(material.getDescripcion(),pulcera.getComposicion());

	}
}
