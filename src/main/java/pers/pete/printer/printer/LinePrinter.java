package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.LineData;

import java.awt.BasicStroke;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class LinePrinter implements BasePrinter {

  private int pageWidth;

  public LinePrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    LineData lineData = (LineData) data;
    float lineWidth = 0.5f;

    float[] dash = new float[] {2.0f};
    if (lineData.isFullLine()) {
      dash = new float[] {2.0f, 0.0f};
      lineWidth = 1f;
    }

    g2.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, dash, 0.0f));

    if (null == lineData.getValue()) {
      //在此图形上下文的坐标系中使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线。 即绘制虚线
      g2.drawLine(x, (y + Const.PADDING), x + pageWidth, (y + Const.PADDING));
      return y + Const.PADDING + Const.PADDING;
    } else {
      g2.setFont(lineData.getFont());
      final FontMetrics fm = g2.getFontMetrics();
      final int fontHeight = fm.getHeight();
      int width = fm.stringWidth(lineData.getValue());
      g2.drawLine(x, (y + fontHeight / 2), x + (pageWidth - width) / 2, (y + fontHeight / 2));
      g2.drawString(lineData.getValue(), x + (pageWidth - width) / 2, y + fontHeight);
      g2.drawLine(x + (pageWidth + width) / 2, (y + fontHeight / 2), x + pageWidth, (y + fontHeight / 2));
      return y + fontHeight + Const.PADDING;
    }
  }
}
