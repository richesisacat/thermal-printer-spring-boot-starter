package pers.pete.printer.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import pers.pete.printer.service.MatrixToImageWriter;

import javax.imageio.ImageIO;
import javax.print.PrintService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public class PrinterUtil {

  public static PrintService matchPrinter(String name) {
    PrintService[] printServices = PrinterJob.lookupPrintServices();
    if (printServices == null || printServices.length == 0) {
      throw new RuntimeException("无可用打印机");
    }
    for (PrintService printService : printServices) {
      if (printService.getName().contains(name)) {
        return printService;
      }
    }
    throw new RuntimeException("未找到可用打印机" + name + "，请检查配置");
  }

  /*public static double getHeight(List<BaseData> list, int width) {
    double height = 0d;
    double imageSize = width * 3d / 5d;

    for (BaseData d : list) {
      if (d instanceof TitleData) {
        height += Const.FONTSIZE_12 + Const.PADDING;
      } else if (d instanceof LineData) {
        height += Const.FONTSIZE_10 + Const.PADDING;
      } else if (d instanceof RowData) {
        height += Const.FONTSIZE_8 + Const.PADDING;
      } else if (d instanceof ImageData) {
        height += imageSize + Const.PADDING;
      }
    }

    return height + width / 4d;
  }*/

  public static Image qrCode(String text, String path) {
    try {
      int width = 300; // 二维码图片宽度
      int height = 300; // 二维码图片高度
      String format = "jpg";// 二维码的图片格式
      String filename = "tmp.";

      Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
      hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
      hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
      hints.put(EncodeHintType.MARGIN, 0);

      BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

      // 生成二维码
      File outputFile = new File(path + File.separator + filename + format);
      MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

      File file = new File(path + filename + format);
      InputStream is = new FileInputStream(file);
      BufferedImage bi;
      bi = ImageIO.read(is);
      return bi;
    } catch (IOException | WriterException e) {
      e.printStackTrace();
    }
    return null;
  }
}
