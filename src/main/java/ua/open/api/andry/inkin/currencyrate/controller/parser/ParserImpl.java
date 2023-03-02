package ua.open.api.andry.inkin.currencyrate.controller.parser;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ua.open.api.andry.inkin.currencyrate.controller.utility.MyUtilities;

//Зробити нормальну документацію к методам
public class ParserImpl implements Parser {

    @Override
    public Elements parseMonobankCurrenciesRates() throws IOException {
//        А це бойовий код
        return Jsoup.parse(MyUtilities.convertJSONArrayToXMLArray(Jsoup.connect("https://api.monobank.ua/bank/currency")
                                                                       .timeout(30000)
                                                                       .ignoreContentType(true)
                                                                       .get()
                                                                       .body()
                                                                       .text()))
                    .body()
                    .children();
//      
//        Нижче код, який:  
//        Тимчасовий код, парсинг вже зібраних з відкритого АРІ даних, тому що, є обмеження кількості запитів - 1 запит за 5 хвилин.
//        
//        String Page = "[{\"currencyCodeA\":840,\"currencyCodeB\":980,\"date\":1649106607,\"rateBuy\":29.255,\"rateSell\":29.9904},{\"currencyCodeA\":978,\"currencyCodeB\":980,\"date\":1649176207,\"rateBuy\":32.08,\"rateSell\":32.9804},{\"currencyCodeA\":978,\"currencyCodeB\":840,\"date\":1649176207,\"rateBuy\":1.087,\"rateSell\":1.107},{\"currencyCodeA\":826,\"currencyCodeB\":980,\"date\":1649181136,\"rateCross\":39.405},{\"currencyCodeA\":392,\"currencyCodeB\":980,\"date\":1649180904,\"rateCross\":0.2452},{\"currencyCodeA\":756,\"currencyCodeB\":980,\"date\":1649181150,\"rateCross\":32.4285},{\"currencyCodeA\":156,\"currencyCodeB\":980,\"date\":1649177064,\"rateCross\":4.7213},{\"currencyCodeA\":784,\"currencyCodeB\":980,\"date\":1649181053,\"rateCross\":8.1634},{\"currencyCodeA\":971,\"currencyCodeB\":980,\"date\":1621225573,\"rateCross\":0.3583},{\"currencyCodeA\":8,\"currencyCodeB\":980,\"date\":1649181093,\"rateCross\":0.2724},{\"currencyCodeA\":51,\"currencyCodeB\":980,\"date\":1649180775,\"rateCross\":0.0621},{\"currencyCodeA\":973,\"currencyCodeB\":980,\"date\":1649149550,\"rateCross\":0.0682},{\"currencyCodeA\":32,\"currencyCodeB\":980,\"date\":1649180560,\"rateCross\":0.2695},{\"currencyCodeA\":36,\"currencyCodeB\":980,\"date\":1649179494,\"rateCross\":22.6702},{\"currencyCodeA\":944,\"currencyCodeB\":980,\"date\":1649180858,\"rateCross\":17.7267},{\"currencyCodeA\":50,\"currencyCodeB\":980,\"date\":1649179933,\"rateCross\":0.3483},{\"currencyCodeA\":975,\"currencyCodeB\":980,\"date\":1649181127,\"rateCross\":16.8967},{\"currencyCodeA\":48,\"currencyCodeB\":980,\"date\":1649157879,\"rateCross\":79.7444},{\"currencyCodeA\":108,\"currencyCodeB\":980,\"date\":1538606522,\"rateCross\":0.0158},{\"currencyCodeA\":96,\"currencyCodeB\":980,\"date\":1648120007,\"rateCross\":22.118},{\"currencyCodeA\":68,\"currencyCodeB\":980,\"date\":1649169538,\"rateCross\":4.371},{\"currencyCodeA\":986,\"currencyCodeB\":980,\"date\":1649181127,\"rateCross\":6.5154},{\"currencyCodeA\":72,\"currencyCodeB\":980,\"date\":1645253796,\"rateCross\":2.4885},{\"currencyCodeA\":933,\"currencyCodeB\":980,\"date\":1649180847,\"rateCross\":9.0648},{\"currencyCodeA\":124,\"currencyCodeB\":980,\"date\":1649181155,\"rateCross\":24.0608},{\"currencyCodeA\":976,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0149},{\"currencyCodeA\":152,\"currencyCodeB\":980,\"date\":1649145353,\"rateCross\":0.0386},{\"currencyCodeA\":170,\"currencyCodeB\":980,\"date\":1649180607,\"rateCross\":0.0079},{\"currencyCodeA\":188,\"currencyCodeB\":980,\"date\":1649178628,\"rateCross\":0.0454},{\"currencyCodeA\":192,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":1.219},{\"currencyCodeA\":203,\"currencyCodeB\":980,\"date\":1649181169,\"rateCross\":1.3634},{\"currencyCodeA\":262,\"currencyCodeB\":980,\"date\":1649157021,\"rateCross\":0.1689},{\"currencyCodeA\":208,\"currencyCodeB\":980,\"date\":1649181131,\"rateCross\":4.4566},{\"currencyCodeA\":12,\"currencyCodeB\":980,\"date\":1649115207,\"rateCross\":0.2097},{\"currencyCodeA\":818,\"currencyCodeB\":980,\"date\":1649180937,\"rateCross\":1.6495},{\"currencyCodeA\":230,\"currencyCodeB\":980,\"date\":1648828046,\"rateCross\":0.5848},{\"currencyCodeA\":981,\"currencyCodeB\":980,\"date\":1649181147,\"rateCross\":9.7858},{\"currencyCodeA\":936,\"currencyCodeB\":980,\"date\":1649166066,\"rateCross\":4.1085},{\"currencyCodeA\":270,\"currencyCodeB\":980,\"date\":1648854852,\"rateCross\":0.6169},{\"currencyCodeA\":324,\"currencyCodeB\":980,\"date\":1647016129,\"rateCross\":0.0034},{\"currencyCodeA\":344,\"currencyCodeB\":980,\"date\":1649161572,\"rateCross\":3.8296},{\"currencyCodeA\":191,\"currencyCodeB\":980,\"date\":1649181145,\"rateCross\":4.3693},{\"currencyCodeA\":348,\"currencyCodeB\":980,\"date\":1649181169,\"rateCross\":0.0903},{\"currencyCodeA\":360,\"currencyCodeB\":980,\"date\":1649179739,\"rateCross\":0.002},{\"currencyCodeA\":376,\"currencyCodeB\":980,\"date\":1649181161,\"rateCross\":9.3768},{\"currencyCodeA\":356,\"currencyCodeB\":980,\"date\":1649179754,\"rateCross\":0.398},{\"currencyCodeA\":368,\"currencyCodeB\":980,\"date\":1649071924,\"rateCross\":0.0205},{\"currencyCodeA\":364,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0007},{\"currencyCodeA\":352,\"currencyCodeB\":980,\"date\":1649175240,\"rateCross\":0.2334},{\"currencyCodeA\":400,\"currencyCodeB\":980,\"date\":1649180643,\"rateCross\":42.359},{\"currencyCodeA\":404,\"currencyCodeB\":980,\"date\":1649174542,\"rateCross\":0.2608},{\"currencyCodeA\":417,\"currencyCodeB\":980,\"date\":1649172535,\"rateCross\":0.3678},{\"currencyCodeA\":116,\"currencyCodeB\":980,\"date\":1631541924,\"rateCross\":0.0065},{\"currencyCodeA\":408,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":13.2977},{\"currencyCodeA\":410,\"currencyCodeB\":980,\"date\":1649171410,\"rateCross\":0.0247},{\"currencyCodeA\":414,\"currencyCodeB\":980,\"date\":1649175556,\"rateCross\":98.6379},{\"currencyCodeA\":398,\"currencyCodeB\":980,\"date\":1649179937,\"rateCross\":0.0641},{\"currencyCodeA\":418,\"currencyCodeB\":980,\"date\":1648120275,\"rateCross\":0.0025},{\"currencyCodeA\":422,\"currencyCodeB\":980,\"date\":1649091010,\"rateCross\":0.0013},{\"currencyCodeA\":144,\"currencyCodeB\":980,\"date\":1649180456,\"rateCross\":0.1011},{\"currencyCodeA\":434,\"currencyCodeB\":980,\"date\":1648958626,\"rateCross\":6.4735},{\"currencyCodeA\":504,\"currencyCodeB\":980,\"date\":1649178941,\"rateCross\":3.0829},{\"currencyCodeA\":498,\"currencyCodeB\":980,\"date\":1649181130,\"rateCross\":1.6428},{\"currencyCodeA\":969,\"currencyCodeB\":980,\"date\":1645190362,\"rateCross\":0.0071},{\"currencyCodeA\":807,\"currencyCodeB\":980,\"date\":1649180929,\"rateCross\":0.535},{\"currencyCodeA\":496,\"currencyCodeB\":980,\"date\":1644660467,\"rateCross\":0.0098},{\"currencyCodeA\":478,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0808},{\"currencyCodeA\":480,\"currencyCodeB\":980,\"date\":1649169270,\"rateCross\":0.6741},{\"currencyCodeA\":454,\"currencyCodeB\":980,\"date\":1633949773,\"rateCross\":0.0325},{\"currencyCodeA\":484,\"currencyCodeB\":980,\"date\":1649180858,\"rateCross\":1.5199},{\"currencyCodeA\":458,\"currencyCodeB\":980,\"date\":1649176421,\"rateCross\":7.1234},{\"currencyCodeA\":943,\"currencyCodeB\":980,\"date\":1648737313,\"rateCross\":0.4741},{\"currencyCodeA\":516,\"currencyCodeB\":980,\"date\":1649135578,\"rateCross\":2.0597},{\"currencyCodeA\":566,\"currencyCodeB\":980,\"date\":1649169891,\"rateCross\":0.0722},{\"currencyCodeA\":558,\"currencyCodeB\":980,\"date\":1649096999,\"rateCross\":0.8442},{\"currencyCodeA\":578,\"currencyCodeB\":980,\"date\":1649181161,\"rateCross\":3.4682},{\"currencyCodeA\":524,\"currencyCodeB\":980,\"date\":1649086978,\"rateCross\":0.2469},{\"currencyCodeA\":554,\"currencyCodeB\":980,\"date\":1649155717,\"rateCross\":20.9092},{\"currencyCodeA\":512,\"currencyCodeB\":980,\"date\":1649176229,\"rateCross\":77.9566},{\"currencyCodeA\":604,\"currencyCodeB\":980,\"date\":1649180809,\"rateCross\":8.2763},{\"currencyCodeA\":608,\"currencyCodeB\":980,\"date\":1649174381,\"rateCross\":0.585},{\"currencyCodeA\":586,\"currencyCodeB\":980,\"date\":1649180209,\"rateCross\":0.1636},{\"currencyCodeA\":985,\"currencyCodeB\":980,\"date\":1649181170,\"rateCross\":7.1669},{\"currencyCodeA\":600,\"currencyCodeB\":980,\"date\":1649060321,\"rateCross\":0.0043},{\"currencyCodeA\":634,\"currencyCodeB\":980,\"date\":1649180253,\"rateCross\":8.2346},{\"currencyCodeA\":946,\"currencyCodeB\":980,\"date\":1649181168,\"rateCross\":6.7107},{\"currencyCodeA\":941,\"currencyCodeB\":980,\"date\":1649180938,\"rateCross\":0.2803},{\"currencyCodeA\":682,\"currencyCodeB\":980,\"date\":1649179696,\"rateCross\":7.9934},{\"currencyCodeA\":690,\"currencyCodeB\":980,\"date\":1649165493,\"rateCross\":2.1207},{\"currencyCodeA\":938,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0657},{\"currencyCodeA\":752,\"currencyCodeB\":980,\"date\":1649181148,\"rateCross\":3.209},{\"currencyCodeA\":702,\"currencyCodeB\":980,\"date\":1649177701,\"rateCross\":22.1186},{\"currencyCodeA\":694,\"currencyCodeB\":980,\"date\":1642766851,\"rateCross\":0.0025},{\"currencyCodeA\":706,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0509},{\"currencyCodeA\":968,\"currencyCodeB\":980,\"date\":1591303043,\"rateCross\":3.5865},{\"currencyCodeA\":760,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0116},{\"currencyCodeA\":748,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":2.0097},{\"currencyCodeA\":764,\"currencyCodeB\":980,\"date\":1649180653,\"rateCross\":0.8975},{\"currencyCodeA\":972,\"currencyCodeB\":980,\"date\":1649178741,\"rateCross\":2.3992},{\"currencyCodeA\":795,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0017},{\"currencyCodeA\":788,\"currencyCodeB\":980,\"date\":1649176110,\"rateCross\":10.2053},{\"currencyCodeA\":949,\"currencyCodeB\":980,\"date\":1649181169,\"rateCross\":2.0584},{\"currencyCodeA\":901,\"currencyCodeB\":980,\"date\":1649156066,\"rateCross\":1.0476},{\"currencyCodeA\":834,\"currencyCodeB\":980,\"date\":1649172998,\"rateCross\":0.0131},{\"currencyCodeA\":800,\"currencyCodeB\":980,\"date\":1649151331,\"rateCross\":0.0084},{\"currencyCodeA\":858,\"currencyCodeB\":980,\"date\":1649169482,\"rateCross\":0.7247},{\"currencyCodeA\":860,\"currencyCodeB\":980,\"date\":1649179971,\"rateCross\":0.0026},{\"currencyCodeA\":937,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":6.6466},{\"currencyCodeA\":704,\"currencyCodeB\":980,\"date\":1649181106,\"rateCross\":0.0013},{\"currencyCodeA\":950,\"currencyCodeB\":980,\"date\":1649159646,\"rateCross\":0.0505},{\"currencyCodeA\":952,\"currencyCodeB\":980,\"date\":1649149168,\"rateCross\":0.0505},{\"currencyCodeA\":886,\"currencyCodeB\":980,\"date\":1543715495,\"rateCross\":0.112},{\"currencyCodeA\":710,\"currencyCodeB\":980,\"date\":1649180637,\"rateCross\":2.0597},{\"currencyCodeA\":894,\"currencyCodeB\":980,\"date\":1649106607,\"rateCross\":0.0017}]";
//        return Jsoup.parse(MyUtilities.convertJSONArrayToXMLArray(Page))
//                    .body()
//                    .children();
    }

