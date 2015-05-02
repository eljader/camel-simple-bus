package ru.cinimex.route;

public class SPBusServiceRoutes extends RegisterConverterRoute {
		
	public void __configure() throws Exception { 		
        from("cxf:bean:SPBusService")
        	.to("xslt:xslt/transform1.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
            .multicast()
                .parallelProcessing()
            	.to("jpa:ru.cinimex.csb.model.Transformresult")    	
		    .end()
         	.to("file:/home/jader/workspace/apache-camel/camel-simple-bus/target/runtime-files?fileName=transform1&fileExist=Append")
         	.to("xslt:xslt/transform1-response.xsl?transformerFactoryClass=net.sf.saxon.TransformerFactoryImpl")
        ;       
    }
}
