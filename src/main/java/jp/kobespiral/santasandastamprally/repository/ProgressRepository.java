package jp.kobespiral.santasandastamprally.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.Progress;

/**
 * 進捗のリポジトリ
 */
@Repository
public interface ProgressRepository extends CrudRepository<Progress, Long> {
    // すべての進捗を取得
    List<Progress> findAll();
    // 指定したユーザの，すべての進捗を取得
    List<Progress> findByUserId(UUID userId);
    // 指定したマップの，すべての進捗を取得
    List<Progress> findByMapId(Long MapId);
}
