package org.dlegeza.farmshop.services;

import lombok.RequiredArgsConstructor;
import org.dlegeza.farmshop.entities.Farm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service that provides possibility to re-configure current farm object {@link Farm}
 */
@Service
@RequiredArgsConstructor
public class ReconfigurationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReconfigurationService.class);
    private final FarmService farmService;
    private final StockService stockService;

    /**
     * re-initialize current farm instance and re-calculate stock
     * @param farm
     */
    public void constructNewFarm(final Farm farm) {
        LOGGER.warn("Farm reconstruction initiated");
        this.farmService.setFarm(farm);
        this.stockService.defineStock();
        LOGGER.warn("Farm reconstruction finished");
    }
}
