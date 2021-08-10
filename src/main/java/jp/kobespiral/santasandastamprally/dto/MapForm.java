package jp.kobespiral.santasandastamprally.dto;

import java.util.Date;

import jp.kobespiral.santasandastamprally.entity.Map;
import lombok.Data;

@Data
public class MapForm {
    String name; //マップ名
    String description; // 詳細
    int clearPoint; // クリアに必要なポイント
    double rangeLimit; // 位置情報の誤差
    String presentURL; // プレゼント応募ページのURL
    Date startDate; // イベントの開始日時
    Date endDate; // イベントの終了日時
    Boolean isEnabled; // 表示させるかどうか

    public Map toEntity(){
        Map map = new Map();
        map.setName(name);
        map.setDescription(description);
        map.setClearPoint(clearPoint);
        map.setRangeLimit(rangeLimit);
        map.setPresentURL(presentURL);
        map.setStartDate(startDate);
        map.setEndDate(endDate);
        map.setIsEnabled(isEnabled);
        Date date = new Date();
        map.setCreatedAt(date);
        map.setUpdatedAt(date);

        return map;
    }
}
