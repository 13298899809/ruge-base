package com.ruge.test.xml文件的相关操作.四种解析方式.dom解析xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 9:31
 * 说明:  TODO
 */
public class Dom解析xml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        /**
         * 1 创建一个DocumentBuilderFactory对象
         */
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        /**
         * 2 创建一个 DocumentBuilder对象
         */
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        /**
         * 从文件或流中创建Document对象
         */
        String filePath = "src/main/java/com/ruge/test/xml文件的相关操作/books.xml";
        Document document = documentBuilder.parse(filePath);
        /**
         * 获取所有book节点的集合
         */
        NodeList book = document.getElementsByTagName("book");
        /**
         * 遍历每一个book节点
         */
        System.out.println("共有" + book.getLength() + "本书");
        for (int i = 0; i < book.getLength(); i++) {
            /**
             * 过去每个xml的节点
             */
            Node node = book.item(i);
            /**
             * 获取每个节点的本身的属性
             *   <book addr="aaa">   1个属性
             *    <book>             0个属性
             */
            NamedNodeMap nodeMap = node.getAttributes();
            System.out.println("第" + i + "本书共有" + nodeMap.getLength() + "个属性");
            for (int j = 0; j < nodeMap.getLength(); j++) {
                /**
                 * 获取book节点下的某一个属性
                 */
                Node item = nodeMap.item(j);
                /**
                 * 获取属性名
                 * 获取属性值
                 */
                String nodeName = item.getNodeName();
                short nodeType = item.getNodeType();
                String nodeValue = item.getNodeValue();
                System.out.println("第" + i + "本书的属性名是:" + nodeName + "属性类型是:" + nodeType + "属性值是:" + nodeValue);
            }
            Element element = (Element) book.item(i);
            String idValue = element.getAttribute("id");
            System.out.println("我只想获取id属性 属性名: 'id'  属性值:" + idValue + "的前提条件是我们需要知道这个book属性只能有一个  且知道该属性是 id ");
            /**
             * 获取所有子节点
             */
            NodeList childNodes = node.getChildNodes();
            System.out.println("第" + i + "本书的子节点个数" + childNodes.getLength());
            for (int j = 0; j < childNodes.getLength(); j++) {
                /**
                 * 如何区分text类型的node和element类型的node
                 */
                if (Node.ELEMENT_NODE==childNodes.item(j).getNodeType()) {
                    String nodeName = childNodes.item(j).getNodeName();
                    String nodeValue1 = childNodes.item(j).getFirstChild().getNodeValue();
                    String nodeValue2 = childNodes.item(j).getTextContent();
                    System.out.println("第一种获取方式=== 第" + i + "本书的第" + j + "子节点名称" + nodeName  + " 节点值:" + nodeValue1);
                    System.out.println("第二种获取方式=== 第" + i + "本书的第" + j + "子节点名称" + nodeName  + " 节点值:" + nodeValue2);
                }

            }
            System.out.println("=======================第"+i+"本书遍历结束==============================");
        }
    }
}
