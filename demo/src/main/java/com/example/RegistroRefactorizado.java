package com.example;


import java.util.InputMismatchException;

import java.util.Scanner;

public class RegistroRefactorizado {
    public static void main(String[] args) {

         String [][] registro = new String[50][3];
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                Menú:
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.
                """);

                 boolean opcionValida = false;
                while (!opcionValida) {
                  try {
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= 6) {
                        opcionValida = true;
                    } else {
                        System.out.println("Por favor ingrese una opción válida entre 1 y 6");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Entrada inválida por favor ingrese un número");
                    scanner.next();
                }
            }

            switch (opcion) {
                case 1:
                    if (hayCupo(registro)) {
                        agregarPersona(scanner, registro);
                    } else {
                        System.out.println("No hay cupo");
                    }
                    break;
                case 2:
                    mostrarMayoresDeEdad(registro);
                    break;
                case 3:
                    mostrarMenoresDeEdad(registro);
                    break;
                case 4:
                    mostrarTerceraEdad(registro);
                    break;
                case 5:
                    mostrarEstadoCivil(registro);
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    break;
            }
        } while (opcion != 6);
    }


         
            



    }

    
}

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
