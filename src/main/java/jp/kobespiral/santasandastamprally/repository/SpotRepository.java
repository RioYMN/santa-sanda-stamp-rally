package jp.kobespiral.santasandastamprally.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.Spot;

/**
 * スポットのリポジトリ
 */
@Repository
public interface SpotRepository extends CrudRepository<Spot, Long> {
    // すべてのスポットを取得
    List<Spot> findAll();
    // 指定したマップの，すべてのスポットを取得
    List<Spot> findByMapId(Long mapId);
    // すべての表示するスポットを取得
    List<Spot> findByIsEnabled(boolean isEnabled);
    // 指定したマップの，すべての表示するスポットを取得
    List<Spot> findByMapIdAndIsEnabled(Long mapId, boolean isEnabled);
}
