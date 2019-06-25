package pers.pete.printer.pojo;

import pers.pete.printer.consts.Const;

import java.awt.Font;

/**
 * 线.
 * <p>
 * 虚线、实现，线中带文字.
 *
 * @author Pete.Lee 2019-06-21
 */
public class LineData extends BaseData {

  // 线的标题
  private String value;

  // 是否实线
  private boolean fullLine;

  private Font font;

  public LineData() {
    this(false);
  }

  public LineData(boolean fullLine) {
    this(null, fullLine);
  }

  public LineData(String value, boolean fullLine) {
    this(value, fullLine, Font.PLAIN, Const.FONTSIZE_10);
  }

  public LineData(String value, boolean fullLine, int style, int size) {
    this.value = value;
    this.fullLine = fullLine;
    this.font = new Font(null, style, size);
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public boolean isFullLine() {
    return fullLine;
  }

  public void setFullLine(boolean fullLine) {
    this.fullLine = fullLine;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(Font font) {
    this.font = font;
  }
}
