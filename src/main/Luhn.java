package main;

public class Luhn {
    
    public static String calcular(String codigo){
        
        int[] tmp = new int[codigo.length()];
        
        for (int i=0;i<codigo.length();i++){
            tmp[i] = Character.getNumericValue(codigo.charAt(i));
        }
       
        for (int i=tmp.length-1;i>=0;i=i-2){
            tmp[i]=tmp[i]*2;
           
            if (tmp[i] >= 10) {
                tmp[i] = tmp[i] - 9;
            }
        }
        
        int suma = 0;
        for (int i=0;i<tmp.length;i++){
            suma = suma + tmp[i];
        }
       
        suma=suma*9;
        String resultado = String.valueOf(suma);
        
        return resultado.substring(resultado.length() - 1);
    }
    
    public static boolean verificar(String codigo) {
        char digito = codigo.charAt(codigo.length() - 1);
        String cadena = calcular(codigo.substring(0, codigo.length() - 1));
        
        return digito == cadena.charAt(0);
    }
    
    public static void main(String[] args){
        String codigo = "01000000433";
        String digito = calcular(codigo);
        System.out.println(digito);
        System.out.println("result: " + codigo + digito);
        System.out.println(verificar(codigo+digito));
    }
}
