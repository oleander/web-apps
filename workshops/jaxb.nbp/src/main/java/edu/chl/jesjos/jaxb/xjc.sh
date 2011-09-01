#!/bin/bash

# Create classes from XML-schema
# po.xsd is the XML schema

# To be run in project dir po.xsd is the XML schema
# Probalby need to tweek last 2 argument (packet where it will end up)
xjc src/main/resources/po.xsd -d src/main/java  -p edu.chl.hajo.jaxb.po

exit 0
