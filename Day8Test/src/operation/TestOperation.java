package operation;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import mathformulas.operation.ArithmaticFunctions;

public class TestOperation
{
    public static void main(String[] args) {
        ArithmaticFunctions a=new ArithmaticFunctions();
        System.out.println(a.add(23,43));
    }

}
