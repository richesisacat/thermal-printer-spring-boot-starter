package pers.pete.printer.printer;

import pers.pete.printer.pojo.BaseData;

import java.awt.Graphics2D;

public interface BasePrinter {

  int draw(Graphics2D g2, int x, int y, BaseData data);

}
