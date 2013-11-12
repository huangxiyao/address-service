package com.hp.it.mdm.addressDoctor.client;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hp.it.mdm.addressDoctor.client.Worker;


public class Runit{
	static Logger log = Logger.getLogger(Runit.class);

	/**Tests single-threaded adapter functionality*/
	public static void main(String[] args)
	{
		String parm = null;
		
		if (args.length == 0) {
			parm = Runit.class
					.getResource("/log.properties").getPath();
		} else {
			parm = args[0];
		}
		PropertyConfigurator.configure(parm);

		log.info("Starting log4j configuration");

		Worker w = new Worker();

		w.start();

		try {
			w.join();
		} catch (Exception e){
			log.error("Error on join", e);
		}
	}
}