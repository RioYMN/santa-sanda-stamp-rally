package jp.kobespiral.santasandastamprally.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * タスクログのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_log_id", nullable = false)
    Long taskLogId; // タスクログID

    @Column(name = "task_id", nullable = false)
    Long taskId; // タスクID

    @Column(name = "user_id", nullable = false)
    UUID userId; // ユーザID
    
    @Column(name = "is_correct", nullable = false)
    Boolean isCorrect; // 正解フラグ

    @Column(name = "answer", nullable = true)
    String answer; // 回答

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt; // 作成日時
}
