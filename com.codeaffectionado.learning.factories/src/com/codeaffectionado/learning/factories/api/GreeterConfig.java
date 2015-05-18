package com.codeaffectionado.learning.factories.api;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;


@OCD
public interface GreeterConfig {
	
	@AD(deflt="Default Config Greeting")
	String greeting();
	String instance();
}
