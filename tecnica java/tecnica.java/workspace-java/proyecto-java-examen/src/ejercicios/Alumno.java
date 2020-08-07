package ejercicios;

public class Alumno {
	private Persona persona;
	private Integer legajo;

	public Alumno() {
		this.persona=new Persona();
	}

	public Alumno(Persona persona, Integer legajo) {
		this.persona = persona;
		this.legajo = legajo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

}
