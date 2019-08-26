package note.terminal.service;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import note.terminal.domain.entity.Terminal;
import note.terminal.vo.User;

@Service
public class BankRequestService {

	@Autowired
	private SchedulerService service;

	public void bankNoteSupply(Integer noteValue, Integer quantity, String startDate, String deliveryDate,
			Terminal terminal) throws Exception {

		HttpURLConnection urlConnection = getPost(terminal.getAddressSupply() + "?noteValue=" + noteValue + "&quantity="
				+ quantity + "&startDate=" + startDate + "&deliveryDate=" + deliveryDate);
		urlConnection.setRequestProperty("authorization", login(terminal));

		urlConnection.connect();

		service.supply(noteValue, quantity, getResponse(urlConnection), terminal);
	}

	private String login(Terminal terminal) throws Exception {

		User user = new User();
		user.setPassword(terminal.getPassword());
		user.setUsername(terminal.getUsername());

		HttpURLConnection urlConnection = getPost(terminal.getAddressLogin());

		OutputStream os = urlConnection.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		osw.write(new ObjectMapper().writeValueAsString(user));
		osw.flush();
		osw.close();
		os.close();

		urlConnection.connect();

		if (urlConnection.getResponseCode() != 200) {
			throw new RuntimeException("Credentials invalid : " + urlConnection.getResponseCode());
		}

		return getResponse(urlConnection);
	}

	private HttpURLConnection getPost(String uri) throws IOException {

		URL url = new URL(uri);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "application/" + "json");
		urlConnection.setDoOutput(true);

		return urlConnection;
	}

	private String getResponse(HttpURLConnection urlConnection) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result2 = bis.read();
		while (result2 != -1) {
			buf.write((byte) result2);
			result2 = bis.read();
		}
		return buf.toString();
	}
}
