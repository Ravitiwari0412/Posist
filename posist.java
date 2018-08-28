import java.util.Date;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class Record {
  static  Scanner scn=new Scanner(System.in);
 static class Data{
      int ownerId;
      float value;
      String ownerName;
      String []hash;
      
      Data(int ownerid , float value , String ownerName){
          this.ownerId=ownerId;
          this.value=value;
          this.ownerName=ownerName;
        this.hash[0]=String.valueOf(ownerid);
        this.hash[1]=String.valueOf(value);
        this.hash[2]=ownerName;
         
      }
      
  }
    
    static class node{
     Date timestamp;
    Data data;
    int nodeNumber;
    String nodeId;
    String referenceNodeId;
    String [] childReferenceNodeId;
    String genesisReferenceNodeId;
    String HashValue;
    
    node( String nodeId){
        this.nodeId=nodeId;
        
        
    }
    void createGenesisNode(){
        System.out.println("Enter genesis Nodeid");
     String  nodeId=scn.nextLine();
        node genesis=new node(nodeId);
        genesis.referenceNodeId=null;
    }
   
    
    void createChildNodes(String referenceNodeId, int numNodes){
          node parent=new node(referenceNodeId);
        for(int i=0;i<numNodes;i++){
         //   node parent=new node(referenceNodeId);
            System.out.println("Enter data of node"+ i);
            String data=scn.nextLine();
             System.out.println("Enter data of node"+ i);
                         String childId=scn.nextLine();
                         System.out.println("Enter node number of node"+ i);
                         int nodenum=scn.nextInt();
                         
                         
                         node child=new node(childId);
                         child.referenceNodeId=referenceNodeId;
                         child.data=data;
                         child.nodeNumber=nodenum;
                         

            
            parent.childReferenceNodeId[i]=childId;
            
            
            
            
            
        }
        
        
    }
    void newChildNode(String referenceNodeId){
         System.out.println("Enter data of node");
            String data=scn.nextLine();
             System.out.println("Enter data of node");
                         String childId=scn.nextLine();
                         System.out.println("Enter node number of node");
                         int nodenum=scn.nextInt();
                         
                         
                         node child=new node(childId);
                         child.referenceNodeId=referenceNodeId;
                         child.data=data;
                         child.nodeNumber=nodenum;
                         
        
        
        
    }
    
     String     encrypt(String data,String strKey) throws Exception{
	String strData="";
	
	try {
		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
		Cipher cipher=Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
		byte[] encrypted=cipher.doFinal(data.getBytes());
		strData=new String(encrypted);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e);
	}
	return strData;
}
    
    String decrypt(String strEncrypted,String strKey) throws Exception{
	String strData="";
	
	try {
		SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
		Cipher cipher=Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, skeyspec);
		byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
		strData=new String(decrypted);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e);
	}
	return strData;
}
    void longestChainGenesis(){
        int count=0;
        while()
    }

    }
    
 public static void main(String[] args){
     System.out.println("Enter genesis Nodeid");
     String  nodeId=scn.nextLine();
     node genesis=new node( nodeId);
     genesis.referenceNodeId=null;
     
           
        }}
