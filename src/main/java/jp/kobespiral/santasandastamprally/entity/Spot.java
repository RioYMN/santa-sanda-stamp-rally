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
 * スポットのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spot_id", nullable=false)
    Long spotId;   //スポットID

    @Column(name="map_id", nullable=false)
    Long mapId; // マップID

    @Column(name="name", nullable=false)
    String name; // スポット名

    @Column(name="description", nullable=false)
    String description; // 詳細

    @Column(name="latitude", nullable=false)
    double latitude; // スポットの緯度

    @Column(name="longitude", nullable=false)
    double longitude; // スポットの経度

    @Column(name="image_url", nullable=false)
    String imageUrl; // 画像のURL

    @Column(name="is_enabled", nullable=false)
    Boolean isEnabled; // 表示させるかどうか

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