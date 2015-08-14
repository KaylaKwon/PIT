package com.yckim.project_manager.Manager;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.yckim.project_manager.InfoClass.ToDoBean;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Vector;

public class ToDoManager {
    private static ToDoManager instance;
    public static ToDoManager getInstnace() {
        if (instance == null) {
            instance = new ToDoManager();
        }
        return instance;
    }

    public AsyncHttpClient client;
    private ToDoManager() {

        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            MySSLSocketFactory socketFactory = new MySSLSocketFactory(trustStore);
            socketFactory.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            client = new AsyncHttpClient();
            client.setSSLSocketFactory(socketFactory);
            client.setCookieStore(new PersistentCookieStore(MyApplication.getContext()));
            client.setTimeout(30000);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    public HttpClient getHttpClient() {
        return client.getHttpClient();
    }

    public interface OnResultListener<T> {
        public void onSuccess(T result);
        public void onFail(int code);
    }

    public void ToDolist_sendData(Context context,RequestParams params ,final OnResultListener<Vector> listener){
        String SERVER = "http://210.118.74.191:4389/TIP_server/todo_list";

        client.post(context, SERVER, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  String responseString, Throwable throwable) {
                Log.i("NetworkManager.setUserInfo", "fail:" + responseString);
                listener.onFail(statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  String responseString) {
                Log.i("NetworkManager.setUserInfo", "success:" + "success");
                Gson gson = new Gson();
                Vector result = gson.fromJson(responseString, Vector.class);
                listener.onSuccess(result);
            }
        });
    }

    public void ToDoitem_sendData(Context context,RequestParams params,final OnResultListener<ToDoBean> listener){
        String SERVER = "http://210.118.74.191:4389/TIP_server/todo_item";

        client.post(context, SERVER, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  String responseString, Throwable throwable) {
                Log.i("NetworkManager.setUserInfo", "fail:" + responseString);
                listener.onFail(statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  String responseString) {
                Log.i("NetworkManager.setUserInfo", "success:" + "success");
                Gson gson = new Gson();
                ToDoBean result = gson.fromJson(responseString,ToDoBean.class);
                listener.onSuccess(result);
            }

        });
    }

    public void ToDocreate_sendData(Context context,RequestParams params,final OnResultListener<Boolean> listener){
        String SERVER = "http://210.118.74.191:4389/TIP_server/create_todo";

        client.post(context, SERVER, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  String responseString, Throwable throwable) {
                Log.i("NetworkManager.setUserInfo", "fail:" + responseString);
                listener.onFail(statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  String responseString) {
                Log.i("NetworkManager.setUserInfo", "success:" + "success");
                Gson gson = new Gson();
                boolean result = gson.fromJson(responseString,boolean.class);
                listener.onSuccess(result);
            }
        });
    }

    public void ToDodelete_sendData(Context context,RequestParams params,final OnResultListener<Boolean> listener){
        String SERVER = "http://210.118.74.191:4389/TIP_server/delete_todo";

        client.post(context, SERVER, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  String responseString, Throwable throwable) {
                Log.i("NetworkManager.setUserInfo", "fail:" + responseString);
                listener.onFail(statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  String responseString) {
                Log.i("NetworkManager.setUserInfo", "success:" + "success");
                Gson gson = new Gson();
                boolean result = gson.fromJson(responseString,boolean.class);
                listener.onSuccess(result);
            }
        });
    }

}