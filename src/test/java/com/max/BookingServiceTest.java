package com.max;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private BookingService bookingService;
    private BookingService bookingServiceMock;
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceTest.class);

    private String userId;
    private LocalDateTime from;
    private LocalDateTime to;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        bookingServiceMock = Mockito.spy(new BookingService());

        String userId = "user123";
        LocalDateTime from = LocalDateTime.now().plusDays(1);
        LocalDateTime to = from.plusHours(2);
    }

    @Test
    void testBookSuccess() throws CantBookException {
        // Настройка поведения мока: слот времени доступен.
        when(bookingServiceMock.checkTimeInBD(from, to)).thenReturn(true);
        when(bookingServiceMock.createBook(userId, from, to)).thenReturn(true);

        logger.info("Начало теста успешного бронирования.");

        assertTrue(bookingServiceMock.book(userId, from, to));

        verify(bookingServiceMock).checkTimeInBD(from, to);
        verify(bookingServiceMock).createBook(userId, from, to);

        logger.info("Тест успешного бронирования завершен.");
    }

    @Test
    void testBookSlotUnavailable() {

        // Настройка поведения мока: слот времени недоступен.
        when(bookingServiceMock.checkTimeInBD(from, to)).thenReturn(false);

        logger.info("Начало теста с недоступным слотом времени.");

        assertThrows(CantBookException.class, () -> bookingServiceMock.book(userId, from, to));

        verify(bookingServiceMock, never()).createBook(anyString(), any(LocalDateTime.class), any(LocalDateTime.class));

        logger.info("Тест с недоступным слотом времени завершен.");
    }

    @Test
    void testBookCreationFails() {
        // Настройка поведения мока: слот времени доступен, но создание бронирования возвращает false.
        when(bookingServiceMock.checkTimeInBD(from, to)).thenReturn(true);
        when(bookingServiceMock.createBook(userId, from, to)).thenReturn(false);

        logger.info("Начало теста с ошибкой создания бронирования.");

        try {
            assertFalse(bookingServiceMock.book(userId, from, to));
        } catch (CantBookException e) {
            throw new RuntimeException(e);
        }

        verify(bookingServiceMock).checkTimeInBD(from, to);
        verify(bookingServiceMock).createBook(userId, from, to);

        logger.info("Тест с ошибкой создания бронирования завершен.");
    }
}
