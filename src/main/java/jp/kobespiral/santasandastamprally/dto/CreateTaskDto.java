package jp.kobespiral.santasandastamprally.dto;

import jp.kobespiral.santasandastamprally.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * TODO：属性の追加とtoEntityの実装
 */
public class CreateTaskDto {
    Long spotId;

    public Task toEntity() {
        Task task = new Task();
        return task;
    }
}
