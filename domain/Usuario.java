package domain;

import java.util.Scanner;

import views.Pantalla;

public class Usuario {
	
		/*atributos de clase*/
			String username;			
		/*fin atributos de clase*/
	
	/*instanciar usuario con login automatico*/
	@SuppressWarnings("resource")
	public Usuario(){
		Pantalla p = new Pantalla();
		p.showHeader("Pantalla de login");
			Scanner read = new Scanner(System.in);
			System.out.print("Nombre Usuario : ");
			this.setUsename( read.nextLine() );
		p.showFooter();
		
		this.showLoginStatus();
	}
	
	/*Instanciar usuario con nombre automatico*/
	public Usuario(String name){
		this.setUsename( name );
		this.showLoginStatus();
	}
	
	/*permite a un usuario ingresar un comando por pantalla. Devuelve el string ingresado*/
	@SuppressWarnings("resource")
	public String doAction(){
		Scanner read = new Scanner(System.in);
		System.out.print( "Act : $" );
		return read.nextLine();
		
	}
	
	public void setUsename(String name){
		this.username = name;
	}
		
	public void showLoginStatus(){
		System.out.println(
				"Login with : "
				+ this.getUsername()
		);
	}
	
	/*devuelve el nombre de usuario*/
	public String getUsername() {
		return username;
	}
	
	/*muestra por pantalla el nombre de usuario*/
	public void showUsername(){
		System.out.println("User : "+this.getUsername());
	}
	
	/*ejecutar prueba del objeto*/
	public static void main(String[] args){
		Usuario u = new Usuario();
		u.showUsername();
	}
}
