package xyz.jonam.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private static ServerSocket serverSocket;
  private static final int PORT = 9601;

  public static void main(String[] args) throws IOException {
    serverSocket = new ServerSocket(PORT);
    Socket socket = serverSocket.accept();
    BufferedReader br = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
    String message = String.format(
            "Listening on %d port. Received message : %s", PORT, br.readLine());
    System.out.println(message);

    PrintWriter bw = new PrintWriter(
            new OutputStreamWriter(socket.getOutputStream()));
    bw.println(message);
    socket.close();
  }
}
