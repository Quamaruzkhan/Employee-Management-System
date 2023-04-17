package com.employee.service.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KafkaConfigTest {

	private KafkaConfig config;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		config = new  KafkaConfig();
	}

	@Test
	void testTopic() {
		assertNotNull(config.topic());
	}

}
