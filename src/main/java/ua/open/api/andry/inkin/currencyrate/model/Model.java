package ua.open.api.andry.inkin.currencyrate.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.open.api.andry.inkin.currencyrate.model.domain.CurrencyRate;

//The data in the table with Codes should be overwritten, 
//  and the data in the table with all the information on the courses should only be supplemented.
//While the development is in progress, it is allowed to overwrite data in all tables

public class Model {
    private static final String CONNECT_TO_DB_SUCCESS = "Connected to DB postgresql - SUCCESS!";
    private static final String CONNECT_TO_DB_FAILED = "Connected to DB postgresql - FAILED!";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/currencies_rates";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public Map<String, String> getCurrenciesCodes() {
        Map<String, String> currenciesCodes = new HashMap<>();
        String queryTableOfCodes = "SELECT numerical_code, letter_code FROM сurrencyсodes";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            if (connection != null) {
                System.out.print(CONNECT_TO_DB_SUCCESS);
                Statement statement = connection.createStatement();
                ResultSet resultSetOfCodes = statement.executeQuery(queryTableOfCodes);

                while (resultSetOfCodes.next()) {
                    currenciesCodes.put(resultSetOfCodes.getString(1), resultSetOfCodes.getString(2));
                }
                System.out.println(" And get Currencies Codes");
            } else {
                System.out.println(CONNECT_TO_DB_FAILED);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s %n %s", e.getSQLState(), e.getMessage());
            Logger lgr = Logger.getLogger(Model.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currenciesCodes;
    }

    public long getDateAndTimeOfTheMostRecentRate() {
        long dateAndTime = 0L;
        String query = "SELECT MAX (date_time) FROM currencyrates";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            if (connection != null) {
                System.out.print(CONNECT_TO_DB_SUCCESS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                dateAndTime = resultSet.getLong(1);
                System.out.println(" And get Date And Time Of The Most Recent Rate");
            } else {
                System.out.println(CONNECT_TO_DB_FAILED);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s %n %s", e.getSQLState(), e.getMessage());
            Logger lgr = Logger.getLogger(Model.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateAndTime;
    }

    public void setCurrenciesCodes(Map<String, String> currenciesCodes) {
        Iterator<Entry<String, String>> iterator = currenciesCodes.entrySet()
                                                                  .iterator();
        Entry<String, String> currencyCode;
        String query = "DROP TABLE сurrencyсodes;";
        String currentTime = System.currentTimeMillis() / 1000L
                             + "";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            if (connection != null) {
                System.out.print(CONNECT_TO_DB_SUCCESS);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                query = "CREATE TABLE IF NOT EXISTS public.\"сurrencyсodes\"("
                        + "letter_code text COLLATE pg_catalog.\"default\" NOT NULL,"
                        + "numerical_code text COLLATE pg_catalog.\"default\" NOT NULL,"
                        + "date_time text COLLATE pg_catalog.\"default\" NOT NULL,"
                        + "CONSTRAINT \"сurrencyсodes_pkey\" PRIMARY KEY (numerical_code)"
                        + ")";
                statement.executeUpdate(query);
                while (iterator.hasNext()) {
                    currencyCode = iterator.next();
                    query = "INSERT INTO сurrencyсodes VALUES ('"
                            + currencyCode.getValue()
                            + "', '"
                            + currencyCode.getKey()
                            + "', '"
                            + currentTime
                            + "');";
                    statement.executeUpdate(query);
                }
                System.out.println(" INSERT INTO сurrencyсodes VALUES");
            } else {
                System.out.println(CONNECT_TO_DB_FAILED);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s %n %s", e.getSQLState(), e.getMessage());
            Logger lgr = Logger.getLogger(Model.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCurrenciesRates(List<CurrencyRate> currenciesRates) {
        String query = "DROP TABLE currencyrates;";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            if (connection != null) {
                System.out.print(CONNECT_TO_DB_SUCCESS);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                query = "CREATE TABLE IF NOT EXISTS currencyrates ("
                        + "currency_code_a text COLLATE pg_catalog.default NOT NULL,"
                        + "letter_code_a text COLLATE pg_catalog.default NOT NULL,"
                        + "currency_code_b text COLLATE pg_catalog.default NOT NULL,"
                        + "letter_code_b text COLLATE pg_catalog.default NOT NULL,"
                        + "date_time text COLLATE pg_catalog.default NOT NULL,"
                        + "rate_sell text COLLATE pg_catalog.default,"
                        + "rate_buy text COLLATE pg_catalog.default,"
                        + "rate_cross text COLLATE pg_catalog.default,"
                        + "is_main boolean NOT NULL)";
                statement.executeUpdate(query);
                for (CurrencyRate currencyRate : currenciesRates) {
                    query = "INSERT INTO currencyrates ("
                            + "currency_code_a,"
                            + "letter_code_a,"
                            + "currency_code_b,"
                            + "letter_code_b,"
                            + "date_time,"
                            + "rate_sell,"
                            + "rate_buy,"
                            + "rate_cross,"
                            + "is_main"
                            + ") VALUES ('"
                            + currencyRate.getCurrencyCodeA()
                            + "', '"
                            + currencyRate.getLetterCodeA()
                            + "', '"
                            + currencyRate.getCurrencyCodeB()
                            + "', '"
                            + currencyRate.getLetterCodeB()
                            + "', '"
                            + currencyRate.getDate()
                            + "', '"
                            + currencyRate.getRateSell()
                            + "', '"
                            + currencyRate.getRateBuy()
                            + "', '"
                            + currencyRate.getRateCross()
                            + "', '"
                            + currencyRate.getIsMain()
                            + "');";
                    statement.executeUpdate(query);
                }
                System.out.println(" INSERT INTO currencyrates VALUES");
            } else {
                System.out.println(CONNECT_TO_DB_FAILED);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s %n %s", e.getSQLState(), e.getMessage());
            Logger lgr = Logger.getLogger(Model.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CurrencyRate> getCurrenciesRates() {
        List<CurrencyRate> currencyRates = new ArrayList<>();
        String query = "SELECT * FROM currencyrates";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);) {
            if (connection != null) {
                System.out.println(CONNECT_TO_DB_SUCCESS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    currencyRates.add(CurrencyRate.builder()
                                                  .withCurrencyCodeA(resultSet.getString(1))
                                                  .withLetterCodeA(resultSet.getString(2))
                                                  .withCurrencyCodeB(resultSet.getString(3))
                                                  .withLetterCodeB(resultSet.getString(4))
                                                  .withDate(resultSet.getString(5))
                                                  .withIsMain(resultSet.getBoolean(9))
                                                  .withRateBuy(resultSet.getString(7))
                                                  .withRateCross(resultSet.getString(8))
                                                  .withRateSell(resultSet.getString(6))
                                                  .build());
                }
            } else {
                System.out.println(CONNECT_TO_DB_FAILED);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s %n %s", e.getSQLState(), e.getMessage());
            Logger lgr = Logger.getLogger(Model.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyRates;
    }

}