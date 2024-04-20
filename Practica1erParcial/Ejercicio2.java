import java.util.ArrayList;//importar biblioteca
public class Ejercicio2
{
    public static void vectorGenerado(String [] vec, int x, String ini, ArrayList<String> convinacion){
        if(x < vec.length){//verifica y cuenta el numero de caracteres
            String nCad = ini + vec[x]; // se crea una variable en la que se almacena la cadena inicial mas el valor del vector en la posicion x
            convinacion.add(nCad);//anade un nuevo elemento a la lista
            vectorGenerado(vec, x + 1, nCad, convinacion);//ejecuta la recursividad para iterar sobre los elementos y concatenarlos
            vectorGenerado(vec, x + 1, ini, convinacion);// ejecuta la recursividad para iterar sobre los elementos y concatenarlos
        }
    }
    public static boolean puedoGenerar(String[] a, String x){
        ArrayList<String> convinacion = new ArrayList<String>();//se crea una nueva lista de tipo String
        vectorGenerado(a, 0, "", convinacion);//llamo a la funcion vector generado y le doy valores
        System.out.println(convinacion);//se imprime la convinacion resultante de las cadenas
        return convinacion.contains(x);//determina si la convinacion contiene a X
    }
    public static void main(){
        String [] ejemplo1 = new String[]{"1","1","2"};//crea una lista de cadena
        boolean generar =  puedoGenerar(ejemplo1,  "112");//se crea una nueva variable y se almacena los valores de puedoGenerar
        System.out.println(generar);//se imprime la variable generar
    }
}