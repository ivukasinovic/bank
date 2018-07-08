@XmlSchema( 
		   namespace = "http://poslovna.com/soap-example",
		   elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
		   xmlns = {@javax.xml.bind.annotation.XmlNs(prefix = "all", namespaceURI="http://poslovna.com/soap-example"),
        			@javax.xml.bind.annotation.XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")}
          )
package com.project.modelXml;

import javax.xml.bind.annotation.XmlSchema;

