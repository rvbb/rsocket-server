package om.rvbb.b2b.backend.customer.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IConst {

	public static Map<Integer, String> BANKLISTDEMO_TYPES = Stream
			.of(new Object[][] { { 1, "private" }, { 2, "public"}, })
			.collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

	public static String LOGGER_REQUEST_URL = "url not recognized";

	public static String RESPONSE_OK = "OK";
	public static String RESPONSE_UNKNOWN = "Unknown";
}
