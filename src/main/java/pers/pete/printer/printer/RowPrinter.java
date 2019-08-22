package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.RowData;
import pers.pete.printer.utils.PrinterUtil;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.List;

public class RowPrinter implements BasePrinter {

  private int pageWidth;

  public RowPrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final RowData rowData = (RowData) data;
    // g2.setFont(new Font(null, Font.PLAIN, rowData.getSize()));
    g2.setFont(rowData.getFont());
    final FontMetrics fm = g2.getFontMetrics();
    int stringWidth = fm.stringWidth(rowData.getTitle());
    int left = pageWidth / 3;

    g2.drawString(rowData.getTitle(), x + (left - stringWidth), y + rowData.getSize());
    final List<String> rows = PrinterUtil.wordFold(rowData.getValue(), fm, (pageWidth - left - 10));
    for (int i = 0; i < rows.size(); i++) {
      g2.drawString(rows.get(i), x + (left + 10), y + rowData.getSize());
      if (!(rows.size() <= 1) && i != (rows.size() - 1)) {
        y += rowData.getSize() + Const.PADDING;
      }
    }
    return y + rowData.getSize() + Const.PADDING;
  }
}
