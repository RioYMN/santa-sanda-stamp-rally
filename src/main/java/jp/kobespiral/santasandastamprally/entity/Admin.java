package jp.kobespiral.santasandastamprally.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理者のエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Column(name="admin_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long adminId;   //管理者ID

    @Column(name="name", nullable=true)
    @NotBlank
    String name; // 名前

    @Column(name="last_login_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date lastLoginAt; // 最終ログイン日時

    @Column(name="created_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt; // 作成日時

    @Column(name="updated_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt; // 最終更新日時

    @Column(name="deleted_at", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    Date deletedAt; // 削除日時

    @Column(name="deleted_by", nullable=true)
    Long deletedBy; // 削除者
}