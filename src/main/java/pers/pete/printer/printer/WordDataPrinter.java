package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.enums.Align;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.WordData;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;
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
    // System.out.println(fm.getHeight());
    final String text = wordData.getText();
    final char[] chars = text.toCharArray();
    final List<String> rows = new ArrayList<>();

    int lineWith = 0;
    int from = 0;
    for (int i = 0; i < chars.length; i++) {
      lineWith += fm.charWidth(chars[i]);
      if (lineWith > pageWidth - 8) {
        rows.add(text.substring(from, i));
        from = i;
        lineWith = 0;
      }
    }
    if (0 != lineWith) {
      rows.add(text.substring(from, chars.length));
    }

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
