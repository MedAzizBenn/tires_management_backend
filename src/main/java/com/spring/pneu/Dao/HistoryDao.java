package com.spring.pneu.Dao;

import com.spring.pneu.entity.History;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao extends JpaRepository<History,Integer> {
    @Query(
            value = "SELECT * FROM historique h WHERE h.user_id = :id order by date desc ,time desc",
            nativeQuery = true)
    public List<History> findByUserId(@Param("id") int id);

    @Modifying
    @Query(
            value = "insert into historique (`user_id`,`function`,`date`,`time`,`matricule_piece`) values(:id,'update',:date,:time,:matricule)",
            nativeQuery = true)
    public void saveUpdate(@Param("id") int id,@Param("date") String date,@Param("time") String time,@Param("matricule") String matricule);

    @Modifying
    @Query(
            value = "insert into historique (`user_id`,`function`,`date`,`time`,`matricule_piece`) values(:id,'delete',:date,:time,:matricule)",
            nativeQuery = true)
    public void saveDelete(@Param("id") int id,@Param("date") String date,@Param("time") String time,@Param("matricule") String matricule);

    @Modifying
    @Query(
            value = "insert into historique (`user_id`,`function`,`date`,`time`,`matricule_piece`) values(:id,'insert',:date,:time,:matricule)",
            nativeQuery = true)
    public void saveInsert(@Param("id") int id,@Param("date") String date,@Param("time") String time,@Param("matricule") String matricule);
}
