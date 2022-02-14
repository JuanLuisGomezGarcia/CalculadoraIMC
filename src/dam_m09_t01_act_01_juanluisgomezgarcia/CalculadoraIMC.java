package dam_m09_t01_act_01_juanluisgomezgarcia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalculadoraIMC {


    public static void main(String[] args) throws IOException {
        
        //Creamos las distintas variables que usaremos en la clase
        //su nombre ya las esplica
        String datoRecivido;
        float altura,peso,calculoIMC;
        
        //Recivimos eel dato de la clase Principal
        BufferedReader amc = new BufferedReader(new InputStreamReader(System.in));
        // Introducimos el String recivido en la variable inicialmente declarada
        datoRecivido =amc.readLine();
        
        // Separamos la informacion en dos variables float con la funcion split
        // y los separamos con el indicador espacio
        altura = Float.valueOf (datoRecivido.split(" ")[1]);
        peso =Float.valueOf (datoRecivido.split(" ")[2]);
        
        //Una vez conseguido los datos lo introducimos en la variable calculoIMC
        //Con su respectiva logica para conseguir el IMC
        calculoIMC = altura *altura;
        calculoIMC = peso /calculoIMC   ;
        
        //Para finalizar devolvemos el dato a traves de System.out.println 
        //Seleccionando el adecuado a traves de un conjunto de IF anidados
       if (calculoIMC < 18.50) { System.out.println("Bajo Peso");}
       if (calculoIMC >= 18.50 && calculoIMC <=24.99) { System.out.println("peso normal");}
       if (calculoIMC >= 25 && calculoIMC <=29.99) { System.out.println("Sobrepeso");}
       if (calculoIMC >= 30 && calculoIMC <=39.99) { System.out.println("Obesidad");}
       if (calculoIMC >= 40) { System.out.println("Obesidad morbida");}
       
    }
    
}