package com.ruge.test.xml文件的相关操作.四种解析方式.sax解析xml;

import com.ruge.test.xml文件的相关操作.四种解析方式.Book;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 11:07
 * 说明:  TODO
 */
public class SaxParserController extends DefaultHandler2 {
    private int bookIndex = 0;
    private Book book;
    private List<Book> list = new ArrayList<>();
    private String currentTag; // 记录当前解析到的节点名称

    /**
     * 用来标注解析开始
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("sax解析开始");
        super.startDocument();
        list = new ArrayList<Book>();
    }

    /**
     * 开始解析xml元素
     *
     * @param uri        命名空间的uri
     * @param localName  标签的名称
     * @param qName      带命名空间的标签名称
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);
        /**
         * 开始解析book元素
         */
        if ("book".equals(qName)) {
            bookIndex++;

            /**
             * 已知book元素下的属性的名称  根据属性名称获取属性值
             */
            //  book = new Book();
            //  String value = attributes.getValue("id");
            //  System.out.println("book的属性值是:"+value);
            /**
             * 未知book元素下的属性的名称和个数
             */
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                book = new Book();
       //         System.out.println("book元素的第 " + i + " 个属性名:" + attributes.getLocalName(i) + " 属性值:" + attributes.getValue(i));
                if ("id".equals(attributes.getLocalName(i))) {
                    String id = attributes.getValue(i);
                    book.setId(id);
                }
            }
        }
        currentTag = qName; // 把当前标签记录下来
    }

    /**
     * @param ch     节点中所有的内容
     * @param start  开始节点
     * @param length 长度
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!StringUtils.isBlank(value)) {
      //      System.out.println(currentTag+" 子节点值是:" +value);
        }
        if ("name".equals(currentTag)) {
            book.setName(value);
        } else if ("author".equals(currentTag)) {
            book.setAuthor(value);
        } else if ("year".equals(currentTag)) {
            book.setYear(value);
        } else if ("price".equals(currentTag)) {
            book.setPrice(value);
        } else if ("language".equals(currentTag)) {
            book.setLanguage(value);
        }
    }

    /**
     * 结束解析xml元素
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        /**
         * 判断是否针对一本书已经结束
         */
        if("book".equals(qName)){
            list.add(book);
            book = null;
      //      System.out.println("结束第" + bookIndex + "本书的遍历");
        }
        currentTag = null;
    }

    /**
     * 用来标注解析结束
     *
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
       /* for (Book b: list
             ) {
            System.out.println(b);
        }*/
        System.out.println("sax解析结束");
        super.endDocument();
    }

    public List<Book> getbooks() {
        return list;
    }
}
