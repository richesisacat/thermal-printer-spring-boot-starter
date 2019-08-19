package pers.pete.printer.pojo;


import pers.pete.printer.consts.Const;

import java.awt.Font;

/**
 * 项目.
 * <p>
 * 打印明细.
 *
 * @author Pete.Lee 2019-06-21
 */
public class RowData extends BaseData {

  private String title;

  private String value;

  private Font font;

  private int size;

  public RowData(String title, String value) {
    this(title, value, Font.BOLD, Const.FONTSIZE_10);
  }

  public RowData(String title, String value, int style, int size) {
    this.title = title;
    this.value = value;
    this.font = new Font(null, style, size);
    this.size = size;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(Font font) {
    this.font = font;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
