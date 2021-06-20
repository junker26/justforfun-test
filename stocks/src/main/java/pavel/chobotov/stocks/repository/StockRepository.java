package pavel.chobotov.stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavel.chobotov.stocks.dto.StockDto;
import pavel.chobotov.stocks.entity.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
