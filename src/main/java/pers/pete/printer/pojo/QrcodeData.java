package pers.pete.printer.pojo;

public class QrcodeData extends BaseData {

  private String text;

  public QrcodeData(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "QrcodeData: " +
      "text='" + text + '\'';
  }
}