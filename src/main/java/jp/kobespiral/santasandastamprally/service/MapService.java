package jp.kobespiral.santasandastamprally.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.santasandastamprally.dto.MapForm;
import jp.kobespiral.santasandastamprally.entity.Map;
import jp.kobespiral.santasandastamprally.repository.MapRepository;

/**
 * マップのCRUDを行うサービス
 */
@Service
public class MapService {
    @Autowired
    MapRepository mapRepo;

    /**
    * マップを作成する (C)
    * @param map
    * @return
    */
    public Map createMap(MapForm mapForm) {
        Map map = mapForm.toEntity();
        return mapRepo.save(map);
    }

    /**
    * マップを取得する (R)
    * @param mapId
    * @return
    */
    public Map getMap(Long mapId) {
        Map map = mapRepo.findById(mapId).orElseThrow();
        return map;
    }

    /**
    * 全マップを取得する (R)
    * @return
    */
    public List<Map> getAllMap(){
        return mapRepo.findAll();
    }

    /**
    * マップを更新する (U)
    * @param map
    * @return
    */
    public Map updateMap(Long mapId, MapForm mapForm){
        Map map = getMap(mapId);
        map.setName(mapForm.getName());
        return mapRepo.save(map);
    }

    /**
    * マップを削除する (D)
    * @param map
    */
    public void deleteMap(Long mapId){
        Map map = getMap(mapId);
        Date date = new Date();
        map.setDeletedAt(date);
        mapRepo.save(map);
    }

}
