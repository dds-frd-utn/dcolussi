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
					+"show    : Muestra todos los posts del foro\n"
					+"ustatus : Muestra informacion sobre el usuario logeado"
					+"change  : Cambia de usuario\n"
					+"clear   : Limpia la consola\n"
					+"exit    : Terminar ejecucion\n"		
			);
		p.showFooter();
		
	}
	
	/*prueba de clase*/
	public static void main(String[] args){
		Help h = new Help();
	}
}
