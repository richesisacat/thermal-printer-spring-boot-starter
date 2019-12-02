package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.TitleData;
import pers.pete.printer.utils.PrinterUtil;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.List;

public class TitlePrinter implements BasePrinter {

  private int pageWidth;

  public TitlePrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final TitleData titleData = (TitleData) data;
    //Font.PLAIN： 普通样式常量  	Font.ITALIC 斜体样式常量	Font.BOLD 粗体样式常量。
    //g2.setFont(new Font(null, Font.BOLD, titleData.getSize()));
    g2.setFont(titleData.getFont());
    final FontMetrics fm = g2.getFontMetrics();
    final List<String> rows = PrinterUtil.wordFold(titleData.getValue(), fm, pageWidth);
    for (String row : rows) {
      int rx = x + (pageWidth - fm.stringWidth(row)) / 2;
      g2.drawString(row, rx, y + fm.getHeight());
      y += fm.getHeight() + Const.PADDING;
    }
    return y;

    /*int width = fm.stringWidth(titleData.getValue());
    if (width < pageWidth) {
      g2.drawString(titleData.getValue(), x + (pageWidth - width) / 2, y + titleData.getSize());
    } else {
      g2.drawString(titleData.getValue(), x, y + titleData.getSize());
    }
    return y + titleData.getSize() + Const.PADDING;*/
  }

}
