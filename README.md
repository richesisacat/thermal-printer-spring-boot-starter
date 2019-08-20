# thermal-printer-spring-boot-starter
spring boot 调用默认热敏打印机

## 配置

- 引入依赖
```
<dependency>
    <groupId>io.github.rich-is-cat</groupId>
    <artifactId>thermal-printer-spring-boot-starter</artifactId>
    <version>0.0.3</version>
</dependency>
```

- 配置yml
```
thermal:
  printer:
    # 热敏纸宽：mm58-58毫米 mm80-80毫米 userdefined-用户自定义宽度
    paper-width: 
    # 当paper-width为"userdefined"时，填写打印纸宽度，1 = 1/72nds of an inch
    user-defined-width: 
    # 指定打印机名称，用默认打印机可无此项
    printer-name:
    
```

## 调用

- 可直接注入
```
  @Autowired
  private ThermalPrinter thermalPrinter
```

- 也可调用构造函数构造自己的参数
```
@Configuration
public class PrinterConfig {
  
  @Bean
  public ThermalPrinter thermalPrinter() {
    return new ThermalPrinter(145, "MyPrinter");
  }
}
```

- 组装数据List调用ThermalPrinter.print()即可实现打印

## 支持的数据类型

1. TitleData
    > **默认标题** 超出纸张宽度截断，可指定字号、样式

1. WordData
    > **普通文本** 超出纸张宽度自动折行，可指定字号、样式、对齐方式
 
1. LineData
    > **线** 虚线、实现，线中带文字，可指定字号、样式

1. RowData
    > **项目** K-V对，可展现打印明细
 
1. ImageData
    > **二维码**
 
1. SpaceData
    > **空白行** 可指定行高
    
## 数据示例

```
public class StyleDemo {

  public static void main(String[] args) {
    new StyleDemo().test();
  }

  public void test() {
    ThermalPrinter a = new ThermalPrinter(145);

    List<BaseData> list = new ArrayList<>();

    list.add(new WordData("编号: 1001", Align.LEFT, Font.BOLD, 5));

    list.add(new TitleData("标题"));
    list.add(new LineData(true));

    list.add(new LineData("普通文本", false));
    list.add(new WordData("左对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号，一二三四五六七八九十", Align.LEFT));
    list.add(new LineData());
    list.add(new WordData("居中对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号，一二三四五六七八九十", Align.CENTER, Font.ITALIC, Const.FONTSIZE_8));
    list.add(new LineData());
    list.add(new WordData("右对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号，一二三四五六七八九十", Align.RIGHT, Font.ITALIC, Const.FONTSIZE_8));
    list.add(new LineData());

    list.add(new LineData("键值文本", false));
    list.add(new RowData("房间号", "1001"));
    list.add(new RowData("入住房型", "豪华大床房"));
    list.add(new RowData("入住人", "张三"));
    list.add(new RowData("入住日期", "2019-06-20"));
    list.add(new RowData("离店日期", "2019-06-21"));

    list.add(new LineData("二维码", false));
    list.add(new ImageData("https://www.baidu.com/s?wd=Wow!%20You%20find%20me!"));

    list.add(new SpaceData(10));
    list.add(new WordData("打印时间: 2019-06-21", Align.RIGHT, Font.BOLD, 5));
    try {
      a.print(list);
    } catch (PrinterException e) {
      e.printStackTrace();
    }
  }
}
```
