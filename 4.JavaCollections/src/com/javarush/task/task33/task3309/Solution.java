package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

//для решения использовал информацию отсюда
// https://java-online.ru/java-xml.xhtml - Document
// https://stackoverflow.com/questions/2567416/xml-document-to-string - Transformer

public class Solution {

    /**
     * @param obj     сериализуемый объект
     * @param tagName имя тега перед которым нужно вставить комментарий
     * @param comment комментарий
     * @return вернуть XML
     */
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(obj, writer);
            String xml = writer.toString(); //строка содержит в себе сериализованный obj

            //создание документа, чтобы работать с DOM
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

            NodeList nodeList = document.getElementsByTagName(tagName); //получение списка искомых тегов
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                node.getParentNode().insertBefore(document.createComment(comment), node); //вставка комментария перед текущим тегом
            }

            //позволит получить из DOM результат (в нашем случае в виде текста)
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            https://askdev.ru/q/chto-oznachaet-direktiva-standalone-v-xml-7116/
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//          трансформирует xml в то, что нам нужно. Первый параметр - новый объект DOMSource, при создании которого
//          используется document, вторым параметром - StreamResult - содержит в себе результат преобразования
            writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));


        } catch (ParserConfigurationException | JAXBException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }
}

