package com.example.bottomnavi;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://c1478038.dothome.co.kr/Register.php" ; //서버 URL tjfwjd (PHP 파일 연동0
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>() ;
        map.put("userID",userID) ;
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userAge",userAge + "") ;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map ;
    }
}
