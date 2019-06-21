# thermal-printer-spring-boot-starter
spring boot 调用默认热敏打印机

## 配置

- 引入依赖
```
<dependency>
    <groupId>pers.pete</groupId>
    <artifactId>thermal-printer-spring-boot-starter</artifactId>
    <version>0.0.1</version>
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