package ua.alfabank.andry.inkin.currencyrate.provider;

//import ua.alfabank.andry.inkin.currencyrate.parser.Document;
//import ua.alfabank.andry.inkin.currencyrate.parser.DocumentBuilder;
//import ua.alfabank.andry.inkin.currencyrate.parser.DocumentBuilderFactory;
//import ua.alfabank.andry.inkin.currencyrate.parser.Element;
//import ua.alfabank.andry.inkin.currencyrate.parser.File;
//import ua.alfabank.andry.inkin.currencyrate.parser.Node;
//import ua.alfabank.andry.inkin.currencyrate.parser.NodeList;

public class CurrencyRateProviderImpl implements CurrencyRateProvider {

    @Override
    public void provideCurrencyRate() {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(new File(xmlFile
//                                                   + inn
//                                                   + ".xml"));
//
//        Element element = document.getDocumentElement();
//        NodeList nodeList = element.getChildNodes();
//        Node rootNode = document.getFirstChild();
//
//        NodeList rootChilds = rootNode.getChildNodes();
//        for (int i = 0; i < rootChilds.getLength(); i++) {
//
//            if (rootChilds.item(i)
//                          .getNodeType() != Node.ELEMENT_NODE) {
//                continue;
//            }
//
//            NodeList dataChilds = rootChilds.item(i)
//                                            .getChildNodes();
//
//            for (int j = 0; j < dataChilds.getLength(); j++) {
//                if (dataChilds.item(j)
//                              .getNodeType() != Node.ELEMENT_NODE) {
//                    continue;
//                }
//
//                NodeList fildInData = dataChilds.item(j)
//                                                .getChildNodes();
//
//                for (int k = 0; k < fildInData.getLength(); k++) {
//                    writer.write(fildInData.item(k)
//                                           .getNodeValue()
//                                 + ",");
//
//                }
//
//            }
//
//            if ("HEAD".equals(rootChilds.item(i)
//                                        .getNodeName())) {
//                writer.write("0,0,0,0,0"
//                             + ",");
//            }
//
//            writer.write("\n");
//
//        }
    }
}
