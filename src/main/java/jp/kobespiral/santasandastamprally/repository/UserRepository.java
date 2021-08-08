package jp.kobespiral.santasandastamprally.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    // すべてのユーザを取得
    List<User> findAll();
}
