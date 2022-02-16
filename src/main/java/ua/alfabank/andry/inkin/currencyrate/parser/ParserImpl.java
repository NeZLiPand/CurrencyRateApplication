package ua.alfabank.andry.inkin.currencyrate.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

import ua.alfabank.andry.inkin.currencyrate.domain.MainCurrenciesRate;
import ua.alfabank.andry.inkin.currencyrate.domain.MinorCurrenciesRate;

public class ParserImpl implements Parser {

    private String pageReading(String url) throws IOException {
        URL bankCurrencyRates = new URL(url);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bankCurrencyRates.openStream()));
        String sketchCurrencyRates = bufferedReader.readLine();
        bufferedReader.close();
        return sketchCurrencyRates;
    }

    private void writeToFile(String record,
                             String nameFile) {
        try {
            FileWriter myWriter = new FileWriter(nameFile
                                                 + ".txt");
            myWriter.write(record);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createFile(String name) throws IOException {
        return new File(name
                        + ".txt");
    }

    private void deleteFile(File name) throws IOException {
        name.delete();
    }
    
    @Override
    public void parse(String url) throws IOException {
//        CurrencyRateResult
        String sketchCurrencyRates = "[{\"date\":1645000206,\"currencyCodeA\":840,\"currencyCodeB\":980,\"rateBuy\":28.03,\"rateSell\":28.2302},{\"date\":1644997806,\"currencyCodeA\":978,\"currencyCodeB\":980,\"rateBuy\":31.84,\"rateSell\":32.2404},{\"date\":1644963006,\"currencyCodeA\":643,\"currencyCodeB\":980,\"rateBuy\":0.36,\"rateSell\":0.385},{\"date\":1644998406,\"currencyCodeA\":978,\"currencyCodeB\":840,\"rateBuy\":1.128,\"rateSell\":1.143},{\"date\":1645015130,\"currencyCodeA\":826,\"currencyCodeB\":980,\"rateCross\":38.3042},{\"date\":1645014733,\"currencyCodeA\":392,\"currencyCodeB\":980,\"rateCross\":0.2449},{\"date\":1645015117,\"currencyCodeA\":756,\"currencyCodeB\":980,\"rateCross\":30.6017},{\"date\":1645015121,\"currencyCodeA\":156,\"currencyCodeB\":980,\"rateCross\":4.4548},{\"date\":1645015110,\"currencyCodeA\":784,\"currencyCodeB\":980,\"rateCross\":7.6886},{\"date\":1621225573,\"currencyCodeA\":971,\"currencyCodeB\":980,\"rateCross\":0.3583},{\"date\":1645013993,\"currencyCodeA\":8,\"currencyCodeB\":980,\"rateCross\":0.2646},{\"date\":1645014917,\"currencyCodeA\":51,\"currencyCodeB\":980,\"rateCross\":0.0592},{\"date\":1644951498,\"currencyCodeA\":973,\"currencyCodeB\":980,\"rateCross\":0.0545},{\"date\":1645014958,\"currencyCodeA\":32,\"currencyCodeB\":980,\"rateCross\":0.2652},{\"date\":1645012648,\"currencyCodeA\":36,\"currencyCodeB\":980,\"rateCross\":20.206},{\"date\":1645012040,\"currencyCodeA\":944,\"currencyCodeB\":980,\"rateCross\":16.6686},{\"date\":1644987991,\"currencyCodeA\":50,\"currencyCodeB\":980,\"rateCross\":0.3319},{\"date\":1645014984,\"currencyCodeA\":975,\"currencyCodeB\":980,\"rateCross\":16.4112},{\"date\":1644939514,\"currencyCodeA\":48,\"currencyCodeB\":980,\"rateCross\":75.476},{\"date\":1538606522,\"currencyCodeA\":108,\"currencyCodeB\":980,\"rateCross\":0.0158},{\"date\":1644573230,\"currencyCodeA\":96,\"currencyCodeB\":980,\"rateCross\":20.9475},{\"date\":1644919516,\"currencyCodeA\":68,\"currencyCodeB\":980,\"rateCross\":4.1518},{\"date\":1645014628,\"currencyCodeA\":986,\"currencyCodeB\":980,\"rateCross\":5.4695},{\"date\":1637367780,\"currencyCodeA\":72,\"currencyCodeB\":980,\"rateCross\":2.2816},{\"date\":1645015017,\"currencyCodeA\":933,\"currencyCodeB\":980,\"rateCross\":10.9179},{\"date\":1645015156,\"currencyCodeA\":124,\"currencyCodeB\":980,\"rateCross\":22.232},{\"date\":1644999006,\"currencyCodeA\":976,\"currencyCodeB\":980,\"rateCross\":0.0143},{\"date\":1644974520,\"currencyCodeA\":152,\"currencyCodeB\":980,\"rateCross\":0.0356},{\"date\":1644985827,\"currencyCodeA\":170,\"currencyCodeB\":980,\"rateCross\":0.0072},{\"date\":1644982601,\"currencyCodeA\":188,\"currencyCodeB\":980,\"rateCross\":0.0448},{\"date\":1644999006,\"currencyCodeA\":192,\"currencyCodeB\":980,\"rateCross\":1.1679},{\"date\":1645015166,\"currencyCodeA\":203,\"currencyCodeB\":980,\"rateCross\":1.3179},{\"date\":1632581742,\"currencyCodeA\":262,\"currencyCodeB\":980,\"rateCross\":0.1513},{\"date\":1645015059,\"currencyCodeA\":208,\"currencyCodeB\":980,\"rateCross\":4.312},{\"date\":1644965461,\"currencyCodeA\":12,\"currencyCodeB\":980,\"rateCross\":0.2027},{\"date\":1645015159,\"currencyCodeA\":818,\"currencyCodeB\":980,\"rateCross\":1.8044},{\"date\":1644940197,\"currencyCodeA\":230,\"currencyCodeB\":980,\"rateCross\":0.5624},{\"date\":1645015017,\"currencyCodeA\":981,\"currencyCodeB\":980,\"rateCross\":9.4808},{\"date\":1644245675,\"currencyCodeA\":936,\"currencyCodeB\":980,\"rateCross\":4.6136},{\"date\":1635083891,\"currencyCodeA\":270,\"currencyCodeB\":980,\"rateCross\":0.5482},{\"date\":1644696164,\"currencyCodeA\":324,\"currencyCodeB\":980,\"rateCross\":0.0031},{\"date\":1645006760,\"currencyCodeA\":344,\"currencyCodeB\":980,\"rateCross\":3.6186},{\"date\":1645014628,\"currencyCodeA\":191,\"currencyCodeB\":980,\"rateCross\":4.264},{\"date\":1645015104,\"currencyCodeA\":348,\"currencyCodeB\":980,\"rateCross\":0.0908},{\"date\":1645015089,\"currencyCodeA\":360,\"currencyCodeB\":980,\"rateCross\":0.0019},{\"date\":1645015125,\"currencyCodeA\":376,\"currencyCodeB\":980,\"rateCross\":8.8148},{\"date\":1645014650,\"currencyCodeA\":356,\"currencyCodeB\":980,\"rateCross\":0.3748},{\"date\":1644946923,\"currencyCodeA\":368,\"currencyCodeB\":980,\"rateCross\":0.0194},{\"date\":1644999006,\"currencyCodeA\":364,\"currencyCodeB\":980,\"rateCross\":0.0007},{\"date\":1645012915,\"currencyCodeA\":352,\"currencyCodeB\":980,\"rateCross\":0.2268},{\"date\":1645012153,\"currencyCodeA\":400,\"currencyCodeB\":980,\"rateCross\":39.875},{\"date\":1645014543,\"currencyCodeA\":404,\"currencyCodeB\":980,\"rateCross\":0.2484},{\"date\":1645010234,\"currencyCodeA\":417,\"currencyCodeB\":980,\"rateCross\":0.3329},{\"date\":1631541924,\"currencyCodeA\":116,\"currencyCodeB\":980,\"rateCross\":0.0065},{\"date\":1644999006,\"currencyCodeA\":408,\"currencyCodeB\":980,\"rateCross\":12.7409},{\"date\":1645011963,\"currencyCodeA\":410,\"currencyCodeB\":980,\"rateCross\":0.0236},{\"date\":1644906323,\"currencyCodeA\":414,\"currencyCodeB\":980,\"rateCross\":94.9948},{\"date\":1645014613,\"currencyCodeA\":398,\"currencyCodeB\":980,\"rateCross\":0.0658},{\"date\":1643717443,\"currencyCodeA\":418,\"currencyCodeB\":980,\"rateCross\":0.0025},{\"date\":1644687369,\"currencyCodeA\":422,\"currencyCodeB\":980,\"rateCross\":0.0013},{\"date\":1645015130,\"currencyCodeA\":144,\"currencyCodeB\":980,\"rateCross\":0.1396},{\"date\":1643473993,\"currencyCodeA\":434,\"currencyCodeB\":980,\"rateCross\":6.2781},{\"date\":1644999769,\"currencyCodeA\":504,\"currencyCodeB\":980,\"rateCross\":3.0252},{\"date\":1645015119,\"currencyCodeA\":498,\"currencyCodeB\":980,\"rateCross\":1.5851},{\"date\":1645007216,\"currencyCodeA\":969,\"currencyCodeB\":980,\"rateCross\":0.007},{\"date\":1645011382,\"currencyCodeA\":807,\"currencyCodeB\":980,\"rateCross\":0.5192},{\"date\":1644660467,\"currencyCodeA\":496,\"currencyCodeB\":980,\"rateCross\":0.0098},{\"date\":1644999006,\"currencyCodeA\":478,\"currencyCodeB\":980,\"rateCross\":0.0775},{\"date\":1645014029,\"currencyCodeA\":480,\"currencyCodeB\":980,\"rateCross\":0.6484},{\"date\":1633949773,\"currencyCodeA\":454,\"currencyCodeB\":980,\"rateCross\":0.0325},{\"date\":1645015161,\"currencyCodeA\":484,\"currencyCodeB\":980,\"rateCross\":1.3868},{\"date\":1645012294,\"currencyCodeA\":458,\"currencyCodeB\":980,\"rateCross\":6.7487},{\"date\":1644683942,\"currencyCodeA\":943,\"currencyCodeB\":980,\"rateCross\":0.4473},{\"date\":1645012652,\"currencyCodeA\":516,\"currencyCodeB\":980,\"rateCross\":1.8686},{\"date\":1644926591,\"currencyCodeA\":566,\"currencyCodeB\":980,\"rateCross\":0.0684},{\"date\":1644979039,\"currencyCodeA\":558,\"currencyCodeB\":980,\"rateCross\":0.8059},{\"date\":1645014924,\"currencyCodeA\":578,\"currencyCodeB\":980,\"rateCross\":3.1959},{\"date\":1645008374,\"currencyCodeA\":524,\"currencyCodeB\":980,\"rateCross\":0.2345},{\"date\":1644988038,\"currencyCodeA\":554,\"currencyCodeB\":980,\"rateCross\":18.9639},{\"date\":1645010562,\"currencyCodeA\":512,\"currencyCodeB\":980,\"rateCross\":73.3432},{\"date\":1645011878,\"currencyCodeA\":604,\"currencyCodeB\":980,\"rateCross\":7.4725},{\"date\":1645000088,\"currencyCodeA\":608,\"currencyCodeB\":980,\"rateCross\":0.5521},{\"date\":1645014227,\"currencyCodeA\":586,\"currencyCodeB\":980,\"rateCross\":0.1602},{\"date\":1645015161,\"currencyCodeA\":985,\"currencyCodeB\":980,\"rateCross\":7.148},{\"date\":1644955968,\"currencyCodeA\":600,\"currencyCodeB\":980,\"rateCross\":0.0041},{\"date\":1645011722,\"currencyCodeA\":634,\"currencyCodeB\":980,\"rateCross\":7.7552},{\"date\":1645015149,\"currencyCodeA\":946,\"currencyCodeB\":980,\"rateCross\":6.5058},{\"date\":1645013710,\"currencyCodeA\":941,\"currencyCodeB\":980,\"rateCross\":0.2732},{\"date\":1645015103,\"currencyCodeA\":682,\"currencyCodeB\":980,\"rateCross\":7.5246},{\"date\":1645015067,\"currencyCodeA\":690,\"currencyCodeB\":980,\"rateCross\":1.9886},{\"date\":1644999006,\"currencyCodeA\":938,\"currencyCodeB\":980,\"rateCross\":0.0633},{\"date\":1645015024,\"currencyCodeA\":752,\"currencyCodeB\":980,\"rateCross\":3.0486},{\"date\":1645003721,\"currencyCodeA\":702,\"currencyCodeB\":980,\"rateCross\":21.0083},{\"date\":1642766851,\"currencyCodeA\":694,\"currencyCodeB\":980,\"rateCross\":0.0025},{\"date\":1644999006,\"currencyCodeA\":706,\"currencyCodeB\":980,\"rateCross\":0.0487},{\"date\":1591303043,\"currencyCodeA\":968,\"currencyCodeB\":980,\"rateCross\":3.5865},{\"date\":1644999006,\"currencyCodeA\":760,\"currencyCodeB\":980,\"rateCross\":0.0112},{\"date\":1644999006,\"currencyCodeA\":748,\"currencyCodeB\":980,\"rateCross\":1.8703},{\"date\":1645015114,\"currencyCodeA\":764,\"currencyCodeB\":980,\"rateCross\":0.8749},{\"date\":1645014727,\"currencyCodeA\":972,\"currencyCodeB\":980,\"rateCross\":2.4983},{\"date\":1644999006,\"currencyCodeA\":795,\"currencyCodeB\":980,\"rateCross\":0.0016},{\"date\":1645003025,\"currencyCodeA\":788,\"currencyCodeB\":980,\"rateCross\":9.932},{\"date\":1645015167,\"currencyCodeA\":949,\"currencyCodeB\":980,\"rateCross\":2.0861},{\"date\":1645014906,\"currencyCodeA\":901,\"currencyCodeB\":980,\"rateCross\":1.0146},{\"date\":1645012911,\"currencyCodeA\":834,\"currencyCodeB\":980,\"rateCross\":0.0123},{\"date\":1645007422,\"currencyCodeA\":800,\"currencyCodeB\":980,\"rateCross\":0.008},{\"date\":1645010363,\"currencyCodeA\":858,\"currencyCodeB\":980,\"rateCross\":0.6558},{\"date\":1645014956,\"currencyCodeA\":860,\"currencyCodeB\":980,\"rateCross\":0.0026},{\"date\":1644999006,\"currencyCodeA\":937,\"currencyCodeB\":980,\"rateCross\":6.3272},{\"date\":1645013364,\"currencyCodeA\":704,\"currencyCodeB\":980,\"rateCross\":0.0012},{\"date\":1645005068,\"currencyCodeA\":950,\"currencyCodeB\":980,\"rateCross\":0.0487},{\"date\":1644948424,\"currencyCodeA\":952,\"currencyCodeB\":980,\"rateCross\":0.0493},{\"date\":1543715495,\"currencyCodeA\":886,\"currencyCodeB\":980,\"rateCross\":0.112},{\"date\":1645014771,\"currencyCodeA\":710,\"currencyCodeB\":980,\"rateCross\":1.8832},{\"date\":1644999006,\"currencyCodeA\":894,\"currencyCodeB\":980,\"rateCross\":0.0016}]";
//        String sketchCurrencyRates = pageReading(url);
        JSONArray jsonArray = new JSONArray(sketchCurrencyRates);
        List<MinorCurrenciesRate> minorCurrenciesRateList = new LinkedList<>();
        List<MainCurrenciesRate> mainCurrenciesRateList = new LinkedList<>();
        MainCurrenciesRate mainCurrenciesRate = new MainCurrenciesRate();
        MinorCurrenciesRate minorCurrenciesRate = new MinorCurrenciesRate();
        for (int iterator = 0; iterator < jsonArray.length(); iterator++) {
            if ((jsonArray.getJSONObject(iterator)
                          .names()
                          .length()) == mainCurrenciesRate.getColumnCount()) {
                mainCurrenciesRateList.add(MainCurrenciesRate.builder()
                                                             .withDate(jsonArray.getJSONObject(iterator)
                                                                                .getString("Date"))
                                                             .withCurrencyCodeA(jsonArray.getJSONObject(iterator)
                                                                                         .getString("currencyCodeA"))
                                                             .withCurrencyCodeB(jsonArray.getJSONObject(iterator)
                                                                                         .getString("currencyCodeB"))
                                                             .withRateBuy(jsonArray.getJSONObject(iterator)
                                                                                   .getString("rateBuy"))
                                                             .withRateSell(jsonArray.getJSONObject(iterator)
                                                                                    .getString("rateSell"))
                                                             .build());
            } else if ((jsonArray.getJSONObject(iterator)
                                 .names()
                                 .length()) == minorCurrenciesRate.getColumnCount()) {
                minorCurrenciesRateList.add(MinorCurrenciesRate.builder()
                                                               .withDate(jsonArray.getJSONObject(iterator)
                                                                                  .getString("Date"))
                                                               .withCurrencyCodeA(jsonArray.getJSONObject(iterator)
                                                                                           .getString("currencyCodeA"))
                                                               .withCurrencyCodeB(jsonArray.getJSONObject(iterator)
                                                                                           .getString("currencyCodeB"))
                                                               .withRateCross(jsonArray.getJSONObject(iterator)
                                                                                       .getString("rateCross"))
                                                               .build());
            }

        }
    }
}
