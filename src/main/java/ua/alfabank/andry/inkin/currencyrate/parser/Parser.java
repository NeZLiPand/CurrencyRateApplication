package ua.alfabank.andry.inkin.currencyrate.parser;

import java.io.IOException;

public interface Parser {
    public String parse(String url) throws IOException;
}
