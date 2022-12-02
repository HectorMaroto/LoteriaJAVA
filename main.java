import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int boleto[]=new int[9];    //Inicializamos el array que contendra los numeros del boleto
		
		int control;       // Para cuando el usuario quiera salir de la aplicacion
		
		int respuesta=0;  // Seran los numeros que va diciendo el usuario
		
		int intentos=1;   // Intentos permitidos al usuario
		
		int aciertos=0;
		
		int contador=1;  //Para comprobar cuando hemos acertado todo el boleto
		
		String tachados[]=new String[boleto.length]; // Creamos un array de tipo String para tachar los numeros acertados del boleto con la misma longitud del array boleto
		
		boolean control1=false; // Lo usaremos como controlador para saber si el numero existe en el boleto o no
		
		Scanner sc= new Scanner(System.in);
		
		//La variable valor recogera los numeros aleatorios que tendra el boleto
		
		for(int i=0;i<boleto.length;i++) {
			
			//Generamos valores aleatorios del 10 al 100 y llenamos el array boleto con esos valores
			
			int valor = (int) Math.floor(Math.random()*(100 - 10)+10);
			
			boleto[i]=valor;
			
			for(int j=0;j<i;j++) {  //Con este bucle hacemos que ningun numero aleatorio se repita
				
				if(boleto[j]==boleto[i]) {
				
					i--;             //Si se repite, el iterador no avanza hasta que salga un numero distinto
				
				}
			
			}
			
			System.out.println("Numero "+(i+1)+" del boleto: "+boleto[i]);
			
		}
		
		//Imprimimos nuestro boleto generado
		
		System.out.print("Nuestro boleto es: ");
		
		for(int j=0;j<boleto.length;j++) {
			
			System.out.print(boleto[j]+" ");
			
		}
		
		for(int j=0;j<tachados.length;j++) {
			
			tachados[j]=Integer.toString(boleto[j]);   //Hacemos que los valores de boleto sean de tipo String para tachar los numeros acertados
			
		}
		
		//Aqui empieza la loteria
		
		//Limpiamos pantalla para que el usuario empiece a intentar adivinar los numeros del boleto en un maximo de 15 intentos
		
		for(int i=0;i<150;i++) {
			
			System.out.println(" ");
			
		}
		
		System.out.println("Empieza el juego usuario. Debes introducir numeros del 10 al 100 para adivinar el boleto ganador.");
		
		System.out.println("Si introduces un numero fuera del rango 10-100, desaprovecharas un intento");
		
		do {
			
			System.out.println("Probar numero (1) o salir del juego (0)");  
			
			control=sc.nextInt();   //Primero comprobamos si el usuario quiere seguir jugando o prefiere salir del juego
			
			if(control==1) {
				
				contador=0;
				
				System.out.println("Intento: "+intentos);
				
				System.out.println("Escribe un numero entre el 10 y el 100");	
				
				respuesta=sc.nextInt();
				
				int i=0;
				
				while(i<boleto.length){
					
					if(respuesta==boleto[i]) {
						
						tachados[i]="0";
						
						if(tachados[i].equals("0")) {
							
							tachados[i]="XX";      //Los numeros acertados se sustituiran por XX
							
						}

						aciertos++;                 //Sumaremos un acierto si se adivina el numero
						
						control1=true;
						
						i=9;                        //Salimos del bucle si se acierta el numero			
				
					}else{
							
						control1=false;
						
					}
					
					i++;
					
				}
				
				for(int j=0;j<tachados.length;j++) {  //Con este bucle hacemos que aunque el usuario repita algun numero el usuario siga jugando hasta tachar  
					
					if(tachados[j]!="XX") {           //todo el boleto y no solo cuando obtenga nueve aciertos
						
						contador++;
						
					}
					
				}
				
				System.out.print("El boleto actual es: ");
				
				for(int j=0;j<boleto.length;j++) {
					
					System.out.print(tachados[j]+" ");

				}
				
				System.out.println(" ");
				
				if(!control1) {
					
					System.out.println("Numero "+respuesta+": no existe");
				
				}
				
				System.out.println("Numero de aciertos: "+aciertos);
				
				if(contador==0) {
					
					intentos=15;
					
				}
				
				intentos++;
				
			}
			
			System.out.println(" ");
			
		}while(control!=0 && intentos<=15);
		
		if(contador==0) { 
			
			System.out.println("Has ganado la primitiva!! Enhorabuena, eres millonario");
			
		}else{
			
			System.out.println("Vuelve a ejecutar el programa para una nueva partida");
			
		}
		
	}

}

