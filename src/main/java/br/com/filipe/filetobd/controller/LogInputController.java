package br.com.filipe.filetobd.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipe.filetobd.model.LogInput;
import br.com.filipe.filetobd.service.LogInputService;



@RestController
@RequestMapping("/search")
public class LogInputController {
	
	private LogInputService logInputService;
	
	public LogInputController(LogInputService logInputService) {
		this.logInputService = logInputService;
	}
	
	
	 @GetMapping public List<LogInput> process() throws IOException { 
		
		 return logInputService.process(); }
	 

}
