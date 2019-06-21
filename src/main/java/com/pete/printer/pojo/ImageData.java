package com.pete.printer.pojo;

public class ImageData extends BaseData {

  private String text;

  public ImageData(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
