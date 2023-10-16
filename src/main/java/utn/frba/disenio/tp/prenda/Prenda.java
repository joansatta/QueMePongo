package utn.frba.disenio.tp.prenda;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Prenda {
	
	@NonNull private Material material;
	@NonNull private Tipo tipo;
	@NonNull private Color colorPrimario;
	private Integer temperaturaMinima;
	private Color colorSecundario;

	public String getTipo() {
		return this.tipo.getDescripcion();
	}	
	
	public String getMaterial() {
		return this.material.getDescripcion();
	}
	
	public void setMaterial(Material material) {
		this.material = material.clonar();
	}
	
	public void setColorPrimario(Color color) {
		this.colorPrimario = color.clonar();
	}
	
	public String getColorPrimario() {
		return this.colorPrimario.getDescripcion();
	}
	
	public void setColorSecundario(Color color) {
		this.colorSecundario = color!=null?color.clonar():null;
	}
	
	public String getColorSecundario() {
		return this.colorSecundario!=null?this.colorSecundario.getDescripcion():null;
	}
	
	public CategoriaEnum getCategoria() {
		return this.tipo.getCategoria();
	}
	
	public Prenda(@NonNull Tipo tipo) {
		super();
		this.tipo = tipo;
	}

	public Prenda(@NonNull Material material
			, @NonNull Tipo tipo
			, @NonNull Color colorPrimario
			, Integer temperaturaMinima) {
		super();
		this.material = material.clonar();
		this.tipo = tipo.clonar();
		this.colorPrimario = colorPrimario.clonar();
		this.temperaturaMinima = temperaturaMinima;
	}
	
	public Prenda(@NonNull Material material
			, @NonNull Tipo tipo
			, @NonNull Color colorPrimario
			) {
		super();
		this.material = material.clonar();
		this.tipo = tipo.clonar();
		this.colorPrimario = colorPrimario.clonar();
	}

	public Prenda clonar() {
		Prenda prenda = new Prenda(material,tipo,colorPrimario,temperaturaMinima);
		prenda.setColorSecundario(colorSecundario!=null?colorSecundario.clonar():null);
		return prenda;
	}
	
}
