package com.morning.star.retail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "business")
@Component
@Data
public class BusinessRequestProperties {

	private String url;
	private String createGoodsUri;
	private String onOffGoodsUri;

}
