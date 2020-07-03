package br.com.filipe.filetobd.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import br.com.filipe.filetobd.model.LogInput;
import br.com.filipe.filetobd.repository.LogInputRepo;

@Service
public class LogInputService {
	
	@Autowired
	private LogInputRepo logInputRepo;
	
	@Value("file:C:/Users/maule/Desktop/loader/access.log")

	Resource resourceFile;

	public List<String> read() throws IOException {
		File resource = resourceFile.getFile();
		List<String> list = Files.readAllLines(Paths.get(String.valueOf(resource)));
		return list;
	}

	public List<LogInput> toBd(List<String> file) {
		List<LogInput> logs = new ArrayList<>();

		for (int i = 0; i < file.size(); i++) {
			LogInput logInput = LogInput.builder().build();
			String[] l = file.get(i).split("\\|");

			try {
				logInput = LogInput.builder().date(l[0]).
						ip(l[1])
						.httpMethod(l[2])
						.responseStatus(l[3])
						.browser(l[4])
						.build();
			} catch (ArrayIndexOutOfBoundsException e) {

			}

			logs.add(logInput);

		}

		return logs;

	}

	public List<LogInput> process() throws IOException {
		List<String> read = read();
		List<LogInput> logs = toBd(read);
		//System.out.println(logs.size());
		logInputRepo.saveAll(logs);
		return logs;

	}
}
