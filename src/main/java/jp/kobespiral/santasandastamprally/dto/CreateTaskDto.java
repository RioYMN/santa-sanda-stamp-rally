package jp.kobespiral.santasandastamprally.dto;

import java.util.Date;

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
    int type;
    String title;
    String description;
    String imageUrl;
    String answer;
    String explanation;
    String hint;
    String option1;
    String option2;
    String option3;
    Boolean isEnabled;
    Long createdBy;
    Long updatedBy;

    public Task toEntity() {
        Task task = new Task();
        task.setSpotId(spotId);
        task.setType(type);
        task.setTitle(title);
        task.setDescription(description);
        task.setImageUrl(imageUrl);
        task.setAnswer(answer);
        task.setExplanation(explanation);
        task.setHint(hint);
        task.setOption1(option1);
        task.setOption2(option2);
        task.setOption3(option3);
        task.setIsEnabled(isEnabled);
        task.setCreatedAt(new Date());
        task.setCreatedBy(createdBy);
        task.setUpdatedAt(new Date());
        task.setUpdatedBy(updatedBy);
        return task;
    }
}
