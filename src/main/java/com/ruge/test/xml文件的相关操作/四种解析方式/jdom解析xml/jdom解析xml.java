package com.ruge.test.xml文件的相关操作.四种解析方式.jdom解析xml;

import com.ruge.test.xml文件的相关操作.四种解析方式.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 14:02
 * 说明:  TODO
 */
public class jdom解析xml {
    @Test
    public void test1() throws JDOMException, IOException {
        List<Book> list = new ArrayList<>();
        /**
         * 创建一个 SAXBuilder 对象
         */
        SAXBuilder saxBuilder = new SAXBuilder();
        //获取books.xml文档
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/ruge/test/xml文件的相关操作/books.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        Document document = saxBuilder.build(inputStreamReader);
        //获得根节点
        Element element = document.getRootElement();
        //获得根节点下的节点数据
        List<Element> children = element.getChildren();
        for (Element e : children
                ) {
            Book book = new Book();

            List<Attribute> attributes = e.getAttributes();

            for (Attribute a : attributes
                    ) {
                if ("id".equals(a.getName())) {
                    book.setId(a.getValue());
                }
                //   System.out.println(a.getName()+"==="+a.getValue());
            }
            /**
             * 获取id下的所有字节点
             */
            List<Element> children1 = e.getChildren();
            for (Element e1 : children1
                    ) {
                System.out.print(e1.getName() + ":" + e1.getValue() + "   ");
                if ("name".equals(e1.getName())) {
                    book.setName(e1.getValue());
                } else if ("price".equals(e1.getName())) {
                    book.setPrice(e1.getValue());
                } else if ("author".equals(e1.getName())) {
                    book.setAuthor(e1.getValue());
                } else if ("year".equals(e1.getName())) {
                    book.setYear(e1.getValue());
                } else if ("language".equals(e1.getName())) {
                    book.setLanguage(e1.getValue());
                }
            }
            System.out.println();
            list.add(book);
        }
        for (Book l : list
                ) {
            System.out.println(l);
        }
    }
}
