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
import utn.frba.disenio.tp.prenda.Trama;
import utn.frba.disenio.tp.prenda.constructores.MaterialFactory;
import utn.frba.disenio.tp.prenda.constructores.MaterialFactoryImpl;
import utn.frba.disenio.tp.prenda.constructores.PrendaBuilder;
import utn.frba.disenio.tp.prenda.constructores.PrendaBuilderImpl;
import utn.frba.disenio.tp.prenda.constructores.TipoPrendaFactory;
import utn.frba.disenio.tp.prenda.constructores.TipoPrendaFactoryImpl;
import utn.frba.disenio.tp.prenda.constructores.TramaFactory;
import utn.frba.disenio.tp.prenda.constructores.TramaFactoryImpl;
import utn.frba.disenio.tp.prenda.constructores.excepciones.MaterialInvalidoException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.PrendaNoInstanciadaException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TipoInvalidoException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TramaInvalidaException;

@SpringBootTest
class QueMePongoApplicationTests {

	private TramaFactory tramaFactory = new TramaFactoryImpl();
	private Trama tramaLisa = tramaFactory.getInstance("lisa");
	private Trama tramaRayada = tramaFactory.getInstance("rayada");
	private Color azul = new Color("Azul");
	private Color negro = new Color("Negro");
	private MaterialFactory materialFactory = new MaterialFactoryImpl();
	private Material cuero = materialFactory.getInstance("Cuero",tramaLisa);
	private Material almidon = materialFactory.getInstance("Almidón",tramaRayada);
	private PrendaBuilder prendaBuilder = new PrendaBuilderImpl();
	private TipoPrendaFactory tipoPrendaFactory = new TipoPrendaFactoryImpl();
	private Tipo pantalon = tipoPrendaFactory.getInstance("Pantalon",CategoriaEnum.ParteInferior);
	private Tipo remera = tipoPrendaFactory.getInstance("Remera", CategoriaEnum.ParteSuperior);
	private Tipo zapatilla = tipoPrendaFactory.getInstance("Zapatilla",CategoriaEnum.Calzado);
	private Tipo pulcera = tipoPrendaFactory.getInstance("Pulcera",CategoriaEnum.Accesorio);

	
	@Test
	void crearPrendaInferior() throws TipoInvalidoException {
		Prenda pantalonCueroAzul = new Prenda(cuero, pantalon, azul);
		assertEquals(CategoriaEnum.ParteInferior, pantalonCueroAzul.getCategoria());
		assertEquals(azul.getDescripcion(),pantalonCueroAzul.getColorPrimario());
		assertEquals(cuero.getDescripcion(),pantalonCueroAzul.getMaterial());
	}
	
	@Test
	void crearPrendaSuperior() throws TipoInvalidoException {
		Prenda remeraCueroAzul = new Prenda(almidon, remera, azul);
		assertEquals(CategoriaEnum.ParteSuperior, remeraCueroAzul.getCategoria());
		assertEquals(azul.getDescripcion(),remeraCueroAzul.getColorPrimario());
		assertEquals(almidon.getDescripcion(),remeraCueroAzul.getMaterial());
	}

	@Test
	void crearCalzado() throws TipoInvalidoException {
		Prenda zapatillaCueroAzul = new Prenda(cuero, zapatilla, azul);
		assertEquals(CategoriaEnum.Calzado, zapatilla.getCategoria());
		assertEquals(azul.getDescripcion(),zapatillaCueroAzul.getColorPrimario());
		assertEquals(cuero.getDescripcion(),zapatillaCueroAzul.getMaterial());
	}
	
	@Test
	void crearAccesorio() throws TipoInvalidoException {
		Prenda pulceraCueroAzul = new Prenda(cuero, pulcera, azul);
		assertEquals(CategoriaEnum.Accesorio, pulceraCueroAzul.getCategoria());
		assertEquals(azul.getDescripcion(),pulceraCueroAzul.getColorPrimario());
		assertEquals(cuero.getDescripcion(),pulceraCueroAzul.getMaterial());
	}

	@Test
	void crearPrendaPorPartesSinColorSecundarioOk() {
		Prenda remeraCueroAzul = prendaBuilder
		.start(remera)
		.setMaterial(almidon)
		.setColorPrimario(azul)
		.build();
		assertEquals(CategoriaEnum.ParteSuperior, remeraCueroAzul.getCategoria());
		assertEquals(azul.getDescripcion(),remeraCueroAzul.getColorPrimario());
		assertEquals(almidon.getDescripcion(),remeraCueroAzul.getMaterial());
	}
	
	@Test
	void crearPrendaPorPartesConColorSecundarioOk() {
		Prenda remeraCueroAzul = prendaBuilder
		.start(remera)
		.setMaterial(almidon)
		.setColorPrimario(azul)
		.setColorSecundario(negro)
		.build();
		assertEquals(CategoriaEnum.ParteSuperior, remeraCueroAzul.getCategoria());
		assertEquals(azul.getDescripcion(),remeraCueroAzul.getColorPrimario());
		assertEquals(negro.getDescripcion(),remeraCueroAzul.getColorSecundario());
		assertEquals(almidon.getDescripcion(),remeraCueroAzul.getMaterial());
	}
	
	@Test
	void crearPrendaConMaterialIncompatibleConTipo() {
		assertThrows(
				MaterialInvalidoException.class, 
				()->
				prendaBuilder
				.start(remera)
				.setMaterial(cuero)
				);
		prendaBuilder.reset();
	}
	
	@Test
	void setearPrendaNoInstanciada() {
		assertThrows(
				PrendaNoInstanciadaException.class, 
				()->
				prendaBuilder
				.setMaterial(cuero)
				);
		prendaBuilder.reset();
	}

	
	@Test
	void crearAccesorioMal() {
		assertThrows(
				TipoInvalidoException.class, 
				()-> tipoPrendaFactory.getInstance("Algo que no es un accesorio",CategoriaEnum.Accesorio));
	}
	
	@Test
	void crearMaterialMal() {
		assertThrows(
				MaterialInvalidoException.class, 
				()-> materialFactory.getInstance("Material que no existe",tramaLisa));
	}
	
	@Test
	void crearTramaMal() {
		assertThrows(
				TramaInvalidaException.class, 
				()-> tramaFactory.getInstance("Trama que no existe"));
	}
	
}
