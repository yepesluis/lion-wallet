package com.yepes.lionwallet.controller.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.luisyepes.lionwallet.LionWalletApplication;
import com.luisyepes.lionwallet.controller.MovementController;
import com.luisyepes.lionwallet.domain.dto.CategoryDto;
import com.luisyepes.lionwallet.domain.dto.MovementDto;
import com.yepes.lionwallet.domain.testdatabuilder.CategoryTestDataBuilder;
import com.yepes.lionwallet.domain.testdatabuilder.MovementTestDataBuilder;

@SpringBootTest
@ContextConfiguration(classes = LionWalletApplication.class)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@TestInstance(Lifecycle.PER_CLASS)
public class MovementControllerTest {
	
	@Autowired
	MovementController movementController;

	MovementDto movementDto;
	
	public static int MONTH_9 = 9;
	public static int YEAR_2024 = 2024;
	
	@BeforeAll
	public void setup() {}
	
	@Test
	public void recordMovementOutflow_ok() {
		
		movementDto = MovementDto.builder()
				.movementType(MovementTestDataBuilder.MOVEMENT_TYPE_OUTFLOW)
				.date(MovementTestDataBuilder.DATE_2024_10_10)
				.title(MovementTestDataBuilder.MOVEMENT_TITLE)
				.value(MovementTestDataBuilder.MOVEMENT_VALUE_50K)
				.category(CategoryDto.builder()
						.name(CategoryTestDataBuilder.CATEGORY_NAME)
						.build())
				.build();
		
		ResponseEntity<?> response = movementController.recordMovement(movementDto);
		assertNotEquals(null, response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(MovementDto.class, response.getBody().getClass());
		MovementDto movementResponse = (MovementDto) response.getBody();
		assertNotEquals(null, movementResponse.getId());
		
	}
	
	@Test
	public void getTotalOutflowsMonth_ok() {
		
		ResponseEntity<?> response = movementController.getTotalOutflowsMonth(MONTH_9, YEAR_2024);
		assertNotEquals(null, response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Object responseBody = response.getBody();
		assertNotEquals(null, responseBody);
		assertEquals(Double.class, response.getBody().getClass());
		assertEquals(50d, (Double) responseBody);
				
	}

}
