package ru.cinimex.export.ws;

import org.apache.camel.builder.RouteBuilder;

public class SPBusServiceRoutes extends RouteBuilder {
	
    public void configure() throws Exception {        	
      	
        from("cxf:bean:SPBusService")
         	.to("xslt:xslt/transform1.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
         	.to("log:disply")
         	.to("xslt:xslt/transform1-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        ;
    }
}
