package TestesCif;

import br.com.rnp.cif.CifClientManager;




public class Main {

	public static void main(String[] args) {
		
//	  /** "192.168.32.4"  */
//	  /** "ee73f9bf-6f3b-4e1a-81d7-e44a7eb81622" */
//	  /** 199.195.193.0/24 */
//		  
      CifClientManager cifClientManager= new CifClientManager("192.168.32.4", "3943e84e-97a1-4a23-8e91-26ab949f59b1");
//	  
//      System.out.println(cifClientManager.queryForInfraestructureScan());
      cifClientManager.postData();
//	

		
	}
	
	
	
	                 

}
