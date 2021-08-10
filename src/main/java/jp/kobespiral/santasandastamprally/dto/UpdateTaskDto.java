package jp.kobespiral.santasandastamprally.dto;

import jp.kobespiral.santasandastamprally.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDto {
    Long taskId;

    public Task toEntity(){
        Task task = new Task();

        return task;
    }
}
