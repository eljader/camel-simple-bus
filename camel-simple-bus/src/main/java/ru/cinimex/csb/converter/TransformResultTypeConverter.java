package ru.cinimex.csb.converter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.Converter;

import ru.cinimex.csb.model.Transformresult;

@Converter
public class TransformResultTypeConverter {

	@Converter
	public static Transformresult toTransformresult(String value) throws IOException {
    	Transformresult result = new Transformresult();
		result.setPayload(value.toString());
		return result;
	}
	
	@Converter
	public static String convertToString(Transformresult value) throws IOException {
		return value.getPayload();
	}
	
	@Converter
	public static InputStream toInputStream(Transformresult value) throws IOException {
		return new ByteArrayInputStream(value.getPayload().getBytes());
	}
}