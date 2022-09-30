package com.jbground.dbserver;


import com.jbground.grpc.User;
import com.jbground.grpc.UserIdx;
import com.jbground.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DbserverApplication {

	public static void main(String[] args) {
		int port = 8080;
		Server server = ServerBuilder.forPort(port).addService(new UserServiceImpl()).build();

		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Runtime.getRuntime().addShutdownHook(new Thread(() ->{
			System.err.println("Server: Shutting down gRPC server");
			server.shutdown();
			System.err.println("Server: Server shutdown");
		}));

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
		UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
		UserIdx setUserResult = stub.setUser(User.newBuilder()
				.setUsername("JSJEONG")
				.setEmail("jsj00203@gmail.com")
				.addRoles("USER")
				.build());
		System.out.println("Client: "+setUserResult);

		User getUserResult = stub.getUser(setUserResult);
		System.out.println(getUserResult.toString());

		channel.shutdown();
		Runtime.getRuntime().exit(0);
	}

}
