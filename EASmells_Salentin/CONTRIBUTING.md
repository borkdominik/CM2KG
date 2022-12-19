# Using JAXB:
1. Bind the schema for the XML document: \
``xjc -p de.example.model -encoding UTF-8 archimate3_Diagram.xsd`` \
If needed compile with \
``javac example/model/*.java``
2. Unmarshal the document into Java content objects.
The Java content objects represent the content and organization of the XML document, and are directly available to your program. \
``unmarshal(String xmlFile, Class<T> c, String xsdSchema)``
3. Modify the content tree with ``ObjectFactory``
4. Marshal the content tree into an XML-File (can be the same as before) \
``marshal(Object jaxbElement, String xmlFile, String xsdSchema)`` \
Can be necessary to add ``@XmlRootElement(name = "model")`` to ``ModelType`` for proper marshalling according to previous XML.

The marshalling and unmarshalling functionality is provided in the ``de.example.modelAdapter`` package.
Currently the bound classes for the model are located in the ``de.example.model`` package.