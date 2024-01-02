package com.tickettrackerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tickettrackerapp.entity.Ticket;

@Repository

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

	
	@Query(value = "select * from ticket s where s.title like %:keyword% or s.description like %:keyword%", nativeQuery = true)
	 List<Ticket> findByKeyword(@Param("keyword") String keyword);
	

}
