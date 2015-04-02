<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:bus="http://bus.cinimex.ru"
>

	<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
	
	<xsl:template match="bus:inputTransform1/userList/user/interestList">		
	  <interestList>
	    <xsl:for-each-group select="interest" group-by="@name"> 
	      <interest>
		  <xsl:attribute name="name"><xsl:value-of select="interest/name"/></xsl:attribute>
		  <xsl:attribute name="userCount">1</xsl:attribute>
		      <user>
		         <xsl:attribute name="name"><xsl:value-of select="../../name"/></xsl:attribute>
		         <xsl:attribute name="age"><xsl:value-of select="../../age"/></xsl:attribute>
                 <xsl:attribute name="messagesCount"><xsl:value-of select="../../user/messagesCount"/></xsl:attribute>
		      </user>				
	       </interest>			
	    </xsl:for-each-group>
	  </interestList>
	</xsl:template>
</xsl:stylesheet>