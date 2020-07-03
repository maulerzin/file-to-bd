package br.com.filipe.filetobd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.filipe.filetobd.model.LogInput;

@Repository
public interface LogInputRepo extends JpaRepository<LogInput, Long> {

}
