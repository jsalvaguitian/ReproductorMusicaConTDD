package ar.edu.unlam.pb2.music;

public class ReproductorMusica {
	
	private Usuario[] usuarios;
	private final Integer CANT_MAX_USUARIOS;
	
	public ReproductorMusica() {
		this.CANT_MAX_USUARIOS = 1000;
		this.usuarios = new Usuario[this.CANT_MAX_USUARIOS];
	}

	public boolean existeElUsuario(String usernameOMail) {
		for(int i=0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]!=null && (this.usuarios[i].getUsername().equals(usernameOMail) || this.usuarios[i].getMail().equals(usernameOMail)))
				return true;
		}
		
		return false;
	}

	public boolean agregarUsuario(Usuario user) {
		for(int i=0 ; i<this.usuarios.length; i++) {
			if(this.usuarios[i]== null && user !=null) {
				this.usuarios[i] = user;
				return true;
			}
		}
		return false;
	}
	
	public Integer darLaCantidadDeUsuariosRegistrados() {
		Integer contadorUsuarios =0;
		
		for(int i=0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]!=null) {
				contadorUsuarios++;
			}
		}
		
		return contadorUsuarios;
		
	}

	

}
