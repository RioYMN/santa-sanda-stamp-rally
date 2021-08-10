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
 * スポットログのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SpotLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spot_log_id", nullable=false)
    Long spotLogId; //スポットログID

    @Column(name="spot_id", nullable=false)
    Long spotId; // スポットID

    @Column(name="user_id", nullable=false)
    UUID userId; // ユーザID

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    Date createdAt; // 作成日時
}