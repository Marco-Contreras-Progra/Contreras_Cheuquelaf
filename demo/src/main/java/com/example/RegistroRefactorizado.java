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
