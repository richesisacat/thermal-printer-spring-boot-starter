package com.pete.printer.service;

import com.pete.printer.pojo.BaseData;
import com.pete.printer.pojo.ImageData;
import com.pete.printer.pojo.LineData;
import com.pete.printer.pojo.RowData;
import com.pete.printer.pojo.TitleData;
import com.pete.printer.consts.Const;
import com.pete.printer.printer.BasePrinter;
import com.pete.printer.printer.Printer;
import org.springframework.stereotype.Service;

import javax.print.PrintService;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonPrinter {

  private Map<String, BasePrinter> printers = new HashMap<>();

  public CommonPrinter() {
    /*this.printers.put(TitleData.class.getName(), new TitlePrinter());
    this.printers.put(LineData.class.getName(), new LinePrinter());
    this.printers.put(RowData.class.getName(), new RowPrinter());
    this.printers.put(ImageData.class.getName(), new ImagePrinter());*/
  }

  public void print() {
    List<BaseData> list = new ArrayList<>();

    try {
      //Book 类提供文档的表示形式，该文档的页面可以使用不同的页面格式和页面 painter
      Book book = new Book(); //要打印的文档

      //PageFormat类描述要打印的页面大小和方向
      PageFormat pf = new PageFormat();  //初始化一个页面打印对象
      pf.setOrientation(PageFormat.PORTRAIT); //设置页面打印方向，从上往下，从左往右

      //设置打印纸页面信息。通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
      Paper paper = new Paper();
      double size = (Const.FONTSIZE_12 + Const.PADDING) * list.size();
      //paper.setSize(Const.PAGESIZE58, size);// 纸张大小
      //paper.setImageableArea(0, 0, Const.PAGESIZE58, size);// A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
      //paper.setSize(Const.PAGESIZE58, 1000);
      //paper.setImageableArea(0, 0, Const.PAGESIZE58, 1000);
      pf.setPaper(paper);

      Printer printer = new Printer(printers, list);
      book.append(printer, pf);

      PrinterJob job = PrinterJob.getPrinterJob();   //获取打印服务对象
      /*PrintService printService = matchPrinter("Grandi");
      try {
        job.setPrintService(printService);
      } catch (PrinterException e) {
        e.printStackTrace();
      }*/
      job.setPageable(book);  //设置打印类

      job.print(); //开始打印
    } catch (PrinterException e) {
      e.printStackTrace();
    }
    /*List<Orders> goods = new ArrayList<Orders>();
    goods.add(new Orders("sendname", "sendtel", "sendaddress", "recname", "rectel",
      "recaddress", "goodstype", 200D));
    SalesTicket stk = new SalesTicket(goods, "源辰信息", "barcode", "3", "38400", "38400", "0");
    YcPrinter p = new YcPrinter(stk);
    p.printer();*/
  }

  private PrintService matchPrinter(String name) {
    PrintService[] printServices = PrinterJob.lookupPrintServices();
    if (printServices == null || printServices.length == 0) {
      System.out.print("打印失败，未找到可用打印机，请检查。");
      return null;
    }
    //匹配指定打印机
    for (int i = 0; i < printServices.length; i++) {
      System.out.println(printServices[i].getName());
      if (printServices[i].getName().contains(name)) {
        return printServices[i];
      }
    }
    return null;
  }

}
