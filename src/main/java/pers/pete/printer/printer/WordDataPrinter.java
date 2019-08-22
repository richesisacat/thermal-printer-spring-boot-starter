package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.enums.Align;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.WordData;
import pers.pete.printer.utils.PrinterUtil;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.List;

public class WordDataPrinter implements BasePrinter {

  private int pageWidth;

  public WordDataPrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final WordData wordData = (WordData) data;
    g2.setFont(wordData.getFont());

    final FontMetrics fm = g2.getFontMetrics();
    final List<String> rows = PrinterUtil.wordFold(wordData.getText(), fm, pageWidth);
    for (String row : rows) {
      int rx = x;
      if (Align.RIGHT.equals(wordData.getAlign())) {
        rx = x + pageWidth - fm.stringWidth(row);
      } else if (Align.CENTER.equals(wordData.getAlign())) {
        rx = x + (pageWidth - fm.stringWidth(row)) / 2;
      }
      g2.drawString(row, rx, y + fm.getHeight());
      y += fm.getHeight() + Const.PADDING;
    }
    return y;
  }
}
