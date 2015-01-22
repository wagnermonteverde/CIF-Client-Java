package br.com.rnp.main;

import java.util.ArrayList;

import br.com.rnp.cif.Assessment;
import br.com.rnp.cif.CifClientManager;
import br.com.rnp.cif.CifObject;
import br.com.rnp.cif.CifObjectFactory;
import br.com.rnp.cif.Protocol;


public class Main {

	public static void main(String[] args) {
		
		 /*
         * 
         * Gerenciador cliente CIF
         * Submissões e consultas
         * 
         * */
      
         CifClientManager cifClientManager= new CifClientManager("192.168.1.37", "ca673b16-a055-44a3-b73e-f8676d11b3f0");

        
         
         /*
          * 
          * Fábrica de objetos CIF
          * 
          * */
         
         CifObjectFactory cifFactory = new CifObjectFactory();
         
         
         /*
          * 
          * Exemplo de submissão de 
          * vários registros ao servidor CIF
          * 
          * */
		 cifFactory.addCifObjectInList("200.10.2.1", "22", Protocol.TCP,Assessment.SCANNER);
		 cifFactory.addCifObjectInList("200.10.2.12", "33", Protocol.TCP,Assessment.SCANNER);
		 cifFactory.addCifObjectInList("200.10.2.13", "33", Protocol.TCP,Assessment.SCANNER);
		
		CifObject[] arrayCifObj = cifFactory.buildArrayCifObjects();
 
        if (cifClientManager.postData(arrayCifObj)){
        	
		    System.out.println("Success");
		    
	       }else{
	    	   
		   System.out.println("Falha ao Submeter dados");
	    }
        
        
        /*
         * 
         * Exemplo de construção e submissão de 
         * único registro
         * 
         * */
        
         CifObject objCif = cifFactory.buildCifObject("200.10.2.13", "24", Protocol.TCP,Assessment.SCANNER);
         
         if (cifClientManager.postData(objCif)){
         	
 		    System.out.println("Success");
 		    
 	       }else{
 	    	   
 		   System.out.println("Falha ao Submeter dados");
 	    }
        
       
	}
}
