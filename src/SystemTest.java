import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class SystemTest
{

    public static void main(String[] args)
    {
        String entirePath = System.getProperty("java.library.path");
        StringTokenizer stringTokenizer = new StringTokenizer(entirePath, ";");
        while (stringTokenizer.hasMoreTokens())
        {

            System.out.println(stringTokenizer.nextToken());
        }

        Properties systemProperties = System.getProperties();
        // System.out.println(systemProperties);

        systemProperties.put("rizwan.test", "test");
        System.setProperties(null);

        systemProperties = System.getProperties();
        for (Object property : systemProperties.keySet())
        {
            System.out.println(property + " : " + systemProperties.get(property));
        }
        List<? super Number> myObjs = new ArrayList<Object>();

        List<String> circuitList = new ArrayList<String>();
        circuitList.add("W0X10964-1955569");
        circuitList.add("W0X10964-1955549");
        StringBuffer circuitListJson = new StringBuffer("\"circuitList\":[");
        for (String circuit : circuitList)
        {
            String[] data = circuit.split("-");
            circuitListJson.append("{").append("\"circuitId\":\"").append(data[0]).append("\",\"pvcId\":\"")
                    .append(data[1]).append("\"}").append(",");
        }
        circuitListJson = new StringBuffer(circuitListJson.substring(0, circuitListJson.length() - 1));
        circuitListJson.append("]");
        
        System.out.println(circuitListJson);

    }
}
