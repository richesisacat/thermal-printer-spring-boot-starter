package pers.pete.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.enums.Align;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.ImageData;
import pers.pete.printer.pojo.LineData;
import pers.pete.printer.pojo.QrcodeData;
import pers.pete.printer.pojo.RowData;
import pers.pete.printer.pojo.SpaceData;
import pers.pete.printer.pojo.TitleData;
import pers.pete.printer.pojo.WordData;

import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StyleDemo {

  public static void main(String[] args) {
    new StyleDemo().test();
  }

  public void test() {
    ThermalPrinter a = new ThermalPrinter(145, true);

    List<BaseData> list = new ArrayList<>();

    list.add(new WordData("编号: 1001", Align.LEFT, Font.BOLD, 5));

    list.add(new TitleData("标题"));
    list.add(new LineData(true));

    list.add(new LineData("普通文本", false));
    list.add(new WordData("左对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号", Align.LEFT));
    list.add(new LineData());
    list.add(new WordData("居中对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号", Align.CENTER, Font.PLAIN, Const.FONTSIZE_10));
    list.add(new LineData());
    list.add(new WordData("右对齐，超出纸张宽度自动折行，可设置字体样式、对齐方式、字号", Align.RIGHT, Font.ITALIC, Const.FONTSIZE_8));
    list.add(new SpaceData());

    list.add(new LineData("键值文本", false));
    list.add(new RowData("房间号", "1001"));
    list.add(new RowData("入住房型", "豪华大床房"));
    list.add(new RowData("入住人", "张三"));
    list.add(new RowData("入住日期", "2019-06-20"));
    list.add(new RowData("离店日期", "2019-06-21"));
    list.add(new RowData("超长的小标题", "超过纸张宽度折到下一行"));

    list.add(new LineData("二维码", false));
    list.add(new QrcodeData("https://www.baidu.com/s?wd=Wow!%20You%20find%20me!"));
    list.add(new LineData("本地图片", false));

    File file = new File("D:\\test.png");
    InputStream is;
    BufferedImage bi = null;
    try {
      is = new FileInputStream(file);
      bi = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    list.add(new ImageData(bi));

    list.add(new SpaceData(10));
    list.add(new WordData("打印时间: 2019-06-21", Align.RIGHT, Font.BOLD, 5));

    try {
      a.print(list);
    } catch (PrinterException e) {
      e.printStackTrace();
    }
  }
}
