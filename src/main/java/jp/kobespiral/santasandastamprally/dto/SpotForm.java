package jp.kobespiral.santasandastamprally.dto;

import java.util.Date;

import jp.kobespiral.santasandastamprally.entity.Spot;
import lombok.Data;

/**
 * スポットの登録フォーム
 */
@Data
public class SpotForm {
    Long mapId;
    String name;
    String description;
    double latitude;
    double longitude;
    String imageUrl;
    Long createdBy;

    public Spot toEntity() {
        Spot spot = new Spot();
        Date createdAt = new Date();
        spot.setMapId(mapId);
        spot.setName(name);
        spot.setDescription(description);
        spot.setLatitude(latitude);
        spot.setLongitude(longitude);
        spot.setImageUrl(imageUrl);
        spot.setIsEnabled(true);
        spot.setCreatedAt(createdAt);
        spot.setCreatedBy(createdBy);
        spot.setUpdatedAt(createdAt);
        spot.setUpdatedBy(createdBy);
        spot.setDeletedAt(null);
        spot.setDeletedBy(null);
        return spot;
    }
}
