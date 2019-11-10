package springweb.demo.bank.repo;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IConst {

	public static Map<Integer, String> BANKLISTDEMO_TYPES = Stream
			.of(new Object[][] { { 1, "private" }, { 2, "public"}, })
			.collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
}
