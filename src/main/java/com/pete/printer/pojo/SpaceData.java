package com.pete.printer.pojo;

import com.pete.printer.consts.Const;

public class SpaceData extends BaseData {

  private int padding;

  public SpaceData() {
    this(Const.PADDING);
  }

  public SpaceData(int padding) {
    this.padding = padding;
  }

  public int getPadding() {
    return padding;
  }

  public void setPadding(int padding) {
    this.padding = padding;
  }
}
