package utn.frba.disenio.tp.prenda;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Prenda {
	
	@NonNull private Material material;
	@NonNull private Tipo tipo;
	@NonNull private Color colorPrimario;
	private Color colorSecundario;

	public String getMaterial() {
		return this.material.getDescripcion();
	}	
	
	public String getTipo() {
		return this.tipo.getDescripcion();
	}	
	
	public String getColorPrimario() {
		return this.colorPrimario.getDescripcion();
	}
	
	public String getColorSecundario() {
		return this.colorSecundario!=null?this.colorSecundario.getDescripcion():null;
	}
	
	public CategoriaEnum getCategoria() {
		return this.tipo.getCategoria();
	}

	public Prenda(@NonNull Material material, @NonNull Tipo tipo, @NonNull Color colorPrimario) {
		super();
		this.material = material;
		this.tipo = tipo;
		this.colorPrimario = colorPrimario;
	}
	
	
	
}
