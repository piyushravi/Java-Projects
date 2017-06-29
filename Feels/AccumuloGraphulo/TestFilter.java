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
import java.util.*;
import edu.mit.ll.graphulo.*;
import org.apache.accumulo.core.iterators.Filter;

public class TestFilter extends Filter{
	List<Integer> keyElems = new ArrayList<>();
	List<Integer> valueElems = new ArrayList<>();
	public TestFilter(List<Integer> keyElems, List<Integer> valueElems){
		this.valueElems = valueElems;
		this.keyElems = keyElems;
		
	}
	public boolean accept(Key k, Value v){
		
		Integer k = new Integer.parseInt("1"); 
		for (int i=0; i<keyElems.size(); i++){
			return true;
		}
	}
	
}