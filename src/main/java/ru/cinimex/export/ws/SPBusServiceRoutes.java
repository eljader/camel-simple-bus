package ru.cinimex.export.ws;

import org.apache.camel.builder.RouteBuilder;

import ru.cinimex.bus.OutputTransform1;
import ru.cinimex.bus.type2.InterestList;

public class SPBusServiceRoutes extends RouteBuilder {
	
    public void configure() throws Exception {        	
    	OutputTransform1 result = new OutputTransform1();   	
    	result.setInterestList(new InterestList());
    	
    	// endpoint to our CXF webservice
    	String cxfEndpoint = "cxf://http://localhost:8080/camel-simple-bus/webservices/SPBusService"
    	        + "?serviceClass=org.apache.camel.example.reportincident.ReportIncidentEndpoint"
    	        + "&wsdlURL=ru/cinimex/bus/wsdl/report_incident.wsdl";
    	    	
    	from(cxfEndpoint)
    		.to("log:input")
	        .transform(constant(result));
    }
}
