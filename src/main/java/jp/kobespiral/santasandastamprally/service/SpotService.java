package jp.kobespiral.santasandastamprally.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.santasandastamprally.dto.SpotForm;
import jp.kobespiral.santasandastamprally.entity.Spot;
import jp.kobespiral.santasandastamprally.repository.SpotRepository;

/**
 * スポットのCRUDを行うサービス
 */
@Service
public class SpotService {
    @Autowired
    SpotRepository spotRepository;

    /**
     * スポットを作成する (C)
     *
     * @param spotForm
     * @return
     */
    public Spot createSpot(SpotForm spotForm) {
        Spot spot = spotForm.toEntity();
        return spotRepository.save(spot);
    }

    /**
     * スポットを1つ取得する (R)
     * 
     * @param spotId
     * @return
     */
    public Spot getSpot(Long spotId) {
        return spotRepository.findById(spotId).orElseThrow();
    }

    /**
     * 指定したマップの表示するスポットを取得する (R)
     * 
     * @param mapId
     * @return
     */
    public List<Spot> getEnabledSpotsByMap(Long mapId) {
        return spotRepository.findByMapIdAndIsEnabled(mapId, true);
    }

    /**
     * 指定したマップのすべてのスポットを取得する (R)
     * 
     * @param mapId
     * @return
     */
    public List<Spot> getAllSpotsByMap(Long mapId) {
        return spotRepository.findByMapId(mapId);
    }

    /**
     * すべてのスポットを取得する (R)
     * 
     * @return
     */
    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    /**
     * スポットの情報を更新する (U)
     * 
     * @param adminId
     * @param spotId
     * @param spotForm
     * @return
     */
    public Spot updateSpot(Long adminId, Long spotId, SpotForm spotForm) {
        Spot spot = getSpot(spotId);
        spot.setMapId(spotForm.getMapId());
        spot.setName(spotForm.getName());
        spot.setDescription(spotForm.getDescription());
        spot.setLatitude(spotForm.getLatitude());
        spot.setLongitude(spotForm.getLongitude());
        spot.setImageUrl(spotForm.getImageUrl());
        spot.setUpdatedAt(new Date());
        spot.setUpdatedBy(adminId);
        return spotRepository.save(spot);
    }

    /**
     * スポットの表示/非表示を切り替える (U)
     * 
     * @param spotId
     * @return
     */
    public Spot toggleEnable(Long adminId, Long spotId) {
        Spot spot = getSpot(spotId);
        spot.setIsEnabled(!spot.getIsEnabled());
        spot.setUpdatedAt(new Date());
        spot.setUpdatedBy(adminId);
        return spotRepository.save(spot);
    }

    /**
     * スポットを削除する (D)
     * 
     * @param adminId
     * @param spotId
     * @return
     */
    public Spot deleteSpot(Long adminId, Long spotId) {
        Spot spot = getSpot(spotId);
        spot.setDeletedAt(new Date());
        spot.setDeletedBy(adminId);
        return spotRepository.save(spot);
    }
}
