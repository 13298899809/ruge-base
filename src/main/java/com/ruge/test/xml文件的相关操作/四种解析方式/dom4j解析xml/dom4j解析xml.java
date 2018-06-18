package com.ruge.test.xml文件的相关操作.四种解析方式.dom4j解析xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 15:27
 * 说明:  TODO
 */
public class dom4j解析xml {
    @Test
    public void test1() throws DocumentException {
        File inputXml = new File("src/main/java/com/ruge/test/xml文件的相关操作/books.xml");
        // 创建SAXReader对象
        SAXReader saxReader = new SAXReader();
        //通过saxReader的read方法加载xml文件
        Document document=saxReader.read(inputXml);
        //获得根节点
        Element rootElement = document.getRootElement();
        // 通过rootElement.elementIterator(); 获取迭代器
        Iterator iterator = rootElement.elementIterator();
        // 遍历迭代器 获取根节点中的信息
        while (iterator.hasNext()){
            // 将迭代器中的元素转换成节点类型
            Element book = (Element) iterator.next();
            // 获取book的属性名  和 属性值
            List<Attribute> attributes = book.attributes();
            for (Attribute a:attributes
                 ) {
                System.out.print("父节点名:"+a.getName()+"父节点值:"+a.getValue()+" ");
            }
            Iterator iterator1 = book.elementIterator();
            while (iterator1.hasNext()){
                Element bookChild = (Element) iterator1.next();
                List<Attribute> attributes1 = bookChild.attributes();
                System.out.print("子节点名"+bookChild.getName()+"子节点值"+bookChild.getStringValue()+" ");
            }
            System.out.println();
        }
        System.out.println(rootElement);
    }
}
