package com.pete.printer.printer;

import com.pete.printer.pojo.BaseData;
import com.pete.printer.pojo.RowData;
import com.pete.printer.consts.Const;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class RowPrinter implements BasePrinter {

  private int pageWidth;

  public RowPrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final RowData rowData = (RowData) data;
    g2.setFont(new Font(null, Font.PLAIN, Const.FONTSIZE_8));

    final FontMetrics fm = g2.getFontMetrics();
    int stringWidth = fm.stringWidth(rowData.getTitle());
    int left = pageWidth / 3;

    g2.drawString(rowData.getTitle(), x + (left - stringWidth), y + Const.FONTSIZE_8);
    g2.drawString(rowData.getValue(), x + (left + 10), y + Const.FONTSIZE_8);
    return y + Const.FONTSIZE_8 + Const.PADDING;
  }
}
