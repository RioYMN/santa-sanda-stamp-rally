package jp.kobespiral.santasandastamprally.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.Admin;

/**
 * 管理者のリポジトリ
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    // すべての管理者を取得
    List<Admin> findAll();
}
