package ejercicios;

import java.util.Date;

public class Persona {

	enum TipoDocumento {
		DNI, LIBRETACIVICA
	};

	private Integer nroDocumento;
	private TipoDocumento tipoDocumento;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;

	public Persona() {

	}

	public Persona(TipoDocumento dni,Integer nroDocumento, String nombre, String apellido, Date fechaNacimiento) {
		this.nroDocumento = nroDocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = dni;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
