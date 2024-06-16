
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Producto1> lista = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static Producto1 aggprod;
    static Producto1 elimineit;
    static Producto1 buscar;
    static Producto1 modificar;
    static boolean prooff = true;
    static double precio;
    static double costo;

    public static void Validar() {
        do {

            precio = input.nextDouble();

            costo = input.nextDouble();
            input.nextLine();
            if (precio <= costo) {
                System.out.println("El precio debe ser mayor que el costo. Intente de nuevo.");
            }
            if (precio < 0 || costo < 0) {
                System.out.println("El precio y el costo deben ser positivos. Intente de nuevo.");
            }
        } while (precio <= costo || precio < 0 || costo < 0);
    }

    public static void Mostrar() {

        if (lista.isEmpty()) {
            System.out
                    .println("No hay productos en el catálogo. Por favor, agregue productos.");
        } else {
            System.out.println("Estos son los productos disponibles: ");
            for (int i = 0; i < lista.size(); i++) {
                aggprod = lista.get(i);
                System.out.println("\n- Producto numero " + (i + 1));
                System.out.println("- Código: " + aggprod.codProducto);
                System.out.println("- Nombre: " + aggprod.nombre);
                System.out.println("- Precio: " + aggprod.precio + " $");
                System.out.println("- Costo: " + aggprod.getCosto() + " $");
                System.out.println("- Descripción: " + aggprod.descrip);
            }
        }

    }

    public static void Modificar() {
        System.out.println("Esta seguro de modificar el producto? (Si/No)");
        String segurisimo = input.nextLine().toLowerCase();
        char safe2 = segurisimo.charAt(0);
        switch (safe2) {
            case 's':
                if (lista.isEmpty()) {
                    System.out.println("No hay productos para modificar");

                } else {
                    System.out.println("ingresa el codigo del producto que deseas modificar: ");
                    String modi = input.nextLine();
                    boolean mod = false;

                    for (int i = 0; i < lista.size(); i++) {
                        modificar = lista.get(i);
                        if (lista.get(i).codProducto.contains(modi)) {
                            mod = true;
                            Mostrar();
                            System.out.println("\nInserte los nuevos cambios: ");
                            System.out.println("Ingrese el nuevo codigo, nombre,  precio, costo y descripción: ");
                            String newcode = input.nextLine();
                            String newNombre = input.nextLine();
                            Validar();
                            String newDescrip = input.nextLine();
                            modificar.codProducto = newcode;
                            modificar.nombre = newNombre;
                            modificar.precio = precio;
                            modificar.setCosto(costo);
                            modificar.descrip = newDescrip;
                            System.out.println("El producto ha sido modificado de manera eficiente. ");
                            break;

                        }
                        if (mod) {
                            System.out.println("el producto no existe o el codigo esta mal escrito. ");

                        }

                    }

                }
                break;
            case 'n':
                System.out.println("Volviendo al menu...");
                break;
            default:
                break;
        }

    }

    public static void Buscar() {
        System.out.println(
                "Presiona 1 si deseas buscar el producto, presiona 2 si deseas salir de este apartado y volver al menu: ");
        int presiona = input.nextInt();
        input.nextLine();
        switch (presiona) {
            case 1:
                if (lista.size() == 0) {
                    System.out.println("No hay productos para buscar");

                } else {
                    System.out.println("\tVamos a buscar su producto, inserte el codigo. ");
                    String bus = input.nextLine();
                    boolean confir = false;
                    for (int i = 0; i < lista.size(); i++) {
                        buscar = lista.get(i);

                        if (lista.get(i).codProducto.equals(bus)) {
                            confir = true;
                            Mostrar();
                            break;

                        }
                        if (!confir) {
                            System.out.println(
                                    "\nEl codigo del producto no es el correcto o el producto no existe. ");

                        }
                    }

                }

                break;
            case 2:
                System.out.println("Regreso al menu...");
                break;

            default:
                break;
        }
    }

    public static void Borrar() {
        if (lista.size() == 0) {
            System.out.println("No hay productos para Eliminar.");
        } else {
            System.out.println("¿Está seguro de borrar el producto? (si/no)");
            String seguro = input.nextLine().toLowerCase();
            char safe = seguro.charAt(0);
            switch (safe) {
                case 's':
                    System.out.println("\tIngrese el codigo del producto: ");
                    String codex = input.nextLine();
                    for (int i = 0; i < lista.size(); i++) {
                        elimineit = lista.get(i);

                        if (lista.get(i).codProducto == (codex)) {
                            lista.remove(i);
                            System.out.println("El producto fue eliminado de manera eficiente. ");
                        } else {
                            System.out.println("No se encontro el producto");

                        }

                    }

                    break;
                case 'n':
                    System.out.println("El producto no se eliminara. ");

                default:
                    break;
            }
        }
    }

    public static void Agregar() {
        System.out
                .println("\nInserte los siguientes datos: código, nombre, precio, costo y descripción");
        String codigoPro = input.nextLine();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).codProducto.equals(codigoPro)) {
                System.out.println("\tEl codigo ya existe. ");
                return;
            } else {
                System.out.println();
            }

        }

        String nombrePro = input.nextLine();
        Validar();

        String descrip = input.nextLine();
        aggprod = new Producto1(codigoPro, nombrePro, precio, costo, descrip);
        lista.add(aggprod);
        System.out.println("\n¡Producto agregado exitosamente!");

    }

    public static void menu() {
        boolean proof = true;

        try {
            do {
                System.out.println("\nMenu de productos. ");
                System.out.println("Escoja la opción más adecuada para usted: ");
                System.out.println("\t0. Salir del menú ");
                System.out.println("\t1. Agregar producto ");
                System.out.println("\t2. Eliminar producto ");
                System.out.println("\t3. Buscar producto ");
                System.out.println("\t4. Modificar producto ");
                System.out.println("\t5. Mostrar catálogo ");
                int inser = input.nextInt();
                input.nextLine();
                switch (inser) {
                    case 0:
                        System.out.println("Has salido del menú. Buen viaje crack!!!");
                        proof = false;
                        break;
                    case 1:
                        Agregar();
                        break;
                    case 2:
                        Borrar();
                        break;
                    case 3:
                        Buscar();

                        break;
                    case 4:
                        Modificar();
                        break;

                    case 5:
                        Mostrar();
                        break;
                    default:
                        System.out.println("No existe esa opción.");
                        break;
                }
            } while (proof);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        menu();

    }
}