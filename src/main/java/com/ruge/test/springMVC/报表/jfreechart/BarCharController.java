package com.ruge.test.springMVC.报表.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/4 9:25
 * 说明:  柱状图
 */
@Controller
@RequestMapping(value = "springmvc", method = RequestMethod.GET)
public class BarCharController {

    @RequestMapping(value = "jfreeInit.do", method = RequestMethod.GET)
    public String jfreechartInit() {
        return "报表/jfreechart/Init";
    }

    @RequestMapping(value = "getColumnChart1.do", method = RequestMethod.GET)
    public ModelAndView test1(HttpServletRequest request) throws IOException {
        String viewName = "报表/jfreechart/Bar";
        ModelAndView view = new ModelAndView();
        view.setViewName(viewName);
        /**
         *  1 得到数据
         */
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(120, "上海", "苹果");
        dataset.addValue(160, "广州", "苹果");
        dataset.addValue(210, "北京", "梨子");
        dataset.addValue(220, "上海", "梨子");
        dataset.addValue(230, "广州", "梨子");
        dataset.addValue(330, "北京", "葡萄");
        dataset.addValue(340, "上海", "葡萄");
        dataset.addValue(340, "广州", "葡萄");
        dataset.addValue(420, "北京", "香蕉");
        dataset.addValue(430, "上海", "香蕉");
        dataset.addValue(400, "广州", "香蕉");
        dataset.addValue(510, "北京", "荔枝");
        dataset.addValue(530, "上海", "荔枝");
        dataset.addValue(510, "广州", "荔枝");
        /*
         * 解决字体乱码（在创建图表之前设定）
         */
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        JFreeChart chart = ChartFactory.createBarChart(
                "水果产量图",
                "水果",
                "产量",
                dataset,   // 数据集
                PlotOrientation.VERTICAL,   // 图表方向：水平、
                true, // 是否显示图例(对于简单的柱状图必须
                true, // 是否生成工具
                true // 是否生成URL链接);
        );
        /**
         *  ChartFactory.createStackedBarChart();
         *  ChartFactory.createXYBarChart();
         */

        /**
         * 根据chart生成图片
         */
        String fileName = ServletUtilities.saveChartAsJPEG(chart
                , 700, 700, request.getSession());
        String chartURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
        view.addObject("chartURL", chartURL);
        return view;
    }

    @RequestMapping(value = "getColumnChart2.do", method = RequestMethod.GET)
    public ModelAndView test2(HttpServletRequest request) throws IOException {
        String viewName = "报表/jfreechart/Bar";
        ModelAndView view = new ModelAndView();
        view.setViewName(viewName);
        /**
         * 获取数据集对象
         */
        CategoryDataset dataset = createDataset();
        // DatasetUtils.createCategoryDataset();
        /*
         * 解决字体乱码（在创建图表之前设定）
         */
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        /**
         * 创建图形对象
         */
        JFreeChart jfreechart = ChartFactory.createBarChart("08年图书销售量排名",
                "按季度", "销量", dataset, PlotOrientation.VERTICAL, true, true,
                false);
        /**
         * 获得图表区域对象
         */
        CategoryPlot categoryPlot = (CategoryPlot) jfreechart.getPlot();
        /**
         * 设置网格线可见
         */
        categoryPlot.setDomainGridlinesVisible(true);

        // 获得x轴对象
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        /**
         * 设置x轴显示的分类名称的显示位置，如果不设置则水平显示
         * 设置后，可以斜像显示，但分类角度，图表空间有限时，建议采用
         */
       /* categoryAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(0.39269908169872414D));
        categoryAxis.setCategoryMargin(0.0D);
        */

        /**
         * 获显示图形对象
         */
        BarRenderer barRenderer = (BarRenderer) categoryPlot
                .getRenderer();

        /**
         * 设置不显示边框线
         */
        barRenderer.setDrawBarOutline(false);


        CategoryPlot plot = jfreechart.getCategoryPlot();
        /**
         * 网格背景颜色
         */
        plot.setBackgroundPaint(Color.white);
        /**
         * 网格竖线颜色
         */
        plot.setDomainGridlinePaint(Color.PINK);
        /**
         * 网格横线颜色
         */
        plot.setRangeGridlinePaint(Color.ORANGE);

        CategoryItemRenderer renderer = plot.getRenderer();
        /**
         * 设定JFreeChart柱子上面的颜色
         */
        renderer.setSeriesPaint(0, Color.decode("#24F4DB")); // 给series1 Bar
        renderer.setSeriesPaint(1, Color.decode("#7979FF")); // 给series2 Bar
        renderer.setSeriesPaint(2, Color.decode("#FF5555")); // 给series3 Bar

        /**
         * 根据chart生成图片
         */
        String fileName = ServletUtilities.saveChartAsJPEG(jfreechart
                , 700, 700, request.getSession());
        String chartURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
        view.addObject("chartURL", chartURL);
        return view;
    }


