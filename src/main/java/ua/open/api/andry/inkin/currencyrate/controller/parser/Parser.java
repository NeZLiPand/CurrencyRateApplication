package ua.open.api.andry.inkin.currencyrate.controller.parser;

import java.io.IOException;

public interface Parser {

    public String parseMonobankCurrencyRates() throws IOException;

    public String parseMinfinCurrencyCodes() throws IOException;

}
