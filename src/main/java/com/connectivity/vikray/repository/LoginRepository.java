/*package com.connectivity.vikray.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.connectivity.vikray.entity.UserDetails;


public interface LoginRepository extends JpaRepository<UserDetails, Long>{
	
	@Query("select u from UserDetails u where u.userLoginId = :userLoginId")
	public List<UserDetails> doLogin(@Param("userLoginId") String userLoginId);

	// For Security
	
	Optional<UserDetails> findByUserEmail(String userEmail);

	Optional<UserDetails> findByUserLoginIdOrUserEmail(String userLoginId, String userEmail);

	Optional<UserDetails> findByIdIn(Long id);

	Optional<UserDetails> findByUserLoginId(String userLoginId);

	Boolean existsByUserId(String userId);

	Boolean existsByEmail(String email);
	
	Optional<UserDetails> findByforgotPassGuid(String forgotPassword);

	// End of Security
}
*/