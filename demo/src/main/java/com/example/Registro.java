package com.example;

import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
       

    }

    public static void agregarPersona(String [][] registro, Scanner scanner) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = obtenerEntrada(scanner, "Ingrese nombre: ");
            String estadoCivil = obtenerEntrada(scanner, "Ingrese estado civil (Soltero/a - Casado/a): ");
            String edad = obtenerEntrada(scanner, "Ingrese edad: ");

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadoCivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static String obtenerEntrada(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    public static boolean hayCupo(String[][] registro) {
        return obtenerUltimoEspacio(registro) != -1; 

    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null || registro[i][0].isEmpty()) {
                return i;
            }
        }
        return -1; 
    }

    
    public static void mostrarMayoresDeEdad(String [][] registro, Scanner scanner) {
        int mayoresDeEdad = contarPorEdad(registro, 18, true);
        System.out.println("Hay " + mayoresDeEdad + "mayores de edad" );

    }
    
    public static void mostrarMenoresDeEdad(String [][] registro, Scanner scanner ) {
        int menoresDeEdad = contarPorEdad(registro, 18, false);
        System.out.println("Hay " + menoresDeEdad + "menores de edad"); 
    }
    
    public static void mostrarTerceraEdad(String [][] registro) {
        int terceraEdad = 0;

        for (String[] persona : registro) {
            if (persona[2] != null && !persona[2].isEmpty()) {
                int edad = Integer.parseInt(persona[2]);
                if ((edad >= 60 && persona[1].equals("casado/a")) || (edad >= 65 && persona[1].equals("soltero/a"))) {
                    terceraEdad++;
                }
            }
        }

        System.out.println("Hay " + terceraEdad + " personas de tercera edad.");
    }
    
    public static void mostrarEstadoCivil(String [][] registro) {
        int casados = 0;
        int solteros = 0;

        for (String[] persona : registro) {
            if (persona[1] != null) {
                if (persona[1].equals("casado/a")) {
                    casados++;
                } else if (persona[1].equals("soltero/a")) {
                    solteros++;
                }
            }
        }
    }
    
    public static int contarPorEdad(String[][] registro, int edadReferencia, boolean mayores) {
        int contador = 0;
        for (String[] persona : registro) {
            if (persona[2] != null && !persona[2].isEmpty()) {
                int edad = Integer.parseInt(persona[2]);
                if ((mayores && edad >= edadReferencia) || (!mayores && edad < edadReferencia)) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
        //listo
