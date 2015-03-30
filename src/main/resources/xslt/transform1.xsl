<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:typ="http://bus.cinimex.ru/type2">
	<xsl:template match="/">
		
		<typ:interestList>
			<interest>
				<xsl:attribute name="userCount">0</xsl:attribute>
				<user>
					<xsl:attribute name="name">Test</xsl:attribute>
					<xsl:attribute name="age">13</xsl:attribute>
					<xsl:attribute name="messagesCount">5</xsl:attribute>
				</user>				
			</interest>
		</typ:interestList>
	</xsl:template>
</xsl:stylesheet>