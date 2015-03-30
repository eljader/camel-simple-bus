package ru.cinimex.export.ws;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.language.bean.BeanLanguage;
import org.apache.camel.model.dataformat.JaxbDataFormat;

import ru.cinimex.bus.OutputTransform1;

public class SPBusServiceRoutes extends RouteBuilder {
	
    public void configure() throws Exception {        	
    	JaxbDataFormat jaxb = new JaxbDataFormat();   
    	jaxb.setPrettyPrint(true);
        jaxb.setContextPath("ru.cinimex.bus");
        
        OutputTransform1 output = new OutputTransform1();
      
  
        from("cxf:bean:SPBusService")
        	.to("xslt:xslt/transform1.xsl")
        //	.to("xslt:xslt/transform1_response.xsl")
        //	.transform(constant(BeanLanguage.bean(beanType, method))
	    ;
    }
}
