package test.two.spring.util;

import com.baidu.aip.ocr.AipOcr;

public class AIPOcrJava extends AipOcr {
    public static final String APP_ID = "15370064";
    public static final String API_KEY = "zxTPrPqBLqc2IjgPBIYNdrVU";
    public static final String SECRET_KEY = "aKpFBQrI9GTCudmVD5bQgGeGdBm3T58v";

    public AIPOcrJava(){super(APP_ID, API_KEY, SECRET_KEY);
        this.setConnectionTimeoutInMillis(60000);
        this.setSocketTimeoutInMillis(20000);
        //System.setProperty("aip.log4j.conf", "classpath/log4j.properties");
    }

    public AIPOcrJava(String aipId, String aipKey, String secretKey) {
        super(aipId, aipKey, secretKey);
        this.setConnectionTimeoutInMillis(60000);
        this.setSocketTimeoutInMillis(60000);
      //  System.setProperty("aip.log4j.conf", "classpath/log4j.properties");
    }

}
