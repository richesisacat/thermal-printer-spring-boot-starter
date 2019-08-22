package pers.pete.printer.printer;

import org.springframework.util.ResourceUtils;
import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.ImageData;
import pers.pete.printer.pojo.QrcodeData;
import pers.pete.printer.utils.PrinterUtil;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.FileNotFoundException;

public class QrcodePrinter implements BasePrinter {

  private int pageWidth;

  public QrcodePrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final QrcodeData qrcodeData = (QrcodeData) data;
    try {
      String url = ResourceUtils.getURL("classpath:").getPath().substring(1);
      Image src = PrinterUtil.qrCode(qrcodeData.getText(), url);
      g2.drawImage(src, x + (pageWidth - Const.QRCODE) / 2, y, Const.QRCODE, Const.QRCODE, null);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return y + Const.QRCODE + Const.PADDING;
  }

}
