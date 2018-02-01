package com.othello.testcases;

import org.junit.Test;

import com.othello.service.GameService;

/**
 * This test case is only for auto play verification purpose.
 */
public class TestGameService {

	@Test
	public void testAuto() throws Exception {
		
		GameService service = new GameService();
		service.autoPlay(2000);
	}
}
