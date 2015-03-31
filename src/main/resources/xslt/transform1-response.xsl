<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://bus.cinimex.ru">		 
	
	<xsl:template match="/">
		<soapenv:Envelope>
	    	<soapenv:Header/>
	    	<soapenv:Body>
		      	<bus:outputTransform1>		
					<xsl:copy-of select="." />
				</bus:outputTransform1>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
</xsl:stylesheet>
