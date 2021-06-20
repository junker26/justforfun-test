package pavel.chobotov.stocks.service;

import pavel.chobotov.stocks.dto.StockDto;
import pavel.chobotov.stocks.exceptions.ValidationException;

import java.util.List;

public interface StockService {
    StockDto saveStock(StockDto stockDto) throws ValidationException;

    void deleteStock(Integer stockId);

    StockDto updateStock(StockDto stockDto);

    List<StockDto> findAll();
}
