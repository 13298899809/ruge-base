package com.ruge.test.xml文件的相关操作.四种生成方式.sax生成xml;

import com.ruge.test.xml文件的相关操作.四种解析方式.Book;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 18:04
 * 说明:原理
 * 通过result关联到xml文档，
 * 通过handler开始一个标签、设置标签属性、添加文本、结束一个标签方法操作result从而改变xml文档内容。
 */
public class sax生成xml {
    List<Book> books = Arrays.asList(new Book("1", "刘德华1", "爱丽丝、如歌", "2018", "233", "中文"),
            new Book("2", "刘德华2", "爱丽丝、如歌", "2018", "233", "中文"),
            new Book("3", "刘德华3", "爱丽丝、如歌", "2018", "233", "中文"),
            new Book("4", "刘德华4", "爱丽丝、如歌", "2018", "233", "中文"),
            new Book("5", "刘德华5", "爱丽丝、如歌", "2018", "233", "中文")
    );

    @Test
    public void createXMLBySAX() {
        File dest = new File("src/main/java/com/ruge/test/xml文件的相关操作/sax.xml");
        /**
         * 1 创建SAX转换器工厂
         */
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            /**
             *2  创建转换handler
             */
            TransformerHandler handler = factory.newTransformerHandler();
            /**
             * 3 由handler创建转换器
             */
            Transformer transformer = handler.getTransformer();
            /**
             * 4 设置转换格式
             *  OutputKeys.INDENT 换行
             */
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            /**
             *5  创建Result连接到xml文件
             */
            Result result = new StreamResult(dest);
            /**
             * 6 关联result到handler
             */
            handler.setResult(result);

            try {
                /**
                 * 7 利用handler操作xml文件
                 * 开启文档
                 */
                handler.startDocument();
                /**
                 * 8 新建节点
                 *handler.startElement(uri,命名空间,元素名,属性列表);
                 *没有则填null
                 */
                handler.startElement("", "", "bookstore", null);
                /**
                 * 9 创建子结点
                 * handler.startElement(uri,命名空间,子元素名,属性列表)
                 * 在一个start与end的元素之间添加的结点就是它的子节点
                 */
                AttributesImpl atts = new AttributesImpl();
                for (Book book : books) {
                    atts.clear();
                    atts.addAttribute("", "", "id", "", String.valueOf(book.getId()));
                    handler.startElement("", "", "book", atts);

                    handler.startElement("", "", "name", null);
                    handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                    handler.endElement("", "", "name");

                    handler.startElement("", "", "author", null);
                    handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                    handler.endElement("", "", "author");

                    handler.startElement("", "", "price", null);
                    handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
                    handler.endElement("", "", "price");

                    handler.endElement("", "", "book");
                }
                /**
                 * 关闭dom对象：handler.endDocument();
                 */
                handler.endElement("", "", "bookstore");
                // 关闭文档
                handler.endDocument();
            } catch (SAXException e) {
                e.printStackTrace();
            }

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }
}
