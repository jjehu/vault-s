package db;

import java.util.Scanner;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class Principal {
	public static void main(String[] args) {
        /*
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "database.bd4o");
        
        try {
        	Docentes doc1 = new Docentes("111","Jose","Miranda","Arce",1); 
			Docentes doc2 = new Docentes("222","Raul","Mercado","Peralta",1);
			
			Materias mat1 = new Materias("DIS111","Taller 1",6,1);
			Materias mat2 = new Materias("DIS221","Base Datos 1",6,1);
			Materias mat3 = new Materias("DIS421","Redes 2",5,1);
			Materias mat4 = new Materias("DIS521","Programacion",6,1);
			
			Dicta di1 = new Dicta(2000,doc1,mat1);
			Dicta di2 = new Dicta(2001,doc1,mat2);
			Dicta di3 = new Dicta(2002,doc1,mat3);
			Dicta di4 = new Dicta(2000,doc2,mat2);
			Dicta di5 = new Dicta(2001,doc2,mat3);
			Dicta di6 = new Dicta(2000,doc2,mat1);
			
			db.store(di1);
			db.store(di2);
			db.store(di3);
			db.store(di4);
			db.store(di5);
			db.store(di6);
            System.out.println("Datos almacenados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        */
        
		Scanner io = new Scanner(System.in);
		int opcion;
		ObjectContainer db = null;
		
		
		try {
			do {
				System.out.println("\n--- Menu ---");
				System.out.println("1. Buscar por Cedula");
				System.out.println("2. Buscar por Sigla");
				System.out.println("3. Buscar por Gestion");
				System.out.println("4. Salir");
				System.out.print("Seleccione una opción: ");
				opcion = io.nextInt();
				io.nextLine();

				switch (opcion) {
				case 1:
					buscarCedula(io);
					break;
				case 2:
					buscarSigla(io);
					break;
				case 3:
					buscarGestion(io);
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
				}
			} while (opcion != 4);
		} catch (Exception e) {
			System.out.println("error!!!");
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static void buscarCedula(Scanner io) {
        System.out.print("Ingrese la cedula: ");
        String ced = io.nextLine();
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "database.bd4o");
        
        try {
            ObjectSet<Docentes> resultado = db.query(new Predicate<Docentes>() {
                @Override
                public boolean match(Docentes obj) {
                    return obj.getCedula().equalsIgnoreCase(ced);
                }
            });
            
            if (resultado.hasNext()) {
            	Docentes docente = resultado.next();
                ObjectSet<Dicta> dicta = db.query(new Predicate<Dicta>() {
                    @Override
                    public boolean match(Dicta obj) {
                        return obj.getDoc().equals(docente);
                    }
                });
                imprimir(dicta);
                
            } else {
                System.out.println("No se encontró datos con la cedula: " + ced);
            }
        } finally {
            db.close();
        }
    }

	public static void buscarSigla(Scanner io) {
        System.out.print("Ingrese la sigla: ");
        String sig = io.nextLine();
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "database.bd4o");
        
        try {
            ObjectSet<Materias> resultado = db.query(new Predicate<Materias>() {
                @Override
                public boolean match(Materias obj) {
                    return obj.getSigla().equalsIgnoreCase(sig);
                }
            });

            if (resultado.hasNext()) {
            	Materias materia = resultado.next();
                ObjectSet<Dicta> dicta = db.query(new Predicate<Dicta>() {
                    @Override
                    public boolean match(Dicta obj) {
                        return obj.getMat().equals(materia);
                    }
                });
                imprimir(dicta);
                
            } else {
                System.out.println("No se encontró datos con la sigla: " + sig);
            }
        } finally {
            db.close();
        }
    }
	
	public static void buscarGestion(Scanner io) {
        System.out.print("Ingrese la gestión: ");
        int ges = io.nextInt();
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "database.bd4o");
        
        try {
            ObjectSet<Dicta> resultado = db.query(new Predicate<Dicta>() {
                @Override
                public boolean match(Dicta obj) {
                    return obj.getGestion()==ges;
                }
            });

            if (resultado.hasNext()) {
                imprimir(resultado);
                
            } else {
                System.out.println("No se encontró datos con la gestión: " + ges);
            }
        } finally {
            db.close();
        }
    }
	
	public static void imprimir(ObjectSet<Dicta> resultado) {
        System.out.println("Datos encontrados:");
        while (resultado.hasNext()) { 
            Dicta dicta = resultado.next();
            System.out.println("LISTA DE DOCENTE");
            System.out.println(dicta.getDoc());
            System.out.println("LISTA DE MATERIAS");
            System.out.println(dicta.getMat());
            System.out.println("LISTA DE DICTA");
            System.out.println(dicta);
            System.out.println();
        }
    }
}
