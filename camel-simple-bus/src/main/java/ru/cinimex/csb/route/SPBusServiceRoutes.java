package ru.cinimex.csb.route;

import org.apache.camel.builder.RouteBuilder;

public class SPBusServiceRoutes extends RouteBuilder {
		
	public void configure() throws Exception {
		
        from("cxf:bean:SPBusService")
        	.to("xslt:xslt/transform1.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        	.to("direct:jpa-file")
        	.to("xslt:xslt/transform1-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        ;
        
        from("direct:jpa-file")
		    .multicast()
		        .parallelProcessing()
		    	.to("jpa:ru.cinimex.csb.model.Transformresult")    	
		    .end()
		 	.to("file:/home/jader/workspace/apache-camel/camel-simple-bus/target/runtime-files?fileName=transform1&fileExist=Append")
		;
    }
}
