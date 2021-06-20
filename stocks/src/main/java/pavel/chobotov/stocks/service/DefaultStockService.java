package pavel.chobotov.stocks.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavel.chobotov.stocks.dto.StockDto;
import pavel.chobotov.stocks.entity.Stock;
import pavel.chobotov.stocks.exceptions.ValidationException;
import pavel.chobotov.stocks.repository.StockRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultStockService implements StockService{

    private final StockRepository stockRepository;
    private final StockConverter stockConverter;

    @Override
    public StockDto saveStock(StockDto stockDto) throws ValidationException {
        validateStockDto(stockDto);
        Stock savedStock = stockRepository.save(stockConverter.fromStockDtoToStock(stockDto));
        return stockConverter.fromStockToStockDto(savedStock);
    }

    private void validateStockDto(StockDto stockDto) throws ValidationException {
        if (isNull(stockDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(stockDto.getName()) || stockDto.getName().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteStock(Integer stockId) {
        stockRepository.deleteById(stockId);
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        Stock savedStock = stockRepository.save(stockConverter.fromStockDtoToStock(stockDto));
        return stockConverter.fromStockToStockDto(savedStock);
    }

    @Override
    public List<StockDto> findAll() {
        return stockRepository.findAll()
                .stream()
                .map(stockConverter::fromStockToStockDto)
                .collect(Collectors.toList());
    }
}
