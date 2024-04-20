public class Ejercicio1
{
    public static int[] encontrarInicio(int n, String[] maze, int x){
        if(x == n){//verifica si la posicion esta fuera de rango en caso verdadero retorna nulo
        return null;
        }
        if(maze[x].contains("S")){// determinar si la cadena en la poscion x  contiene a S
           return new int[]{x, maze[x].indexOf("S")};//encuentra la posicion y o columna   en la que se encuentra S y la retorna
        }
        return encontrarInicio(n, maze, x + 1);//si no se cumplen los casos base ejecutar la recursividad para iterar sobre las filas 
    }
    
    public static boolean posicionValida(int n, String[] maze, int x, int y, boolean[][] visitados){
        if(x<0 || y<0 || x>=n || y>=n){//valida q la posicion estee dentro del tamano
            return false;//si esta fuera del tamano retornar posicion invalida
        }
        if(maze[x].charAt(y) == '?'|| visitados[x][y]){//extrae el valor de la matriz y verifica si es una pared, extrae el valor de la matriz visitados y verifica si el valor es veradero
            return false;//retorna posicion invalida en caso de que sea una pared o una posicion visitada
        }
        return true;//retorna que la posicion es valida debido a q las condiciones excluyentes no se cumplan 
    }
    
    public static boolean buscarSalida(int n, String[] maze, int x, int y,boolean[][] visitados){
        boolean posValida = posicionValida(n, maze, x, y, visitados);//verifica si la posicion es valida y el resultado de la funcion lo almacena en posValida
        if(posValida == false){//caso base //verifica si la posicion no es valida y deja de iterar
            return false;//retorna posicion invalida
        } 
        visitados[x][y] = true;//dejo rastro asignando el valor de true en la posicion x y
        if(maze[x].charAt(y) == 'E'){//extrae el valor de la matriz y verifica si es la salida
            return true;//caso base//si es la salida retorna verdadero y termina la iteracion
        }
        //si la posicion es valida y aun no es la salida ejecutar el caso recursivo y moverse a los cuatro lados
        boolean norte = buscarSalida(n, maze, x+1, y,visitados);//primero busca arriba
        boolean sur = buscarSalida(n, maze, x-1, y,visitados);//luego abajo
        boolean este = buscarSalida(n, maze, x, y+1,visitados);//luego a la derecha
        boolean oeste = buscarSalida(n, maze, x, y-1,visitados);//y por ultimo a la izquierda
        return norte|| sur||este||oeste;// devuelve la posicion y avanza
    }
    public static boolean puedoSalir(int n, String[] maze){
        int [] posIni = encontrarInicio(n, maze, 0);//verifica si encontro el inicio y lo alamacena en la variable posIni
        int x = posIni[0];//extrae el valor de un vector en la posicion 0 y lo asigna a la variable x
        int y = posIni[1];//extrae el valor de un vector en la posicion 1 y lo asigna a la variable y
        boolean[][] visitados = new boolean[n][n];//creando una matriz para almacenar las posiciones visitadas
        boolean busSalida = buscarSalida(n, maze, x, y, visitados);//almacena el resultado final de la funcion buscar salida
        for(int i=0;i<n;i++){//creando una iteracion o bucle para representar las filas empezando en 0 hasta el tamano del laberinto
           for(int j=0;j<n;j++) {//creando una interacion para representar las columnas empezando en 0 hasta el tamano del laberinto
               if(visitados[i][j]){//extrae el valor de la matriz en la posicion i j y verifica si es verdadero
                System.out.print(" * ");//se imprimen los caminos
                } else{//en caso en ue el valor de la mtriz en la posicion i j sea falso imprime la pared
                    System.out.print(" ? ");//se imprimen las paredes
                }
            }
            System.out.println();//salto de linea
        }
        return busSalida;//retorna si encontro la salida o no 
    }
    
    public static void main(){
        String [] ejemplo1 = { //creando el laberinto
            "**?**",
            "*S*??",
            "**?*?",
            "?***?",
            "?*?E?"
        };
        boolean salir = puedoSalir (5 ,ejemplo1);//el resultado del metodo puedoSalir se almacena en la variables salir
        System.out.println("res: " + salir);//imprime si fue posible salir
    }
}