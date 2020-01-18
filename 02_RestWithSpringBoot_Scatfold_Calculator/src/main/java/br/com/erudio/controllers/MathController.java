package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.numeric.NumericOperations;
import br.com.erudio.numeric.NumericUtil;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value="num1") String num1, @PathVariable(value="num2") String num2) throws Exception {
		if(!(NumericUtil.isNumeric(num1) && NumericUtil.isNumeric(num2))) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.sum(NumericUtil.convertToDouble(num1), NumericUtil.convertToDouble(num2));		
	}
	
	@RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value="num1") String num1, @PathVariable(value="num2") String num2) throws Exception {
		if(!(NumericUtil.isNumeric(num1) && NumericUtil.isNumeric(num2))) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.sub(NumericUtil.convertToDouble(num1), NumericUtil.convertToDouble(num2));
	}
	
	@RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value="num1") String num1, @PathVariable(value="num2") String num2) throws Exception {
		if(!(NumericUtil.isNumeric(num1) && NumericUtil.isNumeric(num2))) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.mult(NumericUtil.convertToDouble(num1), NumericUtil.convertToDouble(num2));		
	}
	
	@RequestMapping(value = "/div/{num1}/{num2}", method = RequestMethod.GET)
	public Double div(@PathVariable(value="num1") String num1, @PathVariable(value="num2") String num2) throws Exception {
		if(!(NumericUtil.isNumeric(num1) && NumericUtil.isNumeric(num2)) || NumericUtil.convertToDouble(num2) == 0.0D ) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.div(NumericUtil.convertToDouble(num1), NumericUtil.convertToDouble(num2));		
	}
	
	@RequestMapping(value = "/avg/{num1}/{num2}", method = RequestMethod.GET)
	public Double avg(@PathVariable(value="num1") String num1, @PathVariable(value="num2") String num2) throws Exception {
		if(!(NumericUtil.isNumeric(num1) && NumericUtil.isNumeric(num2))) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.avg(NumericUtil.convertToDouble(num1), NumericUtil.convertToDouble(num2));		
	}
	
	@RequestMapping(value = "/sqrt/{num1}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value="num1") String num1 ) throws Exception {
		if(!NumericUtil.isNumeric(num1)) {
			throw new UnsuportedMathOperationException("Por favor coloque um valor numerico !!");
		}				
		return NumericOperations.sqrt(NumericUtil.convertToDouble(num1));		
	}
}
