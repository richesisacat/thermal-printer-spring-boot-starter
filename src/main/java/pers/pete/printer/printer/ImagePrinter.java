package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.ImageData;

import java.awt.Graphics2D;

public class ImagePrinter implements BasePrinter {

  private int pageWidth;

  public ImagePrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final ImageData imageData = (ImageData) data;
    g2.drawImage(imageData.getImage(), x + (pageWidth - Const.QRCODE) / 2, y, Const.QRCODE, Const.QRCODE, null);
    return y + Const.QRCODE + Const.PADDING;
  }

}
