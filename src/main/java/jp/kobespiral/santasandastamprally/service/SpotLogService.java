package jp.kobespiral.santasandastamprally.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.santasandastamprally.entity.SpotLog;
import jp.kobespiral.santasandastamprally.repository.SpotLogRepository;
import jp.kobespiral.santasandastamprally.dto.SpotLogDto;

@Service
public class SpotLogService {
    @Autowired
    SpotLogRepository spotLogRepository;
    @Autowired
    SpotLogDto spotLogDto;

    /**
     * スポットログを作成する
     * @param spotLogDto
     * @return 
     */
    public SpotLog createSpotLog(SpotLogDto spotLogDto) {
        SpotLog spotLog = spotLogDto.toEntity();
        return spotLogRepository.save(spotLog);
    }

    /**
     * スポットログを取得する
     * @param spotLogId
     * @return 
     */
    public SpotLog getSpotLog(Long spotLogId) {
        return spotLogRepository.findById(spotLogId).orElseThrow();
    }

    /**
     * すべてのスポットログを取得する
     * @return
     */
    public List<SpotLog> getAllSpotLogs() {
        return spotLogRepository.findAll();
    }

    /**
     * 指定したスポットのスポットログを取得する
     * @param spotId
     * @return
     */
    public List<SpotLog> getSpotLogs(Long spotId) {
        return spotLogRepository.findBySpotId(spotId);
    }

    /**
     * 指定したユーザのスポットログを取得する
     * @param spotId
     * @return
     */
    public List<SpotLog> getSpotLogs(UUID userId) {
        return spotLogRepository.findByUserId(userId);
    }

    /**
     * 指定したスポットの，指定したユーザのスポットログを取得する
     * @param spotId
     * @return
     */
    public List<SpotLog> getSpotLogs(Long spotId, UUID userId) {
        return spotLogRepository.findBySpotIdAndUserId(spotId, userId);
    }
}
