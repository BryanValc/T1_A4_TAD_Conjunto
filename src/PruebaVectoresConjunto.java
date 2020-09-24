import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

class Conjunto {
	private ArrayList<int[]> elementos;

	public Conjunto(ArrayList<int[]> elementos) {
		super();
		this.elementos = elementos;
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
		Collections.sort(elementos1);
		elementos1 = this.eliminarDuplicados(elementos1);
		System.out.println(elementos1);
		
		ArrayList elementos2 = cj2.getElementos();
		Collections.sort(elementos2);	
		elementos2= this.eliminarDuplicados(elementos2);
		System.out.println(elementos2);
		
		return null;
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
		
		int[] elementos = {1, 3, 2, 4, 6, 5, 7, 0, 9, 8, 5, 7, 4, 3, 6, 7};
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i: elementos) {
            arr.add(i);
        }
        
        System.out.println(arr);
        System.out.println(arr.size());
        System.out.println(elementos.length);
	}

}
