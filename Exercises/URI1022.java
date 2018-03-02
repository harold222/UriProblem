package uri1022;

import java.io.*;

public class URI1022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write("Introduzca la cantidad de casos: \n");bw.flush();
            int cases = Integer.parseInt(br.readLine());//leo las veces que ingresaran valores
            int n, d;
            bw.write("Introduzca las operaciones: \n");bw.flush();
            for (int i = 0; i < cases; i++) {
                String[] expression = br.readLine().split(" ");//separo por el espacio los valores
                
                switch (expression[3].charAt(0)) {//toammos el valor si es suma,resta, multplicacion, division que esta en esa posicion  
                    case '+': //Sum: (N1*D2 + N2*D1) / (D1*D2)
                    {
                        n = ((Integer.parseInt(expression[0]) * Integer.parseInt(expression[6])) + (Integer.parseInt(expression[4]) * Integer.parseInt(expression[2])));
                        d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);//(D1*D2)
                        if (d == 0) 
                            bw.write(n + "/" + d +" = "+n+"\n\n");bw.flush();//si es igual a 0 devuelvo el numerador    
                        int a = n / MCD(n, d);//paso los valores obtenidos despues del mcd
                        int b = d / MCD(n, d);
                        
                        if(a < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+(a*-1)+"/"+b);
                        if(b < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+a+"/"+(b*-1));
                        else
                            bw.write(n + "/" + d +" = "+a+"/"+b+"\n\n");bw.flush();
                    }break;

                    case '-': //RESTA: (N1*D2 - N2*D1) / (D1*D2)
                    {
                        n = ((Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]))- (Integer.parseInt(expression[4]) * Integer.parseInt(expression[2])));
                        d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);//(D1*D2) 
                        if (d == 0) 
                            bw.write(n + "/" + d +" = "+n+"\n\n");bw.flush();//si es igual a 0 devuelvo el numerador
                        int a = n / MCD(n, d);//paso los valores obtenidos despues del mcd
                        int b = d / MCD(n, d);
                        
                        if(a < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+(a*-1)+"/"+b);
                        if(b < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+a+"/"+(b*-1));
                        else
                            bw.write(n + "/" + d +" = "+a+"/"+b+"\n\n");bw.flush();
                        
                    } break;
                    
                    case '*': //Multi: (N1*N2) / (D1*D2)
                    {
                        n = (Integer.parseInt(expression[0]) * Integer.parseInt(expression[4]));
                        d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]);
                        if (d == 0) 
                            bw.write(n + "/" + d +" = "+n+"\n\n");bw.flush();//si es igual a 0 devuelvo el numerador
                        int a = n / MCD(n, d);//paso los valores obtenidos despues del mcd
                        int b = d / MCD(n, d);
                        
                        if(a < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+(a*-1)+"/"+b);
                        if(b < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+a+"/"+(b*-1));
                        else
                            bw.write(n + "/" + d +" = "+a+"/"+b+"\n\n");bw.flush();
                    } break;
                    
                    case '/': //Division: (N1 * D2) / (N2 * D1)
                    {
                        n = (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]));//1*4
                        d = Integer.parseInt(expression[2]) * Integer.parseInt(expression[4]);//2*3
                        if (d == 0) 
                            bw.write(n + "/" + d +" = "+n+"\n\n");bw.flush();//si es igual a 0 devuelvo el numerador
                        int a = n / MCD(n, d);//paso los valores obtenidos despues del mcd
                        int b = d / MCD(n, d);
                        
                        if(a < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+(a*-1)+"/"+b);
                        if(b < 0 )
                            System.out.println(n + "/" + d +" = "+"-"+a+"/"+(b*-1));
                        else
                            bw.write(n + "/" + d +" = "+a+"/"+b+"\n\n");bw.flush();
                    } break;
                }
                System.out.println("--------------------------------------");
            }
        } catch (Exception ex) {}
    }
    
    public static int MCD(int n, int d) {
        for (int i = n; i != 0.0; i--) {//comienzo desde n, y va disminuyendo
            if (n % i == 0 && d % i == 0) {//los dos deben ser divisibles por el mismo numero para poder reducirlos
                return i;
            }
        }
        return 1;
    }
}
