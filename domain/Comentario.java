package domain;

import java.util.Scanner;

import views.Pantalla;

public class Comentario {
	
	/*atributos de clase*/
		Usuario autor;
		String texto;
		int megusta;
	/*fin atributos de clase*/
	
	/*instancia de Comentario sin parametros*/
	public Comentario(){
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		this.setPuntuacion(0);
		this.setTexto("");
				
		System.out.print("Nuevo comentario : ");
		String com = reader.nextLine();
		
		this.setTexto(com);		
	}
	
	/*instancia de comentario con parametro ture*/
	public Comentario(Boolean parm){
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String com;
		this.setPuntuacion(0);				
		System.out.print("Primer Comentario : ");
		com = reader.nextLine();
		
		this.setTexto(com);		
	}
	
	/*devuele el el string del comentario*/
	public String getTexto() {
		return texto;
	}
	
	/*setea el texto del comentario*/
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/*devuelve la puntuacion del comentario*/
	public int getPuntuacion() {
		return megusta;
	}
	
	/*setea la puntuacion*/
	public void setPuntuacion(int puntuacion) {
		this.megusta = puntuacion;
	}

	/*muestra por pantalla el comentario*/
	public void showComentario(){
		Pantalla p = new Pantalla();
		p.textLine("Com", this.getTexto());

	}
	
	/*pregunta si el comentario es nulo "N" , devuelve true*/
	public Boolean comentarioNull(){
		if( this.getTexto().equals("N") ) return true ; else return false;
	}
	
	/*ejecutar prueba de objeto*/
	public static void main(String[] arg){
		Comentario com = new Comentario(true);
		com.showComentario();
	}
	
}
