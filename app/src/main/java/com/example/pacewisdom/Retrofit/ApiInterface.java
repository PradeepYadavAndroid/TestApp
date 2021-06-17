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
 @POST("assignment/Add")
 public Call<JsonElement> SaveAssignment(@Field("Assignment_Body") String Assignment_Body, @Field("Assignment_Name") String Assignment_Name,
                                         @Field("M_Section_Id") String M_Section_Id, @Field("M_Class_Id") String M_Class_Id, @Field("M_Subject_Id") String M_Subject_Id,
                                         @Field("T_Person_Detail_Id") String T_Person_Detail_Id, @Field("FromDate") String FromDate, @Field("ToDate") String ToDate,
                                         @Field("File_Name") String File_Name, @Field("File_Base64") String File_Base64, @Field("Type") String Type);


 @FormUrlEncoded
 @POST("notification/Add")
 public Call<JsonElement> SaveAnnouncement(@Field("Message_From") String Message_From, @Field("Notification") String Notification,
                                           @Field("M_Section_Id") String M_Section_Id, @Field("M_CLass_Id") String M_CLass_Id, @Field("M_Subject_Id") String M_Subject_Id,
                                           @Field("T_Person_Detail_Id") String T_Person_Detail_Id,
                                           @Field("File_Name") String File_Name, @Field("File_Base64") String File_Base64);





 @FormUrlEncoded
 @POST("")
 public Call<JsonElement> SaveGallery(@Field("https://drive.google.com/drive/u/0/folders/16k65ZRoYEFVqn7__cfvxrSC3FMB5517d") String File_Base64);



 /*@GET("login/user")
 public Call<List<LoginResult>> Login(@QueryMap Map<String, String> options);

 @GET("class/get")
 public Call<JsonElement> getClass(@QueryMap Map<String, String> options);
 @GET("section/get")
 public Call<JsonElement> Section(@QueryMap Map<String, String> options);

 @GET("subject/get")
 public Call<JsonElement> getsubject();

 @GET("assignment/get")
 public Call<List<Assignments>> getassignmentlist(@QueryMap Map<String, String> options);

 @GET("notification/GetByID")
 public Call<List<Announcement>> getannouncementlist(@QueryMap Map<String, String> options);

 @GET("gallery/GetByID")
 public Call<List<GalleryClass>> getgallerylist(@QueryMap Map<String, String> options);




 @POST("assignment/Delete")
 public Call<String> deleteAssignment(@QueryMap Map<String, String> options);

 @POST("notification/Delete")
 public Call<String> deleteAnnouncement(@QueryMap Map<String, String> options);

 @POST("gallery/Delete")
 public Call<String> deleteGallery(@QueryMap Map<String, String> options);

*/


}
