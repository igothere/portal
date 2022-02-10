package com.hamonize.portal.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByUserid(String userid);
    public User findByUsername(String username);
    public Optional<User> findByEmail(String email);
    
    @Modifying
    @Query(
        value = "UPDATE tbl_admin_user SET domain = :domain WHERE user_id = :userid " , nativeQuery = true
    )
    void updateDomain(@Param("domain") String domain, @Param("userid") String userid);
      
}
