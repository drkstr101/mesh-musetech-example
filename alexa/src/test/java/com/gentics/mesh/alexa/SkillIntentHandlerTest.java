package com.gentics.mesh.alexa;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.gentics.mesh.alexa.intent.SkillIntentHandler;
import com.gentics.mesh.alexa.intent.impl.DebugIntent;
import com.gentics.mesh.alexa.intent.impl.GetNextTourIntent;
import com.gentics.mesh.alexa.intent.impl.GetTourPriceIntent;
import com.gentics.mesh.alexa.intent.impl.GetToursInfoIntent;
import com.gentics.mesh.alexa.intent.impl.ReserveTourIntent;
import com.gentics.mesh.alexa.intent.impl.TourInfoIntentHandler;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

public class SkillIntentHandlerTest extends AbstractSkillTest {

	@Test
	@Ignore
	public void testStream() throws IOException {
		JsonObject input = loadJson("open");

		GetTourPriceIntent priceIntent = Mockito.mock(GetTourPriceIntent.class);
		TourInfoIntentHandler stockLevelIntent = Mockito.mock(TourInfoIntentHandler.class);
		ReserveTourIntent reserveIntent = Mockito.mock(ReserveTourIntent.class);
		GetToursInfoIntent toursInfo = Mockito.mock(GetToursInfoIntent.class);
		GetNextTourIntent nextTourInfo = Mockito.mock(GetNextTourIntent.class);
		DebugIntent debugIntent = Mockito.mock(DebugIntent.class);

		SkillIntentHandler handler = new SkillIntentHandler(priceIntent, stockLevelIntent, reserveIntent, toursInfo, nextTourInfo, debugIntent);
		handler.handleRequest(input, h -> {
			Buffer buffer = Buffer.buffer(h.getRawResponse());
			JsonObject output = new JsonObject(buffer);
			System.out.println(output);
		});
	}
}
