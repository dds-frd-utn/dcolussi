package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import domain.Comentario;
import domain.Post;
import domain.Usuario;
import views.Help;
import views.Pantalla;

/*Clase principal del programa.
 * Este programa va a instanciar todas las otras
 * clases, como Comentarios Post, etc*/	

public class Aplicacion {
	
	/*Definicion de atributos globales*/
		
		public static Map<String, Post> systemPost = new HashMap<String, Post>();
		/*Recordar que el usuario se logea automaticamente al instanciarse. En este caso
		 * por default se logea como Diego*/
		public static Usuario thisUsuario = new Usuario("Diego");
		
	/*Fin de atributos globales globales*/
		
	/*Ejecucion del programa principal*/
	public static void main(String[] args){
		
		Help.showSystenInfo();
		
		while(true){
			
			/*permite a un usuario ingresar un comando por consola*/
			String myAction = thisUsuario.doAction();
			
			/*si el comando ingresado es exit, cerrar el programa*/
			if(myAction.equals("exit")){
				System.out.println("Hasta la vista");
				break;
			}
			
			/*Procesa el comando, y realiza una accion*/
				processAction(myAction);
						
		}
					
	}
	
	/*procesa un comando ingresado. (Utiliza atributos globales para funcionar)*/
	private static void processAction(String myAction){
		
		switch(myAction){
			
			case "post" : usrPost(thisUsuario, systemPost);
				break;
				
			case "comment": comPost(thisUsuario, systemPost); 
				break;
			
			case "punt": usrPunt(systemPost);; 
				break;
				
			case "change": {
				thisUsuario = null;
				thisUsuario = change();
			}
				break;
				
			case "show": showAllPosts(systemPost);
				break;
			
			case "ustatus": showUserStatus(thisUsuario);
				break;
			
			case "detail": showPostDetail(systemPost);
				break;
				
			case "delete": deletePost(thisUsuario,systemPost);
				break;
				
			case "help": showHelp();
				break;
				
			case "clear": clearConsole();
				break;
				
			default: System.out.println("\nInvalid : 'help' para mas opciones ");
			
		}
	}
	
	/*Muestra por pantalla informacion de ayuda*/
	private static void showHelp() {
		Help h = new Help();
		h = null;
	}

	/*Hace cambio de usuario*/
	public static Usuario change(){
		Usuario u = new Usuario();
		return u;
	}
	
	public static void usrPost(Usuario u , Map<String, Post> sp){
		try{
			
			Post thisPost = new Post(u);
			if(existPost(thisPost, sp)) throw new Exception();
			sp.put(thisPost.getNombre(), thisPost);
			
		}catch(Exception e){
			System.out.println("\nYa existe un post con ese nombre");
		}
		
		
	}
	
	/*Permite comentar un post*/
	@SuppressWarnings("resource")
	public static void comPost(Usuario usr , Map<String, Post> systemPost){
		try{		
			Exception no_existe = new Exception();
			Scanner s = new Scanner(System.in);
			System.out.print("Nombre de post a comentar : ");
			
			Post pst = systemPost.get(s.nextLine());
			if(pst == null) throw new Exception();
			Comentario com = new Comentario();
				if(com.comentarioNull()) return;	
			pst.addComentario(com);
			
		}catch(Exception e){
			System.out.println("Error al comentar post");
		}

	}
	
	/*Borra las lineas anteriores de la consola*/
	public static void clearConsole(){
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	/*Borra un post cuyo nombre sea el especificado y el autor sea el
	 * usuario pasado como parametro*/
	@SuppressWarnings("resource")
	public static void deletePost(Usuario usr , Map<String, Post> systemPost){
	
		try{		
			
			Scanner s = new Scanner(System.in);
			System.out.print("Nombre de post a eliminar : ");
			
			Post pst = systemPost.get(s.nextLine());
			if(pst.isAutor(usr))
				systemPost.remove(pst.getNombre());
			else
				throw new Exception();
				
			System.out.println("Post eliminado ...");
			
		}catch(Exception e){
			System.out.println("No se pudo borrar el post");
		}

	}
	
	/*muestra informacion del usuario que esta logeado*/
	public static void showUserStatus(Usuario u){
		Pantalla p = new Pantalla();
		p.showHeader("Informacion de logeo");
			u.showLoginStatus();
		p.showFooter();
	}
	
	/*Muestra detalles de un post en particular*/
	@SuppressWarnings("resource")
	public static void showPostDetail(Map<String, Post> systemPost){
		Pantalla p = new Pantalla();
		Scanner s = new Scanner(System.in);
		System.out.print("Nombre del post : ");
		String name = s.nextLine();
		
		try{
			
			p.showHeader("Detalle de post");
				/*Elegimos un Post de Label lista de post*/
				Post pst = systemPost.get(name);
					pst.showNombre();
					pst.showComentarios();
					pst.showPuntos();
			p.showFooter();
		
		}catch(Exception e){
			
			System.out.println("Hay algun error");
			
		}
	}
	
	/*Muestra todos los post que hay en una coleccion map*/
	public static void showAllPosts(Map<String, Post> systemPost){
		Pantalla p = new Pantalla();
		
		p.showHeader("Todos los posts");
			for( Entry<String, Post> data : systemPost.entrySet() ){
				data.getValue().showNombre();
				data.getValue().showAutor();
				data.getValue().showPuntos();
				System.out.print("\n");
			}
			
		p.showFooter();
		
	}
	
	/*Permite a un usuario puntuar un post*/
	@SuppressWarnings("resource")
	public static void usrPunt(Map<String, Post> systemPost){
	
		Scanner s = new Scanner(System.in);
		Pantalla p = new Pantalla();
		try{
			System.out.print("Nombre del post : ");
			String postName = s.nextLine();

			if(systemPost.get(postName) == null) throw new Exception();

			System.out.println("Puntuar post\n");
			
				p.textLine("Malo"		, 0);
				p.textLine("Regular"	, 1);
				p.textLine("Bueno"		, 2);
				p.textLine("Buenisimo"	, 3);
				p.textLine("Genial     ", 4);
			
			System.out.print("\nPunt : ");
				
			int val = Integer.parseInt(s.nextLine());
			
			if(val<0 || val>4) throw new Exception();
			
			systemPost.get(postName).setLike(val);	
			
		
		}catch(Exception e){
			System.out.println("Error al puntuar");
		}
		
	}
	
	/*Verifica si ya existe un post con el mismo nombre*/
	public static boolean existPost(Post p , Map<String, Post> systemPost){
		
		for(Entry<String, Post> data : systemPost.entrySet()){
			
			if( p.getNombre().equals(data.getValue().getNombre()) ) 
				return true;
			else
				return false;
			
		}
		
		return false;
	}
	
}
