/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ivz.cps.classes;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author emu479p01 : CPS
 */
public class IVZ_ValidateDriver {

    public static void main(String[] _args) {
        boolean flag = true;
        String msg = "No Error";

        try {
            validate("../xml/productionPerformance - Ex.xml", "../xsd/B2MML-V0600-ProductionPerformance.xsd");
        } catch (SAXException e) {
            flag = false;
            msg = "SAXException Type";
        } catch (IOException e) {
            flag = false;
            msg = "IOException Type";
        }
        
        System.out.println("xml file is valid : " + flag + " Error type : " + msg);
    }

    public static void validate(String _xmlFile, String _validationFile) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        ((schemaFactory.newSchema(new File(_validationFile)))
                .newValidator()).validate(new StreamSource(new File(_xmlFile)));
    }
}
