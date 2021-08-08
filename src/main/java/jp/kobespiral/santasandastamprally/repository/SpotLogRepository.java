package jp.kobespiral.santasandastamprally.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.SpotLog;

@Repository
public interface SpotLogRepository extends CrudRepository<SpotLog, Long> {
    // すべてのスポットログを取得
    List<SpotLog> findAll();
    // 指定したスポットの，すべてのスポットログを取得
    List<SpotLog> findBySpotId(Long spotId);
    // 指定したユーザの，すべてのスポットログを取得
    List<SpotLog> findByUserId(UUID userId);
}
