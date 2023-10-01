package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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
import utn.frba.disenio.tp.prenda.constructores.excepciones.MaterialInvalidoException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.PrendaNoInstanciadaException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TipoInvalidoException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TramaInvalidaException;
import utn.frba.disenio.tp.services.AccuWeatherAdapter;
import utn.frba.disenio.tp.services.impl.entities.AccuWeatherResponse;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoApplicationTests {

	@Autowired private TramaFactory tramaFactory;
	@Autowired private MaterialFactory materialFactory;
	@Autowired private PrendaBuilder prendaBuilder;
	@Autowired private TipoPrendaFactory tipoPrendaFactory;
	@Autowired private AccuWeatherAdapter accuWeatherAdapter;
	private Trama tramaLisa;
	private Trama tramaRayada;
	private Color azul; 
	private Color negro; 
	private Material cuero;
	private Material almidon; 
	private Tipo pantalon;
	private Tipo remera;
	private Tipo zapatilla;
	private Tipo pulcera;
	
	
    @BeforeEach
    void init() {
		tramaLisa = tramaFactory.getInstance("lisa");
		tramaRayada = tramaFactory.getInstance("rayada");
		cuero = materialFactory.getInstance("Cuero",tramaLisa);
		almidon = materialFactory.getInstance("Almidón",tramaRayada);
		pantalon = tipoPrendaFactory.getInstance("Pantalon",CategoriaEnum.ParteInferior);
		remera = tipoPrendaFactory.getInstance("Remera", CategoriaEnum.ParteSuperior);
		zapatilla = tipoPrendaFactory.getInstance("Zapatilla",CategoriaEnum.Calzado);
		pulcera = tipoPrendaFactory.getInstance("Pulcera",CategoriaEnum.Accesorio);
		azul = new Color("Azul");
		negro = new Color("Negro");
    }
	
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
		assertThrows(MaterialInvalidoException.class, ()->
				prendaBuilder
				.start(remera)
				.setMaterial(cuero)
				);
		prendaBuilder.reset();
	}
	
	@Test
	void setearPrendaNoInstanciada() {
		assertThrows(PrendaNoInstanciadaException.class, ()->
				prendaBuilder.setMaterial(cuero)
				);
		prendaBuilder.reset();
	}

	
	@Test
	void crearAccesorioMal() {
		assertThrows(TipoInvalidoException.class, ()-> 
		tipoPrendaFactory.getInstance("Algo que no es un accesorio",CategoriaEnum.Accesorio));
	}
	
	@Test
	void crearMaterialMal() {
		assertThrows(MaterialInvalidoException.class, ()-> 
		materialFactory.getInstance("Material que no existe",tramaLisa));
	}
	
	@Test
	void crearTramaMal() {
		assertThrows(TramaInvalidaException.class, ()-> 
		tramaFactory.getInstance("Trama que no existe"));
	}
	
	@Test 
	void obtenerClima() {
		AccuWeatherResponse res = accuWeatherAdapter.obtenerTemperaturaCompleta("Buenos Aires");
		assertEquals(0,res.getProbabilidadLluvia());
	}
	
	@Test 
	void obtenerTemperaturaFarenheit() {
		Integer far = accuWeatherAdapter.obtenerTemperaturaFarenheit("Buenos Aires");
		assertEquals(57,far);
	}
	
}
