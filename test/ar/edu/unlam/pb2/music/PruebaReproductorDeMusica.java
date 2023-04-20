package ar.edu.unlam.pb2.music;

import static org.junit.Assert.*;

import org.junit.Test;
/*El programa debe contar con el siguiente menú de opciones :
a. Guardar mis datos personales

b. Crear una lista de reproducción

c. Agregar canciones a la lista

d. Reproducir una lista de reproducción.

e. se visualice por pantalla la información de la lista:
		i. El listado de las canciones	
		ii. La cantidad de canciones
		iii. La duración de la lista (Se debe mostrar en el formato mm:ss)
*/
public class PruebaReproductorDeMusica {

	@Test
	public void queSePuedaCrearUnUsuarioConUnUsernameQueNoExistaAun(){
		//Preparacion de datos
		final String mail = "jesi@mail.com.ar";
		final String username = "jesi";
		final String password = "Qwerty12!";
		
		ReproductorMusica reproductor;
		Usuario user = null;
		
		//Ejecucion
		reproductor = new ReproductorMusica();
		try {
			user = new Usuario(mail,username,password);
			
		} catch (DatosIncorrectos exception) {
			exception.printStackTrace();
		}
		
		//Validacion
		assertFalse(reproductor.existeElUsuario(username));
		assertNotNull(user);
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioConMailQueNoExistaAun() {
		// Preparacion de datos
		final String mail = "jesi@mail.com.ar";
		final String username = "jesi";
		final String password = "Qwerty12!";

		ReproductorMusica reproductor;
		Usuario user = null;

		// Ejecucion
		reproductor = new ReproductorMusica();
		try {
			user = new Usuario(mail, username, password);

		} catch (DatosIncorrectos exception) {
			exception.printStackTrace();
		}

		// Validacion
		assertFalse(reproductor.existeElUsuario(mail));
		assertNotNull(user);
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioConUnaContraseniaDeLargoMinimoOchoCaracteresUnaMayusculaUnNumeroUnCaracterEspecial() throws DatosIncorrectos {

		// Preparacion de datos
		final String mail = "jesi@mail.com.ar";
		final String username = "jesi";
		final String password = "Qwerty12!";
		Usuario user;
		
		//Ejecucion
		user = new Usuario();
		user.setMail(mail);
		user.setUsername(username);
		user.setPassword(password);
		
		//Validacion
		assertTrue(user.validarContrasenia(password));
		assertNotNull(user);
		assertEquals(username, user.getUsername());
		
	}
	
	@Test
	public void queSePuedaRegistrarUnUsuario() throws DatosIncorrectos {
		// Preparacion de datos
		final String MAIL = "jesi@mail.com.ar";
		final String USERNAME = "jesi";
		final String PASSWORD = "Qwerty12!";
		final Integer CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA = 1;
		
		ReproductorMusica reproductor = new ReproductorMusica();
		Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
		
		assertTrue(reproductor.agregarUsuario(user));
		assertEquals(CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA, reproductor.darLaCantidadDeUsuariosRegistrados());
	}
	
	//-------------------------- completar >>>
	@Test
	public void queSePuedaRegistrarDosUsuarios() throws DatosIncorrectos {
		// Preparacion de datos
		final Integer CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA = 2;

		final String MAIL = "jesi@mail.com.ar";
		final String USERNAME = "jesi";
		final String PASSWORD = "Qwerty12!";
		
		final String MAIL2 = "belen@mail.com.ar";
		final String USERNAME2 = "belen";
		final String PASSWORD2 = "CyberSec&Sys1";
		
		ReproductorMusica reproductor = new ReproductorMusica();
		Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
		Usuario user2 = new Usuario(MAIL2,USERNAME2,PASSWORD2);
		
		assertTrue(reproductor.agregarUsuario(user));
		assertTrue(reproductor.agregarUsuario(user2));
		assertEquals(CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA, reproductor.darLaCantidadDeUsuariosRegistrados());
	}
	
	@Test(expected = DatosIncorrectos.class)
	public void queNoSePuedaRegistrarElTercerUsuarioDebidoAUsuarioDuplicado() throws DatosIncorrectos {
		// Preparacion de datos
		final Integer CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA = 2;

		final String MAIL = "jesi@mail.com.ar";
		final String USERNAME = "jesi";
		final String PASSWORD = "Qwerty12!";
		
		final String MAIL2 = "belen@mail.com.ar";
		final String USERNAME2 = "belen";
		final String PASSWORD2 = "CyberSec&Sys1";
		
		final String MAIL3 = "musiclove@mail.com.ar";
		final String USERNAME3 = "belen";
		final String PASSWORD3 = "hol@1234+";
		
		ReproductorMusica reproductor = new ReproductorMusica();
		Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
		Usuario user2 = new Usuario(MAIL2,USERNAME2,PASSWORD2);
		Usuario user3 = new Usuario(MAIL3,USERNAME3,PASSWORD3);
		
		assertTrue(reproductor.agregarUsuario(user));
		assertTrue(reproductor.agregarUsuario(user2));
		assertTrue(reproductor.agregarUsuario(user3)); //ajam no se agregó. Good
		assertEquals(CANTIDAD_USUARIOS_REGISTRADOS_ESPERADA, reproductor.darLaCantidadDeUsuariosRegistrados());
	}
	
	
	@Test
	public void queSePuedaCrearUnaListaDeReproduccionEnUnUsuarioEspecifico() throws DatosIncorrectos {
		//Preparacion de datos
		final String MAIL = "jesi@mail.com.ar";
		final String USERNAME = "jesi";
		final String PASSWORD = "Qwerty12!";
		
		final String NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION = "Canciones favoritas";
		
		//Ejecucion
		//Creo usuario
		ReproductorMusica reproductor = new ReproductorMusica();
		Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
		Boolean usuarioAgregado = reproductor.agregarUsuario(user);
		
		//Creo la lista
		assertTrue(usuarioAgregado);
		assertTrue(user.crearUnaNuevaLista(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION));	
	}
	
	@Test
	public void queSePuedaBuscarUnaListaDeReproduccionEnUnUsuarioEspecifico() throws DatosIncorrectos {
		//Preparacion de datos
		final String MAIL = "jesi@mail.com.ar";
		final String USERNAME = "jesi";
		final String PASSWORD = "Qwerty12!";
		
		final String NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION = "Canciones favoritas";
		
		//Ejecucion
		//Creo usuario
		ReproductorMusica reproductor = new ReproductorMusica();
		Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
		Boolean usuarioAgregado = reproductor.agregarUsuario(user);
		
		//Creo la lista
		assertTrue(usuarioAgregado);
		assertTrue(user.crearUnaNuevaLista(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION));
		assertEquals(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION, user.buscarListaDeReproduccion(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION));
	}
	
	
	@Test
	public void queSePuedaGuardarUnaCancionEnUnaListaDeReproduccionDeterminadaYQueSeaDeUnUsuario() throws DatosIncorrectos {
		//Preparacion de datos
				final String MAIL = "jesi@mail.com.ar";
				final String USERNAME = "jesi";
				final String PASSWORD = "Qwerty12!";
				
				final String NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION = "Canciones favoritas";
				
				final String NOMBRE_DE_LA_CANCION = "Tú";
				final String CANTANTE = "Maye";
				
				//Ejecucion
				//Creo usuario
				ReproductorMusica reproductor = new ReproductorMusica();
				Usuario user = new Usuario(MAIL,USERNAME,PASSWORD);
				Cancion song = new Cancion(NOMBRE_DE_LA_CANCION,CANTANTE);
				Boolean usuarioAgregado = reproductor.agregarUsuario(user);
				
				
				//Creo la lista
				assertTrue(usuarioAgregado);
				assertTrue(user.crearUnaNuevaLista(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION));
				assertEquals(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION, user.buscarListaDeReproduccion(NOMBRE_DE_UNA_LISTA_DE_REPRODUCCION));
				//agregarcancion
		
	}
	
	

}