    @RequestMapping(value = "getColumnChart3.do", method = RequestMethod.GET)
    public ModelAndView test3(HttpServletRequest request) throws IOException {
        String viewName = "报表/jfreechart/Bar";
        ModelAndView view = new ModelAndView();
        view.setViewName(viewName);
        /**
         *  1 得到数据
         */
        IntervalXYDataset dataset = createXYDataset();
        /*
         * 解决字体乱码（在创建图表之前设定）
         */
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
        /**
         * 创建图形对象
         */
        JFreeChart jfreechart = ChartFactory.createXYBarChart("08年图书销售量", null,
                false, "销量", dataset, PlotOrientation.VERTICAL, true, false,
                false);
        /**
         *  ChartFactory.createStackedBarChart();
         */
        /**
         * 设置背景为白色
         */
        jfreechart.setBackgroundPaint(Color.GREEN);

        /**
         * 获得图表区域对象
          */
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        /**
         * 设置区域对象背景为灰色
         */
        xyplot.setBackgroundPaint(Color.cyan);

        /**
         * 设置区域对象网格线调为黑色
          */
        xyplot.setDomainGridlinePaint(Color.black);
        xyplot.setRangeGridlinePaint(Color.black);

        /**
         * 获显示图形对象
          */
        XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer();
        /**
         * 设置不显示边框线
         */
        xybarrenderer.setDrawBarOutline(false);


        /**
         * 根据chart生成图片
         */
        String fileName = ServletUtilities.saveChartAsJPEG(jfreechart
                , 700, 700, request.getSession());
        String chartURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
        view.addObject("chartURL", chartURL);
        return view;
    }


    /**
     * 造数据
     */
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(100, "北京", "苹果");
        ds.addValue(100, "上海", "苹果");
        ds.addValue(100, "广州", "苹果");
        ds.addValue(200, "北京", "梨子");
        ds.addValue(200, "上海", "梨子");
        ds.addValue(200, "广州", "梨子");
        ds.addValue(300, "北京", "葡萄");
        ds.addValue(300, "上海", "葡萄");
        ds.addValue(300, "广州", "葡萄");
        ds.addValue(400, "北京", "橘子");
        ds.addValue(400, "上海", "橘子");
        ds.addValue(400, "广州", "橘子");
        ds.addValue(500, "北京", "香蕉");
        ds.addValue(500, "上海", "香蕉");
        ds.addValue(500, "广州", "香蕉");
        return ds;
    }


    private static CategoryDataset createDataset() {
        // 时间维度
        String[] category1 = {"第一季度", "第二季度", "第三季度", "第四季度"};
        // 分类维度
        String[] category2 = {"JAVA", "C/C++", "PHP"};
        DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
        for (int i = 0; i < category1.length; i++) {
            String category = category1[i];
            for (int j = 0; j < category2.length; j++) {
                String cat = category2[j];
                // 模拟添加数据
                defaultdataset.addValue(Math.random() * 100, cat, category);
            }
        }
        return defaultdataset;
    }

    /**
     * 数据叠加
     * @return
     */
    private static IntervalXYDataset createXYDataset() {
        // 创建基本数据
        XYSeries xyseries = new XYSeries("JAVA");
        XYSeries xyseries1 = new XYSeries("PHP");
        for (int i = 1; i <= 12; i++) {
            // 添加数据
            xyseries.add(i,Math.random()*100);
            xyseries1.add(i,Math.random()*100);
        }
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
    }
}
