<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:bus="http://bus.cinimex.ru"
>
	<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
		
	<xsl:template match="interestList">
		<userList>
		    <xsl:for-each-group select="*/userList/user" group-by="@name">		    	 
				<xsl:element name="user"> 							 													
					<xsl:attribute name="age"><xsl:value-of select="@age"/></xsl:attribute>
					<xsl:attribute name="messagesCount">
						<xsl:value-of select="sum(//user[@name = current-grouping-key()]/@messagesCount)"/>
					</xsl:attribute>
					<xsl:element name="name"><xsl:value-of select="@name"/></xsl:element>					
					
					<xsl:for-each-group select="current-group()/../../../*" group-by="name(.)">
						<xsl:sort select="sum(current-group()/userList/user/@messagesCount)" order="ascending"/>
									
						<xsl:choose>
							<xsl:when test="position() = last()">
								<xsl:element name="{name(.)}">
									<xsl:attribute name="messagesCount">
										<xsl:value-of select="sum(current-group()/userList/user/@messagesCount)"/>
									</xsl:attribute>									
								</xsl:element>				
							</xsl:when>
						</xsl:choose>				
					</xsl:for-each-group>
				</xsl:element>												
		    </xsl:for-each-group>
	    </userList>
	</xsl:template>
</xsl:stylesheet>