// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc.proto

package br.com.cinema.server;

public final class GrpcProto {
  private GrpcProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_cinema_server_BuyTicketRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_cinema_server_BuyTicketRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_cinema_server_AvailableChairReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_cinema_server_AvailableChairReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_cinema_server_Chair_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_cinema_server_Chair_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_cinema_server_ChairList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_cinema_server_ChairList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_br_com_cinema_server_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_br_com_cinema_server_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ngrpc.proto\022\024br.com.cinema.server\"\"\n\020Bu" +
      "yTicketRequest\022\016\n\006ticket\030\001 \001(\003\")\n\023Availa" +
      "bleChairReply\022\022\n\nchairReply\030\001 \001(\t\"*\n\005Cha" +
      "ir\022\016\n\006number\030\001 \001(\003\022\021\n\tavailable\030\002 \001(\010\"8\n" +
      "\tChairList\022+\n\006chairs\030\001 \003(\0132\033.br.com.cine" +
      "ma.server.Chair\"\007\n\005Empty2\304\001\n\006Cinema\022`\n\tb" +
      "uyTicket\022&.br.com.cinema.server.BuyTicke" +
      "tRequest\032).br.com.cinema.server.Availabl" +
      "eChairReply\"\000\022X\n\026listAllAvailableChairs\022" +
      "\033.br.com.cinema.server.Empty\032\037.br.com.ci" +
      "nema.server.ChairList\"\000B#\n\024br.com.cinema" +
      ".serverB\tGrpcProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_br_com_cinema_server_BuyTicketRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_br_com_cinema_server_BuyTicketRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_cinema_server_BuyTicketRequest_descriptor,
        new java.lang.String[] { "Ticket", });
    internal_static_br_com_cinema_server_AvailableChairReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_br_com_cinema_server_AvailableChairReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_cinema_server_AvailableChairReply_descriptor,
        new java.lang.String[] { "ChairReply", });
    internal_static_br_com_cinema_server_Chair_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_br_com_cinema_server_Chair_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_cinema_server_Chair_descriptor,
        new java.lang.String[] { "Number", "Available", });
    internal_static_br_com_cinema_server_ChairList_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_br_com_cinema_server_ChairList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_cinema_server_ChairList_descriptor,
        new java.lang.String[] { "Chairs", });
    internal_static_br_com_cinema_server_Empty_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_br_com_cinema_server_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_br_com_cinema_server_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
