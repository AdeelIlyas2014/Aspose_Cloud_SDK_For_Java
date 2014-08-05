package com.aspose.cloud.words;

import java.io.InputStream;

import com.aspose.cloud.common.BaseResponse;
import com.aspose.cloud.common.Product;
import com.aspose.cloud.common.Utils;
import com.aspose.cloud.storage.Folder;
import com.google.gson.Gson;

    public class DocumentBuilder
    {
        public class WatermarkText
        {
            public String text ;
            public double rotationAngle ;
        }

        public class WatermarkImage
        {
            public String imageFile ;
            public double rotationAngle ;
        }

        public class ReplaceText
        {
            public String oldValue ;
            public String newValue ;
            public boolean isMatchCase ;
            public boolean isMatchWholeWord ;
        }

        /// <summary>
        /// insert water mark text into the document
        /// </summary>
        /// <param name="FileName"></param>
        /// <param name="text"></param>
        /// <param name="rotationAngle"></param>
        /// <returns></returns>
        public Boolean insertWatermarkText(String fileName, String text, double rotationAngle)
        {
            try
            {
            	//build URI to get Image
                String strURI = Product.getBaseProductUri() + "/words/" + fileName + "/insertWatermarkText";

                String signedURI = Utils.sign(strURI);

                //serialize the JSON request content
                WatermarkText watermark = new WatermarkText();
                watermark.text = text;
                watermark.rotationAngle = rotationAngle;

                String strJSON = "";

         	   Gson gson = new Gson();
         	   
         	   strJSON = gson.toJson(watermark, WatermarkText.class);

         	   InputStream responseStream = Utils.processCommand(signedURI, "POST", strJSON);
         	
         	    String strResponse = Utils.streamToString(responseStream);
         	
         	    //Parse the json string to JObject
         	    BaseResponse baseResponse = gson.fromJson(strResponse,BaseResponse.class);
                 
         	    if (baseResponse.getCode().equals("200") & baseResponse.getStatus().equals("OK"))
         	        return true;
         	    else
         	        return false;            
            	
            }   
       
            catch (Exception ex)
            {
            	ex.printStackTrace();
            	return false;
            }
        }

        /// <summary>
        /// insert image water mark into the document
        /// </summary>
        /// <param name="FileName"></param>
        /// <param name="imageFile"></param>
        /// <param name="rotationAngle"></param>
        /// <returns></returns>
        public Boolean insertWatermarkImage(String fileName, String imageFile, double rotationAngle)
        {
            try
            {
                //build URI to get Image
                String strURI = Product.getBaseProductUri() + "/words/" + fileName + "/insertWatermarkImage?imageFile=";
                strURI += imageFile + "&rotationAngle=" + rotationAngle;

                String signedURI = Utils.sign(strURI);

                InputStream responseStream =Utils.processCommand(signedURI, "POST");

                //further process JSON response
                String strJSON = Utils.streamToString(responseStream);

                Gson gson = new Gson();

                //Parse the json string to JObject and Deserializes the JSON to a object. 
                BaseResponse baseResponse=gson.fromJson(strJSON,BaseResponse.class);

                if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK"))
                    return true;
                else
                    return false;

            }
            catch (Exception ex)
            {
            	ex.printStackTrace();
            	return false;
            }
        }

        /// <summary>
        /// Replace a text with new value into the document
        /// </summary>
        /// <param name="FileName"></param>
        /// <param name="OldValue"></param>
        /// <param name="NewValue"></param>
        /// <param name="IsMatchCase"></param>
        /// <param name="IsMatchWholeWord"></param>
        /// <param name="output"></param>
        /// <returns></returns>
        public boolean replaceText(String fileName, String OldValue, String NewValue, boolean IsMatchCase, boolean IsMatchWholeWord, String output)
        {
            try
            {
                //build URI to get Image
                String strURI = Product.getBaseProductUri() + "/words/" + fileName + "/replaceText";

                String signedURI = Utils.sign(strURI);

                //serialize the JSON request content
                ReplaceText repacetext = new ReplaceText();
                repacetext.oldValue = OldValue;
                repacetext.newValue = NewValue;
                repacetext.isMatchCase = IsMatchCase;
                repacetext.isMatchWholeWord = IsMatchWholeWord;

                String strJSON = "";

          	   Gson gson = new Gson();
          	   
          	   strJSON = gson.toJson(repacetext, ReplaceText.class);

          	   InputStream responseStream = Utils.processCommand(signedURI, "POST", strJSON);
          	
          	    String strResponse = Utils.streamToString(responseStream);
          	
          	    //Parse the json string to JObject
          	  ReplaceTextResponse baseResponse = gson.fromJson(strResponse,ReplaceTextResponse.class);
             
          	  
                //sign URI
                signedURI = Utils.sign(baseResponse.getDocumentLink().getHref() + "?format=doc");

                //get response stream
                responseStream = Utils.processCommand(signedURI, "GET");

                boolean response=Folder.saveStreamToFile(output, responseStream);
		        responseStream.close();
		        return response;
            }
            catch (Exception ex)
            {
            	ex.printStackTrace();
            	return false;
            }
        }
    }