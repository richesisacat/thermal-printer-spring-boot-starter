package com.pete.printer;

import com.pete.printer.pojo.BaseData;
import com.pete.printer.pojo.ImageData;
import com.pete.printer.pojo.LineData;
import com.pete.printer.pojo.RowData;
import com.pete.printer.pojo.SpaceData;
import com.pete.printer.pojo.TitleData;
import com.pete.printer.pojo.WordData;
import com.pete.printer.printer.BasePrinter;
import com.pete.printer.printer.ImagePrinter;
import com.pete.printer.printer.LinePrinter;
import com.pete.printer.printer.Printer;
import com.pete.printer.printer.RowPrinter;
import com.pete.printer.printer.SpacePrinter;
import com.pete.printer.printer.TitlePrinter;
import com.pete.printer.printer.WordDataPrinter;
import com.pete.printer.utils.PrinterUtil;

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

  private Map<String, BasePrinter> printers = new HashMap<>();

  public ThermalPrinter(int paperWidth) {
    this.width = paperWidth;
    this.printers.put(TitleData.class.getName(), new TitlePrinter(width));
    this.printers.put(LineData.class.getName(), new LinePrinter(width));
    this.printers.put(RowData.class.getName(), new RowPrinter(width));
    this.printers.put(ImageData.class.getName(), new ImagePrinter(width));
    this.printers.put(WordData.class.getName(), new WordDataPrinter(width));
    this.printers.put(SpaceData.class.getName(), new SpacePrinter());
  }

  public ThermalPrinter(int paperWidth, String printerName) {
    this(paperWidth);
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
  }
}
