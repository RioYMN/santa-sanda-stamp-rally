package jp.kobespiral.santasandastamprally.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.Task;

/**
 * タスクのリポジトリ
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    // すべてのタスクを取得
    List<Task> findAll();
    // 指定したスポットの，すべてのタスクを取得
    List<Task> findBySpotId(Long spotId);
    // すべての表示するタスクを取得
    List<Task> findByIsEnabled(boolean isEnabled);
    // 指定したスポットの，すべての表示するタスクを取得
    List<Task> findBySpotIdAndIsEnabled(Long spotId, boolean isEnabled);
}
