<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:bus="http://bus.cinimex.ru"
>

	<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
	<xsl:variable name="userCount" />		
		
	<xsl:template match="userList">
		<userList>
		    <xsl:for-each-group select="user" group-by="name">		    	 
					<xsl:choose>
						<xsl:when test="sum(current-group()/messagesCount) > 5">
							<xsl:element name="user"> 							 													
								<xsl:attribute name="age"><xsl:value-of select="current-group()/age"/></xsl:attribute>
								<xsl:attribute name="messagesCount"><xsl:value-of select="current-group()/messagesCount"/></xsl:attribute>
								<xsl:element name="name"><xsl:value-of select="current-group()/name"/></xsl:element>					
								
								<xsl:for-each-group select="current-group()/interestList/interest" group-by="name">
									<xsl:sort select="messagesCount" order="ascending"/>
									
									<xsl:choose>
										<xsl:when test="position() = last()">
											<xsl:element name="{name}">
												<xsl:attribute name="messagesCount">
													<xsl:value-of select="messagesCount"/>
												</xsl:attribute>									
											</xsl:element>				
										</xsl:when>
									</xsl:choose>																
								</xsl:for-each-group>
							</xsl:element>										
						</xsl:when>
					</xsl:choose>		
		    </xsl:for-each-group>
	    </userList>
	</xsl:template>
</xsl:stylesheet>