package pers.pete.printer.pojo;

import pers.pete.printer.consts.Const;
import pers.pete.printer.enums.Align;

import java.awt.Font;

/**
 * 普通文本.
 * <p>
 * 超出纸张宽度自动折行，可指定字号、样式、对齐方式
 *
 * @author Pete.Lee 2019-06-21
 * @see Align
 */
public class WordData extends BaseData {

  private String text;

  private Align align;

  private Font font;

  private int size;

  public WordData(String text, Align align) {
    this(text, align, Font.PLAIN, Const.FONTSIZE_10);
  }

  public WordData(String text, Align align, int style, int size) {
    this.text = text;
    this.align = align;
    this.size = size;
    this.font = new Font(null, style, size);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Align getAlign() {
    return align;
  }

  public void setAlign(Align align) {
    this.align = align;
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
