package ru.cinimex.csb.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class SPBusServiceRoutes extends RouteBuilder {
		
	public void configure() throws Exception {
		
        from("cxf:bean:SPBusService")
        	.choice()
        		.when(header(CxfConstants.OPERATION_NAME).isEqualTo("Transform1")).to("direct:transform1")
        		.when(header(CxfConstants.OPERATION_NAME).isEqualTo("Transform2")).to("direct:transform2")
        	.end()
        ;
        
        from("direct:transform1")
        	.to("xslt:xslt/transform1.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        	.to("direct:jpa-file")
        	.to("xslt:xslt/transform1-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        ;
        
        from("direct:transform2")
	    	.to("xslt:xslt/transform2.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
	    	.to("direct:jpa-file")
	    	.to("xslt:xslt/transform2-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
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
