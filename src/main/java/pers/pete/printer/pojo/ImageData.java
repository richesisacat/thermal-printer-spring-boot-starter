package pers.pete.printer.pojo;

import java.awt.Image;

public class ImageData extends BaseData {

  private Image image;

  public ImageData(Image image) {
    this.image = image;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "ImageData: image";
  }
}
