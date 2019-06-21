package com.pete.printer.pojo;

import java.io.Serializable;

public class Orders implements Serializable {

  private static final long serialVersionUID = -560708444936642252L;

  /**
   * id
   */
  private Integer id;

  /**
   * 寄件人姓名
   */
  private String sendname;

  /**
   * 寄件人电话
   */
  private String sendtel;

  /**
   * 寄件人地址
   */
  private String sendaddress;

  /**
   * 收件人姓名
   */
  private String recname;

  /**
   * 收件人电话
   */
  private String rectel;

  /**
   * 收件人地址
   */
  private String recaddress;

  /**
   * 收件人邮编
   */
  private String reccode;

  /**
   * 订单日期
   */
  private Long orderstime;

  /**
   * 商品类型
   */
  private String goodstype;

  /**
   * 重量 (kg)
   */
  private Double weight;

  /**
   * 体积 (m^3)
   */
  private Double volume;

  /**
   * 配送费
   */
  private Double price;

  /**
   * 报价金额
   */
  private Double insureprice;

  /**
   * 订单类型(0快件, 1慢件,  2大宗)
   */
  private Integer orderstype;

  /**
   * 订单状态 (0未发件, 1已发件, 2已送达,3 已取消,4 正在排件(备用属性，不一定使用), 100前台下单)
   */
  private Integer status;

  /**
   * 条形码编码
   */
  private Long barcode;

  /**
   * 条形码图片
   */
  private String barpic;

  /**
   * 预计到达时间
   */
  private Long endtime;

  /**
   * 配送点姓名
   */
  private String recspname;

  /**
   * 备注
   */
  private String remark;

  /**
   * 客户信息(Id)
   */

  private Integer usid;

  /**
   * 代理点(PID)
   */

  private Integer pid;

  /**
   * 系统管理员id
   */
  private Integer sysid;

  /**
   * 路线(rid)
   */

  private Integer rid;

  /**
   * 凭证，图片
   */
  private String url;

  /**
   * 4个备用字段
   */

  /**
   * 付款方式
   */
  private String res1;

  private String res2;

  private String res3;

  private String res4;

  /**
   * 路线名称
   */
  private String rname;

  /**
   * 路线地址
   */
  private String raddr;

  public Orders() {
    super();
  }

  public Orders(String sendname, String sendtel, String sendaddress, String recname, String rectel, String recaddress, String goodstype, Double price) {
    super();
    this.sendname = sendname;
    this.sendtel = sendtel;
    this.sendaddress = sendaddress;
    this.recname = recname;
    this.rectel = rectel;
    this.recaddress = recaddress;
    this.goodstype = goodstype;
    this.price = price;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSendname() {
    return sendname;
  }

  public void setSendname(String sendname) {
    this.sendname = sendname;
  }

  public String getSendtel() {
    return sendtel;
  }

  public void setSendtel(String sendtel) {
    this.sendtel = sendtel;
  }

  public String getSendaddress() {
    return sendaddress;
  }

  public void setSendaddress(String sendaddress) {
    this.sendaddress = sendaddress;
  }

  public String getRecname() {
    return recname;
  }

  public void setRecname(String recname) {
    this.recname = recname;
  }

  public String getRectel() {
    return rectel;
  }

  public void setRectel(String rectel) {
    this.rectel = rectel;
  }

  public String getRecaddress() {
    return recaddress;
  }

  public void setRecaddress(String recaddress) {
    this.recaddress = recaddress;
  }

  public String getReccode() {
    return reccode;
  }

  public void setReccode(String reccode) {
    this.reccode = reccode;
  }

  public Long getOrderstime() {
    return orderstime;
  }

  public void setOrderstime(Long orderstime) {
    this.orderstime = orderstime;
  }

  public String getGoodstype() {
    return goodstype;
  }

  public void setGoodstype(String goodstype) {
    this.goodstype = goodstype;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getInsureprice() {
    return insureprice;
  }

  public void setInsureprice(Double insureprice) {
    this.insureprice = insureprice;
  }

  public Integer getOrderstype() {
    return orderstype;
  }

  public void setOrderstype(Integer orderstype) {
    this.orderstype = orderstype;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Long getBarcode() {
    return barcode;
  }

  public void setBarcode(Long barcode) {
    this.barcode = barcode;
  }

  public String getBarpic() {
    return barpic;
  }

  public void setBarpic(String barpic) {
    this.barpic = barpic;
  }

  public Long getEndtime() {
    return endtime;
  }

  public void setEndtime(Long endtime) {
    this.endtime = endtime;
  }

  public String getRecspname() {
    return recspname;
  }

  public void setRecspname(String recspname) {
    this.recspname = recspname;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getUsid() {
    return usid;
  }

  public void setUsid(Integer usid) {
    this.usid = usid;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getSysid() {
    return sysid;
  }

  public void setSysid(Integer sysid) {
    this.sysid = sysid;
  }

  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getRes1() {
    return res1;
  }

  public void setRes1(String res1) {
    this.res1 = res1;
  }

  public String getRes2() {
    return res2;
  }

  public void setRes2(String res2) {
    this.res2 = res2;
  }

  public String getRes3() {
    return res3;
  }

  public void setRes3(String res3) {
    this.res3 = res3;
  }

  public String getRes4() {
    return res4;
  }

  public void setRes4(String res4) {
    this.res4 = res4;
  }

  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

  public String getRaddr() {
    return raddr;
  }

  public void setRaddr(String raddr) {
    this.raddr = raddr;
  }
}
