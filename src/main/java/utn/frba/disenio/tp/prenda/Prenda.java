package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Prenda {
	
	@NonNull private CategoriaEnum categoria;
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
	
}
