package com.rocha.curso.ceshi.refactoring.generictype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access=AccessLevel.PACKAGE)
public class Order {
	
	public long number;
	public double total;
	public People client;

}