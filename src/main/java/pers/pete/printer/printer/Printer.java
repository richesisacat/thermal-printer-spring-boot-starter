package pers.pete.printer.printer;

import pers.pete.printer.pojo.BaseData;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.List;
import java.util.Map;

public class Printer implements Printable {

  private Map<String, BasePrinter> printers;

  private List<BaseData> baseData;

  public Printer(Map<String, BasePrinter> printers, List<BaseData> baseData) {
    this.printers = printers;
    this.baseData = baseData;
  }

  @Override
  public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex) {
    if (pageIndex > 0) {
      return NO_SUCH_PAGE;
    }
    final Graphics2D g2 = (Graphics2D) graphics;
    int x = (int) pageFormat.getImageableX();
    int y = (int) pageFormat.getImageableY();
    g2.setColor(Color.black);

    for (BaseData d : baseData) {
      if (null != printers.get(d.getClass().getName())) {
        // System.out.println(y);
        y = printers.get(d.getClass().getName()).draw(g2, x, y, d);
      }
    }
    return PAGE_EXISTS;
  }
}
