/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mecanica;

/**
 *
 * @author BRYAN TACURI, INGRID PARDO, CARLOS GUAMAN
 */
public class Taller_MecanicaFinal {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.ArrayList<Trabajo> trabajos = new java.util.ArrayList<>();
        int nextId = 0;
        final String SECRET = "RESET123";
        while (true) {
            System.out.println("--- Taller Mecánica - Menú ---");
            System.out.println("1) Registrar trabajo");
            System.out.println("2) Aumentar horas");
            System.out.println("3) Aumentar coste de piezas (por trabajo)");
            System.out.println("4) Finalizar trabajo");
            System.out.println("5) Mostrar trabajo (por id)");
            System.out.println("6) Consultar plazo (por id)");
            System.out.println("7) Mostrar todos");
            System.out.println("8) Reset condicional (clave secreta)");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            String opt = sc.nextLine().trim();
            if (opt.equals("0")) break;
            switch (opt) {
                case "1": // registrar
                    System.out.print("Tipo (1-ReparacionMecanica,2-ChapaPintura,3-Revision,4-Trabajo): ");
                    String tipo = sc.nextLine().trim();
                    int id = nextId++;
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    int horas = 0;
                    if (tipo.equals("1")) {
                        trabajos.add(new Reparacion_Mecanica(new java.util.ArrayList<>(), "Pendiente", "", id, desc, horas, 0));
                        System.out.println("Reparacion mecanica registrada con plazo por defecto (14 días).");
                    } else if (tipo.equals("2")) {
                        trabajos.add(new Chapa_Pintura(new java.util.ArrayList<>(), "Pendiente", "", id, desc, horas, 0));
                        System.out.println("Chapa y pintura registrada con plazo por defecto (21 días).");
                    } else if (tipo.equals("3")) {
                        trabajos.add(new Revision(id, desc, horas, 0));
                        System.out.println("Revision registrada con plazo por defecto (7 días).");
                    } else {
                        trabajos.add(new Trabajo(id, desc, horas, 0));
                        System.out.println("Trabajo genérico registrado.");
                    }
                    System.out.println("id de trabajo asignado: " + id);
                    break;
                case "2": // aumentar horas
                    System.out.print("idTrabajo a aumentar horas: ");
                    int id2 = Integer.parseInt(sc.nextLine().trim());
                    Trabajo t2 = buscarPorId(trabajos, id2);
                    if (t2 == null) { System.out.println("Trabajo no encontrado."); break; }
                    if (t2.isFinalizado()) { System.out.println("El trabajo ya está finalizado, no se pueden actualizar horas."); break; }
                    System.out.print("Cantidad de horas a sumar: ");
                    int sum = Integer.parseInt(sc.nextLine().trim());
                    t2.setHoras(t2.getHoras() + sum);
                    System.out.println("Horas actualizadas.");
                    break;
                case "3": // aumentar coste de piezas
                    System.out.print("idTrabajo para aumentar coste: ");
                    int id3 = Integer.parseInt(sc.nextLine().trim());
                    Trabajo t3 = buscarPorId(trabajos, id3);
                    if (t3 == null) { System.out.println("Trabajo no encontrado."); break; }
                    System.out.print("Aumento en porcentaje (ej 10 para 10%): ");
                    double pct = Double.parseDouble(sc.nextLine().trim());
                    if (t3 instanceof Reparacion_Mecanica) {
                        Reparacion_Mecanica rm = (Reparacion_Mecanica) t3;
                        try {
                            java.lang.reflect.Field f = Reparacion_Mecanica.class.getDeclaredField("piezas");
                            f.setAccessible(true);
                            java.util.ArrayList pies = (java.util.ArrayList) f.get(rm);
                            for (Object o : pies) {
                                if (o instanceof Pieza_Mecanica) {
                                    Pieza_Mecanica p = (Pieza_Mecanica) o;
                                    p.setPrecio(p.getPrecio() * (1 + pct/100.0));
                                }
                            }
                            System.out.println("Coste de piezas actualizado.");
                        } catch (Exception e) {
                            System.out.println("No se pudo actualizar piezas: " + e.getMessage());
                        }
                    } else if (t3 instanceof Chapa_Pintura) {
                        Chapa_Pintura cp = (Chapa_Pintura) t3;
                        try {
                            java.lang.reflect.Field f = Chapa_Pintura.class.getDeclaredField("pinturas");
                            f.setAccessible(true);
                            java.util.ArrayList pits = (java.util.ArrayList) f.get(cp);
                            for (Object o : pits) {
                                if (o instanceof Pintura) {
                                    Pintura p = (Pintura) o;
                                    p.setPrecio(p.getPrecio() * (1 + pct/100.0));
                                }
                            }
                            System.out.println("Coste de pinturas actualizado.");
                        } catch (Exception e) {
                            System.out.println("No se pudo actualizar pinturas: " + e.getMessage());
                        }
                    } else {
                        System.out.println("El trabajo no contiene piezas ni pinturas.");
                    }
                    break;
                case "4": // finalizar trabajo
                    System.out.print("idTrabajo a finalizar: ");
                    int id4 = Integer.parseInt(sc.nextLine().trim());
                    Trabajo t4 = buscarPorId(trabajos, id4);
                    if (t4 == null) { System.out.println("Trabajo no encontrado."); break; }
                    t4.finalizar();
                    if (t4 instanceof Reparaciones) ((Reparaciones) t4).setEstado("Finalizado");
                    System.out.println("Trabajo finalizado.");
                    break;
                case "5": // mostrar trabajo
                    System.out.print("idTrabajo a mostrar: ");
                    int id5 = Integer.parseInt(sc.nextLine().trim());
                    Trabajo t5 = buscarPorId(trabajos, id5);
                    if (t5 == null) { System.out.println("Trabajo no encontrado."); break; }
                    mostrarDetalle(t5);
                    break;
                case "6": // consultar plazo
                    System.out.print("idTrabajo a consultar plazo: ");
                    int id6 = Integer.parseInt(sc.nextLine().trim());
                    Trabajo t6 = buscarPorId(trabajos, id6);
                    if (t6 == null) { System.out.println("Trabajo no encontrado."); break; }
                    System.out.println("Plazo: " + t6.getPlazo() + " días");
                    break;
                case "7": // mostrar todos
                    for (Trabajo tr : trabajos) {
                        System.out.println("id=" + tr.getIdTrabajo() + " | tipo=" + tr.getClass().getSimpleName() + " | hrs=" + tr.getHoras() + " | plazo=" + tr.getPlazo() + " | finalizado=" + tr.isFinalizado());
                    }
                    break;
                case "8": // reset condicional
                    System.out.print("Ingresa clave secreta: ");
                    String clave = sc.nextLine().trim();
                    if (SECRET.equals(clave)) {
                        for (Trabajo tr : trabajos) {
                            if (!tr.isFinalizado()) tr.setHoras(0);
                        }
                        System.out.println("Reset aplicado: horas a 0 en trabajos no finalizados.");
                    } else {
                        System.out.println("Clave incorrecta.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static Trabajo buscarPorId(java.util.List<Trabajo> lista, int id) {
        for (Trabajo t : lista) if (t.getIdTrabajo() == id) return t;
        return null;
    }

    private static void mostrarDetalle(Trabajo t) {
        System.out.println("--- Detalle trabajo ---");
        System.out.println("id: " + t.getIdTrabajo());
        System.out.println("descripcion: " + t.getDescripcion());
        System.out.println("horas: " + t.getHoras());
        System.out.println("plazo: " + t.getPlazo());
        System.out.println("tipo: " + t.getClass().getSimpleName());
        System.out.println("finalizado: " + t.isFinalizado());
        if (t instanceof Reparacion_Mecanica) {
            try {
                java.lang.reflect.Field f = Reparacion_Mecanica.class.getDeclaredField("piezas");
                f.setAccessible(true);
                java.util.List pies = (java.util.List) f.get((Reparacion_Mecanica) t);
                System.out.println("Piezas: " + pies.size());
                for (Object o : pies) if (o instanceof Pieza_Mecanica) {
                    Pieza_Mecanica p = (Pieza_Mecanica) o;
                    System.out.println(" - " + p.getNombre() + ": " + p.getPrecio());
                }
            } catch (Exception e) { }
        } else if (t instanceof Chapa_Pintura) {
            try {
                java.lang.reflect.Field f = Chapa_Pintura.class.getDeclaredField("pinturas");
                f.setAccessible(true);
                java.util.List pits = (java.util.List) f.get((Chapa_Pintura) t);
                System.out.println("Pinturas: " + pits.size());
                for (Object o : pits) if (o instanceof Pintura) {
                    Pintura p = (Pintura) o;
                    System.out.println(" - " + p.getNombre() + ": " + p.getPrecio());
                }
            } catch (Exception e) { }
        }
    }
}
