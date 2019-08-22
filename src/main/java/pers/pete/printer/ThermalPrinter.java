package pers.pete.printer;

import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.ImageData;
import pers.pete.printer.pojo.LineData;
import pers.pete.printer.pojo.QrcodeData;
import pers.pete.printer.pojo.RowData;
import pers.pete.printer.pojo.SpaceData;
import pers.pete.printer.pojo.TitleData;
import pers.pete.printer.pojo.WordData;
import pers.pete.printer.printer.BasePrinter;
import pers.pete.printer.printer.ImagePrinter;
import pers.pete.printer.printer.LinePrinter;
import pers.pete.printer.printer.Printer;
import pers.pete.printer.printer.QrcodePrinter;
import pers.pete.printer.printer.RowPrinter;
import pers.pete.printer.printer.SpacePrinter;
import pers.pete.printer.printer.TitlePrinter;
import pers.pete.printer.printer.WordDataPrinter;
import pers.pete.printer.utils.PrinterUtil;

import javax.print.PrintService;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThermalPrinter {

  private int width;

  private String printerName;

  private boolean showLog;

  private Map<String, BasePrinter> printers = new HashMap<>();

  public ThermalPrinter(int paperWidth, boolean showLog) {
    this.width = paperWidth;
    this.showLog = showLog;
    this.printers.put(TitleData.class.getName(), new TitlePrinter(width));
    this.printers.put(LineData.class.getName(), new LinePrinter(width));
    this.printers.put(RowData.class.getName(), new RowPrinter(width));
    this.printers.put(ImageData.class.getName(), new ImagePrinter(width));
    this.printers.put(QrcodeData.class.getName(), new QrcodePrinter(width));
    this.printers.put(WordData.class.getName(), new WordDataPrinter(width));
    this.printers.put(SpaceData.class.getName(), new SpacePrinter());
  }

  public ThermalPrinter(int paperWidth, boolean showLog, String printerName) {
    this(paperWidth, showLog);
    this.printerName = printerName;
  }

  public void print(List<BaseData> list) throws PrinterException {
    final PageFormat pf = new PageFormat();
    pf.setOrientation(PageFormat.PORTRAIT);

    final Paper paper = new Paper();
    double height = 3200d;
    //PrinterUtil.getHeight(list, width);
    paper.setSize(width, height);
    paper.setImageableArea(0, 0, width, height);
    pf.setPaper(paper);

    final Book book = new Book();
    final Printer printer = new Printer(printers, list);
    book.append(printer, pf);

    final PrinterJob job = PrinterJob.getPrinterJob();
    job.setPageable(book);
    if (null != printerName) {
      final PrintService printService = PrinterUtil.matchPrinter(printerName);
      try {
        job.setPrintService(printService);
      } catch (PrinterException e) {
        e.printStackTrace();
      }
    }
    job.print();
    if (showLog) {
      for (BaseData aList : list) {
        System.out.println("p -> " + aList.toString());
      }
    }
  }
}
