/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.sw.main;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latch.sw.domain.impl.HelloWorld;
import com.latch.sw.domain.impl.SevenWondersCard;
import com.latch.sw.domain.impl.SevenWondersDeck;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
        main.testKryo();
        main.testJackson();
        main.testJacksonRead();
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
    public void testKryo() throws FileNotFoundException {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.bin"));
        SevenWondersCard swCard = new SevenWondersCard();
        swCard.setAction("sc.Appliquee+1");
        swCard.setAge("1");
        swCard.setConfig(3);
        swCard.addCost("Verre");
        swCard.addChainProduction("Laboratoire");
        swCard.addChainProduction("Champs de Tir");
        swCard.setType("Scientifique");
        swCard.setName("Atelier");
        kryo.writeObject(output, swCard);
        output.close();
        

        
        
        
    }
    public void testJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SevenWondersCard swCard = new SevenWondersCard();
        swCard.setAction("sc.Appliquee+1");
        swCard.setAge("1");
        swCard.setConfig(3);
        swCard.addCost("verre");
        swCard.addChainProduction("Laboratoire");
        swCard.addChainProduction("Champs de Tir");
        swCard.setType("Scientifique");
        swCard.setName("Atelier");
        SevenWondersDeck swDeck = new SevenWondersDeck();
        swDeck.addSwCardToDeck(swCard);
        swCard = new SevenWondersCard();
        swCard.setAction("sc.Pure+1");
        swCard.setAge("1");
        swCard.setConfig(3);
        swCard.addCost("tissu");
        swCard.addChainProduction("Écuries");
        swCard.addChainProduction("Dipensaire");
        swCard.setType("Scientifique");
        swCard.setName("Officine");
        swDeck.addSwCardToDeck(swCard);
        log.info("\nswDeck = "+swDeck);
        mapper.writeValue(new File("swCard.json"), swDeck);
        
        
    }
    
    public void testJacksonRead() throws IOException  {
        ObjectMapper mapper = new ObjectMapper();
        SevenWondersDeck swDeck = mapper.readValue(new File("resources/swDeck.json"), SevenWondersDeck.class);
        log.info("\nswDeck = "+swDeck);
        
        
    }
    
    
    
}
