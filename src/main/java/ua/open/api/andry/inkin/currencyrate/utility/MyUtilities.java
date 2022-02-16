package ua.open.api.andry.inkin.currencyrate.utility;

import org.json.JSONArray;
import org.json.XML;

public final class MyUtilities {

    private MyUtilities() {
        throw new IllegalStateException("Utility class");
    }

    public static String dateConverterFromUNIXTimeToISO8601(long dateInSeconds) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(dateInSeconds * 1000));
    }

    public static String convertJSONArrayToXMLArray(String jsonData) {
        return new String(XML.toString(new JSONArray(jsonData)));
    }

    public static String convertXMLArraytoJSONArray(String xmlData) {
        return new String(new JSONArray(XML.toJSONObject(xmlData)).toString());
    }

}
