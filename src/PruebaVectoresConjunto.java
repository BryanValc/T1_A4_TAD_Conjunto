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
	public void mostrarElementos() {
		System.out.println(this.getElementos());
	}
	public Conjunto union(Conjunto cj1, Conjunto cj2) {
		
		ArrayList elementos1 = cj1.getElementos();
		ArrayList elementos2 = cj2.getElementos();
		elementos2.addAll(elementos1);
		
		Collections.sort(elementos2);
		elementos2 = this.eliminarDuplicados(elementos2);
		
		Conjunto union = new Conjunto(elementos2);
		return union;
	}
	public <T> ArrayList<T> eliminarDuplicados(ArrayList<T> elementos) {
		Set<T> set = new LinkedHashSet<>();   
        set.addAll(elementos); 
        elementos.clear(); 
        elementos.addAll(set);
        return elementos;
	}

}


public class PruebaVectoresConjunto {

	public static void main(String[] args) {
		
		Conjunto cj0 = new Conjunto();
		/*
		int[] elementos1 = {1, 3, 2, 4, 6, 5, 7, 0};
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i: elementos1) {
            arr1.add(i);
        }*/
        Conjunto cj1 = new Conjunto(cj0.llenarLista());
        
        /*
        int[] elementos2 = {1, 9, 8, 5, 7, 4, 3, 7};
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i: elementos2) {
            arr2.add(i);
        }*/
        
        Conjunto cj2 = new Conjunto(cj0.llenarLista());
        
        Conjunto cj3 = cj0.union(cj1, cj2);
        cj3.mostrarElementos();
	}

}
