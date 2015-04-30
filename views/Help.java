package views;


public class Help {
	
	/*lo que sucede cuando se instancia*/
	public Help(){
		this.showHelp();
	}
	
	/*muestra la ayuda por pantalla*/
	public void showHelp(){
		
		Pantalla p = new Pantalla();
		p.showHeader("Ayuda de comandos");
			System.out.println(
				"\n"
					+"post    : Crea un nuevo post en el foro\n"
					+"comment : Comenta un post con el usuario logeado\n"
					+"punt    : Agrega una puntuacion al post\n"
					+"delete  : Borra un post\n"
					+"detail  : Muestra en detalle un post en particular\n"
					+"show    : Muestra todos los posts del foro\n"
					+"ustatus : Muestra informacion sobre el usuario logeado"
					+"change  : Cambia de usuario\n"
					+"clear   : Limpia la consola\n"
					+"exit    : Terminar ejecucion\n"		
			);
		p.showFooter();
		
	}
	
	public static void showSystenInfo(){
		Pantalla p = new Pantalla();
			System.out.println("\nSystem Foro 1.0\nAuthor : Diego Colussi\nUTN-FRD\n");
	}
	
	/*prueba de clase*/
	public static void main(String[] args){
		Help h = new Help();
	}
}
