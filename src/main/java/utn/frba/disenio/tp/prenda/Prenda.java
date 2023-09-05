package utn.frba.disenio.tp.prenda;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Prenda implements Cloneable {
	
	@NonNull private Material material;
	@NonNull private Tipo tipo;
	@NonNull private Color colorPrimario;
	private Color colorSecundario;

	public String getTipo() {
		return this.tipo.getDescripcion();
	}	
	
	public String getMaterial() {
		return this.material.getDescripcion();
	}
	
	public void setMaterial(Material material) {
		this.material = material.clone();
	}
	
	public void setColorPrimario(Color color) {
		this.colorPrimario = color.clone();
	}
	
	public String getColorPrimario() {
		return this.colorPrimario.getDescripcion();
	}
	
	public void setColorSecundario(Color color) {
		this.colorSecundario = color!=null?color.clone():null;
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

	public Prenda(@NonNull Material material, @NonNull Tipo tipo, @NonNull Color colorPrimario) {
		super();
		this.material = material.clone();
		this.tipo = tipo.clone();
		this.colorPrimario = colorPrimario.clone();
	}

	public Prenda clone() {
		try {
			this.tipo=tipo.clone();
			this.material=material.clone();
			this.colorPrimario=colorPrimario.clone();
			this.colorSecundario=colorSecundario!=null?colorSecundario.clone():null;
			return (Prenda) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
