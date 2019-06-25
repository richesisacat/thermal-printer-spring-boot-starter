package pers.pete.printer;

import pers.pete.printer.enums.PaperWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
  public ThermalPrinter init() {
    if (PaperWidth.USERDEFINED.equals(properties.getPaperWidth())) {
      if (null == properties.getUserDefinedWidth()) {
        throw new RuntimeException("properties file userDefinedWidth is null!");
      }
      return new ThermalPrinter(properties.getUserDefinedWidth(), properties.getPrinterName());
    } else {
      return new ThermalPrinter(properties.getPaperWidth().getWidth(), properties.getPrinterName());
    }
  }

}
