package br.edu.curso.junit.exemplo.theory;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class DataPointCombinationsTest {

	@DataPoints public static int[] xs = new int[] { 1, 2 };	
	@DataPoints public static int[] ys = new int[] { 3, 4 };

	@Theory public void meta(int x, int y) {
		System.out.printf("(x, y) : (%s, %s)\n", x, y);
	}

}