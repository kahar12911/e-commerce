package com.flipkart.e_commerce;

import com.flipkart.e_commerce.controller.UserContoller;
import com.flipkart.e_commerce.model.User;
import com.flipkart.e_commerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ECommerceApplicationTests {

	@InjectMocks
	private UserContoller userController;

	@Mock
	private UserRepository userRepository;

	private User mockUser;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockUser = new User(1, "john_doe", "password123", "john@example.com", 1234567890L);
	}

	// ✅ Test: Application Context Loads
	@Test
	void contextLoads() {
		assertNotNull(userController);
	}

	// ✅ Test: Get All Users
	@Test
	void testGetAllUsers() {
		when(userRepository.findAll()).thenReturn(Arrays.asList(mockUser));

		List<User> users = userController.getAllUsers();

		assertNotNull(users);
		assertEquals(1, users.size());
		assertEquals("john_doe", users.get(0).getUsername());
		verify(userRepository, times(1)).findAll();
	}

	// ✅ Test: Get User by Email (Positive Case)
	@Test
	void testGetUserByEmail_Success() {
		when(userRepository.findUserByEmail("john@example.com")).thenReturn(mockUser);

		User user = userController.getUserByEmail("john@example.com");

		assertNotNull(user);
		assertEquals("john_doe", user.getUsername());
		verify(userRepository, times(1)).findUserByEmail("john@example.com");
	}

	// ✅ Test: Get User by ID (Positive Case)
	@Test
	void testGetUserByID_Success() {
		when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

		Optional<User> user = userController.getUserByID(1);

		assertTrue(user.isPresent());
		assertEquals("john_doe", user.get().getUsername());
		verify(userRepository, times(1)).findById(1);
	}

	// ✅ Test: Add User (Positive Case)
	@Test
	void testRegisterUser_Success() {
		when(userRepository.save(mockUser)).thenReturn(mockUser);

		String response = userController.registerUser(mockUser);

		assertEquals("User has been added", response);
		verify(userRepository, times(1)).save(mockUser);
	}
}
