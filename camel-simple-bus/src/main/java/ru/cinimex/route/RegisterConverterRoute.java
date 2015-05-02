package ru.cinimex.route;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.TypeConverterSupport;

import ru.cinimex.csb.converter.reg.ConverterMap;
import ru.cinimex.csb.converter.reg.RegisterConverter;

abstract class RegisterConverterRoute extends RouteBuilder {
	
	protected List<RegisterConverter> converters;
	
	public void setConverters(List<RegisterConverter> converters) {
		this.converters = converters;
	}
	
	public void configure() throws Exception {
		register();
		this.__configure();
	}
	
	private void register() { 	
		for(RegisterConverter converter: converters)	
	    	for(ConverterMap<?, ?> map: converter.getTypes())	
	    		this.getContext().getTypeConverterRegistry().addTypeConverter(
	    			map.getTo(), 
					map.getFrom(), 
					(TypeConverterSupport) converter
				)
		;
    }
	
	public abstract void __configure() throws Exception;
}
