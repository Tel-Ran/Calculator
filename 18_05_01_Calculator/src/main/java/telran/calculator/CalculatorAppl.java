package telran.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.calculator.dto.CalculateData;

import java.util.*;
@SpringBootApplication
@RestController
public class CalculatorAppl {
	@Value("${param}")
	int param;
	Calculator calculator=new Calculator();
@RequestMapping(value="operations")
	Set<String> getOperations(){
	return calculator.getOperations();
}
@RequestMapping(value="/")
int getStarted() {
	return param;
}

@PostMapping(value="calculate")
int getResult(@RequestBody CalculateData data){
	return calculator.getResult(data.operation,
			data.op1, data.op2);
}
	public static void main(String[] args) {
		SpringApplication.run(CalculatorAppl.class, args);

	}

}
