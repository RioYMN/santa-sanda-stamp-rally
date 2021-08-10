package jp.kobespiral.santasandastamprally.dto;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import jp.kobespiral.santasandastamprally.entity.SpotLog;
import lombok.Data;

@Data
public class SpotLogDto {
    @NotBlank
    Long spotId;

    @NotBlank
    UUID userId;

    public SpotLog toEntity() {
        SpotLog spotLog = new SpotLog();
        spotLog.setSpotId(spotId);
        spotLog.setUserId(userId);
        spotLog.setCreatedAt(new Date());
        return spotLog;
    }
}
