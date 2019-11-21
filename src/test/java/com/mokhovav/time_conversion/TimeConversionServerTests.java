package com.mokhovav.time_conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class TimeConversionServerTests {
	@Autowired
	private TestRequest tr;

	@Test
	void contextLoads() throws JsonProcessingException {
		tr.URL_TIMEZONE = "https://timeconversion.herokuapp.com/convert";
		String response = sGR(tr.URL_TIMEZONE + "?from=" + tr.original_timezone + "&to=" + tr.result_timezone + "&time=" + tr.original_timestamp);
		System.out.println("response = " + response);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Pattern result_timestampP = Pattern.compile(".*\"result_timestamp\"\\s*:\\s*\"(.[^,}\"\\s]*)?");
		Matcher result_timestampM = result_timestampP.matcher(response);
		if (result_timestampM.find()) {
			System.out.println("Time converted from: " + dateFormat.format(tr.original_timestamp));
			System.out.println("Time converted to:   " + dateFormat.format(Long.parseLong(result_timestampM.group(1))));
		}

		Pattern result_errorP = Pattern.compile(".*\"error\"\\s*:\\s*\"(.[^,}\"]+)?");
		Matcher result_errorM = result_errorP.matcher(response);
		if (result_errorM.find() && result_errorM.group(1) != null)
			System.out.println("Error: " + result_errorM.group(1));
	}

	private String sGR(String request) {
        /* A data structure representing HTTP request or response headers, mapping String header names
		 to a list of String values, also offering accessors for common application-level data types.
		 */
		try {
			HttpHeaders headers = new HttpHeaders();
			// Set the list of acceptable media types, as specified by the Accept header.
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			// Set the media type of the body, as specified by the Content-Type header.
			headers.setContentType(MediaType.APPLICATION_JSON);
			// Represents an HTTP request or response entity, consisting of headers and body.
			HttpEntity<String> entity = new HttpEntity<>(headers);
			// RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			// Send request with GET method, and without Headers.
			/*String result = restTemplate.getForObject(request1, String.class);
			System.out.println(result);/**/
			// Send request with GET method, and Headers.
			ResponseEntity<String> response = restTemplate.exchange(
					request,
					HttpMethod.GET,
					entity,
					String.class);
			return response.getBody();
		} catch (Exception e) {
			return "{" + " \"error\" : \"" + e.getMessage() + "\" }";
		}
	}

}
