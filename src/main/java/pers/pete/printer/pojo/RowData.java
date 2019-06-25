package pers.pete.printer.pojo;


/**
 * 项目.
 * <p>
 * 打印明细.
 *
 * @author Pete.Lee 2019-06-21
 */
public class RowData extends BaseData {

  private String title;

  private String value;

  public RowData(String title, String value) {
    this.title = title;
    this.value = value;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
