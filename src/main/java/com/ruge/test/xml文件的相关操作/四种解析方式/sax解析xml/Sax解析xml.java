package com.ruge.test.xml文件的相关操作.四种解析方式.sax解析xml;

import com.ruge.test.xml文件的相关操作.四种解析方式.Book;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 11:00
 * 说明:  TODO
 */
public class Sax解析xml {
    @Test
    public void test1() throws ParserConfigurationException, SAXException, IOException {
        //1.创建解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.得到解析器
        SAXParser parser=factory.newSAXParser();
        SaxParserController controller = new SaxParserController();
        parser.parse("src/main/java/com/ruge/test/xml文件的相关操作/books.xml",controller);
        List<Book> getbooks = controller.getbooks();
        for (Book get:getbooks
             ) {
            System.out.println(get);
        }
        //3得到解读器
        //XMLReader reader=parser.getXMLReader();
        //设置内容处理器
       // reader.setContentHandler(new ListHandler());
        //读取xml的文档内容
     //   reader.parse("src/Book.xml");
    }
}
