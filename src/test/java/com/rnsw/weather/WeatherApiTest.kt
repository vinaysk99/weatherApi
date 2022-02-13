//package com.rnsw.weather
//
//import okhttp3.mockwebserver.MockResponse
//import okhttp3.mockwebserver.MockWebServer
//import org.apache.commons.io.IOUtils
//import org.junit.Assert
//import org.junit.jupiter.api.AfterEach
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.core.io.DefaultResourceLoader
//import org.springframework.http.HttpHeaders
//import org.springframework.test.context.TestPropertySource
//import org.springframework.test.web.reactive.server.WebTestClient
//
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = [WeatherApplication::class]
//)
//@TestPropertySource(locations = ["classpath:application-test.properties"])
//class WeatherApiTest {
//
//    @Autowired
//    lateinit var testClient: WebTestClient
//
//    val mockServer = MockWebServer()
//
//    @BeforeEach
//    fun setup() {
//        mockServer.start(9001)
//    }
//
//    @AfterEach
//    fun tearDown() {
//        mockServer.shutdown()
//    }
//
//    private fun createMockResponse(path: String, responseCode: Int): MockResponse {
//        val loader = DefaultResourceLoader()
//        val resource = loader.getResource(path)
//        val mockResponse = MockResponse()
//        mockResponse.setResponseCode(responseCode)
//        mockResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
//        mockResponse.setBody(IOUtils.toString(resource.inputStream, "UTF-8"))
//        return mockResponse
//    }
//
//    @Test
//    fun getWeatherDataSuccess() {
//        mockServer.enqueue(createMockResponse("classpath:mock/resp1.json", 200))
//
//        val responseBody = testClient.get().uri("/weather?lat=33.44&lon=-94.04&exclude=minutely")
//                .exchange()
//                .expectStatus().is2xxSuccessful
//                .expectBody()
//                .returnResult()
//                .responseBody
//
//        Assert.assertNotNull(responseBody)
//    }
//}