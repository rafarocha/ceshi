package br.edu.curso.faq.builders;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.natpryce.makeiteasy.Maker;

import example.fruit.Apple;
import example.fruit.makeiteasy.FruitMakers;

@SuppressWarnings("unchecked")
public class MakeItEasyBuilderTest {
    
	private Maker<Apple> appleWith2Leaves = an(FruitMakers.Apple, with(2, FruitMakers.leaves));
	private Maker<Apple> ripeApple = appleWith2Leaves.but(with(FruitMakers.ripeness, 1.2));
	private Maker<Apple> unripeApple = appleWith2Leaves.but(with(FruitMakers.ripeness, 0.125));
	
	@Test public void testandoMakeItEasyWithApples() {
		Apple apple1 = make( ripeApple );
		Apple apple2 = make( unripeApple );
		Apple apple3 = make( appleWith2Leaves );
		
		assertThat( apple3.numberOfLeaves(), equalTo(2) );
		assertFalse( apple2.isRipe() );
		assertTrue( apple1.isRipe() );
	}
	
}