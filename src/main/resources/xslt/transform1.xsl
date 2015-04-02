<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:bus="http://bus.cinimex.ru"
	xmlns:typ1="http://bus.cinimex.ru/type1"
	xmlns:typ2="http://bus.cinimex.ru/type2"
>
	<xsl:output omit-xml-declaration="yes" indent="yes"/>

	<xsl:template match="/">		
	  <typ2:interestList>
	    <xsl:for-each select="bus:inputTransform1/typ1:user/interestList">
	      <interest>
		  <xsl:attribute name="name"><xsl:value-of select="interest/name"/></xsl:attribute>
		  <xsl:attribute name="userCount">1</xsl:attribute>
		      <user>
		         <xsl:attribute name="name"><xsl:value-of select="../../../user/name"/></xsl:attribute>
		         <xsl:attribute name="age"><xsl:value-of select="../user/age"/></xsl:attribute>
                 <xsl:attribute name="messagesCount"><xsl:value-of select="../user/messagesCount"/></xsl:attribute>
		      </user>				
	       </interest>			
	     </xsl:for-each>
	  </typ2:interestList>
	</xsl:template>
</xsl:stylesheet>