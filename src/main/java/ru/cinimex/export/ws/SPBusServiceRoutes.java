package ru.cinimex.export.ws;

import org.apache.camel.builder.RouteBuilder;

import ru.cinimex.bus.OutputTransform1;
import ru.cinimex.bus.type2.InterestList;

public class SPBusServiceRoutes extends RouteBuilder {
	
    public void configure() throws Exception {        	
    	OutputTransform1 result = new OutputTransform1();   	
    	result.setInterestList(new InterestList());
    	
        from("cxf:bean:SPBusService")
    		.to("log:input")
	        .transform(constant(result));
    }
}
