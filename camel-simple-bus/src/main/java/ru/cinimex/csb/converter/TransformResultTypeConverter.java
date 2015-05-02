package ru.cinimex.csb.converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.TypeConversionException;
import org.apache.camel.support.TypeConverterSupport;

import ru.cinimex.csb.converter.reg.ConverterMap;
import ru.cinimex.csb.converter.reg.RegisterConverter;
import ru.cinimex.csb.model.Transformresult;

public class TransformResultTypeConverter extends TypeConverterSupport implements RegisterConverter {

	public List<ConverterMap<?,?>> getTypes() {
		List<ConverterMap<?,?>> list = new ArrayList<ConverterMap<?,?>>();
		
		list.add(new ConverterMap<String, Transformresult>(String.class, Transformresult.class));
		list.add(new ConverterMap<Transformresult, String>(Transformresult.class, String.class));
		list.add(new ConverterMap<Transformresult, InputStream>(Transformresult.class, InputStream.class));
		
		return list;
	}
	
	public <T> T convertTo(Class<T> type, Exchange exchange, Object value)
			throws TypeConversionException {
		
		T result = null;
		
		if(type.equals(Transformresult.class)) {	
			result = toTransformResult(value);
		}
		
		if(type.equals(String.class)) {	
			result = toString((Transformresult)value);
		}
		
		if(type.equals(InputStream.class)) {	
			result = toInputStream((Transformresult)value);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T toTransformResult(Object value) {
    	Transformresult result = new Transformresult();
		result.setPayload(value.toString());
		
		return (T) result;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T toString(Transformresult value) {	
		return (T) value.getPayload();
	}
	
	@SuppressWarnings("unchecked")
	private <T> T toInputStream(Transformresult value) {	
		return (T) new ByteArrayInputStream(value.getPayload().getBytes());
	}
}