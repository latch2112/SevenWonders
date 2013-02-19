/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.main;

import com.latch.sw.domain.HelloWorld;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author admin
 */
public class Main {
    
    final static String BEANFILE = "SpringXMLConfig.xml";
    static Log log = LogFactory.getLog(Main.class.getName());
    
    
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.propFileName = "SevenWonders.properties";
        main.readProp();
        ApplicationContext context = 
             new ClassPathXmlApplicationContext(BEANFILE);
        log.info("Going to create HelloWord Obj");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        log.info("Exiting the program");
        log.info("properties msg="+System.getProperty("sw.msg"));
    }
    private String propFileName;
 
    public void readProp() {
        // Read properties file.
        Properties properties = new Properties();
        try {
            //properties.load(new FileInputStream("./properties/SevenWonders.properties"));
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
            //properties.load(this.getClass().getResourceAsStream("SevenWonders.properties"));
            if (inputStream == null) {
                throw new FileNotFoundException("property file '" + propFileName+ "' not found in the classpath");
            }
            properties.load(inputStream);
            System.setProperty("sw.msg",properties.getProperty("sw.msg"));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
    
    
}
