
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.BatchScanner;
import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.client.BatchWriterConfig;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.admin.TableOperations;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Mutation;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.accumulo.core.security.ColumnVisibility;
import org.apache.hadoop.io.Text;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




import org.apache.accumulo.core.client.Instance;
import org.apache.accumulo.core.client.ZooKeeperInstance;
import org.apache.accumulo.core.client.security.tokens.PasswordToken;




import org.apache.accumulo.core.client.MutationsRejectedException;
import org.apache.accumulo.core.client.TableExistsException;


import org.apache.accumulo.core.data.PartialKey;

import org.junit.Assert;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import edu.mit.ll.graphulo.Graphulo;



public class TestGraphuloConnection {

	public static void main(String[] args) throws AccumuloException, AccumuloSecurityException {
		// setup
		Instance instance = new ZooKeeperInstance("accumulo","192.168.10.149");
		Connector connector = instance.getConnector("root","password");
		Graphulo graphulo = new Graphulo(connector, new PasswordToken("password"));
		String tR="piyush_test_1";
		

		
		Map <String, String> entriesToIngest= new HashMap<>();
		
		for(Integer i=0; i<1000; i++){
			Integer temp=i;
			Integer val=0;
			while (temp>0){
				val+=temp%10;
				temp/=10;
						
			}
			entriesToIngest.put(String.valueOf(i), String.valueOf(val));
		}
		System.out.println(entriesToIngest);
		
		 if (connector.tableOperations().exists(tR)) {
			 try {
				 connector.tableOperations().delete(tR);
				 System.out.println(13);
			 } 
			 catch (TableNotFoundException e) {
			 throw new RuntimeException("crazy timing bug", e);
			 }
			 
	}
		 try {
			 connector.tableOperations().create(tR);
			 System.out.println(1);
			
			 } 
			  catch (TableExistsException e) {
				  System.out.println(11);
			 throw new RuntimeException("crazy timing bug", e);
			 
			 }
		
		 try{
			 BatchWriter bw = connector.createBatchWriter(tR, new BatchWriterConfig());
			 
			 for (Map.Entry<String, String> pair : entriesToIngest.entrySet()) {
				 Mutation m = new Mutation(pair.getKey());
				 m.put("Test", "Sum_of_Digits", pair.getValue());
				 bw.addMutation(m);
				 

				 
			 }
			
			 


			 bw.flush();
			 System.out.println(12);
			 
			 bw.close();

		 }
		 catch (TableNotFoundException e) {
			 System.out.println(111);
			 throw new RuntimeException("crazy timing bug", e);
			 
			 }
		 
		 try{
		 BatchScanner bs = connector.createBatchScanner(tR, Authorizations.EMPTY, 1);
		 bs.setRanges(Collections.singleton(new Range()));
		 for (Map.Entry<Key, Value> entry : bs) {
			 
			 System.out.println(entry.getKey().toStringNoTime()+" -> "+entry.getValue());
			 }
			 bs.close();
		 }
		 catch (TableNotFoundException e) {
			 System.out.println(111);
			 throw new RuntimeException("crazy timing bug", e);
			 
			 }
	}

}
