package bd.com.rafi.okhttptest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Respons {
    Context context;
    Model model;
    List<Model> list=new ArrayList<Model>();
    boolean has=false;
    public Respons(String url,Context context){
        this.context=context;
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {

                Request request=chain.request();

                Request newRequest= request.newBuilder().addHeader("token", "2").build();
                return chain.proceed(newRequest);
            }
        }).build();

        Request request=new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                      String data=response.body().string();

//                try {
//                    JSONObject jsonObject=new JSONObject(data);
//                    JSONObject essential =jsonObject.getJSONObject("data");
//                      Log.e("data",essential.getString("name"));
//
//                  /*  JSONObject maindata = new JSONObject(data);
//
//                    JSONArray jsonArray = maindata.getJSONArray("data");*/
//                   // JSONObject[] mainjsonarrays = new JSONObject[mainjsonArray.length()];
//                   // String id=jsonArray.getJSONObject(0).getString("id");
//                    //Log.e("data",maindata.toString());
//
//
//                  /* for(int i=0;i<jsonArray.length();i++){
//                        int id=Integer.parseInt(jsonArray.getJSONObject(i).getString("id"));
//                        String email=jsonArray.getJSONObject(i).getString("email");
//                        String fname=jsonArray.getJSONObject(i).getString("first_name");
//                        String lname=jsonArray.getJSONObject(i).getString("last_name");
//
//
//                        model=new Model(id,email,fname,lname);
//                        list.add(model);
//                   }*/
//
//
//
//                      /*  int id=(Integer.parseInt(essential.getString("id")));
//                        String email=(essential.getString("email"));
//                        String fname=(essential.getString("first_name"));
//                        String lname=(essential.getString("last_name"));
//                        model=new Model(id,email,fname,lname);*/
//
//
//
//                       /* ((Activity)context).runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                MainActivity.data=list;
//                                MainActivity.fun();
//                            }
//                        });*/
//                       // Log.e("data",model.getEmail());
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }


                    Log.e("respons",response.body().string());

            }
        });
    }

}
