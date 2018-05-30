package org.dlegeza.farmshop.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.services.FarmService;
import org.dlegeza.farmshop.services.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@ConditionalOnProperty(name = "app.init-data.enabled", havingValue = "true")
@RequiredArgsConstructor
public class DataProvider {
	private static final String INIT_DATA = "init/farm.xml";
	private static final Logger LOGGER = LoggerFactory.getLogger(DataProvider.class);
	private final FarmService farmService;
	private final StockService stockService;

	@PostConstruct
	public void postConstruct() {
		XmlMapper xmlMapper = new XmlMapper();
		try {
			InputStream resourceAsStream = DataProvider.class.getClassLoader().getResourceAsStream(INIT_DATA);
			String xml = inputStreamToString(resourceAsStream);
			final Farm farm = xmlMapper.readValue(xml, Farm.class);
			farmService.setFarm(farm);
			stockService.defineStock();
			LOGGER.info("Setup was successful");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private String inputStreamToString(InputStream stream) throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		}
	}

}
