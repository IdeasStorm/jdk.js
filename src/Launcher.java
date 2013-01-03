import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import com.martiansoftware.jsap.UnflaggedOption;

public class Launcher {

	/**
	 * @param args
	 * @throws JSAPException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws JSAPException,
			FileNotFoundException {
		JSAP jsap = new JSAP();
		UnflaggedOption opt2 = new UnflaggedOption("filename")
				.setStringParser(JSAP.STRING_PARSER)
				.setDefault("src//data.txt")
				.setRequired(false);
		
		jsap.registerParameter(opt2);

		Switch sw1 = new Switch("interactive")
			.setShortFlag('i')
			.setLongFlag("interactive");

		jsap.registerParameter(sw1);

		JSAPResult config = jsap.parse(args);
		String fileName = config.getString("filename");
		compiler.compileStream(new InputStreamReader(new FileInputStream(
				fileName)));
	}
}
