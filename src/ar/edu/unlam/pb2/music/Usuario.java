package ar.edu.unlam.pb2.music;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private String mail;
	private String username;
	private String password;
	
	private HashMap<String,ArrayList<Cancion>> listasDeReproduccion;
	
	private ReproductorMusica reproductor;

	public Usuario() {
	}
	
	public Usuario(String mail, String username, String password) throws DatosIncorrectos {
		reproductor = new ReproductorMusica();
		if(reproductor.existeElUsuario(username) || reproductor.existeElUsuario(password) || !this.validarContrasenia(password) || !this.validarMail(mail)) {
			throw new DatosIncorrectos();
		}else {
			this.mail = mail;
			this.username = username;
			this.password = password;
			listasDeReproduccion = new HashMap<String,ArrayList<Cancion>>();
		}
	}

	private boolean validarMail(String mail) {
		boolean tienePunto = false;
		int contadorDeArroba = 0;
		
		if(mail.contains("."))
			tienePunto = true;
		
		for(int i=0; i<mail.length(); i++) {
			if(mail.charAt(i) == '@')
				contadorDeArroba++;
		}
		
		if(tienePunto && contadorDeArroba == 1)
			return true;
		
		return false;
	}

	public boolean validarContrasenia(String password) {
		
		int largoMinimo = 8;
		int numeroCero = 48;
		int numeroNueve = 57;
		int letraA = 65;
		int letraZ = 90;
		boolean tieneMayuscula = false;
		boolean tieneNumero = false;
		boolean tieneCaracterEspecial = false;
		
		if(password.length() >= largoMinimo) {
			if(password.contains("~") || password.contains("@") || password.contains("_") || password.contains("/") || password.contains("+") || password.contains(":")|| password.contains("!") || password.contains("?") || password.contains("&"))
				tieneCaracterEspecial = true;
			
			tieneNumero = comprobarSiTieneNumeroOLetra(password,numeroCero,numeroNueve);
			tieneMayuscula = comprobarSiTieneNumeroOLetra(password,letraA,letraZ);
			
			if(tieneCaracterEspecial && tieneNumero && tieneMayuscula)
				return true;
		}

		return false;
	}


	private boolean comprobarSiTieneNumeroOLetra(String password, int inicio, int fin) {
		for(int i=0; i<password.length(); i++) {
			for(int j= inicio; j< fin+1; j++) {
				if(password.charAt(i)== (char)j)
					return true;
			}
		}
			
		return false;
	}
	
	public boolean crearUnaNuevaLista(String codigoDeUnaLista) {
		if(!this.listasDeReproduccion.containsKey(codigoDeUnaLista)) {
			this.listasDeReproduccion.put(codigoDeUnaLista,new ArrayList<Cancion>());
			return true;
		}
		return false;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String buscarListaDeReproduccion(String nombreDeLaLista) {
		for(String codigo : this.listasDeReproduccion.keySet()) {
			if(codigo.equals(nombreDeLaLista))
				return codigo;
		}
		return "";
	}

	public boolean agregarUnaCancionEnUnaListaDeReproduccion(String nombreDeLaLista, Cancion song) {
		return false;
	}

	

	

	

}
