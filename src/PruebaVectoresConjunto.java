import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

class Conjunto {
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
		
		int[] elementos1 = {1, 3, 2, 4, 6, 5, 7, 0};
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i: elementos1) {
            arr1.add(i);
        }
        Conjunto cj1 = new Conjunto(arr1);
        
        int[] elementos2 = {1, 9, 8, 5, 7, 4, 3, 7};
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i: elementos2) {
            arr2.add(i);
        }
        Conjunto cj2 = new Conjunto(arr2);
        
        Conjunto cj3 = cj0.union(cj1, cj2);
        cj3.mostrarElementos();
        
        
	}

}
