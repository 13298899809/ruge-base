jfreechart
     
     <dependency>
            <groupId>org.jfree</groupId>
            <artifactId>jfreechart</artifactId>
            <version>1.5.0</version>
        </dependency>
        
        
web.xml中

<!--集成 jfreechart-->

    <servlet>
        <servlet-name>DisplayChart</servlet-name>
        <servlet-class>org.jfree.chart.servlet.DisplayChart</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>DisplayChart</servlet-name>
        <url-pattern>/chart</url-pattern>
    </servlet-mapping>
