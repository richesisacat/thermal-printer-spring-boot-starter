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
    // int stringWidth = fm.stringWidth(rowData.getTitle());
    int left = pageWidth / 3;

    final List<String> rowsKey = PrinterUtil.wordFold(rowData.getTitle(), fm, left);
    for (int i = 0; i < rowsKey.size(); i++) {
      int stringWidth = fm.stringWidth(rowsKey.get(i));
      g2.drawString(rowsKey.get(i), x + (left - stringWidth), y + rowData.getSize());
      if (!(rowsKey.size() <= 1) && i != (rowsKey.size() - 1)) {
        y += rowData.getSize() + Const.PADDING;
      }
    }
    // g2.drawString(rowData.getTitle(), x + (left - stringWidth), y + rowData.getSize());
    final List<String> rowsValue = PrinterUtil.wordFold(rowData.getValue(), fm, (pageWidth - left - 10));
    for (int i = 0; i < rowsValue.size(); i++) {
      g2.drawString(rowsValue.get(i), x + (left + 5), y + rowData.getSize());
      if (!(rowsValue.size() <= 1) && i != (rowsValue.size() - 1)) {
        y += rowData.getSize() + Const.PADDING;
      }
    }
    return y + rowData.getSize() + Const.PADDING;
  }
}
