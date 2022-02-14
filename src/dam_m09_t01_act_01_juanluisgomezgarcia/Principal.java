
package dam_m09_t01_act_01_juanluisgomezgarcia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Principal {

    public static void main(String[] args) throws IOException {
   
        //Generamos las distintas variables que usaremos en el programa
        //Con nombres orientativos que esplican su uso
        String datoEnviado,datoRecivido;
        double altura = 0,peso = 0;
        String rutaProyecto = System.getProperty("user.dir");        

        do{
        
        //A traves de una funcion creada por nosotros pedimos un double
        //y controlamos que no se añadan otro datos que no sean numeros
        System.out.println("Introduce la altura. (0 para finalizar programa)");
        altura= pedirDouble();
        System.out.println("Introduce el peso. (0 para finalizar programa)");
        peso = pedirDouble();
        
        //Cogemos los datos introducidos por el usuarios y los metemos en un String
        // concadenados con un espacio frente a cada valor que usaremos para separarlos
        //con un esplit en la clase CalculadoraIMC
        datoEnviado= String.valueOf(" " +altura + " " + peso);
      
        // Generamos el proceso usando el jar ya previamente creado.
        Process calculadoraIMC = new ProcessBuilder ("java", "-jar",rutaProyecto+
        "\\src\\dam_m09_t01_act_01_juanluisgomezgarcia\\calculadoraIMC.jar").start();
        
        //Enviamos el string priviamente comentado a traves de un prinStream que apunta
        //la clase CalculadoraIMC.
        PrintStream ps = new PrintStream(calculadoraIMC.getOutputStream(),true);
        ps.println((datoEnviado));

        //Recivimos el calculo ya realizado con un bufferedReader que recive de la clase calculadoraIMC
        //y lo metemos en una variable
        BufferedReader br = new BufferedReader(new InputStreamReader(calculadoraIMC.getInputStream()));
        datoRecivido = br.readLine();
        
        //Mostramos esa variable por consola
        System.out.println(datoRecivido);
        }while(!(altura==0 && peso==0));}
    
        // Aqui esta la funcion utilizada para pedir los datos double al usuario
        public static double pedirDouble(){
        double numeroRetornar=0;
        double clave_pedirDouble;
        do{ clave_pedirDouble=0;
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brm = br.readLine();
        numeroRetornar = Double.parseDouble(brm);
        if(numeroRetornar<0){
            System.out.println("Introdusca un valor positivo por favor");
            clave_pedirDouble=-1;
        }
        }catch(Exception e){ clave_pedirDouble=-1;System.out.println("Introdusca un numero por favor");}
        }while(!(clave_pedirDouble==0));
        return numeroRetornar;}     }
