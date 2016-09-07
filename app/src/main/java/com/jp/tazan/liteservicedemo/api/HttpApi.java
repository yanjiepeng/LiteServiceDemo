package com.jp.tazan.liteservicedemo.api;

import com.jp.tazan.liteservicedemo.entity.KeyEntity;
import com.jp.tazan.liteservicedemo.entity.KeyExsitedEntity;
import com.jp.tazan.liteservicedemo.entity.LockEntity;
import com.jp.tazan.liteservicedemo.entity.LoginResponse;
import com.jp.tazan.liteservicedemo.entity.TaskEntity;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016-09-07.
 */
public interface HttpApi {

    //Base URL
    public static final String API_URL = "http://103.235.224.122:8000";

    @POST("/tower_login")
    Call<LoginResponse> login(@Field("name") String name , @Field("password") String password ,@Field("client") String client ,@Field("sign") String sign);

    @POST("/tower_logout")
    Call<ResponseBody> logout();

    @POST("/tower_getkeys")
    Call<KeyEntity> getKeys(@Field("token") String token , @Field("page") int page , @Field("pagecount") int pagecount);

    @POST("/tower_judgekey")
    Call<KeyExsitedEntity> judgeKey(@Field("token") String token , @Field("esn") String esn);

    @POST("/tower_getlocks")
    Call<LockEntity> getLocks(@Field("token") String token , @Field("page") int page , @Field("pagecount") int pagecount);

    @POST("/tower_updatelock")
    Call<ResponseBody> updateLock(@FieldMap Map<String , String > map);

    @POST("/tower_gettasks")
    Call<TaskEntity> getTasks(@Field("token") String token , @Field("page") int page , @Field("pagecount") int pagecount ,@Field("starttime") String starttime , @Field("endtime") String endtime);

    @POST("/tower_requesttmptask")
    Call<ResponseBody> requestTempTask(@Field("token") String token , @Field("name") String name ,@Field("starttime") String starttime , @Field("endtime") String endtime , @Field("esn") String esn );

    @POST("/tower_agreetmptask")
    Call<ResponseBody> agressTempTask(@Field("token") String token  , @Field("id") int id);

    @POST("/tower_taskissued")
    Call<ResponseBody> taskIssued(@Field("token") String token  , @Field("id") int id);

    @POST("/tower_savelog")
    Call<ResponseBody> saveLog(@Field("token") String token , @Field("lockesn") String lockesn , @Field("keyesn") String keyesn ,@Field("result") byte result , @Field("time") String time);

    /**
     * 提交JSON RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
     * @param body
     * @return
     */
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("/tower_savelogs")
    Call<ResponseBody> saveLogs(@Body RequestBody body);


    @POST("/tower_getlogs")
    Call<LockEntity> getLogs(@Field("token") String token , @Field("page") int page , @Field("pagecount") int pagecount);
}
