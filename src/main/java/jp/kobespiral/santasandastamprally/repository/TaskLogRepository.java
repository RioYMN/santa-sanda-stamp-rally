package jp.kobespiral.santasandastamprally.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.santasandastamprally.entity.TaskLog;

@Repository
public interface TaskLogRepository extends CrudRepository<TaskLog, Long> {
    // すべてのタスクログを取得
    List<TaskLog> findAll();
    // 指定したタスクの，すべてのタスクログを取得
    List<TaskLog> findByTaskId(Long taskId);
    // 指定したユーザの，すべてのタスクログを取得
    List<TaskLog> findByUserId(UUID userId);
    // 指定したユーザの，すべての達成したタスクのタスクログを取得
    List<TaskLog> findByUserIdAndIsCorrect(UUID userId, boolean isCorrect);
}
