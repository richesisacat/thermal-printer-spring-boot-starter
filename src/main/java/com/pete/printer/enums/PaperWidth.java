package com.pete.printer.enums;

public enum PaperWidth {

  /*MM58(165),

  MM80(226);
  */

  USERDEFINED(145),

  MM58(145),

  MM80(200);

  private int width;

  private PaperWidth(int width) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }
}
