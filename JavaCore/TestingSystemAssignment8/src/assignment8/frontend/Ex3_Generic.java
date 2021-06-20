package assignment8.frontend;

import java.util.ArrayList;
import java.util.List;

import assignment8.entity.GStudent;

public class Ex3_Generic {

	public static <E> void main(String[] args) {
		GStudent<Integer> s1 = new GStudent<Integer>(1, "Nam");
		GStudent<Float> s2 = new GStudent<Float>(1f, "Giang");
		GStudent<Double> s3 = new GStudent<Double>(1d, "Phuong");
		
		gPrint("Toi dang o dau");
		gPrint(19024705183012L);
		gPrint(Math.PI);
		
		List<E> a1 = new ArrayList<E>();
	}
	
	static <T> void gPrint(T input) {
		System.out.println(input);
	}
}
