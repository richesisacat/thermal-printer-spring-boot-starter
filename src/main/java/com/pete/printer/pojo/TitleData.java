package com.pete.printer.pojo;

import com.pete.printer.consts.Const;

import java.awt.Font;

/**
 * 默认标题.
 * <p>
 * 超出纸张宽度截断，可指定字号、样式
 *
 * @author Pete.Lee 2019-06-21
 */
public class TitleData extends BaseData {

  private String value;

  private Font font;

  private int size;

  public TitleData(String value) {
    this(value, Font.BOLD, Const.FONTSIZE_12);
  }

  public TitleData(String value, int style, int size) {
    this.value = value;
    this.size = size;
    this.font = new Font(null, style, size);
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
