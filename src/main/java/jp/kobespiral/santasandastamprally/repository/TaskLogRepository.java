package jp.kobespiral.santasandastamprally.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.TaskLog;

/**
 * タスクログのリポジトリ
 */
@Repository
public interface TaskLogRepository extends CrudRepository<TaskLog, Long> {
    // すべてのタスクログを取得
    List<TaskLog> findAll();
    // 指定したタスクの，すべてのタスクログを取得
    List<TaskLog> findByTaskId(Long taskId);
    // 指定したユーザの，すべてのタスクログを取得
    List<TaskLog> findByUserId(UUID userId);
    // 指定したタスクの，指定したユーザのタスクログを取得
    List<TaskLog> findByTaskIdAndUserId(Long taskId, UUID userId);
    // 指定したタスクの，すべての達成したタスクのタスクログを取得
    List<TaskLog> findByTaskIdAndIsCorrect(Long taskId, boolean isCorrect);
    // 指定したユーザの，すべての達成したタスクのタスクログを取得
    List<TaskLog> findByUserIdAndIsCorrect(UUID userId, boolean isCorrect);
    // 指定したタスクの，指定したユーザの達成したタスクのタスクログを取得
    List<TaskLog> findByTaskIdAndUserIdAndIsCorrect(Long taskId, UUID userId, boolean isCorrect);
}
