package ua.alfabank.andry.inkin.currencyrate.utility;

import org.json.JSONArray;
import org.json.XML;

public class JSONtoXMLandXMLtoJSONConverter {
    
    public static String convertJSONArraytoXMLArray(String jsonData) {
        return new String(XML.toString(new JSONArray(jsonData)));
    }
    
//    public static String convertXMLArraytoJSONArray(String xmlData) {
//        return new String(new JSONArray(XML.toJSONObject(xmlData)).toString());
//    }
}
