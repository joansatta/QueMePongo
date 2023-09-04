package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.factory.TipoInvalidoException;
import utn.frba.disenio.tp.prenda.factory.TipoPrendaFactory;
import utn.frba.disenio.tp.prenda.factory.TipoPrendaFactoryImpl;

@SpringBootTest
class QueMePongoApplicationTests {
	
	private Color azul = new Color("Azul");
	private Material material = new Material("Cuero");
	private TipoPrendaFactory tipoPrendaFactory = new TipoPrendaFactoryImpl();

	@Test
	void crearPrendaInferior() throws TipoInvalidoException {
		Tipo tipo = tipoPrendaFactory.getInstance("Pantalon",CategoriaEnum.ParteInferior);
		Prenda pantalonLargo = new Prenda(material, tipo, azul);
		assertEquals(CategoriaEnum.ParteInferior, pantalonLargo.getCategoria());
		assertEquals(azul.getDescripcion(),pantalonLargo.getColorPrimario());
		assertEquals(material.getDescripcion(),pantalonLargo.getMaterial());
	}
	
	@Test
	void crearPrendaSuperior() throws TipoInvalidoException {
		Tipo tipo = tipoPrendaFactory.getInstance("Remera", CategoriaEnum.ParteSuperior);
		Prenda remera = new Prenda(material, tipo, azul);
		assertEquals(CategoriaEnum.ParteSuperior, remera.getCategoria());
		assertEquals(azul.getDescripcion(),remera.getColorPrimario());
		assertEquals(material.getDescripcion(),remera.getMaterial());
	}

	@Test
	void crearCalzado() throws TipoInvalidoException {
		Tipo tipo = tipoPrendaFactory.getInstance("Zapatilla",CategoriaEnum.Calzado);
		Prenda zapatilla = new Prenda(material, tipo, azul);
		assertEquals(CategoriaEnum.Calzado, zapatilla.getCategoria());
		assertEquals(azul.getDescripcion(),zapatilla.getColorPrimario());
		assertEquals(material.getDescripcion(),zapatilla.getMaterial());
	}
	
	@Test
	void crearAccesorio() throws TipoInvalidoException {
		Tipo tipo = tipoPrendaFactory.getInstance("Pulcera",CategoriaEnum.Accesorio);
		Prenda pulcera = new Prenda(material, tipo, azul);
		assertEquals(CategoriaEnum.Accesorio, pulcera.getCategoria());
		assertEquals(azul.getDescripcion(),pulcera.getColorPrimario());
		assertEquals(material.getDescripcion(),pulcera.getMaterial());
	}
	
	@Test
	void crearAccesorioMal() {
		assertThrows(
				RuntimeException.class, 
				()-> tipoPrendaFactory.getInstance("Algo que no es un accesorio",CategoriaEnum.Accesorio));
	}
}
