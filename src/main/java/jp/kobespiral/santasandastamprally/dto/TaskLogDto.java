package jp.kobespiral.santasandastamprally.dto;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jp.kobespiral.santasandastamprally.entity.TaskLog;
import lombok.Data;

@Data
public class TaskLogDto {
    @NotBlank
    Long taskId;

    @NotBlank
    UUID userId;

    @NotNull
    Boolean isCorrect;

    @NotNull
    String answer;

    public TaskLog toEntity() {
        TaskLog taskLog = new TaskLog();
        taskLog.setTaskId(taskId);
        taskLog.setUserId(userId);
        taskLog.setIsCorrect(isCorrect);
        taskLog.setAnswer(answer);
        taskLog.setCreatedAt(new Date());
        return taskLog;
    }
}
