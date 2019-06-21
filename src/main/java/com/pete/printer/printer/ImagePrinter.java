package com.pete.printer.printer;

import com.pete.printer.consts.Const;
import com.pete.printer.pojo.BaseData;
import com.pete.printer.pojo.ImageData;
import com.pete.printer.utils.PrinterUtil;
import org.springframework.util.ResourceUtils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.FileNotFoundException;

public class ImagePrinter implements BasePrinter {

  private int pageWidth;

  public ImagePrinter(int pageWidth) {
    this.pageWidth = pageWidth;
  }

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    final ImageData imageData = (ImageData) data;
    try {
      String url = ResourceUtils.getURL("classpath:").getPath().substring(1);
      Image src = PrinterUtil.qrCode(imageData.getText(), url);
      g2.drawImage(src, x + (pageWidth - Const.QRCODE) / 2, y, Const.QRCODE, Const.QRCODE, null);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return y + Const.QRCODE + Const.PADDING;
  }

}
