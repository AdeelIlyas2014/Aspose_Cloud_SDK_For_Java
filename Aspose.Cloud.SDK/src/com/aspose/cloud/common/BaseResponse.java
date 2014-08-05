/**
 * 
 */
package com.aspose.cloud.common;

import java.lang.String;
/**
 * @author Mudassir
 *
 */
public class BaseResponse {
    public BaseResponse() { }

    private String code;
    private String status;
 
    public String getCode(){return code;}
    public String getStatus(){return status;}
    
    public void  setCode(String temCode){ code=temCode;}
    public void setStatus(String temStatus){ status=temStatus;}
}
