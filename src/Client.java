/**
 * Client.Java
 * -----------------------
 * Authors:
 * Kian Aliwalas
 * Delanie Crews
 * -----------------------
 * CNT4504 Summer 2024
 * Instructor: Scott Kelly
 * -----------------------
 * Iterative Socket Server
 * Due Date 07/05/24
 * -----------------------
 * Implement an iterative (single-threaded) server for use in a client-server
 * Configured to examine, analyze, and study the effects an iterative server
 * has on the efficiency (average turn-around time) of processing client requests.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //User input IP/Port
        Scanner scanner = new Scanner(System.in); //To scan for IP/Port being used

        System.out.println("Enter IP: ");
        String ip = scanner.nextLine(); //Takes user input port

        System.out.println("Enter port: ");
        int port = scanner.nextInt(); //Takes user input port

        //Client Menu
        int clientChoice = 9; //Initializes choice and make sure it isn't an option or 0 to go to while
        while (clientChoice != 7) {
            menu();

            clientChoice = scanner.nextInt();
            System.out.println("Client choice " + clientChoice); //Debugging

            //TO-DO Ask for how many requests/threads. Make according to deliverables requirements
            System.out.println("How many requests?");
            int requests = scanner.nextInt();

            //noinspection InstantiatingAThreadWithDefaultRunMethod
            myThread thread = new myThread();
            thread.start();

            //Try-Catch opening socket to server
            /*try (Socket socket = new Socket(ip, port)) {
                System.out.println("Connected to " + ip + ":" + port);

                System.out.println("Opening input stream");
                InputStream inputStream = socket.getInputStream(); //Gets lines from server
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //Reads lines from server

                System.out.println("Opening output stream");
                OutputStream outputStream = socket.getOutputStream(); //Opens output stream to server
                PrintWriter writer = new PrintWriter(outputStream, true); //Opens PrintWrite to server

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

             */

        }
    }

        /**
         * Displays options when called
         */
        private static void menu(){
            System.out.println("\r\n Select desired operation");
            System.out.println("1 - Date and Time");
            System.out.println("2 - Uptime");
            System.out.println("3 - Memory use");
            System.out.println("4 - Netstat");
            System.out.println("5 - Current users");
            System.out.println("6 - Running processes");
            System.out.println("0 - Exit \r\n");
        }

        static class myThread extends Thread {

            public void run(String ip, int port){
                try (Socket socket = new Socket(ip, port)) {
                    System.out.println("Connected to " + ip + ":" + port);

                    System.out.println("Opening input stream");
                    InputStream inputStream = socket.getInputStream(); //Gets lines from server
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //Reads lines from server

                    System.out.println("Opening output stream");
                    OutputStream outputStream = socket.getOutputStream(); //Opens output stream to server
                    PrintWriter writer = new PrintWriter(outputStream, true); //Opens PrintWrite to server

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }

        //Proto-typing
        /*static class myRunnable implements Runnable {

            public void run() {
                long startTime = System.currentTimeMillis();
                System.out.println(startTime);

                writer.println(clientChoice); //Sends client choice to server
                writer.flush(); //Clears writer (sender)

                long endTime = System.currentTimeMillis();
                System.out.println(endTime);
                long elapsedTime = endTime - startTime;

                System.out.println(bufferedReader.readLine()); //Debugging prints out returned value from server.
                System.out.println(elapsedTime); //Debugging to see if elapsed time works
            }
        }*/
    }


