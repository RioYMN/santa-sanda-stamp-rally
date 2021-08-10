package jp.kobespiral.santasandastamprally.dto;

import jp.kobespiral.santasandastamprally.entity.Map;
import lombok.Data;

@Data
public class MapForm {
    Long mid; //マップID
    String name; //マップ名

    public Map toEntity(){
        Map map = new Map();
        return map;
    }
}
