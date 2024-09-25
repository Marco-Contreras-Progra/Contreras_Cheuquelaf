package com.example;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];

        int a = -1;




        do {
            System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);




            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (a > 0 || a < 6);




            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    String edad;




                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Estadocivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            edad = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(a == 2) {
                int mayoresDeEdad = 0;




                for (String[] persona : registro) {
                    int edad = Integer.parseInt(persona[2]); 
                    if (edad >= 18)
                     mayoresDeEdad++;
                }

                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
                
            } else if(a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);




                for (int i = 0; i < queSera; i++) {
                    int edad = Integer.parseInt(registro[i][2]);
                    if (edad < 18) 
                    menoresDeEdad++;
                }
            

                System.out.println("Hay " + menoresDeEdad + " menores de edad.");

            } else if(a == 4) {
                int catidadMayoresEdad = 0;




                for (String[] persona : registro) {
                    int edad = Integer.parseInt(persona[2]); 
                    if (edad >= 60 && persona[1].equals("casado/a")) {
                        catidadMayoresEdad++;
                    } else if (edad >= 65 && persona[1].equals("soltero/a")) {
                        catidadMayoresEdad++;
                        
                    }
                }
                
                System.out.println("Hay " + catidadMayoresEdad + " personas de tercera edad");
            } else if(a == 5) {
                int c = 0;
                int d = 0;



                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
            }
        }while (a != 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - opa(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return opa(registro) != 0;
    }




    public static int opa(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }




        return 0;
    }
}

       

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

