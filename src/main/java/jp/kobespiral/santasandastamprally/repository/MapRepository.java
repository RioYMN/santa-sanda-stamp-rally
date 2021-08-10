package jp.kobespiral.santasandastamprally.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.Map;

/**
 * マップのリポジトリ
 */
@Repository
public interface MapRepository extends CrudRepository<Map, Long> {
    // すべてのマップを取得
    List<Map> findAll();
    // すべての表示するマップを取得
    List<Map> findByIsEnabled(boolean isEnabled);
}