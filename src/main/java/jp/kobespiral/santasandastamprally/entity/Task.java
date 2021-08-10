package jp.kobespiral.santasandastamprally.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * タスクのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id", nullable=false)
    Long taskId; // タスクID

    @Column(name="spot_id", nullable=false)
    Long spotId; // スポットID

    @Min(0)
    @Max(2)
    @Column(name="type", nullable=false)
    int type; // タスクの種類 (0:クイズ，1:謎解き，2:立ち寄り)

    @Column(name="title", nullable=false)
    String title; // タイトル

    @Column(name="description", nullable=false)
    String description; // 詳細

    @Column(name="image_url", nullable=false)
    String imageUrl; // 画像のURL

    @Column(name="answer", nullable=true)
    String answer; // 答え

    @Column(name="explanation", nullable=true)
    String explanation; // 解説

    @Column(name="hint", nullable=true)
    String hint; // ヒント

    @Column(name="option1", nullable=true)
    String option1; // 選択肢1

    @Column(name="option2", nullable=true)
    String option2; // 選択肢2

    @Column(name="option3", nullable=true)
    String option3; // 選択肢3

    @Column(name="is_enabled", nullable=false)
    boolean isEnabled; // 表示させるかどうか

    @Column(name="created_at", nullable=false)
    Date createdAt; // 作成日時

    @Column(name="created_by", nullable=true)
    Long createdBy; // 作成者
    
    @Column(name="updated_at", nullable=false)
    Date updatedAt; // 最終更新日時

    @Column(name="updated_by", nullable=true)
    Long updatedBy; // 最終更新者

    @Column(name="deleted_at", nullable=true)
    Date deletedAt; // 削除日時

    @Column(name="deleted_by", nullable=true)
    Long deletedBy; // 削除者
}