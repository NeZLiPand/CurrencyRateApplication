package ua.alfabank.andry.inkin.currencyrate.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ParserImpl implements Parser {

    @Override
    public String parse(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String parsedTextFromTheSite = bufferedReader.readLine();
        bufferedReader.close();
        return parsedTextFromTheSite;
    }
}
