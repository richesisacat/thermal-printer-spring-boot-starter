package pers.pete.printer.enums;

public enum PaperWidth {

  /*MM58(165),

  MM80(226);
  */

  USERDEFINED(132),

  MM58(132),

  MM80(210);

  private int width;

  private PaperWidth(int width) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }
}
