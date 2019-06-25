package pers.pete.printer;

import pers.pete.printer.enums.PaperWidth;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("thermal.printer")
public class ThermalPrinterProperties {

  /**
   * 热敏纸宽,单位毫米.
   * <p>
   * 常见的规格有 58 78 80
   */
  private PaperWidth paperWidth;

  /**
   * 用户自定义热敏纸宽度,单位毫米
   */
  private Integer userDefinedWidth;

  /**
   * 打印机名称,不写为默认打印机.
   */
  private String printerName;

  public PaperWidth getPaperWidth() {
    return paperWidth;
  }

  public void setPaperWidth(PaperWidth paperWidth) {
    this.paperWidth = paperWidth;
  }

  public String getPrinterName() {
    return printerName;
  }

  public void setPrinterName(String printerName) {
    this.printerName = printerName;
  }

  public Integer getUserDefinedWidth() {
    return userDefinedWidth;
  }

  public void setUserDefinedWidth(Integer userDefinedWidth) {
    this.userDefinedWidth = userDefinedWidth;
  }
}
