package pavel.chobotov.stocks.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pavel.chobotov.stocks.dto.StockDto;
import pavel.chobotov.stocks.exceptions.ValidationException;
import pavel.chobotov.stocks.service.StockService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
@Log
@CrossOrigin
public class StockController {

    private final StockService stockService;

    @PostMapping("/save")
    public StockDto saveStocks(@RequestBody StockDto stockDto) throws ValidationException{
        log.info("Save stock: " + stockDto);
        return stockService.saveStock(stockDto);
    }
    @Modifying
    @PutMapping("/update")
    public StockDto updateStock(@RequestBody StockDto stockUpd){
        log.info("Update stock: " + stockUpd);
        return stockService.updateStock(stockUpd);
    }
    @GetMapping("/findAll")
    public List<StockDto> findAllStocks(){
        log.info("Find all stocks request");
        return stockService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Integer id){
        log.info("Delete user request: " + id);
        stockService.deleteStock(id);
        return ResponseEntity.ok().build();
    }

}
