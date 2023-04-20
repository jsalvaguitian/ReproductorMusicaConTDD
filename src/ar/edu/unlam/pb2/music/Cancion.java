package ar.edu.unlam.pb2.music;

public class Cancion {

	private String nombreDeLaCancion;
	private String cantante;
	
	public Cancion(String nombreDeLaCancion, String cantante) {
		this.nombreDeLaCancion = nombreDeLaCancion;
		this.cantante = cantante;
	}

	public String getNombreDeLaCancion() {
		return nombreDeLaCancion;
	}

	public String getCantante() {
		return cantante;
	}
	
	

}
