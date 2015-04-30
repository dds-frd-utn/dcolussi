package domain;
import java.util.ArrayList;
import java.util.Scanner;

import views.Pantalla;
public class Post {
	
	/*atributos de clase*/
		ArrayList<Comentario> comentariosList;
		String nombre;
		Comentario textPost;
		Usuario autor;
		int likes;
	/*fin atributos de clase*/
	
	/*Inicializar Post. Forma de instancia sin parametros*/
	public Post(){

		this.nombre = null;
		this.textPost = null;
		this.autor = null;
		this.likes = 0;
		
	}
	
	/*Inicializar Post. Forma de instancia sin parametros*/
	@SuppressWarnings("resource")
	public Post(Usuario autor){
		Pantalla p = new Pantalla();
		Scanner reader = new Scanner(System.in);
		
		this.comentariosList = new ArrayList<Comentario>();
		
		p.showHeader("Nuevo post");
		System.out.print("Nombre de post : ");
		this.nombre = reader.nextLine();
		this.textPost = new Comentario(true);
		this.autor = autor;
		this.likes = 0;
		p.showFooter();
		
	}
	
	/*devuelve el objeto autor*/
	public Usuario getAutor() {
		return autor;
	}

	/*devuelve el nombre del autor*/
	public String getAutorName() {
		return autor.getUsername();
	}
	
	/*devuelve el valor de likes que le dio un usuario*/
	public int getLike(){
		return this.likes;
	}
	
	/*setea nuevos like*/
	public void setLike(int val){
		if(this.likes > 0)
			this.likes = this.likes + val;
		else
			this.likes = val;
	}
	
	/*devuelve true si un objeto usuario es autor del post*/
	public boolean isAutor(Usuario u) {
		if(this.autor.getUsername().equals(u.getUsername()))return true;
		else return false;
	}
	
	/*devuelve el texto inicial del post*/
	public Comentario getTextPost(){
		return this.textPost;
	}
	
	/*devuelve el nombre del post*/
	public String getNombre(){
		return this.nombre;
	}
	
	/*agrega un comentario a la lista de comentarios*/
	public void addComentario(Comentario uncomentario){
		this.comentariosList.add(uncomentario);
	}
	
	/*muestra por pantalla todos los comentarios que tiene este post*/
	public void showComentarios(){
		Pantalla p = new Pantalla();
		p.textLine("Principal[0]", this.getTextPost().getTexto());
		
		int i = 0;
		String textCom;
		for( Comentario com : comentariosList){
			textCom = com.getTexto();
			i++;
			p.textLine("Comentario["+i+"]", textCom);
			
		}
		
	}
	
	/*muestra por pantalla el autor*/
	public void showAutor() {
		Pantalla p = new Pantalla();
		if(this.getAutor() == null )
			p.textLine("Autor", "<null>");
		else
			p.textLine("Autor", this.getAutorName());	
	}
	
	/*muestra por pantalla el comentario principal*/
	public void showTextPost(){
		this.textPost.showComentario();
	}

	/*muestra por pantalla el nombre del post*/
	public void showNombre() {
		Pantalla p = new Pantalla();
		p.textLine("Nombre Post", this.nombre);
	}
	
	/*calcula cuantos comentarios tiene un post*/
	public int getPuntos(){
		return (comentariosList.size()+this.getLike());
	}
	
	/*elige un post por el nombre*/
	public Post getPostByName(String n){
		if( this.getNombre().equals(n) ) return this;
		else return null;
	}
	
	/*muestra por pantalla los puntos del post*/
	public void showPuntos(){
		Pantalla p = new Pantalla();
			p.textLine("Puntaje",(comentariosList.size()+this.getLike()));
	}
	
	/*ejecutar la prueba del objeto*/
	public static void main(String[] args){
		Usuario u = new Usuario();
		Post p = new Post(u);
		p.showTextPost();
		p.showAutor();
	}
	
}
