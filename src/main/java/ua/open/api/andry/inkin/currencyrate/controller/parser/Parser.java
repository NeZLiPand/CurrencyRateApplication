package ua.open.api.andry.inkin.currencyrate.controller.parser;

import java.io.IOException;

import org.jsoup.select.Elements;

public interface Parser {

    public Elements parseMonobankCurrenciesRates() throws IOException;

    public Elements parseMinfinCurrenciesCodes() throws IOException;

}
