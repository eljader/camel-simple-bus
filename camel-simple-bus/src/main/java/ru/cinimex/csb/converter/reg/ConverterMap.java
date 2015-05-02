package ru.cinimex.csb.converter.reg;

public class ConverterMap <F, T> {
	
	private Class<F> from;
	private Class<T> to;
	
	public ConverterMap(Class<F> from, Class<T> to) {
		this.from = from;
		this.to = to;
	}

	public Class<F> getFrom() {
		return from;
	}

	public Class<T> getTo() {
		return to;
	}
}
