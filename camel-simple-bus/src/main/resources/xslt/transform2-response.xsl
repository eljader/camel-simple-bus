<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:bus="http://bus.cinimex.ru">		 
	
	<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
	
	<xsl:template match="/">
      	<bus:outputTransform2>		
			<xsl:copy-of select="." />
		</bus:outputTransform2>
	</xsl:template>
</xsl:stylesheet>
