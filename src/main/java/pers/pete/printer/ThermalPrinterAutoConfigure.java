package pers.pete.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import pers.pete.printer.enums.PaperWidth;

@Configuration
@ConditionalOnClass(ThermalPrinter.class)
@EnableConfigurationProperties(ThermalPrinterProperties.class)
public class ThermalPrinterAutoConfigure {

  private ThermalPrinterProperties properties;

  @Autowired
  public ThermalPrinterAutoConfigure(ThermalPrinterProperties properties) {
    this.properties = properties;
  }

  @Bean
  @ConditionalOnMissingBean
  public ThermalPrinter thermalPrinter() {
    if (PaperWidth.USERDEFINED.equals(properties.getPaperWidth())) {
      if (null == properties.getUserDefinedWidth()) {
        throw new RuntimeException("properties file userDefinedWidth is null!");
      }
      return factory(properties.getUserDefinedWidth(), properties.isShowLog(), properties.getPrinterName());
    } else {
      return factory(properties.getPaperWidth().getWidth(), properties.isShowLog(), properties.getPrinterName());
    }
  }

  private ThermalPrinter factory(int paperWidth, boolean showLog, String printerName) {
    if (StringUtils.isEmpty(printerName)) {
      return new ThermalPrinter(paperWidth, showLog);
    } else {
      return new ThermalPrinter(paperWidth, showLog, printerName);
    }
  }
}
