package CadenaSinCaracterInicialNiFinal;

public class Main {
    public static void main (String[] args){
        String cadena = "1,2,3";
        cadena = devolverSinComasNiCaracterirInicialYFinal(cadena);
    }
    public static String devolverSinComasNiCaracterirInicialYFinal(String cadena) {

        cadena = stringSinComasNiCaracterInicialYFinal(cadena);



        return cadena;
    }

    public static String stringSinComasNiCaracterInicialYFinal(String cadena) {
        cadena = cadenaSinComas(cadena);

        cadena = cadenaSinValorInicialNiFinal(cadena);

        return cadena;
    }

    public static String cadenaSinComas(String cadena) {
        cadena = cadena.replace(",", " ");

        return cadena;
    }

    public static String cadenaSinValorInicialNiFinal(String cadena) {
       cadena = quitarValorInicial(cadena);

       cadena = quitarValorFinal(cadena);

       return cadena;
    }
    
    public static String quitarValorInicial(String cadena){
        String primerCaracter = caracterEnPosiciónX(cadena, 0);
        cadena = cadena.replace(primerCaracter, "");
        return cadena;
    }


    public static String quitarValorFinal(String cadena){
        int posiciónLetraFinal = posicionFinalCadena(cadena);
        String caracterFinal = caracterEnPosiciónX(cadena, posiciónLetraFinal);
        cadena = cadena.replace(caracterFinal, "");

        return cadena;
    }

    public static int posicionFinalCadena(String cadena){
        return cadena.length()-1;
    }

    public static String caracterEnPosiciónX(String cadena, int x){
        Character caracterEnX = cadena.charAt(x);
        return caracterEnX.toString();
    }



}
