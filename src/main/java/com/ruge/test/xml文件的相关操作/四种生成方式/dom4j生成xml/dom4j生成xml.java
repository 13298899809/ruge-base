package com.ruge.test.xml文件的相关操作.四种生成方式.dom4j生成xml;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/17 16:17
 * 说明:  TODO
 */
public class dom4j生成xml {
    @Test
    public void test1() {
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element rss = document.addElement("rss");
        //为rss根节点添加属性
        rss.addAttribute("version", "2.0");
        // 创建channel子节点
        Element channel = rss.addElement("channel");
        // 创建title子节点
        Element title = channel.addElement("title");
        // 设置title节点的值
        title.setText("<![CDATA[谁在悬崖沏一壶茶]]>");
        Element childTitle = title.addElement("childTitle");
        childTitle.setText("我是子标题");
        // 创建输出格式(OutputFormat对象)
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出文件的编码
        format.setEncoding("GBK");
        try {
            File file = new File("src/main/java/com/ruge/test/xml文件的相关操作/dem4j.xml");
            // 创建XMLWriter对象
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            //设置不自动进行转义
            writer.setEscapeText(false);
            // 生成XML文件
            writer.write(document);
            //关闭XMLWriter对象
            writer.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
