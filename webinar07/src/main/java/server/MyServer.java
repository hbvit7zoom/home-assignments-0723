package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyServer {

    ResourceProcessor processor = new ResourceProcessor();

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String startLine = dataInputStream.readLine();
                System.out.println(startLine);

                String[] s = startLine.split(" ");
                String method = s[0];
                String resource = s[1];

                String line = null;
                while (!(line = dataInputStream.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                String body = "";
                int available = 0;
//                while ((available = dataInputStream.available()) == 0) {
                while (true) {

                    if (dataInputStream.available() == 0) {
                        break;
                    }
                    line = dataInputStream.readLine();
                    System.out.println(line);
                    body += line;

                }

                System.out.println("body: " + body);
                System.out.println("END REQUEST");

                String response = processor.process(method, resource, body);

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
