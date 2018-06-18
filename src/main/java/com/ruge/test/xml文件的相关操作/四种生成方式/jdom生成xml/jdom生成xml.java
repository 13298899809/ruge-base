package com.ruge.test.xml文件的相关操作.四种生成方式.jdom生成xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 16:18
 * 说明:  TODO
 */
public class jdom生成xml {
    @Test
    public void test1() {
        Element root = new Element("School");//创建根节点School节点
        Document document = new Document(root);//把根节点添加打文档中
        Element elementclass = new Element("class");//创建根节点的子节点
        elementclass.setAttribute("name", "张三");//给子节点添加name属性
        elementclass.setAttribute("id", "002");//给子节点添加id属性
        Element element_subject = new Element("subject");//给子节点添加subject元素
        element_subject.addContent("数学");
        elementclass.addContent(element_subject);

        Element element_subject1 = new Element("score");//给子节点添加score元素
        element_subject1.addContent("90");
        elementclass.addContent(element_subject1);

        Element element_subject2 = new Element("card");//给子节点添加card元素
        element_subject2.addContent("024125");
        elementclass.addContent(element_subject2);
        /**
         * xml样式
         */
        Format format = Format.getCompactFormat();
        format.setEncoding("utf-8");
        format.setIndent(" ");

        root.addContent(elementclass);//把子节点添加到根节点中。
        XMLOutputter XMLOut = new XMLOutputter(format);  //生成xml文件
        try {
            XMLOut.output(document, new FileOutputStream("src/main/java/com/ruge/test/xml文件的相关操作/jdom.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("生成xml文件失败！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("生成xml文件失败！");
            e.printStackTrace();
        }
    }
}
