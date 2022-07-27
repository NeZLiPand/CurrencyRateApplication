package ua.open.api.andry.inkin.currencyrate.controller.utility;

import org.json.JSONArray;
import org.json.XML;

public final class MyUtilities {

    private MyUtilities() {
        throw new IllegalStateException("Utility class");
    }

    public static String dateConverterFromUNIXTimeToISO8601(long dateInMilliseconds) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(dateInMilliseconds));
    }

    // переписати реалізацію методів нижче з використанням "JSONML"
    public static String convertJSONArrayToXMLArray(String jsonData) {
        return XML.toString(new JSONArray(jsonData));
    }

    public static JSONArray convertXMLArraytoJSONArray(String xmlData) {
        return new JSONArray(XML.toJSONObject(xmlData));
    }

}
