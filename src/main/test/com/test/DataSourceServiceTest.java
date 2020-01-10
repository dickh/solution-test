package com.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.DataSourceService;

/**
 * @author Kevin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceServiceTest {

	@InjectMocks
	DataSourceService dataSourceService;
	
	@Test
	public void getSourceData() {
		assertNotNull(dataSourceService.getSourceData());
	}
	
	@Test
	public void getPossibleKeys() {
		assertNotNull(dataSourceService.getPossibleKeys("222", dataSourceService.getSourceData()));
		assertNull(dataSourceService.getPossibleKeys("22a2", dataSourceService.getSourceData()));
	}
}
