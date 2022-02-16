package ua.open.api.andry.inkin.currencyrate.parse;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface Parser {

    public String parseMonobankCurrencyRates() throws IOException;

    public String parseMinfinCurrencyCodes() throws IOException;

    public String parseRequest();

}
