<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:bus="http://bus.cinimex.ru"
>

	<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
	<xsl:variable name="userCount" />		
		
	<xsl:template match="userList">
		<interestList>
		    <xsl:for-each-group select="user/interestList/*" group-by="name(.)"> 
				<interest>
					<xsl:choose>
						<xsl:when test="sum(current-group()/messagesCount) > 3">
										
							<xsl:attribute name="name"><xsl:value-of select="name(.)"/></xsl:attribute>							
													
							<xsl:for-each-group select="current-group()/../../../user[interestList/*/name() = current-grouping-key()]" group-by="name">
								<xsl:choose>
									<xsl:when test="position() = last()">
										<xsl:attribute name="userCount">
											<xsl:value-of select="last()"/>
										</xsl:attribute>
									</xsl:when>
								</xsl:choose>																
							</xsl:for-each-group>
																																	
							<userList>							
								<xsl:for-each-group select="current-group()/../../../user[interestList/*/name() = current-grouping-key()]" group-by="name">
									<user>
										<xsl:attribute name="name"><xsl:value-of select="current-group()/name"/></xsl:attribute>
										<xsl:attribute name="age"><xsl:value-of select="current-group()/age"/></xsl:attribute>
										<xsl:attribute name="messagesCount"><xsl:value-of select="current-group()/messagesCount"/></xsl:attribute>
									</user>						
								</xsl:for-each-group>
							</userList>	
							
						</xsl:when>
					</xsl:choose>		
				</interest>			
		    </xsl:for-each-group>
	    </interestList>
	</xsl:template>
</xsl:stylesheet>