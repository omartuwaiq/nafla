package com.example.eventms.model.Repository;


import com.example.eventms.model.Entities.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events,Integer>{



}
