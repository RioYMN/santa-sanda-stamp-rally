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
 * 進捗のエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="progress_id", nullable=false)
    Long progressId; //進捗ID

    @Column(name="map_id", nullable=false)
    Long mapId; // マップID

    @Column(name="user_id", nullable=false)
    UUID userId; // ユーザID

    @Column(name="score", nullable=false)
    int score; // スコア

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    Date createdAt; // 作成日時

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    Date updatedAt; // 最終更新日時

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at", nullable=true)
    Date deletedAt; // 削除日時

    @Column(name="deleted_by", nullable=true)
    Date deletedBy; // 削除者
}