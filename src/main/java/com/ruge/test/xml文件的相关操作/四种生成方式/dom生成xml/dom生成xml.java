package com.ruge.test.xml文件的相关操作.四种生成方式.dom生成xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 16:17
 * 说明:  TODO
 */
public class dom生成xml {
    @Test
    public void test() throws ParserConfigurationException, TransformerException {
        /**
         *  1 创建DocumentBuilderFactory对象
         */
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        /**
         *  2 创建DocumentBuilder
         */
        DocumentBuilder db=dbf.newDocumentBuilder();
        /**
         *  3 创建document对象
         */
        Document document=db.newDocument();
        /**
         * 4 standalone表示该xml是不是独立的，
         * 如果是yes，则表示这个XML文档时独立的，不能引用外部的DTD规范文件；
         * 如果是no，则该XML文档不是独立的，表示可以引用外部的DTD规范文档。
         */
        document.setXmlStandalone(true);
        /**
         * 5 创建dom中根元素
         */
        Element element=document.createElement("tb_student");
        Element student=document.createElement("student");
        /**
         * 6 向元素添加子节点
         */
        document.appendChild(element);
        element.appendChild(student);
        /**
         * 7 向元素设置属性：element.setAttribute("属性名","属性值")；
         */
        student.setAttribute("id","1");
        student.setAttribute("name","刘德华");
        /**
         * 8 创建转换器工厂
         */
        TransformerFactory  factory=TransformerFactory.newInstance();
        /**
         * 9 由工厂创建转换器实例
         */
        Transformer transformer=factory.newTransformer();
        /**
         * 10 设置转换格式
         *  OutputKeys.INDENT 换行
         */
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        /**
         * 11 由转换器把dom资源转换到结果输出流，而结果输出流连接到一个xml文件
         */
        transformer.transform(new DOMSource(document),new StreamResult(new File("src/main/java/com/ruge/test/xml文件的相关操作/dom.xml")));
    }
}
