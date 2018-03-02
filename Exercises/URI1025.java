package uri1025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        try{
            String input = br.readLine();// leo los dos primeros numeros diferentes a 0 0
            int n, q, cases = 1, t, index;
            while (!input.equals("0 0")) {
            bw.write("CASE# " + cases + ":\n");//comienza con el primer caso
            bw.flush();
            
            n = Integer.parseInt(input.split(" ")[0]);//tomo el prmer valor que sera el tamaño del arreglo
            q = Integer.parseInt(input.split(" ")[1]);//el segundo num que sera la cantidad de veces para buscar el numero que quiero

            int[] array = new int[n];//creo el array con el tamaño del primer numero

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(br.readLine());//leo los numros
            }

            array = counting_sort(array.clone());//copio todo el arreglo

            for (int i = 0; i < q; i++) {
                t = Integer.parseInt(br.readLine());//Elemento a buscar en los numeros de entrada
                index = binary_search(array, t);//paso los dos para el algoritmo

                if (index != -1) {//si es igual a -1 no encuentra el numero a buscar
                    bw.write(t + " found at " + (index + 1) + "\n");
                    bw.flush();
                } else {
                    bw.write(t + " not found\n");
                    bw.flush();
                }
            }
            cases += 1;
        }
    }catch(Exception ex){}
}

    public static int[] counting_sort(int[] unsorted) {
        int[] sorted = new int[unsorted.length];//numeros sorteados con el tamaño del primer numero
        int[] aux = new int[10001];//no debe ser mayor a 1000
        int index = 0;

        for (int i = 0; i < sorted.length; i++) {//recorremos el array
            aux[unsorted[i]] += 1;//vamos cumando unos a las posiciones si es igual la posicion a la anterior llevara mas de 1
        }

        for (int i = 0; i < aux.length; i++) {//mientras que sea menor a 1000
            if (aux[i] != 0) {//si es diferente a 0 descarta las posiciones del arreglo en donde no se introducieron valores, debido aque donde hay un 1 existen un meero
                //el numero mayor depende de cauntas veces se introdujo el mismo numero 
                for (int j = 0; j < aux[i]; j++) {
                    sorted[index] = i;//guardo el indice de los elementos
                    index += 1;//llevara la cuenta para no salirse del array del tamaño N
                }
            }
        }
        return sorted;     
    }

    public static int binary_search(int[] array, int value) {
    int lowerBound =0;
    int upperBound = (array.length)-1;
    int index = -1;
    int middlepoint;
    while (lowerBound < upperBound){
        middlepoint = (lowerBound + upperBound) / 2;
        if (value == array[middlepoint]){
            index = middlepoint;
            break;
        }else{
            if (value < array[middlepoint])
                upperBound = middlepoint - 1;
            else
                lowerBound = middlepoint + 1;         
        }
    }
                  
    if (lowerBound == upperBound && array[lowerBound] == value)
        index = lowerBound;        
    return index;
    }
    
}
