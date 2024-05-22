package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {


   //sélectionner distinctement les sujets des questions de la base de données
    @Query("SELECT DISTINCT q.subject FROM Question q")
    List<String> findDistinctSubject();

    //recherche les questions dans la base de données qui ont un sujet donné
    List<Question> findBySubject(@Param("subject") String subject);

    //la pagination des résultats
    Page<Question> findBySubject(String subject, Pageable pageable);
}
