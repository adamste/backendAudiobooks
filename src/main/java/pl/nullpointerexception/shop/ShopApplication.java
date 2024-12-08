package pl.nullpointerexception.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.nullpointerexception.shop.product.Book;
import pl.nullpointerexception.shop.product.ProductRepo;
import pl.nullpointerexception.shop.shelve.Shelve;
import pl.nullpointerexception.shop.shelve.ShelveRepo;
import pl.nullpointerexception.shop.user.UserRepo;

import java.math.BigDecimal;

import java.util.Set;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo prodRepo;
    @Autowired
    private ShelveRepo shelveRepo;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Book book = new Book();
        book.setCategory("Kryminiał");
        book.setName("Ojciec Mateusz");
        book.setPrice(BigDecimal.TEN);
        book.setCurrency("PLN");
        book.setDescription("fajne");
        prodRepo.save(book);

        Shelve shelve = new Shelve();
        shelve.setType("Przeczytane");
        shelve.setBook(Set.of(book));
        shelve.setUser(userRepo.findById(1L).get());
        shelveRepo.save(shelve);





        //		String directoryPath = "/Users/adam.stepien/IdeaProjects/kursNPE/KursAplikacjiBackend-783b8ef41e38f07c99df396a489bd03cf2c625b5/request/mp3/";
//		File directory = new File(directoryPath);
//
//		String urlString = "http://localhost:8080/uploadMultipart";
//		String boundary = "WebAppBoundary";
//
//		File[] mp3Files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
//
//		for (File file : mp3Files) {
//			try {
//				HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
//				connection.setDoOutput(true);
//				connection.setRequestMethod("POST");
//				connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
//
//				try (OutputStream output = connection.getOutputStream()) {
//					PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true);
//
//					// Add file part
//					writer.append("--").append(boundary).append("\r\n");
//					writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(file.getName()).append("\"\r\n");
//					writer.append("Content-Type: ").append("application/octet-stream").append("\r\n\r\n");
//					writer.flush();
//
//					try (FileInputStream fileInputStream = new FileInputStream(file)) {
//						byte[] buffer = new byte[4096];
//						int bytesRead;
//						while ((bytesRead = fileInputStream.read(buffer)) != -1) {
//							output.write(buffer, 0, bytesRead);
//						}
//					}
//					output.flush();
//					writer.append("\r\n").flush();
//
//					// End of multipart
//					writer.append("--").append(boundary).append("--").append("\r\n").flush();
//				}
//
//				// Get the response
//				int responseCode = connection.getResponseCode();
//				System.out.println("Response Code: " + responseCode);
//
//				try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//					String line;
//					while ((line = reader.readLine()) != null) {
//						System.out.println(line);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
    }
}
