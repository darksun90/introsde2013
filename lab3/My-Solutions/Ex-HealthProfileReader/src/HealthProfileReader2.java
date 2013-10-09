import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HealthProfileReader2 {

	public static void main(String[] args)  throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

	    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse("HPR.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("/people/person/healthprofile/weitgh/text()");
		XPathExpression expr2 = xpath.compile("/people/person/healthprofile/height/text()");

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
		Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
		NodeList nodes2 = (NodeList) result2;
	    for (int i = 0; i < nodes.getLength() && i < nodes2.getLength() ; i++) {
				System.out.println("person n"+i+": weight:"+nodes.item(i).getNodeValue()+", height:"+nodes2.item(i).getNodeValue());
			}	

	}
}
