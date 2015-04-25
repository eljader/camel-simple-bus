package ru.cinimex.export.ws;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import ru.cinimex.csb.model.Transformresult;

public class SPBusServiceRoutes extends RouteBuilder {
	
    public void configure() throws Exception {        	

        from("cxf:bean:SPBusService")
         	.to("xslt:xslt/transform1.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
         	.multicast()
         	   .parallelProcessing()
         	   .to("log:disply")		       
		       .process(new Processor() {
					public void process(Exchange exchange) {
						Message in = exchange.getIn();
						Transformresult result = new Transformresult();
						result.setPayload(in.getBody(String.class));
						in.setBody(result);			    
					}
			    })
			    .to("jpa:ru.cinimex.csb.model.Transformresult")
		    .end()
         	.to("log:disply")
         	.to("file:/home/jader/workspace/apache-camel/camel-simple-bus/target/runtime-files?fileName=transform1&fileExist=Append")
         	.to("xslt:xslt/transform1-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        ;
    }
}
