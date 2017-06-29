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
import org.apache.accumulo.core.client.Scanner;
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
import edu.mit.ll.graphulo.*;

public class TestScanner{
	private Connector conn;
	private String tableName;
	TestScanner(Connector conn, String tableName){
		this.conn = conn;
		this.tableName = tableName;
		this.scan();
	}
	
	private void scan(){
		try{
			BatchScanner bs = this.conn.createBatchScanner(this.tableName, Authorizations.EMPTY, 1);
			bs.setRanges(Collections.singleton(new Range()));
			for (Map.Entry<Key, Value> entry : bs) {
				System.out.println(entry.getKey().toString()+"-->"+entry.getValue().toString());
			}
			bs.close();
		} catch (TableNotFoundException e) {
			 System.out.println(111);
			 throw new RuntimeException("crazy timing bug", e);
			 
			 }
	}
	
}
