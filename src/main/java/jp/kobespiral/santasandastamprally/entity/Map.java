package jp.kobespiral.santasandastamprally.entity;

import java.util.Date;

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
 * マップのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="map_id", nullable=false)
    Long mapId;   //マップID

    @Column(name="name", nullable=false)
    String name; // マップ名

    @Column(name="description", nullable=false)
    String description; // 詳細

    @Column(name="clear_point", nullable=false)
    int clearPoint; // クリアに必要なポイント

    @Column(name="range_limit", nullable=false)
    double rangeLimit; // 位置情報の誤差

    @Column(name="present_url", nullable=false)
    String presentURL; // プレゼント応募ページのURL

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable=false)
    Date startDate; // イベントの開始日時

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date", nullable=false)
    Date endDate; // イベントの終了日時

    @Column(name="is_enabled", nullable=false)
    boolean isEnabled; // 表示させるかどうか

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    Date createdAt; // 作成日時

    @Column(name="created_by", nullable=true)
    Long createdBy; // 作成者

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    Date updatedAt; // 最終更新日時

    @Column(name="updated_by", nullable=true)
    Long updatedBy; // 最終更新者

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at", nullable=true)
    Date deletedAt; // 削除日時

    @Column(name="deleted_by", nullable=true)
    Long deletedBy; // 削除者
}