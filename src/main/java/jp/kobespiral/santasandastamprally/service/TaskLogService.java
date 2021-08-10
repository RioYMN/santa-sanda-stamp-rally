package jp.kobespiral.santasandastamprally.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.santasandastamprally.entity.TaskLog;
import jp.kobespiral.santasandastamprally.repository.TaskLogRepository;
import jp.kobespiral.santasandastamprally.dto.TaskLogDto;

@Service
public class TaskLogService {
    @Autowired
    TaskLogRepository taskLogRepository;
    @Autowired
    TaskLogDto taskLogDto;

    /**
     * タスクログを作成する
     * @param taskLogDto
     * @return 
     */
    public TaskLog createTaskLog(TaskLogDto taskLogDto) {
        TaskLog taskLog = taskLogDto.toEntity();
        return taskLogRepository.save(taskLog);
    }

    /**
     * タスクログを取得する
     * @param taskLogId
     * @return 
     */
    public TaskLog getTaskLog(Long taskLogId) {
        return taskLogRepository.findById(taskLogId).orElseThrow();
    }

    /**
     * すべてのタスクログを取得する
     * @return
     */
    public List<TaskLog> getAllTaskLogs() {
        return taskLogRepository.findAll();
    }

    /**
     * 指定したタスクのタスクログを取得する
     * @param taskId
     * @return
     */
    public List<TaskLog> getTaskLogs(Long taskId) {
        return taskLogRepository.findByTaskId(taskId);
    }

    /**
     * 指定したユーザのタスクログを取得する
     * @param userId
     * @return
     */
    public List<TaskLog> getTaskLogs(UUID userId) {
        return taskLogRepository.findByUserId(userId);
    }

    /**
     * 指定したタスクの，指定したユーザのタスクログを取得する
     * @param taskId
     * @param userId
     * @return
     */
    public List<TaskLog> getTaskLogs(Long taskId, UUID userId) {
        return taskLogRepository.findByTaskIdAndUserId(taskId, userId);
    }

    /**
     * 指定したタスクの，正解したタスクのタスクログを取得する
     * @param taskId
     * @return
     */
    public List<TaskLog> getCorrectTaskLogs(Long taskId) {
        return taskLogRepository.findByTaskIdAndIsCorrect(taskId, true);
    }

    /**
     * 指定したユーザの，達成したタスクのタスクログを取得する
     * @param userId
     * @return
     */
    public List<TaskLog> getCorrectTaskLogs(UUID userId) {
        return taskLogRepository.findByUserIdAndIsCorrect(userId, true);
    }

    /**
     * 指定したタスクの，指定したユーザの達成したタスクのタスクログを取得する
     * @param userId
     * @return
     */
    public List<TaskLog> getCorrectTaskLogs(Long taskId, UUID userId) {
        return taskLogRepository.findByTaskIdAndUserIdAndIsCorrect(taskId, userId, true);
    }
}
