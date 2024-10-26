/*
* Se deber hacer un conversor de monedas y debe consumir una api
*
 */
package com.myweb.main;
import com.myweb.recursos.FormatClassFromJson;
import com.myweb.recursos.Http;
import com.myweb.modelo.CoinFactor;



import java.io.*;
import java.util.Scanner;


public class Principal {
    //variables
    private static final String path = "./historial.txt";

    private static final String menu = """
            
            **********************************************************
            Sea bienvenido/a al conversor de monedas =]
            
            1) Dólar =>> Peso Argentino
            2) Peso Argentino =>> Dólar
            3) Dólar =>> Real Brasileño
            4) Real Brasileño =>> Dólar
            5) Dólar =>> Peso Colombiano
            6) Peso Colombiano =>> Dólar
            7) Imprimir historial de conversiones
            8) Salir
            
            Elija una opción válida
            **********************************************************
            """;
    private static int seleccion = 0 ;

    public static void main(String[] args) {
        Http http = new Http();
        String gjson = http.httpBodyResponse();
        CoinFactor coinFactor = new CoinFactor(FormatClassFromJson.obtenerValoresDelJson(gjson));

        while (seleccion != 8) {
            System.out.println(menu);
            Scanner entradaTeclado = new Scanner(System.in);

            seleccion = entradaTeclado.nextInt();
            switch (seleccion) {
                case 1: { // dólar a peso Argentino
                    System.out.println("Ingrese el valor que desea convertir");
                    float dolar = entradaTeclado.nextFloat();
                    float pesoArg = coinFactor.getPesoArgentino()*dolar;
                    System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [AR$]", dolar, pesoArg);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+dolar +" [USD] corresponde al valor final de =>>> " +pesoArg +" [AR$]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                }
                    break;
                case 2: { // Peso Argentino a dólar
                    System.out.println("Ingrese el valor que desea convertir");
                    float pesoArg = entradaTeclado.nextFloat();
                    float dolar = (1/coinFactor.getPesoArgentino())*pesoArg;
                    // consumir api
                    System.out.printf("El valor %.2f [AR$] corresponde al valor final de =>>> %f [USD]",pesoArg, dolar);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+pesoArg +" [AR$] corresponde al valor final de =>>> " +dolar +" [USD]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 3: { // dólar a Real Brasil
                    System.out.println("Ingrese el valor que desea convertir");
                    float dolar = entradaTeclado.nextFloat();
                    float realBrasil = coinFactor.getRealBrasil()*dolar;
                    // consumir api

                    System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [BRL]", dolar, realBrasil);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+dolar +" [USD] corresponde al valor final de =>>> " +realBrasil +" [BRL]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 4: { // Real Brasil a Dólar
                    System.out.println("Ingrese el valor que desea convertir");
                    float realBrasil = entradaTeclado.nextFloat();
                    float dolar = (1/coinFactor.getRealBrasil())*realBrasil;
                    System.out.printf("El valor %.2f [BRL] corresponde al valor final de =>>> %f [USD]", realBrasil, dolar);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+realBrasil +" [BRL] corresponde al valor final de =>>> " +dolar +" [USD]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 5: { // Dolar a Peso Colombiano
                    System.out.println("Ingrese el valor que desea convertir");
                    float dolar = entradaTeclado.nextFloat();
                    float pesoColombia = coinFactor.getPesoColombiano()*dolar;
                    System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [COP]", dolar, pesoColombia);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+dolar +" [USD] corresponde al valor final de =>>> " +pesoColombia +" [COP]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                case 6: { // Peso Colombia a Dólar
                    System.out.println("Ingrese el valor que desea convertir");
                    float pesoColomba = entradaTeclado.nextFloat();
                    float dolar = (1/coinFactor.getPesoColombiano())*pesoColomba;
                    System.out.printf("El valor %.2f [COP] corresponde al valor final de =>>> %f [USD]", pesoColomba, dolar);
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file,true);
                        archivo.write("El valor "+pesoColomba +" [COP] corresponde al valor final de =>>> " +dolar +" [USD]\n");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;

                case 7: { // Imprimir historial de conversiones
                    System.out.println("Historiarl de conversiones:\n");
                    try {
                        File file = new File(path);
                        FileReader archivo = new FileReader(file);
                        int data = archivo.read();
                        while (data != -1) {
                            System.out.print((char) data);
                            data = archivo.read();
                        }
                        archivo.close();
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                }
                    break;
                case 8: {
                    System.out.println("Hasta Luego");
                    // el siguiente fragmento es para borrar el contenido del historial.txt
                    try {
                        File file = new File(path);
                        FileWriter archivo = new FileWriter(file);
                        archivo.write("");
                        archivo.close();

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        }
    }
}