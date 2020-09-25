import java.util.ArrayList;
import java.util.Arrays;
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
		
		ArrayList<Integer> elementos3 = new ArrayList<>();
		elementos3.addAll(elementos1);
		elementos3.addAll(elementos2);
		
		Collections.sort(elementos3);
		elementos3 = this.eliminarDuplicados(elementos3);
		
		Conjunto union = new Conjunto(elementos3);
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
		return null;
	}
}

public class PruebaVectoresConjunto {

	public static void main(String[] args) {
		
		Conjunto cj0 = new Conjunto();

		int elementos1[]= {1,2,3,4};
		int elementos2[]= {2,3,4,5};
		
        Conjunto cj1 = new Conjunto(cj0.llenarLista(elementos1));
        Conjunto cj2 = new Conjunto(cj0.llenarLista(elementos2));
        
        cj0 = cj0.union(cj1, cj2);
        cj0.mostrarElementos();
        cj0 = cj0.interseccion(cj1, cj2);
        cj0.mostrarElementos();
        
	}

}
