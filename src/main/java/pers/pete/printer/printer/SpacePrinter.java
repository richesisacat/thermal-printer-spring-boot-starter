package pers.pete.printer.printer;

import pers.pete.printer.consts.Const;
import pers.pete.printer.pojo.BaseData;
import pers.pete.printer.pojo.SpaceData;

import java.awt.Graphics2D;

public class SpacePrinter implements BasePrinter {

  @Override
  public int draw(Graphics2D g2, int x, int y, BaseData data) {
    SpaceData spaceData = (SpaceData) data;
    return y + Const.PADDING + spaceData.getPadding();
  }

}
