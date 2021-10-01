import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Iniciador();
    }

    public static void Iniciador() {
        do {
            menu1();
            int b = intInput(1, 2);
            if (b == 1) {
                seleccionAlimentos();
            } else if (b == 2) {
                seleccionAlimentos();
            }
        } while (!Salir());
    }

    public static void menu1() {
        System.out.println("**********************************************************");
        System.out.println("*                     SafeStomach                        *");
        System.out.println("**********************************************************");
        System.out.println("Por favor, seleccione una de las opcíones");
        System.out.println("[1] Ver comida Vegana");
// Cambiar para ver comidas o salir
    }

    public static void seleccionAlimentos() {
        int o;
        do {
            menu2();
            o = intInput(1, 8);
            switch (o) {
                case 1:
                    mostrarlista(arrLista(0));
                    break;
                case 2:
                    mostrarlista(arrLista(1));
                    break;
                case 3:
                    mostrarlista(arrLista(2));
                    break;
                case 4:
                    mostrarlista(arrLista(3));
                    break;
                case 5:
                    mostrarlista(arrLista(4));
                    break;
                case 6:
                    mostrarlista(arrLista(5));
                    break;
                case 7:
                    mostrarlista(arrLista(6));
                    break;
            }
        } while (o != 8);
    }

    public static void menu2() {
        System.out.println("Que tipo de comida esta buscando?");
        System.out.println("[1] Leche y derivados");
        System.out.println("[2] Carnes Vegetales");
        System.out.println("[3] Aceites y grasas");
        System.out.println("[4] Snacks");
        System.out.println("[5] Bebestibles");
        System.out.println("[6] Pan");
        System.out.println("[7] cereales y pastas");
        System.out.println("[8] Volver");
        System.out.println("Ingrese una respuesta");
    }

    public static void mostrarlista(String[] d) {
        System.out.print("Categoria: ");
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
            if (i == 0) System.out.println("");
        }
        System.out.println("");
    }

    public static String[] arrLista(int n) {
        String[] columna = leerArchivo("datos.csv").split("\n");
        return columna[n].split(";");

    }

    public static String leerArchivo(String ruta) {
        File f = new File(ruta);
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return contenido;
    }

    public static boolean Salir() {
        System.out.println("Desea Salir?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        int opcion = intInput(1, 2);
        if (opcion == 1) {
            return true;
        } else return false;
    }

    public static int intInput(int bot, int top) {
        Scanner intro = new Scanner(System.in);
        return err(intro.next(), bot, top);
    }

    public static int err(String input, int bot, int top) {
        Scanner intro = new Scanner(System.in);
        int in = 0;
        try {
            in = validInt(Integer.parseInt(input), bot, top);
        } catch (Exception ex) {
            System.out.println("Favor ingresar Dígitos y no carácteres");
            in = err(intro.next(), top, bot);
        }
        return in;
    }

    public static int validInt(int in, int bot, int top) {
        if (in < bot || in > top) {
            System.out.println("Favor ingresar un número entre " + bot + " y " + top);
            in = intInput(bot, top);
        }
        return in;
    }

}

