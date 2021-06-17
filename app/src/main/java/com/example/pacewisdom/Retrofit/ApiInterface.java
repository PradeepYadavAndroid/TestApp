package com.example.pacewisdom.Retrofit;


import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
// String drive = " https://drive.google.com/drive/u/0/folders/16k65ZRoYEFVqn7__cfvxrSC3FMB5517d";





 @FormUrlEncoded
 @POST("")
 public Call<JsonElement> SaveGallery(@Field("/16k65ZRoYEFVqn7__cfvxrSC3FMB5517d") String Filetest);






}
