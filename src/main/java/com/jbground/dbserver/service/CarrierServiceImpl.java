package com.jbground.dbserver.service;

import com.jbground.grpc.matarial.Carrier;
import com.jbground.grpc.matarial.CarrierServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CarrierServiceImpl extends CarrierServiceGrpc.CarrierServiceImplBase {

    @Override
    public void getCarriers(Carrier request, StreamObserver<Carrier> responseObserver) {

        responseObserver.onNext(Carrier.newBuilder().setName("test123").build());

        responseObserver.onCompleted();

    }
}
