package com.org.hotelbooking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@SpringBootTest
class HotelbookingApplicationTests
{

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    private void setup() throws Exception
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void createHotelBookingTest() throws Exception
    {

        String payload = " {  \n"
                + "    \"bookingId\": \"2\",  \n"
                + "    \"guestName\": \"bala\",  \n"
                + "    \"roomNumber\": \"A3\",  \n"
                + "    \"bookingDate\": \"2023-04-01\"  \n"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/hotelbooking/api/create").contentType(MediaType.APPLICATION_JSON)
                .content(payload)).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
    }

    @Test
    public void getAllBookingByGuestTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/hotelbooking/api/userbookings?guestName=bala")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    
    @Test
    public void getAvailableRoomByDateTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/hotelbooking/api/availableroom?bookingDate=2023-04-01"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
