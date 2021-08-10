package jp.kobespiral.santasandastamprally.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.santasandastamprally.dto.CreateTaskDto;
import jp.kobespiral.santasandastamprally.dto.UpdateTaskDto;
import jp.kobespiral.santasandastamprally.entity.Task;
import jp.kobespiral.santasandastamprally.exception.TaskException;
import jp.kobespiral.santasandastamprally.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository trepo;

    /**
     * タスク登録のメソッド
     * @param dto
     * @return
     */
    public Task createTask(CreateTaskDto dto) {
        return trepo.save(dto.toEntity());
    }

    /**
     * タスク検索のメソッド
     * 検索して，結果が出なかった場合にはexceptionが投げられる
     * @param taskId
     * @return
     */
    public Task getTask(Long taskId) {
        Task task = trepo.findById(taskId).orElseThrow(
            () -> new TaskException(TaskException.NO_SUCH_TASK, "No such Task!")
        );
        return task;
    }

    /**
     * 登録されているすべてのタスク一覧を返すメソッド
     * @return
     */
    public List<Task> getAllTask() {
        List<Task> list = trepo.findAll();
        return list;
    }

    /**
     * 特定のスポットに紐づいたタスク一覧を返すメソッド
     * @param spotId
     * @return
     */
    public List<Task> getSpotTask(Long spotId) {
        List<Task> list = trepo.findBySpotId(spotId);
        return list;
    }

    /**
     * 特定のspot内でtrueになっているものを取り出す
     * @param spotId
     * @return
     */
    public Task getValidTask(Long spotId) {
        // spotに紐づくモノの取得
        List<Task> list = getSpotTask(spotId);
        Task selectedTask = new Task();
        // 走査して見つけたら返す
        for(Task task : list){
            if (task.getIsEnabled()) {
                selectedTask= task;
                break;
            }
        }
        return selectedTask;
    }

    /**
     * tasuの表示非表示を変更
     * spot内では唯一がtrueになるようにしている
     * @param taskId
     * @return
     */
    public Task changeTaskFlag(Long taskId) {
        Task selectedTask = getTask(taskId);
        // 選ばれたものがfalseの場合，trueが複数になる可能性がある
        if (!selectedTask.getIsEnabled()) {
            Long spotId = selectedTask.getSpotId();
            List<Task> list = getSpotTask(spotId);
            for(Task task : list) {
                task.setIsEnabled(false);
            }
            selectedTask.setIsEnabled(true);
        } else {
            // 選ばれたものがtrueなら，逆にするだけでいい
            selectedTask.setIsEnabled(!selectedTask.getIsEnabled());
        }

        return trepo.save(selectedTask);
    }

    /**
     * taskの更新メソッド
     * @param dto
     * @return
     */
    public Task updateTask(UpdateTaskDto dto) {
        return trepo.save(dto.toEntity());
    }

    /**
     * isEnableが複数trueじゃないかを確認
     * @param spotId
     * @return 複数ならfalse 1以下ならtrue
     */
    public Boolean checkFlag(Long spotId) {
        List<Task> list = getSpotTask(spotId);
        int count = 0;
        for (Task task : list) {
            if (task.getIsEnabled()) {
                count += 1;
            }
        }
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * taskIdで指定してtaskの消去を行う
     * @param taskId
     */
    public void deleteTask(Long taskId, Long deletedBy) {
        Task task = getTask(taskId);
        task.setDeletedAt(new Date());
        task.setDeletedBy(deletedBy);
        trepo.save(task);
    }

    /**
     * 全てのタスクを消去する
     */
    public void deleteAllTask(Long deletedBy) {
        List<Task> list = getAllTask();
        for(Task task : list) {
            task.setDeletedAt(new Date());
            task.setDeletedBy(deletedBy);
            trepo.save(task);
        }
    }

    /**
     * 特定のスポットに紐づくタスクを全て消去する
     * @param spotId
     */
    public void deleteSpotTask(Long spotId, Long deletedBy) {
        List<Task> list = getSpotTask(spotId);
        for (Task task : list) {
            task.setDeletedAt(new Date());
            task.setDeletedBy(deletedBy);
            trepo.save(task);
        }
    }

    /**
     * ユーザが入力した答えと，解答があっているか確認
     * @param taskId
     * @param answer
     * @return 正しければtrue，間違っていればfalse
     */
    public Boolean checkAnswer(Long taskId, String answer) {
        if (answer.equals(getTask(taskId).getAnswer())) {
            return true;
        } else {
            return false;
        }
    }
}