    @Override
    public Elements parseMinfinCurrenciesCodes() throws IOException {
        String requestedLetterCode = "";
        String requestedNumericalCode = "";
        int iteratorCodesParsed = 0;
        Document tablePage = null;

        tablePage = Jsoup.parse(new URL("https://index.minfin.com.ua/ua/reference/currency/code/"), 30000);

        Document currencyCodesParsed = new Document("");
        Elements currencyCodesTable = tablePage.select("tbody")
                                               .first()
                                               .children();
        Elements elementTable = new Elements();
        for (int iterator = 0; iterator < currencyCodesTable.size(); iterator++) {
            elementTable = currencyCodesTable.get(iterator)
                                             .children();
            if (!elementTable.select("td[class*=mono larger][align=center]")
                             .text()
                             .isEmpty()) {
                requestedLetterCode = elementTable.select("td[class*=mono larger][align=center]")
                                                  .text();
                if ((elementTable.select("td[class=r0][align=center]")
                                 .text()).isEmpty()) {
                    requestedNumericalCode = elementTable.select("td[class=r1][align=center]")
                                                         .first()
                                                         .text();
                } else {
                    requestedNumericalCode = elementTable.select("td[class=r0][align=center]")
                                                         .first()
                                                         .text();
                }
                currencyCodesParsed.appendElement("currencyCode");
                currencyCodesParsed.child(iteratorCodesParsed)
                                   .appendElement("letters")
                                   .appendText(requestedLetterCode);
                currencyCodesParsed.child(iteratorCodesParsed++)
                                   .appendElement("Code")
                                   .appendText(requestedNumericalCode);
            }
        }
        return Jsoup.parse(currencyCodesParsed.toString())
                    .body()
                    .children();
    }

}
