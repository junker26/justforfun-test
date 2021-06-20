package pavel.chobotov.stocks.service;

import org.springframework.stereotype.Component;
import pavel.chobotov.stocks.dto.StockDto;
import pavel.chobotov.stocks.entity.Stock;

@Component
public class StockConverter {

    public Stock fromStockDtoToStock(StockDto stockDto){
        Stock stock = new Stock();
        stock.setId(stockDto.getId());
        stock.setDate(stockDto.getDate());
        stock.setName(stockDto.getName());
        stock.setCost(stockDto.getCost());
        return stock;
    }

    public StockDto fromStockToStockDto(Stock stock){
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setDate(stock.getDate());
        stockDto.setName(stock.getName());
        stockDto.setCost(stock.getCost());
        return stockDto;
    }
}
