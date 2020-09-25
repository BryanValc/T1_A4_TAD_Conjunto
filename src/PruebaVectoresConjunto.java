import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.text.html.HTMLDocument.Iterator;

interface Validacion{
	Scanner input = new Scanner(System.in);
	public static int validacionNatural() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida, intente de nuevo:");
				input.nextLine();
				err=true;
			}
			if (ret>0) {
				err=false;
			}else {
				System.out.println("solo números naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
}

class Conjunto implements Validacion {
	private ArrayList<Integer> elementos;

	public Conjunto(ArrayList<Integer> elementos) {
		super();
		this.elementos = elementos;
	}
	public Conjunto() {
	}

	public ArrayList getElementos() {
		return elementos;
	}
	public void setElementos(ArrayList elementos) {
		this.elementos = elementos;
	}
	
	public ArrayList<Integer> llenarLista(){
		System.out.println("cantidad de elementos: ");
		int cnt = Validacion.validacionNatural();
		int elementos[] = {};
		for (int i = 0; i < cnt; i++) {
			System.out.println("elemento "+(i+1)+": ");
			elementos=Arrays.copyOf(elementos, elementos.length+1);
			elementos[elementos.length-1]=Validacion.validacionNatural();
		}
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i: elementos) {
            arr.add(i);
        }
		return arr;
	}
	public ArrayList<Integer> llenarLista(int elementos[]){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i: elementos) {
            arr.add(i);
        }
		return arr;
	}
	public void mostrarElementos() {
		System.out.println(this.getElementos());
	}
	public <T> ArrayList<T> eliminarDuplicados(ArrayList<T> elementos) {
		Set<T> set = new LinkedHashSet<>();   
        set.addAll(elementos); 
        elementos.clear(); 
        elementos.addAll(set);
        return elementos;
	}
	
	public Conjunto union(Conjunto cj1, Conjunto cj2) {
		ArrayList elementos1 = cj1.getElementos();
		ArrayList elementos2 = cj2.getElementos();
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(elementos1);
		arr.addAll(elementos2);
		
		Collections.sort(arr);
		arr = this.eliminarDuplicados(arr);
		
		Conjunto union = new Conjunto(arr);
		return union;
	}
	public Conjunto interseccion(Conjunto cj1, Conjunto cj2) {
		ArrayList elementos1 = cj1.getElementos();
		ArrayList elementos2 = cj2.getElementos();
		
		Collections.sort(elementos1);
		elementos1=this.eliminarDuplicados(elementos1);
		Collections.sort(elementos2);
		elementos2=this.eliminarDuplicados(elementos2);
		
		ArrayList<Integer> arr = new ArrayList<>();
	
		for (int i = 0; i < elementos1.size(); i++) {
			for (int j = 0; j < elementos2.size(); j++) {
				if (elementos1.get(i).equals(elementos2.get(j))) {
					arr.add((Integer) elementos1.get(i));
					break;
				}
			}
		}
	
		Conjunto ret = new Conjunto(arr);
		
		return ret;
	}
	public Conjunto diferencia(Conjunto cj1, Conjunto cj2) {
		ArrayList elementos1 = cj1.getElementos();
		ArrayList elementos2 = cj2.getElementos();
		
		Collections.sort(elementos1);
		elementos1=this.eliminarDuplicados(elementos1);
		Collections.sort(elementos2);
		elementos2=this.eliminarDuplicados(elementos2);
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(elementos1);
		arr.removeAll(elementos2);
		
		Conjunto diferencia = new Conjunto(arr);
		
		return diferencia;
	}
}

public class PruebaVectoresConjunto {

	public static void main(String[] args) {
		
		Conjunto cj0 = new Conjunto();

		ArrayList<Integer> x = new ArrayList<>();//conjunto A
		int cc=0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (i%j==0) {
					cc+=1;
				}
			}
			if (cc==2) {
				x.add(i);
			}
			cc=0;
		}
		Conjunto cja = new Conjunto(x);
		System.out.println("Conjunto A: ");
		cja.mostrarElementos();
		
		ArrayList<Integer> y = new ArrayList<>();//conjunto B
		int z = 350;
		for (int i = 1; i <= z; i++) {
			if (z%i==0) {
				y.add(i);
			}
		}
		Conjunto cjb = new Conjunto(y);
		System.out.println("Conjunto B: ");
		cjb.mostrarElementos();
		System.out.println("union AB:");
		cj0 = cj0.union(cja, cjb);
		cj0.mostrarElementos();
		System.out.println("Intersección AB: ");
		cj0 = cj0.interseccion(cja, cjb);
		cj0.mostrarElementos();
		System.out.println("Diferencia AB: ");
		cj0 = cj0.diferencia(cja, cjb);
		cj0.mostrarElementos();
		System.out.println("Diferencia BA: ");
		cj0 = cj0.diferencia(cjb, cja);
		cj0.mostrarElementos();
		System.out.println("==========MENU==========");
		byte opc = 0;
		
		do {
			System.out.println("1)Llenar lista 1"
					+ "\n 2)Llenar lista 2"
					+ "\n 3)Mostrar elementos lista 1"
					+ "\n 4)Mostrar elementos lista 2"
					+ "\n 5)Mostrar union de las listas"
					+ "\n 6)Mostrar interseccion de las listas"
					+ "\n 7)Mostrar diferencia lista 1 - lista 2"
					+ "\n 8)Mostrar diferencia lista 2 - lista 1"
					+ "\n 9)Salir");
			opc=(byte) Validacion.validacionNatural();
			
			switch (opc) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				System.out.println("entrada no válida");
				break;
			}
			
		} while (opc!=8);
		System.out.println("fin de la ejecución");
		
		
	}

}
