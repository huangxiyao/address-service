package com.hp.it.mdm.addressdoctor.client;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

import com.siperian.common.util.TypedProps;

public class AddressDoctorClientPool {

	private TypedProps props;
	GenericObjectPool pool;

	public static final Logger log = Logger.getLogger(AddressDoctorClientPool.class);

	public AddressDoctorClientPool(TypedProps p) {
		this.props = p;
	}

	public synchronized void initPool(AddressDoctorClient client) {
		pool = new GenericObjectPool(
				new AdapterExampleClientPoolFactory(client));
		pool.setMaxActive(props.getStringInt("pool.MaxActive", 4));
		pool.setMaxIdle(props.getStringInt("pool.MaxIdle", 4));
		pool.setMaxWait(props.getStringInt("pool.MaxWaitMillis",1000 * 60 * 5)); // 5 minutes
		pool.setMinEvictableIdleTimeMillis(props.getStringInt("pool.MinEvictableIdleTimeMillis", 1000 * 60 * 60));
		if (props.containsKey("pool.MinIdle")) {
			pool.setMinIdle(props.getStringInt("pool.MinIdle", 3));
		}
		if (props.containsKey("pool.NumTestsPerEvictionRun")) {
			pool.setNumTestsPerEvictionRun(props.getStringInt("pool.NumTestsPerEvictionRun", 1));
		}
	}

	public AddressDoctorClient borrowClient() throws Exception {

		return (AddressDoctorClient) pool.borrowObject();
	}

	public void returnClient(AddressDoctorClient client) throws Exception {
		pool.returnObject(client);
	}

	private class AdapterExampleClientPoolFactory extends
			BasePoolableObjectFactory {
		AddressDoctorClient client = null;

		AdapterExampleClientPoolFactory(AddressDoctorClient client) {
			this.client = client;
		}

		public Object makeObject() /* throws Exception */{
			AddressDoctorClient newClient = (AddressDoctorClient) client.clone();
			
			newClient.init();

			return newClient;
		}

		public void destroyObject(Object object) {
			AddressDoctorClient oldClient = (AddressDoctorClient) object;
			oldClient.disconnect();
			object = null;
		}
	}
}
