package views;

public class Pantalla {
		/*atributos de la Pantalla*/
			int size;
			int lineSize;
			String symbol;
		/*fin atributos de clase*/
	
	/*instancia por defecto de la pantalla*/		
	public Pantalla(){
		this.setSize(33);
		this.setSymbol("-");
		this.setLineSize(17);
	}
			
	/*instancia seteada de la pantalla*/
	public Pantalla(int n , String s){
		this.setSize(n);
		this.setSymbol(s);
	}
	
	/*Seters y geters de parametros*/
		public int getSize() {
			return size;
		}
		
		public void setSize(int size) {
			this.size = size;
		}
	
		public int getLineSize() {
			return lineSize;
		}
		
		public void setLineSize(int s) {
			this.lineSize = s;
		}
		
		public void setSymbol(String s){
			this.symbol = s;
		}
	
	/*muestra una cabecera con un titulo, longitud por defecto*/
	public void showHeader(String title){
		int l = title.length();
		int x = (this.getSize()-l)/2;
		int x2 = this.getSize()-(l+x);
		lines(this.symbol,x);
		System.out.print(title);
		lines(this.symbol,x2);
		System.out.print("\n\n");
		
	}
	
	/*muestra una cabecera personalizada por pantalla*/
	public void showHeader(String title, int n , String s){
		int l = title.length();
		int x = (n-l)/2;
		int x2 = n-(l+x);
		lines(s,x);
		System.out.print(title);
		lines(s,x2);
		System.out.print("\n\n");
	}
	
	/*muestra un footer por pantalla*/
	public void showFooter(){
		System.out.print("\n");
		lines(this.symbol,this.getSize());
		System.out.print("\n\n");
	}
	
	/*muestra un footer personalizado por pantalla*/
	public void showFooter(int n , String s){
		System.out.print("\n");
		lines(s,n);
		System.out.print("\n\n");
	}
	
	/*muestra una sucesion de linas por pantalla*/
	public static void lines(int dim){
		for(int i = 0 ; i<dim ; i++){
			System.out.print("-");
		}
	}
	
	/*muestra una sucesion de lineas personalizadas por pantalla*/
	public static void lines(String symbol , int dim){
		for(int i = 0 ; i<dim ; i++){
			System.out.print(symbol);
		}
	}
	
	/*funcion parecida a print*/
	public void textLine(String s , String v){
		int n = this.getLineSize();
		int l = s.length();
		int x = n-(l+2);
		System.out.print(s);
		lines(" ", x);
		System.out.print(": ");
		System.out.println(v);
	}
	
	/*funcion parecida a print*/
	public void textLine(String s , int v){
		int n = this.getLineSize();
		int l = s.length();
		int x = n-(l+2);
		System.out.print(s);
		lines(" ", x);
		System.out.print(": ");
		System.out.println(v);
	}
	
	/*main de prueba del objeto*/
	public static void main(String[] args){
		Pantalla p = new Pantalla();
		p.textLine("titulo","valor");
		p.textLine("hola","3");
		p.textLine("chau","5");
	}
}
