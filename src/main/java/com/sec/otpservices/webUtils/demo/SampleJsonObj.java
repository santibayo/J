/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sec.otpservices.webUtils.demo;

import com.sec.otpservices.webUtils.JsonResponse;
import com.sec.otpservices.webUtils.JsonResponseBean;
import com.sec.otpservices.webUtils.JsonServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author santi
 */
public class SampleJsonObj extends JsonServlet{

    @Override
    public void processJson(String username,HttpServletRequest request, JsonResponse response) throws ServletException, IOException {
        String par1 = request.getParameter("x1");
        SampleBean sample = new SampleBean();
        sample.setX1(par1);
        sample.setVal2(32);
        JsonResponseBean bean = new JsonResponseBean();
        bean.setSuccess(true);
        bean.setData(sample);
        response.setJsonResponse(bean);
        
    }
    
}
