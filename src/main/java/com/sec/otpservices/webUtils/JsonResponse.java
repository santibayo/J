/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sec.otpservices.webUtils;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
public class JsonResponse {
    private HttpServletResponse response;
    
    public JsonResponse (HttpServletResponse res){
        this.response = res;
    }
    
    public void addCookie(Cookie cookie){
        cookie.setHttpOnly(true);
        this.response.addCookie(cookie);
    }
    
    public void setHeader(String key,String value){
        this.response.setHeader(key, value);
    }
    
    public void setJsonResponse(JsonResponseBean jsonBean) throws IOException{
        Gson gson = new Gson();
        String result = null;
        if (!jsonBean.isSuccess()){
            this.response.setStatus(400);
            ErrorBean errorBean = new ErrorBean();
            errorBean.setCode(jsonBean.getCodeError());
            errorBean.setMessage(jsonBean.getMessageError());
            result =  gson.toJson(errorBean);
        }else{
            this.response.setStatus(200);            
            result  = gson.toJson(jsonBean.getData());
        }
        this.response.setContentType("application/javascript");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        
    }
    
}
