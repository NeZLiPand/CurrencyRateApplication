package ua.alfabank.andry.inkin.currencyrate.parser;

import java.io.IOException;

public interface Parser {
    public void parse(String url) throws IOException;
}
