package jp.kobespiral.santasandastamprally.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.kobespiral.santasandastamprally.dto.MapForm;
import jp.kobespiral.santasandastamprally.dto.UserForm;
import jp.kobespiral.santasandastamprally.entity.Map;
import jp.kobespiral.santasandastamprally.entity.User;
import jp.kobespiral.santasandastamprally.service.MapService;
import jp.kobespiral.santasandastamprally.service.UserService;

/**
 * ユーザ，マップ，スポット，タスク，進捗，
 * アンサーログ，スポットログの操作，CRUDを行うAPI
 */
@RestController
@RequestMapping("/api")
public class SandaQuestRestController {
    @Autowired
    UserService userService;
    @Autowired
    MapService mapService;

    /* --- C: Userを作成する --- */
    @PostMapping("/users")
    User createUser(@RequestBody UserForm userForm) {
        return userService.createUser(userForm);
    }

    /* --- R: Userを取得する (1件) --- */
    @GetMapping("/users/{userId}")
    User getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }

    /* --- U: Userを更新する --- */
    @PutMapping("/users/{userId}")
    User updateUser(@PathVariable UUID userId,@RequestBody UserForm userForm){
        return userService.updateUser(userId,userForm);
    }

    /* --- D: Userを削除する --- */
    @DeleteMapping("/users/{userId}")
    boolean deleteUser(@PathVariable UUID userId){
        userService.deleteUser(userId);
        return true;
    }
    
    /* --- C: Mapを作成する --- */
    @PostMapping("/maps")
    Map createMap(@RequestBody MapForm mapForm){
        return mapService.createMap(mapForm);
    }

    /* --- R: Mapを取得する (1件) --- */
    @GetMapping("/maps/{mapId}")
    Map getMap(@PathVariable Long mapId){
        return mapService.getMap(mapId);
    }

    /* --- R: Mapを取得する (リスト) --- */
    @GetMapping("/maps")
    List<Map> getAllMap(){
        return mapService.getAllMap();
    }

    /* --- U: Mapを更新する --- */
    @PutMapping("/maps/{mapId}")
    Map updateMap(@PathVariable Long mapId,@RequestBody MapForm mapForm){
        return mapService.updateMap(mapId, mapForm);
    }

    /* --- D: Mapを削除する --- */
    @DeleteMapping("/maps/{mapId}")
    boolean deleteMap(@PathVariable Long mapId){
        mapService.deleteMap(mapId);
        return true;
    }
    
    /*Spot createSpot(Spot spot)
    Spot getSpot(Long sid)
    Spot updateSpot(Long sid)
    Spot deleteSpot(Long sid)
    Task createTask(Task task)
    Task getTask(Long tid)
    Task updateTask(Long tid)
    Task deleteTask(Long tid)
    Progress createProgress(Progress pregress)
    Progress getProgress(Long pid)
    Progress updateProgress(Long pid)
    Progress deleteProgress(Long pid)
    AnswerLog createAnswerLog(AnswerLog answerLog)
    AnswerLog getAnswerLog(Long alid)
    AnswerLog updateAnswerLog(Long alid)
    AnswerLog deleteAnswerLog(Long alid)
    SpotLog createSpotLog(SpotLog spotLog)
    SpotLog getSpotLog(Long slid)
    SpotLog updateSpotLog(Long slid)
    SpotLog deleteSpotLog(Long slid)}*/

}
