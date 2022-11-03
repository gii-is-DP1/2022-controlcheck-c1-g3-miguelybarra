package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
	@Query("SELECT r FROM RecoveryRoom r")
	List<RecoveryRoom> findAll();
    @Query("SELECT r FROM RecoveryRoom r WHERE r.id=?1")
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    @Query("SELECT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    @Query("SELECT rt FROM RecoveryRoomType rt WHERE rt.name=?1")
    RecoveryRoomType getRecoveryRoomType(String name);
}
