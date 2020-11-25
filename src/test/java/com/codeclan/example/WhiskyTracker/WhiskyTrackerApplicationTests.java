package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void whiskyCanGetByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskiesByYear(2020);
		assertEquals("Flora and Fauna", foundWhisky.get(0).getName());
	}

	@Test
	public void distilleryCanGetByRegion(){
		List<Distillery> founddistillery = distilleryRepository.findDistilleriesByRegion("Highland");
		assertEquals("Glendronach", founddistillery.get(0).getName());
	}

	@Test
	public void listWhiskeyFoundByDistilleryAndAge(){
		Distillery distillery5 = distilleryRepository.getOne(5L);
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesByDistilleryNameAndAge("Highland Park", 12);
		assertEquals("Viking Honour", foundWhiskies.get(0).getName());
	}

	@Test
	public void listWhiskeyCanBeFoundByRegion(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskiesByDistilleryRegion("Highland");
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

	@Test
	public void distilleriesCanBeFoundByWhiskyAge(){
		List<Distillery> foundDistillery = distilleryRepository.findDistilleriesByWhiskiesAge(12);
		assertEquals(6, foundDistillery.size());
	}

}
