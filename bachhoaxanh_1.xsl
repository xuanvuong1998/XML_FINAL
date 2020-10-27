<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : bachhoaxanh.xsl
    Created on : October 27, 2020, 10:13 AM
    Author     : chien
    Description:
        First step transform bachhoaxanh product
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>
    
    <xsl:template match="/">
        <product>
            <xsl:apply-templates select="*"/>
        </product>
    </xsl:template>
        
    <xsl:template match="//h1[@class='nameproduct']">
        <name>
            <xsl:value-of select="text()"/>
        </name>
    </xsl:template>

    <xsl:template match="//div[@class='boxprice']">
        <price>
            <xsl:value-of select="text()"/>
        </price>
    </xsl:template>
    
    <xsl:template match="//div[@class='details']">
        <attributes>
            <xsl:apply-templates select="*"/>
        </attributes>
    </xsl:template>
    
    <xsl:template match="//ul[contains(@class, 'infoproduct')]/li">
        <attribute>
            <name>
                <xsl:value-of select="span/text()"/>
            </name>
            <value>
                <xsl:value-of select="div/text()"/>
            </value>
        </attribute>
    </xsl:template>
    
    <xsl:template match="text()"/>
</xsl:stylesheet>
