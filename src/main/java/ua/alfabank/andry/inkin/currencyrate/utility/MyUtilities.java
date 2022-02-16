package ua.alfabank.andry.inkin.currencyrate.utility;

import org.json.JSONArray;
import org.json.XML;

public final class MyUtilities {

    public static String dateFormatting(int dateInSeconds) {
        return "";
    }

    public static String convertJSONArraytoXMLArray(String jsonData) {
        return new String(XML.toString(new JSONArray(jsonData)));
    }

    public static String convertXMLArraytoJSONArray(String xmlData) {
        return new String(new JSONArray(XML.toJSONObject(xmlData)).toString());
    }

}

//List<MinorCurrenciesRate> minorCurrenciesRateList = new LinkedList<>();
//List<MainCurrenciesRate> mainCurrenciesRateList = new LinkedList<>();
//MainCurrenciesRate mainCurrenciesRate = new MainCurrenciesRate();
//MinorCurrenciesRate minorCurrenciesRate = new MinorCurrenciesRate();
//for (int iterator = 0; iterator < jsonArray.length(); iterator++) {
//if ((jsonArray.getJSONObject(iterator)
//            .names()
//            .length()) == mainCurrenciesRate.getColumnCount()) {
//  mainCurrenciesRateList.add(MainCurrenciesRate.builder()
//                                               .withDate(jsonArray.getJSONObject(iterator)
//                                                                  .getString("Date"))
//                                               .withCurrencyCodeA(jsonArray.getJSONObject(iterator)
//                                                                           .getString("currencyCodeA"))
//                                               .withCurrencyCodeB(jsonArray.getJSONObject(iterator)
//                                                                           .getString("currencyCodeB"))
//                                               .withRateBuy(jsonArray.getJSONObject(iterator)
//                                                                     .getString("rateBuy"))
//                                               .withRateSell(jsonArray.getJSONObject(iterator)
//                                                                      .getString("rateSell"))
//                                               .build());
//} else if ((jsonArray.getJSONObject(iterator)
//                   .names()
//                   .length()) == minorCurrenciesRate.getColumnCount()) {
//  minorCurrenciesRateList.add(MinorCurrenciesRate.builder()
//                                                 .withDate(jsonArray.getJSONObject(iterator)
//                                                                    .getString("Date"))
//                                                 .withCurrencyCodeA(jsonArray.getJSONObject(iterator)
//                                                                             .getString("currencyCodeA"))
//                                                 .withCurrencyCodeB(jsonArray.getJSONObject(iterator)
//                                                                             .getString("currencyCodeB"))
//                                                 .withRateCross(jsonArray.getJSONObject(iterator)
//                                                                         .getString("rateCross"))
//                                                 .build());
//}
//
//}
